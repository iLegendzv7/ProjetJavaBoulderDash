 package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Diamond Class.</h1>
 *
 */
 public class Diamond extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('d', "Diamond.png");
    private String Type="Diamond";
    public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	/**
    /**
     * Instantiates a new Diamond.
     */
    public Diamond() {
    	
        super(SPRITE, Permeability.LOOTABLE);
        this.setSprite(SPRITE);
    }

}
