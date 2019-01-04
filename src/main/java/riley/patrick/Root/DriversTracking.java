package riley.patrick.Root;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import riley.patrick.Root.model.Driver;

public class DriversTracking {
	private ArrayList<Driver> driversList = new ArrayList<Driver>();

	public void readTxtFile(String name) {
		try {
			File file = new File(name);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
				parseFirstWord(line);
				System.out.println(line);
			}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("");
		printOutDrivers();
	}

	public void parseFirstWord(String toParseWord) {

		String[] words = toParseWord.split(" ");
		String denoter = words[0];
		String name = words[1];
		if (denoter.equalsIgnoreCase("driver")) {
			Driver driver = new Driver(name);
			driversList.add(driver);
		} else if (denoter.equalsIgnoreCase("trip")) {
			parseOutLines(words, name);
		}
	}

	public void parseOutLines(String[] passedLines, String name) {

		LocalTime startTime = LocalTime.parse(passedLines[2]);
		LocalTime stopTime = LocalTime.parse(passedLines[3]);
		double miles = Double.parseDouble(passedLines[4]);
		Driver driver = getSpecificDriver(name);
		checkTripViability(startTime, stopTime, miles, driver);

	}

	private void checkTripViability(LocalTime start, LocalTime stop, double miles, Driver driver) {
		double duration = start.until(stop, ChronoUnit.MINUTES);
		double mphCalculated = miles / (duration / 60);
		if (mphCalculated >= 5.0 && mphCalculated <= 100.0) {
			driver.addMiles(miles);
			driver.addTime(duration);
		}
	}

	public void printOutDrivers() {
		sortDrivers();
		for (Driver driver : driversList) {
			{
				// sort in order of highest miles
				driver.calculateAverageMph();
				System.out.println(driver.toString());
			}
		}
	}

	public ArrayList<Driver> getDriversList() {
		return driversList;
	}

	public Driver getSpecificDriver(String name) {

		for (Driver driver : driversList) {
			if (driver.getDriverName().equals(name)) {

				return driver;
			}
		}
		return null;
	}

	public void sortDrivers() {

		Collections.sort(driversList, new Comparator<Driver>() {
			public int compare(Driver first, Driver second) {
				first.calculateTotalMiles();
				second.calculateTotalMiles();
				return second.getTotalMiles() - first.getTotalMiles();
			}
		});
	}

}
