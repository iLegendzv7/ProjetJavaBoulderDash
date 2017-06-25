<<<<<<< HEAD
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.ControllerFacade;
import model.ModelFacade;
//import model.dao.HashMap;
//import model.dao.ResultSetMetaData;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     */
    public static void main(final String[] args) throws SQLException {
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
        
        String url = "jdbc:mysql://localhost:8889/boulderdash?useSSL=false&serverTimezone=UTC";
        String user = "remy";
        String passwd = "remy";
        char[][] map3 = new char[22][40];
        java.util.HashMap<Character, Integer> listeImage = new java.util.HashMap<>();
        int x=0,y=0;
        Connection conn = DriverManager.getConnection(url, user, passwd);

        Statement state = conn.createStatement();

        ResultSet result = state.executeQuery("SELECT * FROM Map4");

        java.sql.ResultSetMetaData resultMeta = result.getMetaData();

        int ligne = 0;
        listeImage.put('x', 1);
        listeImage.put('p', 2);
        listeImage.put('b', 3);
        listeImage.put('d', 4);
        listeImage.put('v', 5);
        listeImage.put('a', 6);
        listeImage.put('j', 7);
        //Window fdp = new Window();
        while (result.next()) {
            for (int colonne = 0; colonne < result.getObject(2).toString().length(); colonne++) {
                map3[ligne][colonne] = result.getObject(2).toString().charAt(colonne);
                // System.out.print(map3[ligne][colonne]);

            }
            // System.out.print("\n");
            ligne++;

        }
        
        for (char lireTableau[] : map3) {
            for (char chr : lireTableau) {
                if (listeImage.containsKey(chr)) {
                    System.out.print(listeImage.get(chr));

                }
            }
            System.out.print("\n");
        }
        
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
=======
//package main;
//
//import java.sql.SQLException;
//
//import controller.ControllerFacade;
//import model.ModelFacade;
//import view.ViewFacade;
//
///**
// * <h1>The Class Main.</h1>
// *
// * @author Jean-Aymeric DIET jadiet@cesi.fr
// * @version 1.0
// */
//public abstract class Main {
//
//    /**
//     * The main method.
//     *
//     * @param args
//     *            the arguments
//     */
//    public static void main(final String[] args) {
//        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
//
//        try {
//        	
//            controller.start();
//        } catch (final SQLException exception) {
//            exception.printStackTrace();
//        }
//    }
//
//}

package main;

import java.io.IOException;

import controller.BoulderDashController;
import controller.IBoulderDashController;
import model.ImyCharacterModel;
import model.myCharacterModel;
import view.BoulderDashView;

/**
 * <h1>The InsaneVehicles Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class Main {

    /** The Constant startX. */
    private static final int startX = 4;

    /** The Constant startY. */
    private static final int startY = 1;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             the interrupted exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
 
    	final ImyCharacterModel model = new myCharacterModel("Map_Java5.txt", startX, startY);
        
        	final BoulderDashView view = new BoulderDashView(model.getMap(), model.getMyVehicle());
        
        final IBoulderDashController controller = new BoulderDashController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    	
    }
}

>>>>>>> bc6f3c29191d59c6299ab8f5ecd1f5f7b31e0dde
