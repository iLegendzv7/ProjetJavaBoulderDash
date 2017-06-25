package model;

import java.awt.Point;
import java.io.IOException;

import model.IElement;
import view.IPawn;

/**
 * <h1>The Interface IMobile.</h1>
 *
 * @see IPawn
 * @see IElement
 */
public interface ICharacter extends IPawn, IElement {

    /**
     * Move up.
     * 
     */
    void moveUp()  ;

    /**
     * Move left.
     * 
     */
    void moveLeft() ;

    /**
     * Move down.
     * 
     */
    void moveDown() ;

    /**
     * Move right.
     * 
     */
    void moveRight() ;

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();
   
    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
   // Boolean isCrashed();

    Boolean isWon();
    /*
     * (non-Javadoc)
     * @see view.IPawn#getPosition()
     */
    @Override
    Point getPosition();

}
