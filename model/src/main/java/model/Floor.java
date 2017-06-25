package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Macadam Class.</h1>
 *
 * @author Jade
 * @version 0.2
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
     * Instantiates a new macadam.
     */
	 public Floor() {
        super(SPRITE, Permeability.PENETRABLE);
        this.setSprite(SPRITE);
    }

}
