package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Floor Class.</h1>
 *
 */
public class Floor extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('v', "floor.png");
    private String Type="Floor";
    public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	/**
    /**
     * Instantiates a new Floor.
     */
	 public Floor() {
        super(SPRITE, Permeability.PENETRABLE);
        this.setSprite(SPRITE);
    }

}
