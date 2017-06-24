package model;

import java.util.Observable;

import model.IElement;

/**
 * <h1>The Interface IMap.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IMap {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    public IElement getOnTheMapXY(int x, int y);
    public void setOnTheMap(IElement[][] onTheRoad);
    public IElement[][] getOnTheMap();
    public void setOnTheMapXY(final IElement element, final int x, final int y);
    /**
     * Sets the mobile has changed.
     */
    public IElement[][] updateElement();
    void setMobileHasChanged();
    public void printScoreNeeded();	
    public int getScore() ;
    public void watchRoad(IElement[][] onTheRoad);
    public IElement getOnTheNewTabXY(final int x,final int y);
    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();
}
