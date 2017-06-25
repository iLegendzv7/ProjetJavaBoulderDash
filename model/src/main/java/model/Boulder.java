package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Ditch Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class Boulder extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('b', "boulder.png");
    private String Type="Boulder";
    public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	/**
    /**
     * Instantiates a new ditch.
     */
	 public Boulder() {
        super(SPRITE, Permeability.BLOCKING);
        this.setSprite(SPRITE);
    }
	
}
