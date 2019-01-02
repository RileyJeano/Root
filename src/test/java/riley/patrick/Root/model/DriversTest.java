package riley.patrick.Root.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class DriversTest {

	@Test
	public void shouldHaveDriverName() {
		Drivers underTest = new Drivers("Eric");
		String name = underTest.getDriverName();
		Assert.assertEquals("Eric", name);
	}

	@Test
	public void shouldHaveZeroMilesAsNewDriver() {
		Drivers underTest = new Drivers("Eric");
		ArrayList<Double> miles = underTest.getMiles();
		Assert.assertEquals(true, miles.contains(0.0));
	}

	@Test
	public void shouldAddMiles() {
		Drivers underTest = new Drivers("Eric");
		underTest.addMiles(5.5);
		ArrayList<Double> miles = underTest.getMiles();
		Assert.assertEquals(true, miles.contains(5.5));
	}

	@Test
	public void shouldAddMph() {
		Drivers underTest = new Drivers("Eric");
		underTest.addMph(5.0);
		ArrayList<Double> mph = underTest.getMph();
		Assert.assertEquals(true, mph.contains(5.0));
	}

	@Test
	public void shouldCalculateTotalMiles() {
		Drivers underTest = new Drivers("Eric");
		underTest.addMiles(5.0);
		underTest.addMiles(5.0);
		underTest.addMph(5.0);
		underTest.calculateAverageMph();
		int test = underTest.getAverageMph();
		Assert.assertEquals(2, test);
	}

}
