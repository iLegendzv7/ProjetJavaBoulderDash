package model;

import java.io.IOException;

import model.ICharacter;
import model.MyCharacter;

/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class myCharacterModel implements ImyCharacterModel {

    /** The road. */
    private IMap   map;

    /** The my vehicle. */
    private ICharacter myCharacter;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myCharacterStartX
     *             my Character start X
     * @param myCharacterStartY
     *             my Character start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public myCharacterModel(final String fileName, final int myCharacterStartX, final int myCharacterStartY)
            throws IOException {
        this.setMap(new Map(fileName));
        
        this.setMyCharacter(new MyCharacter(myCharacterStartX, myCharacterStartY, this.getMap()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getRoad()
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    @Override
    public final ICharacter getMyVehicle() {
        return this.myCharacter;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setMyCharacter (final ICharacter myCharacter) {
        this.myCharacter = myCharacter;
    }

}
