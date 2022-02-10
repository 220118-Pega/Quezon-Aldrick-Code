package zero.userdata;

import java.util.List;

import zero.usermodels.Request;

public interface IRepository {

	void addRequest(Request newRequest);
	
	List<Request> getRequest();
	
	Request getRqByFormNum(int rqFormNum) throws Exception;
	
	Request getRqByStatus(String rqStatus) throws Exception;
}
