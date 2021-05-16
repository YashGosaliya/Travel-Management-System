package Model;

import java.util.ArrayList;
import java.util.List;
import Constants.SystemConstants;

public class TravelPackage {

	private String id;
	private String packageName;
	private List<Destination> destinations;
	private int passengerCapacity;
	private List<Passenger> passengers;

	public TravelPackage(int packageId, String packageName, List<Destination> destinations, int passengerCapacity, List<Passenger> passengers) {
		this.id = SystemConstants.TRAVEL_PACKAGE_SUFFIX + Integer.toString(packageId);
		this.packageName = packageName;
		this.destinations = new ArrayList<Destination>(destinations);
		this.passengerCapacity = passengerCapacity;
		this.passengers = new ArrayList<Passenger>(passengers);
	}
	
	public TravelPackage() {
		// TODO Auto-generated constructor stub
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public List<Destination> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public void getPackageDetails() {
		
		System.out.println(SystemConstants.SEPARATOR);
		System.out.println("Package Name : "+ this.packageName);
		System.out.println("Here is the list of Destinations");
		
		for(Destination destination : this.getDestinations()) {
			System.out.println(destination.getDestinationName());
		}
		System.out.println(SystemConstants.SEPARATOR);

	}
	
	public void addPassenger(Passenger passenger) {
		
		if(checkAvailability()) {
			this.passengers.add(passenger);
		} else {
			System.out.println(SystemConstants.TRAVEL_PACKAGE_FULL);
		}
	}
	
	public void removePassenger(Passenger passenger) {
		this.passengers.remove(passenger);
	}
	

	// This function is used to check the Availability in a Travel Package
	public Boolean checkAvailability() {
		if (this.passengers == null)
			this.passengers = new ArrayList();
		if(this.passengers.size() < this.passengerCapacity)
			return true;
		return false;
	}
	
	public void getTravelPackageDetails() {
		System.out.println(SystemConstants.NEW_LINE + SystemConstants.SEPARATOR);
		System.out.println("Travel Package ID : " + this.id);
		System.out.println("Travel Package Name : " + this.packageName);
		for(Destination destinations : this.destinations) {
			System.out.print(destinations.getDestinationName() + "->");
		}
		System.out.println("End of the Trip");
		for(Passenger passenger : this.passengers) {
			passenger.getPassengerDetails();
		}
		System.out.println(SystemConstants.SEPARATOR + SystemConstants.NEW_LINE);
	}
}
