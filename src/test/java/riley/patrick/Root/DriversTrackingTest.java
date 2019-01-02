package riley.patrick.Root;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import javax.annotation.Resource;
import riley.patrick.Root.model.Drivers;

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
		Drivers driver = new Drivers("Mike");
		underTest.getDriversList().add(driver);
		ArrayList<Drivers> drivers = underTest.getDriversList();

		Assert.assertEquals(true, drivers.contains(driver));
	}

	@Test
	public void shouldParseFirstWord() {
		DriversTracking underTest = new DriversTracking();
		underTest.parseFirstWord("Driver Mike");

		ArrayList<Drivers> drivers = underTest.getDriversList();

		assertFalse(drivers.isEmpty());

	}

}
