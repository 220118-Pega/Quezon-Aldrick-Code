package zero.userdata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory {
	
	// Eager loading - create instance of connectionfactory on program startup
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	// holds db config
	private Properties properties = new Properties();
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// force load postgresql driver
	 	// static members of class get loaded into memory at start of program
		// static blocks get run at start
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Singleton - characterized by private constructor
		// as well as getInstance method
	private ConnectionFactory() {
		// loading properties file that contains db config
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			properties.load(loader.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Cannot find db.properties file");
			
		}
	}
	
	public static ConnectionFactory getInstance() {
		
		// Lazy loading - create instance of connectionfactory when called
		//if(connectionFactory == null) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	// Factories - characterized by method that contains logic for object creation
	public Connection getConnection() {
		Connection connect = null;
		// trying to get connection using db creds
		try {
			connect = DriverManager.getConnection(properties.getProperty("url"), 
										          properties.getProperty("username"), 
												  properties.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Cannot get connection");
		}
		return connect;
	}

}
