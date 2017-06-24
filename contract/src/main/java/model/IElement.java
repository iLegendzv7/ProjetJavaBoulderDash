package model;

import java.awt.Image;

import view.ISquare;

/**
 * <h1>The Interface IElement.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see ISquare
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();
    void setSprite(Sprite mdr);
    
    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
        public int getElementX();


	public void setElementX(int elementX) ;

	public int getElementY() ;

	public void setElementY(int elementY) ;
    Permeability getPermeability();
    public String getType();
    public void setType(String type);

    /*;
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    Image getImage();
  

}
