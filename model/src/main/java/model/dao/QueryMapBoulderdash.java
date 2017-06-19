package model.dao;

public abstract class QueryMapBoulderdash {
	
	public static String getQuerySelectMap(final String str){
		return "SELECT * FROM "+str;
	}

}
