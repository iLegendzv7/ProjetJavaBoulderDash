package model;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The MyVehicle Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class MyCharacter extends CharacterActions {

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite('j', "immobile.png");

	/** The Constant spriteTurnLeft. */
	private static final Sprite spriteTurnLeft = new Sprite('j', "gauche.png");

	/** The Constant spriteTurnRight. */
	private static final Sprite spriteTurnRight = new Sprite('j', "droite.png");

	private static final Sprite spriteGoUp = new Sprite('j',"Up.png");
	/** The Constant spriteExplode. */
	private static final Sprite spriteExplode = new Sprite('j', "mouru.png");
	
	private static final Sprite spriteGoDown = new Sprite('j', "Down.png");

	/**
	 * Instantiates a new my vehicle.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param map
	 *            the road
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public MyCharacter(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteGoUp.loadImage();
		spriteExplode.loadImage();
		spriteGoDown.loadImage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
	 */
	@Override
	public final void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteTurnLeft);
	}
	public final void moveUp() {
		super.moveUp();
		this.setSprite(spriteGoUp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
	 */
	@Override
	public final void moveRight() {
		super.moveRight();
		this.setSprite(spriteTurnRight);
	}
	
	public final void moveDown() {
		super.moveDown();
		this.setSprite(spriteGoDown);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
	 */
	@Override
	protected final void die() {
		super.die();
		this.setSprite(spriteExplode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
	 */
	@Override
	public final void doNothing() {
		super.doNothing();
		this.setSprite(sprite);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}


}
