package model;

import java.sql.ResultSet;

public interface IConnexion {

	public void setResult(ResultSet result);
	
	public ResultSet getResult();
}
