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
     * @param levelName
     *            the level name
     * @param myCharacterStartX
     *             my Character start X
     * @param myCharacterStartY
     *             my Character start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public myCharacterModel(final String levelName, final int myCharacterStartX, final int myCharacterStartY)
            throws IOException {
        this.setMap(new Map(levelName));
        
        this.setMyCharacter(new MyCharacter(myCharacterStartX, myCharacterStartY, this.getMap()));
    }

    /* (non-Javadoc)
     * @see model.ImyCharacterModel#getRoad()
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the map to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see model.IBoulderDashModel#getMyVehicle()
     */
    @Override
    public final ICharacter getMyCharacter() {
        return this.myCharacter;
    }

    /**
     * Sets the my character.
     *
     * @param myCharacter
     *            the myCharacter to set
     */
    private void setMyCharacter (final ICharacter myCharacter) {
        this.myCharacter = myCharacter;
    }

}
