 package model;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Tree Class.</h1>
 *
 * @author Jade
 * @version 0.2
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
     * Instantiates a new tree.
     */
    public Diamond() {
    	
        super(SPRITE, Permeability.LOOTABLE);
        this.setSprite(SPRITE);
    }

}
