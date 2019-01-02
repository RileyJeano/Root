package riley.patrick.Root.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drivers {
	@Id
	@GeneratedValue
	private Long id;
	private String driverName;
	private ArrayList<Double> miles = new ArrayList<Double>();
	private ArrayList<Double> mph = new ArrayList<Double>();
	private int averageMph;
	private int totalMiles;

	public Drivers() {

	}

	public Drivers(String driverName) {
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

	public ArrayList<Double> getMph() {
		return mph;
	}

	public void addMph(double mph) {
		this.mph.add(mph);
	}

	public int getAverageMph() {
		return averageMph;
	}

	public int getTotalMiles() {
		return totalMiles;
	}

	public void calculateAverageMph() {
		calculateTotalMiles();
		Double sum = 0.0;
		for (double entry : mph) {
			sum += entry;
		}
		int endMph = sum.intValue();
		averageMph = totalMiles / endMph;
	}

	public void calculateTotalMiles() {
		Double sum = 0.0;
		for (double entry : miles) {
			sum += entry;
		}
		totalMiles = sum.intValue();
	}

}
