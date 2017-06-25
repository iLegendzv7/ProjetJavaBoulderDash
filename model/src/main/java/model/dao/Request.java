package model.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Request {
	public void user (String pseudo){

		try {

	    Statement state = BoulderDashBDDConnector.getInstance().createStatement();


	    ResultSet result = state.executeQuery("SELECT * FROM listplayer");
	    
	    int ID = 0;
	    String nomBDD = " ";
	    int nbrcolumn = 0;
	    
	    
	    result.last();
	    nbrcolumn = result.getRow();
	
	    // next() récupere la ligne
	    result.beforeFirst();
		    do{
		    	result.next();
		    	ID = result.getInt(1);
		    	nomBDD =result.getString(2);
		    }while(!(pseudo.equals(nomBDD)) && (ID != nbrcolumn));

		   //String sql = "{call insert_player("+nom+")}";
		    
			if(!pseudo.equals(nomBDD)){
				System.out.println("ERROR");
				Statement state2 = BoulderDashBDDConnector.getInstance().createStatement();

			    state2.executeUpdate("INSERT INTO listplayer (Pseudo) VALUES ('"+pseudo+"') ");
				
			}
			else{
				System.out.println("Found");
			}
	       
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	}
	public String requestSelect(String level){

        try {

            // Statement allows us to make SQL request
            Statement st; 

            //  ResultSet store the result of statement 
            ResultSet rst;

            st = BoulderDashBDDConnector.getInstance().createStatement();
            rst = st.executeQuery("SELECT * From map WHERE map_name = '"+level+"'");
            // Return the first line
            rst.next();

                // Return the map from the data base
                return rst.getString("mapCode"); 

        } catch (Exception ex) {

            // Print the exception and the state of the execution stack
            ex.printStackTrace(); 
          }

        return null;
    }
	

}
