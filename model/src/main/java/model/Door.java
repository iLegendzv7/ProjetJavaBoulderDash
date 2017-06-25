package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Door Class.</h1>
 *

 */
public class Door extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('a', "Door.png");
    
    private String Type="Door";
    public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	/**
     * Instantiates a new Door.
     */
    public Door() {
        super(SPRITE, Permeability.ESCAPE);
        this.setSprite(SPRITE);
    }
	

}
