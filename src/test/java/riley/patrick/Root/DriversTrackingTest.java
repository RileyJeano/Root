package riley.patrick.Root;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import javax.annotation.Resource;
import riley.patrick.Root.model.Driver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DriversTrackingTest {

	@Test
	public void shouldAddDriver() {
		DriversTracking underTest = new DriversTracking();
		Driver driver = new Driver("Mike");
		underTest.getDriversList().add(driver);
		ArrayList<Driver> drivers = underTest.getDriversList();

		Assert.assertEquals(true, drivers.contains(driver));
	}

	@Test
	public void shouldParseFirstWord() {
		DriversTracking underTest = new DriversTracking();
		underTest.parseFirstWord("Driver Mike");

		ArrayList<Driver> drivers = underTest.getDriversList();

		assertFalse(drivers.isEmpty());

	}

	@Test
	public void shouldGetSpecificDriver() {
		DriversTracking underTest = new DriversTracking();
		underTest.parseFirstWord("Driver Mike");
		Driver driver = underTest.getSpecificDriver("Mike");

		Assert.assertEquals(true, driver.getDriverName().equals("Mike"));

	}

	@Test
	public void shouldSortDrivers() {
		DriversTracking underTest = new DriversTracking();
		Driver driver1 = new Driver("Mike");
		driver1.addMiles(5.0);
		underTest.getDriversList().add(driver1);

		Driver driver2 = new Driver("Pete");
		driver2.addMiles(10.0);
		underTest.getDriversList().add(driver2);

		underTest.sortDrivers();
		Assert.assertEquals("Pete", underTest.getDriversList().get(0).getDriverName());
		Assert.assertEquals("Mike", underTest.getDriversList().get(1).getDriverName());

	}

}
