package Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassengerTest {
	
	private Passenger passenger;
	private Activity activity;
	@BeforeEach                                         
	public void setUp() throws Exception {
		passenger = new Passenger();
		activity = new Activity(1, "Horse Riding", "This activity will include Horse Riding at the Kufri location in Shimla", 
				2000, 50);
	}
	
	@Test
	public void testIdFormation() {
		passenger = new Passenger(0, "Lucifer Specter", (double) 50000, PassengerType.PREMIUM);
		assertEquals(passenger.getId(), "Passenger_0");
	}
	
	@Test
	public void testAddActivityForPremiumCustomer()
	{
		passenger = new Passenger(0, "Lucifer Specter", (double) 50000, PassengerType.PREMIUM);
		passenger.addActivity(activity);
		assertEquals(passenger.getAccountBalance(), -1.0);
		assertEquals(passenger.getActivityCostMap().size(), 1);
	}
	
	@Test
	public void testAddActivityForGoldCustomer()
	{
		passenger = new Passenger(1, "Lucifer Specter", (double) 45000, PassengerType.GOLD);
		passenger.addActivity(activity);
		assertEquals(passenger.getAccountBalance(), 43200.0);
		assertEquals(passenger.getActivityCostMap().size(), 1);
	}
	
	@Test
	public void testAddActivityForStandardCustomer()
	{
		passenger = new Passenger(1, "Lucifer Specter", (double) 45000, PassengerType.STANDARD);
		passenger.addActivity(activity);
		assertEquals(passenger.getAccountBalance(), 43000.0);
		assertEquals(passenger.getActivityCostMap().size(), 1);
	}

}
