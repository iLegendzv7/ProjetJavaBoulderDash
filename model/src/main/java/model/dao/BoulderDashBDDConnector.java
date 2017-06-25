<<<<<<< HEAD
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
final class BoulderDashBDDConnector {

	/** The instance. */
	private static BoulderDashBDDConnector instance;

	/** The login. */
	private static String user = "remy";

	/** The password. */
	private static String password = "remy";

	/** The url. */
	private static String url = "jdbc:mysql://localhost:8889/boulderdash?useSSL=false&serverTimezone=UTC";

	
	/** The connection. */
	private Connection connection;

	/** The statement. */
	private Statement statement;

	/**
	 * Instantiates a new boulder dash BDD connector.
	 */
	private BoulderDashBDDConnector() {
		this.open();
	}

	/**
	 * Gets the single instance of BoulderDashBDDConnector.
	 *
	 * @return single instance of BoulderDashBDDConnector
	 */
	public static BoulderDashBDDConnector getInstance() {
		if (instance == null) {
			setInstance(new BoulderDashBDDConnector());
		}
		return instance;
	}

	/**
	 * Sets the instance.
	 *
	 * @param instance
	 *            the new instance
	 */
	private static void setInstance(final BoulderDashBDDConnector instance) {
		BoulderDashBDDConnector.instance = instance;
	}

	/**
	 * Open.
	 *
	 * @return true, if successful
	 */
	private boolean open() {
		try {
			this.connection = DriverManager.getConnection(BoulderDashBDDConnector.url, BoulderDashBDDConnector.user,
					BoulderDashBDDConnector.password);
			this.statement = this.connection.createStatement();
			return true;
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * Execute query.
	 *
	 * @param query
	 *            the query
	 * @return the result set
	 */
	public ResultSet executeQuery(final String query) {
		try {
			return this.getStatement().executeQuery(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Prepare call.
	 *
	 * @param query
	 *            the query
	 * @return the java.sql. callable statement
	 */
	public java.sql.CallableStatement prepareCall(final String query) {
		try {
			return this.getConnection().prepareCall(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Execute update.
	 *
	 * @param query
	 *            the query
	 * @return the int
	 */
	public int executeUpdate(final String query) {
		try {
			return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection
	 *            the new connection
	 */
	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	public Statement getStatement() {
		return this.statement;
	}

	/**
	 * Sets the statement.
	 *
	 * @param statement
	 *            the new statement
	 */
	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

}
=======
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
final class BoulderDashBDDConnector {

	/** The instance. */
	private static BoulderDashBDDConnector instance;

	/** The login. */
	private static String user = "xavier";

	/** The password. */
	private static String password = "xavier";

	/** The url. */
	private static String url = "jdbc:mysql://localhost/boulderdash?useSSL=false&serverTimezone=UTC";

	/** The connection. */
	private Connection connection;

	/** The statement. */
	private Statement statement;
	private ResultSet result;

	/**
	 * Instantiates a new boulder dash BDD connector.
	 */
	private BoulderDashBDDConnector() {
		this.open();
	}

	/**
	 * Gets the single instance of BoulderDashBDDConnector.
	 *
	 * @return single instance of BoulderDashBDDConnector
	 */
	public static BoulderDashBDDConnector getInstance() {
		if (instance == null) {
			setInstance(new BoulderDashBDDConnector());
		}
		return instance;
	}

	/**
	 * Sets the instance.
	 *
	 * @param instance
	 *            the new instance
	 */
	private static void setInstance(final BoulderDashBDDConnector instance) {
		BoulderDashBDDConnector.instance = instance;
	}

	/**
	 * Open.
	 *
	 * @return true, if successful
	 */
	private boolean open() {
		try {
			this.connection = DriverManager.getConnection(BoulderDashBDDConnector.url, BoulderDashBDDConnector.user,
					BoulderDashBDDConnector.password);
			this.statement = this.connection.createStatement();
			
			return true;
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * Execute query.
	 *
	 * @param query
	 *            the query
	 * @return the result set
	 */
	public ResultSet executeQuery(final String query) {
		try {
			
			return this.getStatement().executeQuery(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Prepare call.
	 *
	 * @param query
	 *            the query
	 * @return the java.sql. callable statement
	 */
	public java.sql.CallableStatement prepareCall(final String query) {
		try {
			return this.getConnection().prepareCall(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertMap(final String str) {
		final ResultSet resultSet = this.executeQuery(QueryMapBoulderdash.getQuerySelectMap(str));
		try {

			char[][] map3 = new char[22][40];

			Connection conn = DriverManager.getConnection(url, user, password);

			Statement state = conn.createStatement();

			ResultSet result = state.executeQuery("SELECT * FROM map3");

			ResultSetMetaData resultMeta = result.getMetaData();
			int ligne = 0;
			while (result.next()) {
				for (int colonne = 0; colonne < result.getObject(2).toString().length(); colonne++) {
					map3[ligne][colonne] = result.getObject(2).toString().charAt(colonne);
				}
				ligne++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Execute update.
	 *
	 * @param query
	 *            the query
	 * @return the int
	 */
	public int executeUpdate(final String query) {
		try {
			return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection
	 *            the new connection
	 */
	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	public Statement getStatement() {
		return this.statement;
	}

	/**
	 * Sets the statement.
	 *
	 * @param statement
	 *            the new statement
	 */
	public void setStatement(final Statement statement) {
		this.statement = statement;
	}

}
>>>>>>> bc6f3c29191d59c6299ab8f5ecd1f5f7b31e0dde
