package model;
import model.Permeability;
import model.Sprite;



/*
 * <h1>The Monster Class.</h1>
 */
public class Monster extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('m', "Monster.png");
    private String Type="Monster";
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    
    /*
     * Instantiates a new Monster.
     */
     public Monster() {
        super(SPRITE, Permeability.DEAD);
        this.setSprite(SPRITE);
    }

}