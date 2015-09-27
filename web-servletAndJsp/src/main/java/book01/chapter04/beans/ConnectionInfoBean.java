package book01.chapter04.beans;

import java.sql.*;

/**
 * Stores information to create a JDBC connection to a database. Information
 * includes:
 * <UL>
 * <LI>connection name
 * <LI>description of the connection
 * <LI>driver classname
 * <LI>URL to connect to the host
 * <LI>username
 * <LI>password
 * </UL>
 */

public class ConnectionInfoBean {
	private String connectionName;
	private String description;
	private String driver;
	private String url;
	private String username;
	private String password;

	public ConnectionInfoBean() {
	}

	public ConnectionInfoBean(String connectionName, String description,
			String driver, String url, String username, String password) {
		setConnectionName(connectionName);
		setDescription(description);
		setDriver(driver);
		setURL(url);
		setUsername(username);
		setPassword(password);
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getConnectionName() {
		return (connectionName);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return (description);
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriver() {
		return (driver);
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getURL() {
		return (url);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return (username);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return (password);
	}

	public Connection getConnection() {
		return (getConnection(driver, url, username, password));

	}

	/**
	 * Create a JDBC connection or return null if a problem occurs.
	 */

	public static Connection getConnection(String driver, String url,
			String username, String password) {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username,
					password);
			return (connection);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Error loading driver: " + cnfe);
			return (null);
		} catch (SQLException sqle) {
			System.err.println("Error connecting: " + sqle);
			return (null);
		}
	}
}