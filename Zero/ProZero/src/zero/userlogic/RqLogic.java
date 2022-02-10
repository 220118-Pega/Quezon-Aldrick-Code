package zero.userlogic;

import java.util.List;

import zero.userdata.IRepository;
import zero.usermodels.Request;

public class RqLogic implements IRqLogic{
	
	private IRepository repo;
	public RqLogic(IRepository repo) {
		this.repo = repo;
	}
	@Override
	public void addRequest(Request rq) {
		repo.addRequest(rq);
	}
	@Override
	public List<Request> getRequest() {
		return repo.getRequest();
	}
	@Override
	public Request getRqByFormNum(int rqFormNum) throws Exception {
		// TODO Auto-generated method stub
		return repo.getRqByFormNum(rqFormNum);
	}
	@Override
	public Request getRqByStatus(String rqStatus) throws Exception {
		// TODO Auto-generated method stub
		return repo.getRqByStatus(rqStatus);
	}
	
	
}