package zero.userdata;

import java.util.List;

import zero.usermodels.Request;

public class DBRepository implements IRepository {
	private DAO<Request, Integer> requestDAO;
	public DBRepository(DAO<Request, Integer> requestDAO) {
		this.requestDAO = requestDAO;
	}
	
	@Override
	public void addRequest(Request newRequest) {
		// TODO Auto-generated method stub
		requestDAO.add(newRequest);
	}

	@Override
	public List<Request> getRequest() {
		// TODO Auto-generated method stub
		return requestDAO.findAll();
	}

	@Override
	public Request getRqByFormNum(int rqFormNum) throws Exception {
		// TODO Auto-generated method stub
		return requestDAO.findByFormNum(rqFormNum);
	}

	@Override
	public Request getRqByStatus(String rqStatus) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
