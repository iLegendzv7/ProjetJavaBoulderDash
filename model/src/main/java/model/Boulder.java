package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Boulder Class.</h1>
*
*
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
     * Instantiates a new boulder.
     */
	 public Boulder() {
        super(SPRITE, Permeability.BLOCKING);
        this.setSprite(SPRITE);
    }
	
}
