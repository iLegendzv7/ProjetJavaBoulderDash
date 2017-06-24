package view;

import java.io.IOException;

import model.IMap;
import BoardFrame;

/**
 * <h1>The Interface IInsaneVehiclesView.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IBoulderDashView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    public BoardFrame getBoardFrame();
    /**
     * Follow myVehicle.
     * @throws IOException 
     */
    void setMap(IMap map) throws IOException;
    void followRockford();
   // public void show(int i);

}
