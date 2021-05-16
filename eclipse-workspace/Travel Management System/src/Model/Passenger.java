package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Constants.SystemConstants;

public class Passenger {
	
	private String id;
	private String fullName;
	private Double accountBalance;
	private PassengerType passengerType;
	private Map<Activity, Double> activityCostMap;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public PassengerType getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public Map<Activity, Double> getActivityCostMap() {
		return activityCostMap;
	}
	public void addActivity(Activity activity) {
		Double activityCost = activity.getCost();
		if (this.passengerType.equals(PassengerType.GOLD))
			activityCost = 0.9 * activityCost;
		else if(this.passengerType.equals(PassengerType.PREMIUM)) {
			this.activityCostMap.put(activity, activityCost);
		}
		
		if (this.accountBalance - activityCost > 0.0) {
			this.accountBalance -= activityCost;
			this.activityCostMap.put(activity, activityCost);
		} else {
			System.out.println(SystemConstants.ACTIVITY_FULL);
		}
		
	}
	public void getPassengerDetails() {
		
		System.out.println(SystemConstants.NEW_LINE + SystemConstants.SEPARATOR);
		System.out.println("Passenger ID : " + this.id);
		System.out.println("Passenger Name : " + this.fullName);
		System.out.println("Passenger Subscription Type : " + this.passengerType);
		if (this.passengerType.equals(PassengerType.PREMIUM))
			System.out.println("Passenger Account Balance : No Limit");
		else
			System.out.println("Passenger Account Balance : " + this.accountBalance);
		 for (Entry<Activity, Double> entry : this.activityCostMap.entrySet())
	            System.out.println("Activity = " + entry.getKey().getActivityName() +
	                             ", Cost = " + entry.getValue());
		System.out.println(SystemConstants.SEPARATOR + SystemConstants.NEW_LINE);

	}
	
	public Passenger(int id, String fullName, Double accountBalance, PassengerType passengerType) {
		this.id = SystemConstants.PASSENGER_SUFFIX + Integer.toString(id);
		this.fullName = fullName;
		this.passengerType = passengerType;
		this.activityCostMap = new HashMap();
		if (this.passengerType.equals(PassengerType.PREMIUM))
			this.accountBalance = -1.0;
		else
			this.accountBalance = accountBalance;
	}
	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
