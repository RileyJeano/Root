package riley.patrick.Root;

import java.util.Collection;

import javax.annotation.Resource;
import javax.annotation.Resources;

import riley.patrick.Root.model.Drivers;
import riley.patrick.Root.repository.DriversRepository;

public class DriversTracking {

	@Resource
	DriversRepository driverRepo;

	public void parseFirstWord(String toParseWord) {
		String[] words = toParseWord.split(" ");
		String denoter = words[0];
		String name = words[1];
		if (denoter.equalsIgnoreCase("driver")) {
			Drivers driver = new Drivers(name);

		} else if (denoter.equalsIgnoreCase("trip")) {
			// parseOutLines(toParseWord, name);
		}
	}

	public void parseOutLines(String toParseLines, String name) {
		String[] words = toParseLines.split(" ");
		Drivers driver = (Drivers) driverRepo.findByDriverName(name);
		double startTime = Double.parseDouble(words[2]);
		double stopTime = Double.parseDouble(words[3]);
		double miles = Double.parseDouble(words[4]);
		checkTripViability(startTime, stopTime, miles, driver);

	}

	private void checkTripViability(double start, double stop, double miles, Drivers driver) {
		double time = stop - start;
		double mphCalculated = miles / time;
		if (mphCalculated < 5.0 || mphCalculated > 100.0) {
			driver.addMiles(miles);
			driver.addMph(mphCalculated);
		}
	}
}
