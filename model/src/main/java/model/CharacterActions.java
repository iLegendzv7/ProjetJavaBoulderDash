package model;

import java.awt.Point;

import model.Element;

import model.Permeability;
import model.Sprite;
import model.*;
import view.IBoard;

/**
 * <h1>The CharacterActions Class.</h1>
 *

 */
abstract class CharacterActions extends Element implements ICharacter {

	/**
	 * The x.
	 */
	private Point position;

	/** The alive. */
	private Boolean alive = true;

	private Boolean win = false;
	/** The map. */
	private IMap map;
	/** The Score */
	private int score;
	/** The board. */
	private IBoard board;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	CharacterActions(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the road
	 * @param permeability
	 *            the permeability
	 */
	CharacterActions(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.BLOCKING) {
			this.setY(this.getY());
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
				.getPermeability() == Permeability.LOOTABLE) {
			this.getMap().getOnTheMap()[this.getX()][this.getY() - 1] = new Floor();
			this.incrementScore();
			this.setY(this.getY() - 1);
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.ESCAPE) {

			this.won();

			this.setY(this.getY() - 1);
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
				.getPermeability() == Permeability.BREAKABLE) {
			this.getMap().getOnTheMap()[this.getX()][this.getY()] = new Floor();
			this.setY(this.getY() - 1);
			this.getMap().updateElement();

		}   if (this.getMap().getOnTheMapXY(this.getX(), this.getY()-1).getPermeability() == Permeability.DEAD) {
            this.setY(this.getY() - 1);
            this.die();

        } if (this.getMap().getOnTheMapXY(this.getX(), this.getY()-1).getPermeability() == Permeability.PENETRABLE) {
            this.setY(this.getY() - 1);
            ;

        }


		
		this.setHasMoved();
		// System.out.println(this.getRoad().getOnTheRoad()[this.getX()][this.getY()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.BLOCKING) {
			this.setX(this.getX());
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
				.getPermeability() == Permeability.BREAKABLE) {
			


			this.getMap().setOnTheMapXY(new Floor(), this.getX(), this.getY());
			this.getMap().updateElement();
			this.setX(this.getX() - 1);
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
				.getPermeability() == Permeability.LOOTABLE) {
			this.getMap().getOnTheMap()[this.getX() - 1][this.getY()] = new Floor();
			this.incrementScore();
			this.setX(this.getX() - 1);
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.TEST) {

			this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.setSprite(MotionlessElementsFactory.getDiamond().getSprite());

			this.setX(this.getX() - 1);
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.ESCAPE) {

			this.won();

			this.setX(this.getX() - 1);
		} else {
			this.setX(this.getX() - 1);

			this.setHasMoved();
		}
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.BLOCKING) {
			this.setY(this.getY());
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
				.getPermeability() == Permeability.BREAKABLE) {
			this.getMap().getOnTheMap()[this.getX()][this.getY() + 1] = new Floor();
			this.getMap().updateElement();
			this.setY(this.getY() + 1);
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
				.getPermeability() == Permeability.LOOTABLE) {
			this.getMap().getOnTheMap()[this.getX()][this.getY() + 1] = new Floor();
			this.incrementScore();
			this.setY(this.getY() + 1);
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.ESCAPE) {

			this.won();

			this.setY(this.getY() + 1);
		}  else if (this.getMap().getOnTheMapXY(this.getX() , this.getY()+1).getPermeability() == Permeability.DEAD) {
            this.setY(this.getY() +1);
            this.die();

        }

		else {
			this.setY(this.getY() + 1);

		}
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.BLOCKING) {
			this.setX(this.getX());
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
				.getPermeability() == Permeability.BREAKABLE) {
			this.getMap().getOnTheMap()[this.getX() + 1][this.getY()] = new Floor();
			this.getMap().updateElement();
			this.setX(this.getX() + 1);
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
				.getPermeability() == Permeability.LOOTABLE) {
			this.getMap().getOnTheMap()[this.getX() + 1][this.getY()] = new Floor();
			this.incrementScore();
			this.setX(this.getX() + 1);
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.ESCAPE) {
			this.won();
			this.setX(this.getX() + 1);
		}
		else if (this.getMap().getOnTheMapXY(this.getX() +1, this.getY()).getPermeability() == Permeability.DEAD) {
	            this.setX(this.getX() +1);
	            this.die();

	        }else {
			this.setX(this.getX() + 1);
		}
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * Sets the has moved.
	 */
	private void setHasMoved() {
		this.getMap().setMobileHasChanged();

	}

	// public

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
	 */
	@Override
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x
	 *            the new x
	 */
	public final void setX(final int x) {
		this.getPosition().x = x;
		// if (this.isCrashed()) {
		// this.die();
	}
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
	 */
	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 *            the new y, as the road is an infinite loop, there's a modulo
	 *            based on the road height.
	 */
	public final void setY(final int y) {
		this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
		// if (this.isCrashed()) {
		// if(this.getRoad().getOnTheRoadXY(getX(),
		// y-1).getPermeability()==Permeability.BLOCKING){

		// }

		// this.die();
	}
	// }

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the new map
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}


	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	public Boolean isWon() {
		return this.win;
	}

	public int incrementScore() {
		score++;
		System.out.println(score);
		return score;

	}

	/**
	 * Dies.
	 */
	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}

	protected void won() {
		if (score >= this.getMap().getScore()) {
			this.win = true;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
	 */

	// @Override
	// public Boolean isCrashed() {
	// //return this.getMap().getOnTheRoadXY(this.getX(),
	// this.getY()).getPermeability() == Permeability.BLOCKING;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
	 */
	@Override
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the position to set
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	protected IBoard getBoard() {
		return this.board;
	}

}