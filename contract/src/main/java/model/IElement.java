package model;

import java.awt.Image;

import view.ISquare;

/**
 * <h1>The Interface IElement.</h1>
 *
 * @see ISquare
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    public  ISprite getSprite();
	public void setSprite(ISprite sprite);

    
    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
        public int getElementX();


	public void setElementX(int elementX) ;

	public int getElementY() ;

	public void setElementY(int elementY) ;
    public Permeability getPermeability();
    public String getType();
    public void setType(String type);

    /*;
     * (non-Javadoc)
     * @see view.ISquare#getImage()
     */
    @Override
    public Image getImage();


  

}
