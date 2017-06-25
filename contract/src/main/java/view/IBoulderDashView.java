package view;

import java.io.IOException;

import model.IMap;
import view.IBoard;

/**
 * <h1>The Interface IInsaneVehiclesView.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IBoulderDashView {

    /**
     * Display message.
     *;
     * @param message;
     *            the message
     */
    void displayMessage(String message);
    public IBoard getBoardFrame();
    /**
     * Follow myVehicle.
     *  
     */
    void followRockford();
    /**
     * set the map
     * @param map;
     * 			the map
     * @throws IOException
     *  Signals that an I/O exception has occurred.
     */
    void setMap(IMap map) throws IOException;
    
  

}
