package Model;

import Constants.SystemConstants;

public class Activity {
	
	private String id;
	private String activityName;
	private String description;
	private double cost;
	private int passengerCapacity;
	private int enrolledPassengers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	public int getEnrolledPassengers() {
		return enrolledPassengers;
	}
	public void setEnrolledPassengers(int enrolledPassengers) {
		this.enrolledPassengers = enrolledPassengers;
	}
	
	public Boolean checkAvailability(){
		if(this.enrolledPassengers < this.passengerCapacity)
			return true;
		return false;
	}
	public Activity(int id, String activityName, String description, double cost, int passengerCapacity) {
		this.id = SystemConstants.ACTIVITY_SUFFIX + Integer.toString(id);
		this.activityName = activityName;
		this.description = description;
		this.cost = cost;
		this.passengerCapacity = passengerCapacity;
	}
	
	public Activity() {
	}
	public void addPassenger() {
		
		if(checkAvailability()) {
			this.enrolledPassengers++;
		} else {
			System.out.println(SystemConstants.ACTIVITY_FULL);
		}
	}
	public void getActivityDetails() {
		System.out.println(SystemConstants.NEW_LINE + SystemConstants.SEPARATOR);
		System.out.println("Activity ID : " + this.id);
		System.out.println("Activity Name : " + this.activityName);
		System.out.println("Activity Description : " + this.description);
		System.out.println("Cost : " + this.cost);
		System.out.println("Passenger Capacity : " + this.passengerCapacity);
		System.out.println(SystemConstants.SEPARATOR + SystemConstants.NEW_LINE);
	}
}
