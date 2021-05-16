package Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActivityTest {

	private Activity activity;
	 
	@BeforeEach                                         
	public void setUp() throws Exception {
		activity = new Activity();
	}
	
	@Test
	public void testAddPassengerFunction() {
		activity.setPassengerCapacity(1);
		activity.setEnrolledPassengers(1);
		activity.addPassenger();
		assertEquals(activity.getEnrolledPassengers(),1);
	}
	
	@Test
	public void testCheckAvailabilityFunction() {
		activity.setPassengerCapacity(1);
		activity.setEnrolledPassengers(1);
		assertEquals(activity.checkAvailability(), Boolean.FALSE);
		activity.setPassengerCapacity(3);
		activity.setEnrolledPassengers(1);
		assertEquals(activity.checkAvailability(), Boolean.TRUE);
		
	}
}
