package zero.usermodels;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Request {
    
	private String requestUser;
	private String requestType;
	private String requestAmount;
	//private String requestReason;   -------- May add
	private int rqFormNum;
	
	Date date = new Date();
	Timestamp tStamp = new Timestamp(date.getTime());
	
	// Find out how to return random (APPROVED, REJECTED, PENDING)
	
	String[] status = {"Approved", "Rejected", "Pending"};
	String rqStatus = status[(int) (Math.random() * status.length)];
	
	//Request requestStatus = new Request() {
		
	//};
	
	public Request() {
		this("Bob", "No Type", "No Amount", 0);
	}


	public Request(String requestUser, String requestType, String requestAmount) {
		this.setRequestUser(requestUser);
		this.requestType = requestType;
		this.requestAmount = requestAmount;
	}
	
	public Request(String requestUser, String requestType, String requestAmount, int rqFormNum) {
		this(requestUser, requestType, requestAmount);
		this.rqFormNum = rqFormNum;
	}

	public String getRequestUser() {
		return requestUser;
	}


	public void setRequestUser(String requestUser) {
		this.requestUser = requestUser;
	}


	public String getRequestType() {
		return requestType;
	}


	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}


	public String getRequestAmount() {
		return requestAmount;
	}


	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}


	public int getRqFormNum() {
		return rqFormNum;
	}
	
	public void setRqFormNum(int rqFormNum) {
		this.rqFormNum = rqFormNum;
	}


	@Override
	public String toString() {
		return "Request created: [Name: " + requestUser + "]\n "
				+ "                [Request Type: " + requestType + "]\n"
						+ "                 [Requested Amount: $" + 
				requestAmount + ".00]\n"
						+ "                 [Request Form #: " + rqFormNum + "]\n        " +
				"         [Status: " + rqStatus + "]\n" +
				"                 [Requested on: " + tStamp + "]\n";
	}


	public String getRqStatus() {
		return rqStatus;
	}


	public void setRqStatus(String rqStatus) {
		this.rqStatus = rqStatus;
	}

	



	
}


