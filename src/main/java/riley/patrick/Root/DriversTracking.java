package riley.patrick.Root;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import riley.patrick.Root.model.Drivers;

public class DriversTracking {
	private ArrayList<Drivers> driversList = new ArrayList<Drivers>();

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
			String inputFile = stringBuffer.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parseFirstWord(String toParseWord) {
		String[] words = toParseWord.split(" ");
		String denoter = words[0];
		String name = words[1];
		if (denoter.equalsIgnoreCase("driver")) {
			Drivers driver = new Drivers(name);
			driversList.add(driver);
		} else if (denoter.equalsIgnoreCase("trip")) {
			// parseOutLines(words, name);
		}
	}

	public void parseOutLines(String[] passedLines, String name) {
//		Drivers driver = driverRepo.findByDriverName(name);
//	LocalTime	
		double startTime = Double.parseDouble(passedLines[2]);
		double stopTime = Double.parseDouble(passedLines[3]);
		double miles = Double.parseDouble(passedLines[4]);
//		checkTripViability(startTime, stopTime, miles, driver);

	}
//
//	private void checkTripViability(double start, double stop, double miles, Drivers driver) {
//		double time = stop - start;
//		double mphCalculated = miles / time;
//		if (mphCalculated <= 5.0 || mphCalculated >= 100.0) {
//			driver.addMiles(miles);
//			driver.addMph(mphCalculated);
//		}
//	}

	public ArrayList<Drivers> getDriversList() {
		return driversList;
	}
}
