package zero.userlogic;

import java.util.List;

import zero.usermodels.Request;

public interface IRqLogic {

	void addRequest(Request rq);
	
	List<Request> getRequest();
	
	Request getRqByFormNum(int rqFormNum) throws Exception;
	
	Request getRqByStatus(String rqStatus) throws Exception;
	
}
