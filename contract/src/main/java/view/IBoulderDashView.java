package view;

import java.io.IOException;

import model.IMap;
import view.IBoard;

/**
 * <h1>The Interface IBoulderDashView.</h1>
 *

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
     * Follow RockFord.
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
