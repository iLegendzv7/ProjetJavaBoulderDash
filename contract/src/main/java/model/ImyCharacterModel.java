package model;

import model.ICharacter;

/**
 * <h1>The Interface IInsaneVehiclesModel.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface ImyCharacterModel {

    /**
     * Gets the road.
     *
     * @return the road
     */
    IMap getMap();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    ICharacter getMyVehicle();

}
