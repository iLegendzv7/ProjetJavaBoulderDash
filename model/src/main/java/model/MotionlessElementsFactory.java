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
 */
public abstract class MotionlessElementsFactory {

	/** The Constant door. */
	private static final Door door = new Door();

	/** The Constant wall. */
	private static final Wall wall = new Wall();

	/** The Constant boulder. */
	private static final Boulder boulder = new Boulder();

	/** The Constant DIAMOND. */
	private static final Diamond DIAMOND = new Diamond();
	/** The Constant MONSTER. */
	private static final Monster MONSTER = new Monster();

	/** The Constant UNBREAKABLEWALL. */
	private static final unbreakableWall UNBREAKABLEWALL = new unbreakableWall();

	/** The Constant floor. */
	private static final Floor floor = new Floor();

	public static Diamond getDiamond() {
		return DIAMOND;
	}

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static MotionlessElement[] motionlessElements = { door, wall, boulder, floor, UNBREAKABLEWALL, DIAMOND,
			MONSTER };



	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createWall() {
		return wall;
	}
	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createMonster() {
		return MONSTER;
	}
	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */

	public static MotionlessElement createDoor() {
		return door;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createBoulder() {
		return boulder;
	}

	public static MotionlessElement createFloor() {
		return floor;
	}

	/**
	 * Creates a new obstacle object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createUnbreakableWall() {
		return UNBREAKABLEWALL;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDiamond() {
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
