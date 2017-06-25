package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Obstacle Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class unbreakableWall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('x', "unbreakableWall.png");
    private String Type="unbreakableWall";
    public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	/**
    /**
     * Instantiates a new obstacle.
     */
	 public unbreakableWall() {
        super(SPRITE, Permeability.BLOCKING);
        this.setSprite(SPRITE);
    }

}
