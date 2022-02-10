package zero.userdata;

import java.util.List;

import zero.usermodels.Request;

// This is a generic interface for DAO
	// <T> = type of object that we're creating DAO for
	// <K> = data type of id of object
public interface DAO<T, K> {
	T findByFormNum(K rqFormNum);
	List<Request> findAll();
	void add(T newObject);
	void update(T newObject);

}
