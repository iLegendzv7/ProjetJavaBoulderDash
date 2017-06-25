package model;

import model.Permeability;
import model.Sprite;;

/**
 * <h1>The DitchLeft Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('p', "Wall.png");
    private String Type="Wall";
    public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	/**
    /**
     * Instantiates a new Wall.
     */
	 public   Wall() {
        super(SPRITE, Permeability.BREAKABLE);
        this.setSprite(SPRITE);
    }

}
