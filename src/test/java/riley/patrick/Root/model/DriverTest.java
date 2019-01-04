package riley.patrick.Root.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class DriverTest {

	@Test
	public void shouldHaveDriverName() {
		Driver underTest = new Driver("Eric");
		String name = underTest.getDriverName();
		Assert.assertEquals("Eric", name);
	}

	@Test
	public void shouldHaveZeroMilesAsNewDriver() {
		Driver underTest = new Driver("Eric");
		ArrayList<Double> miles = underTest.getMiles();
		Assert.assertEquals(true, miles.contains(0.0));
	}

	@Test
	public void shouldAddMiles() {
		Driver underTest = new Driver("Eric");
		underTest.addMiles(5.5);
		ArrayList<Double> miles = underTest.getMiles();
		Assert.assertEquals(true, miles.contains(5.5));
	}

	@Test
	public void shouldAddMph() {
		Driver underTest = new Driver("Eric");
		underTest.addTime(5.0);
		ArrayList<Double> mph = underTest.getTimes();
		Assert.assertEquals(true, mph.contains(5.0));
	}

	@Test
	public void shouldCalculateTotalMiles() {
		Driver underTest = new Driver("Eric");
		underTest.addMiles(5.0);
		underTest.addMiles(5.0);
		underTest.calculateTotalMiles();
		int test = underTest.getTotalMiles();
		Assert.assertEquals(10, test);
	}

	@Test
	public void shouldCalculateAverageMpm() {
		Driver underTest = new Driver("Eric");
		underTest.addMiles(5.0);
		underTest.addMiles(5.0);
		underTest.addTime(5.0);
		underTest.calculateAverageMph();
		int test = underTest.getAverageMph();
		Assert.assertEquals(120, test);
	}

	// send right string
	@Test
	public void shouldHaveRightString() {
		Driver underTest = new Driver("Eric");
		underTest.addMiles(5.0);
		underTest.addMiles(5.0);
		underTest.addTime(5.0);
		underTest.calculateAverageMph();
		String test = underTest.toString();
		Assert.assertEquals("Eric: 10 miles 120 mph", test);
	}

	// sort

}
