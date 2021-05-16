package Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Constants.SystemConstants;
import Model.Activity;
import Model.Destination;
import Model.Passenger;
import Model.PassengerType;
import Model.TravelPackage;

public class AdminConsole {
	
	/*
	 * As, we are not using Database, we are storing all the details in form of Maps
	 */
	private static Map<String, TravelPackage> travelPackageMap = new HashMap();
	private static Map<String, Passenger> passengerMap = new HashMap();
	private static Map<String, Activity> activityMap = new HashMap();
	private static Map<String, Destination> destinationMap = new HashMap();
	private static Map<String, String> activityDestinationMap = new HashMap();
	private static Map<String, String> destinationTravelPackageMap = new HashMap();
	
	public static void main(String[] args) {
				
		Passenger passenger1 = addPassenger("Lucifer Specter", (double) 50000, PassengerType.GOLD);
		Passenger passenger2 = addPassenger("Rachel Green", (double) 45000, PassengerType.STANDARD);
		Activity activity = addActivity("Horse Riding", "This activity will include Horse Riding at the Kufri location in Shimla", 
				2000, 5);
		Destination destination1 = addDestination("Shimla", Arrays.asList(activity));
		TravelPackage travelPackage = addTravelPackage("Shimla-Manali", Arrays.asList(destination1), 
				5, Arrays.asList(passenger1, passenger2)); 
		passenger1.getPassengerDetails();
		travelPackage.getTravelPackageDetails();
		signupPassengerToTravelPackage("Passenger_0", "TravelPackage_0");
		signupPassengerToActivity("Passenger_0", "Activity_0");
		Passenger passenger3 = passengerMap.get("Passenger_0");
		passenger3.getPassengerDetails();
		getAllActivityWithSpaceAvailable();
	}
	
	/*
	 * Get all the activities with Spaces available
	 */

	private static void getAllActivityWithSpaceAvailable() {
		System.out.println("The Activity with spaces available are : ");
		for (Map.Entry<String, Activity> entry : activityMap.entrySet()) {
			if(entry.getValue().checkAvailability().equals(Boolean.TRUE)) {
				System.out.println(entry.getValue().getActivityName());
			}
		}
	}

	/*
	 * Signup a Passenger for Travel Package
	 */
	private static void signupPassengerToTravelPackage(String passengerId, String travelPackageId) {
		TravelPackage travelPackage = travelPackageMap.get(travelPackageId);
		Passenger passenger = passengerMap.get(passengerId);
		travelPackage.addPassenger(passenger);
		travelPackageMap.put(travelPackageId, travelPackage);
	}

	/*
	 * Signup a Passenger for Activity if they have enrolled in required Travel Package
	 */
	private static void signupPassengerToActivity(String passengerId, String activityId) {
		Activity activity = activityMap.get(activityId);
		Passenger passenger = passengerMap.get(passengerId);
		String travelPackageForActivity = getTravelPackageForActivity(activityId);
		if (travelPackageForActivity != null && passengerHasTravelPackageSingup(passengerId, travelPackageForActivity)){
			passenger.addActivity(activity);
			activity.addPassenger();
		}
		activityMap.put(activityId, activity);
		passengerMap.put(passengerId, passenger);
	}

	/*
	 * Utility function to check if the Passenger is enrolled for given Travel Package
	 */
	private static boolean passengerHasTravelPackageSingup(String passengerId, String travelPackageForActivity) {
		TravelPackage travelPackage = travelPackageMap.get(travelPackageForActivity);
		for (Passenger passenger : travelPackage.getPassengers()) {
			if(passenger.getId().equals(passengerId))
				return true;
		}
		return false;
	}

	/*
	 * Utility Function to get the Travel Package ID for given Activity
	 */
	private static String getTravelPackageForActivity(String activityId) {
		if (activityDestinationMap.containsKey(activityId)) {
			String destinationId = activityDestinationMap.get(activityId);
			if (destinationTravelPackageMap.containsKey(destinationId)) {
				String travelPackageId = destinationTravelPackageMap.get(destinationId);
				return travelPackageId;
			}
		}
		return null;
	}

	/*
	 * Below are the Utility Functions for Admin Console
	 * It contains functions as below:
	 * 1. Add Travel Package
	 * 2. Add Destination
	 * 3. Add Activity
	 * 4. Add Passenger
	 */
	private static TravelPackage addTravelPackage(String travelPackageName, List<Destination> destinations, int passengerLimit,
			List<Passenger> passengerList) {
		TravelPackage travelPackage = new TravelPackage(travelPackageMap.size(), travelPackageName, destinations, passengerLimit, passengerList);
		travelPackageMap.put(travelPackage.getId(), travelPackage);
		for (Destination destination : destinations) {
			destinationTravelPackageMap.put(destination.getId(), travelPackage.getId());
		}
		travelPackage.getTravelPackageDetails();
;		System.out.println("Travel Package" + SystemConstants.CREATED_MESSAGE);
		return travelPackage;
	}

	private static Destination addDestination(String destinationName, List<Activity> activityList) {
		Destination destination = new Destination(destinationMap.size(), destinationName, activityList);
		destinationMap.put(destination.getId(), destination);
		for (Activity activity : activityList) {
			activityDestinationMap.put(activity.getId(), destination.getId());
		}
		destination.getDestinationDetails();
		System.out.println("Destination" + SystemConstants.CREATED_MESSAGE);
		return destination;
	}
	
	private static Activity addActivity(String activityName, String activityDescription, double cost, int passengerCapacity) {
		Activity activity = new Activity(activityMap.size(), activityName, activityDescription, cost, passengerCapacity);
		activityMap.put(activity.getId(), activity);
		activity.getActivityDetails();
		System.out.println("Activity" + SystemConstants.CREATED_MESSAGE);
		return activity;
	}

	private static Passenger addPassenger(String fullName, double accountBalance, PassengerType passengerType) {
		Passenger passenger = new Passenger(passengerMap.size(), fullName, accountBalance, passengerType);
		passengerMap.put(passenger.getId(), passenger);
		passenger.getPassengerDetails();
		System.out.println("Passenger" + SystemConstants.CREATED_MESSAGE);
		return passenger;
	}

}
