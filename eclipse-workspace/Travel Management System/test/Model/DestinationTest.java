package Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DestinationTest {

	private Destination destination;
	
	@BeforeEach                                         
	public void setUp() throws Exception {
		destination = new Destination();
	}
	
	@Test
	public void testIdFormation() {
		destination = new Destination(1,"Shimla", null);
		assertEquals(destination.getId(), "Destination_1");
	}
}
