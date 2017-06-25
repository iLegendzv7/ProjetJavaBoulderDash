package model;

import model.Element;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The MotionlessElement Class.</h1>
 *
 */
public abstract class MotionlessElement extends Element {

    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement( Sprite sprite,  Permeability permeability) {
        super(sprite, permeability);
    }

}
