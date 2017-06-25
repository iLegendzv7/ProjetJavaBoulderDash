package model;

import java.awt.Image;

import view.ISquare;

/**
 * <h1>The Element Class.</h1>
 *
 * @author Jade
 * @version 0.4
 * @see ISquare
 */
public class Element implements IElement {

	/** The sprite. */
	private Sprite sprite;
	public int elementX;
	public int elementY;

	public int getElementX() {
		return elementX;
	}

	public void setElementX(int elementX) {
		this.elementX = elementX;
	}

	public int getElementY() {
		return elementY;
	}

	public void setElementY(int elementY) {
		this.elementY = elementY;
	}

	/** The permeability. */
	private Permeability permeability;
	private String Type = "rien";

	/**
	 * Instantiates a new element.
	 *
	 * @param sprite
	 *            the sprite
	 * @param permeability
	 *            the permeability
	 */
	public Element(Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.IElement#getSprite()
	 */
	@Override
	public final ISprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite
	 *            the new sprite
	 */

	public final void setSprite(final Sprite sprite) {

		this.sprite = sprite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
	 */
	@Override
	public final Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * Sets the permeability.
	 *
	 * @param permeability
	 *            the new permeability
	 */
	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.ISquare#getImage()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.IElement#getImage()
	 */
	@Override
	public final Image getImage() {
		return this.getSprite().getImage();
	}

	@Override
	public String getType() {
		
		return Type;
	}

	@Override
	public void setType(String type) {
		this.Type=type;

	}

	@Override
	public void setSprite(ISprite sprite) {
		// TODO Auto-generated method stub
		
	}

}
