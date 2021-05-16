package Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

public class TravelPackageTest {

	private TravelPackage travelPackage;
	
	@BeforeEach                                         
	public void setUp() throws Exception {
		travelPackage = new TravelPackage();
	}
	
	@Test
	public void testCheckAvailabilityFunction() {
		travelPackage.setPassengerCapacity(2);
		Passenger passenger1 = new Passenger();
		Passenger passenger2 = new Passenger();
		assertEquals(travelPackage.checkAvailability(), Boolean.TRUE);
		travelPackage.setPassengers(Arrays.asList(passenger1,passenger2));
		assertEquals(travelPackage.checkAvailability(), Boolean.FALSE);
	}
	
	@Test
	public void testAddPassengerFunction() {
		travelPackage.setPassengerCapacity(1);
		Passenger passenger = new Passenger();
		String name = "New Passenger";
		passenger.setFullName(name);
		travelPackage.addPassenger(passenger);
		assertEquals(travelPackage.checkAvailability(), Boolean.FALSE);
		assertEquals(travelPackage.getPassengers().size(), 1);
		assertEquals(travelPackage.getPassengers().get(0).getFullName(), name);
	}
}
