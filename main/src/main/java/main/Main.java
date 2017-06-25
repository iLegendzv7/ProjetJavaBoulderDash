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

