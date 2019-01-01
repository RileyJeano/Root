package riley.patrick.Root.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drivers {
	@Id
	@GeneratedValue
	private Long driverId;
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

	public double calculateTotalMiles() {
		double sum = 0;
		for (int i = 1; i < miles.size(); i++)
			sum += miles.get(i);
		return sum;
	}

	public void calculateAverageMph() {

	}

}
