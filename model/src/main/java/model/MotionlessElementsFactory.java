package model;

import model.Boulder;
import model.Diamond;
import model.Door;
import model.Floor;
import model.MotionlessElement;
import model.Wall;
import model.unbreakableWall;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.3
 */
public abstract class MotionlessElementsFactory {

	/** The Constant ditchRight. */
	private static final Door door = new Door();

	/** The Constant ditchLeft. */
	private static final Wall wall = new Wall();

	/** The Constant ditchLeftTurnLeft. */
	private static final Boulder boulder = new Boulder();

	/** The Constant TREE. */
	private static final Diamond DIAMOND = new Diamond();

	
	public static Diamond getDiamond() {
		return DIAMOND;
	}

	/** The Constant MACADAM. */
	private static final Floor floor = new Floor();

	/** The Constant OBSTACLE. */
	private static final unbreakableWall UNBREAKABLEWALL = new unbreakableWall();

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static MotionlessElement[] motionlessElements = { door, wall, boulder, floor, UNBREAKABLEWALL, DIAMOND };

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */

	public static MotionlessElement createDitchRight() {
		return door;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDitchLeft() {
		return wall;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDitchLeftTurnLeft() {
		return boulder;
	}

	public static MotionlessElement createMacadam() {
		return floor;
	}

	/**
	 * Creates a new obstacle object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createObstacle() {
		return UNBREAKABLEWALL;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createTree() {
		return DIAMOND;
	}

	/**
	 * Gets the good MotionlessElement from file symbol.
	 *
	 * @param fileSymbol
	 *            the file symbol
	 * @return the from file symbol
	 */
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
				
				return motionlessElement;
			}
		
		}
	
		return floor;
	}
}
