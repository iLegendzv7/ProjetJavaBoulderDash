package model.dao;


import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;

final class Connexion {
	String url = "jdbc:mysql://localhost/boulderdash?useSSL=false&serverTimezone=UTC";
	String user = "xavier";
	String passwd = "xavier";
	public char[][] map3 = new char[22][40];
	HashMap<Character, Integer> listeImage = new HashMap<>();
	private Connection conn;
	private ResultSet result;
	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}

	private Statement state;
	// public static void main(String[] args) {

	public Connexion() throws SQLException {

		this.conn = DriverManager.getConnection(url, user, passwd);
		this.state = conn.createStatement();
		this.result = state.executeQuery("SELECT * FROM Map4");
	}
}