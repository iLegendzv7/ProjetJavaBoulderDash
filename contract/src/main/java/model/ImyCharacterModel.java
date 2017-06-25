package model;

import model.ICharacter;

/**
 * <h1>The Interface ImyCharacterModel.</h1>
 *
 */
public interface ImyCharacterModel {

    /**
     * Gets the map.
     *
     * @return the map
     */
    IMap getMap();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    ICharacter getMyCharacter();

}
