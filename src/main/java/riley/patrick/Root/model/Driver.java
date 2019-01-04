package riley.patrick.Root.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Driver {
	@Id
	@GeneratedValue
	private Long id;
	private String driverName;
	private ArrayList<Double> miles = new ArrayList<Double>();
	private ArrayList<Double> times = new ArrayList<Double>();
	private double averageMph;
	private double totalMiles;

	public Driver() {

	}

	public Driver(String driverName) {
		this.driverName = driverName;
		miles.add(0.0);

	}

	public String getDriverName() {
		return driverName;
	}

	public ArrayList<Double> getMiles() {
		return miles;
	}

	public void addMiles(double miles) {
		this.miles.add(miles);
	}

	public ArrayList<Double> getTimes() {
		return times;
	}

	public void addTime(double times) {
		this.times.add(times);
	}

	public int getAverageMph() {
		int roundedAverageMph = (int) Math.round(averageMph);
		return roundedAverageMph;
	}

	public int getTotalMiles() {
		int roundedMiles = (int) Math.round(totalMiles);
		return roundedMiles;
	}

	public void calculateAverageMph() {
		calculateTotalMiles();
		Double sum = 0.0;
		for (double entry : times) {
			sum = sum + entry;
		}
		double totalTime = (sum / 60.00);

		averageMph = totalMiles / totalTime;
	}

	public void calculateTotalMiles() {
		Double sum = 0.0;
		for (double entry : miles) {
			sum += entry;
		}
		totalMiles = sum.intValue();
	}

	@Override
	public String toString() {

		if (getAverageMph() != 0) {
			return getDriverName() + ": " + getTotalMiles() + " miles " + " @ " + getAverageMph() + " mph";
		} else {
			return getDriverName() + ": " + getTotalMiles() + " miles";
		}

	}

}
