package Model;

import java.util.List;

import Constants.SystemConstants;

public class Destination {
	
	private String id;
	private String destinationName;
	private List <Activity> activityList;
	
	public Destination(int id, String destinationName, List<Activity> activityList) {
		this.id = SystemConstants.DESTINATION_SUFFIX + Integer.toString(id);
		this.destinationName = destinationName;
		this.activityList = activityList;
	}
	public Destination() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public List<Activity> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public void getDestinationDetails() {
		System.out.println(SystemConstants.NEW_LINE + SystemConstants.SEPARATOR);
		System.out.println("Destination ID : " + this.id);
		System.out.println("Destination Name : " + this.destinationName);
		if(!this.getActivityList().isEmpty()) {
			System.out.println("Activity List : ");
			for(Activity activity : this.getActivityList()) {
				System.out.println(activity.getActivityName());
			}
		}
		System.out.println(SystemConstants.SEPARATOR + SystemConstants.NEW_LINE);
	}
}
