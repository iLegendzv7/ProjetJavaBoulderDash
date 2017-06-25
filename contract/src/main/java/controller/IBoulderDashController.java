package controller;

import controller.IOrderPerformer;

/**
 * <h1>The Interface IBoulderDashController.</h1>
 *
 * @see IOrderPerformer
 */
public interface IBoulderDashController {

    /**
     * Start the game
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void play() throws InterruptedException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
