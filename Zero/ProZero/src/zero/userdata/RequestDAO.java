package zero.userdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zero.usermodels.Request;

public class RequestDAO implements DAO<Request, Integer> {
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public Request findByFormNum(Integer rqFormNum) {
		// try with resources block, after try block finishes executing
			// it disposes of resources for you
		try (Connection connect = ConnectionFactory.getInstance().getConnection()) {
			// ? = placeholder for parameter we'll be sending to DB
			String query = "select * from Request where rqFormNum = ?";
			PreparedStatement pstatement = connect.prepareStatement(query);
			pstatement.setInt(1, rqFormNum);
			// executeQuery = executing select commands
			// result set = holds results from DB
			ResultSet resultset = pstatement.executeQuery();
			// need to unpack result set to return something to end user
			if (resultset.next()) {
				return new Request(resultset.getString("requestUser"), resultset.getString("requestType"), resultset.getString("requestAmount"),
								   resultset.getInt("rqFormNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error with connecting to DB");
		}
		return null;
	}

	@Override
	public List<Request> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Request> rq = new ArrayList<Request>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from Request";
			Statement statement = connect.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while (resultset.next()) {
				rq.add(new Request(resultset.getString("requestUser"), resultset.getString("requestType"), resultset.getString("requestAmount"),
								   resultset.getInt("rqFormNum")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Error", e);
		}
		return null;
	}

	@Override
	public void add(Request newObject) {
		// TODO Auto-generated method stub
		try (Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String query = "insert into Request (requestUser, requestType, requestAmount, requestStatus, rqFormNum) values (?,?,?,?,?);";
			PreparedStatement pstatement = connect.prepareStatement(query);
			pstatement.setString(1, newObject.getRequestUser());
			pstatement.setString(2, newObject.getRequestType());
			pstatement.setString(3, newObject.getRequestAmount());
			pstatement.setString(4, newObject.getRqStatus());
			pstatement.setInt(5, newObject.getRqFormNum());
			pstatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Request newObject) {
		// TODO Auto-generated method stub
		
	}

}
