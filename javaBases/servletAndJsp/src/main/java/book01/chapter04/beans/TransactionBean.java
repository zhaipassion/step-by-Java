package book01.chapter04.beans;

import java.sql.*;
import java.util.*;

public class TransactionBean {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setConnection(String driver, String url, String username,
			String password) {
		setConnection(ConnectionInfoBean.getConnection(driver, url, username,
				password));
	}

	public Connection getConnection() {
		return (connection);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void execute(List list) throws SQLException {
		execute((String[]) list.toArray(new String[list.size()]));
	}

	public void execute(String transaction) throws SQLException {
		execute(new String[] { transaction });
	}

	/**
	 * Execute a block of SQL statements as a single transaction. If an
	 * SQLException occurs, a rollback is attempted and the exception is thrown.
	 */

	public void execute(String[] transaction) throws SQLException {
		if (connection == null) {
			throw new SQLException("No connection available.");
		}
		boolean autoCommit = connection.getAutoCommit();
		try {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			for (int i = 0; i < transaction.length; i++) {
				statement.execute(transaction[i]);
			}
			statement.close();
		} catch (SQLException sqle) {
			connection.rollback();
			throw sqle;
		} finally {
			connection.commit();
			connection.setAutoCommit(autoCommit);
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				System.err.println("Failed to close connection: " + sqle);
			} finally {
				connection = null;
			}
		}
	}
}