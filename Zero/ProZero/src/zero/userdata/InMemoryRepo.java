package zero.userdata;

import java.util.ArrayList;
import java.util.List;

import zero.usermodels.Request;

public class InMemoryRepo implements IRepository {

	private static ArrayList<Request> requestList;
	private static int latestFormNum;
	
	
	public InMemoryRepo() {
		 
		requestList = new ArrayList<Request>() {{
			new Request("Bob", "Food", "$40", 1);
		}};
		latestFormNum = 6;
	}


	@Override
	public void addRequest(Request newRequest) {
		newRequest.setRqFormNum(latestFormNum);
		requestList.add(newRequest);
		latestFormNum++;
	}


	@Override
	public List<Request> getRequest() {
		return this.requestList;
	}


	@Override
	public Request getRqByFormNum(int rqFormNum) throws Exception {
		
		Request viewRequest = null;
		
		for (Request rq:requestList) {
			if (rq.getRqFormNum() == rqFormNum) {
				viewRequest = rq;
			}
		}
		if (viewRequest == null) throw new Exception("That Request does not exist.");
		return viewRequest;
	}


	@Override
	public Request getRqByStatus(String rqStatus) throws Exception {
		
		Request viewByStatus = null;
		
		for (Request rq:requestList) {
			if (rq.getRqStatus() == rqStatus); {
				viewByStatus = rq;
			}
		}
		if (viewByStatus == null) throw new Exception ("No Request forms found.");
		return viewByStatus;
	}
}
