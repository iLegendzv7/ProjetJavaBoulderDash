package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.ICharacter;
import controller.IOrderPerformer;
import controller.UserOrder;
import model.IMap;
import view.BoardFrame;

/**
 * <h1>The InsaneVehiclesView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class BoulderDashView implements Runnable, KeyListener, IBoulderDashView {

	/** The Constant mapView. */
	private static final int mapView = 22;

	/** The Constant squareSize. */

	/** The Constant closeView. */
	private Rectangle closeView;

	/** The road. */
	private IMap map;

	/** My vehicle. */
	private ICharacter myCharacter;

	/** The view. */
	private int view;

	/** The order performer. */
	private IOrderPerformer orderPerformer;
	private BoardFrame boardFrame;

	public BoardFrame getBoardFrame() {
		return boardFrame;
	}

	public void setBoardFrame(BoardFrame boardFrame) {
		this.boardFrame = boardFrame;
	}

	/**
	 * Instantiates a new insane vehicles View.
	 *
	 * @param map
	 *            the map
	 * @param myCharacter
	 *            the my Character
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public BoulderDashView(final IMap map, final ICharacter myCharacter) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		
		this.setMyCharacter(myCharacter);
		this.getMyCharacter().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getMyCharacter().getY(), this.getMap().getWidth(), mapView));
		SwingUtilities.invokeLater(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.
	 * String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public final void run() {
		
		this.boardFrame = new BoardFrame("Close view");
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(1000, 600);
		// boardFrame.setResizable(true);
		// boardFrame.setHeightLooped(true);
		
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		// int i=0;
		// while( i==0){
		// for (int x = 0; x < this.getMap().getWidth(); x++) {
		// for (int y = 0; y < this.getMap().getHeight(); y++) {
		// boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
		// }
		// }
		// i++;
		// }
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheNewTabXY(x, y), x, y);
			}

			boardFrame.addPawn(this.getMyCharacter());

			this.getMap().getObservable().addObserver(boardFrame.getObserver());
			this.followRockford();
			boardFrame.setVisible(true);
			
		}
	

	}


	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
		}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(UserOrder.NOP);
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followMyvehicle()
	 */
	@Override
	public final void followRockford() {
		this.getCloseView().y = this.getMyCharacter().getY() - 1;
	}

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	private IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the road.
	 *
	 * @param map
	 *            the new road
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setMap( IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.getMap().getOnTheNewTabXY(x, y).getSprite().loadImage();

			}
		}
	}

	/**
	 * Gets my vehicle.
	 *
	 * @return my vehicle
	 */
	private ICharacter getMyCharacter() {
		return this.myCharacter;
	}

	/**
	 * Sets my vehicle.
	 *
	 * @param myVehicle
	 *            my new vehicle
	 */
	private void setMyCharacter(final ICharacter myCharacter) {
		this.myCharacter = myCharacter;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private int getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	private void setView(final int view) {
		this.view = view;
	}

	/**
	 * Gets the close view.
	 *
	 * @return the close view
	 */
	private Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
}
