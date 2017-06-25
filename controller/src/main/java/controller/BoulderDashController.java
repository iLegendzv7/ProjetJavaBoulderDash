package controller;

import java.io.IOException;

import model.ImyCharacterModel;
import view.IBoulderDashView;

/**
 * <h1>The Class BoulderDashController.</h1>
 *
 * @see IOrderPerformer
 */
public class BoulderDashController implements IBoulderDashController, IOrderPerformer {

	/** The Constant speed. */
	private static final int speed = 300;

	/** The view. */
	private IBoulderDashView view;

	/** The model. */
	private ImyCharacterModel model;

	/** The stack order. */
	private UserOrder stackOrder;

	/**
	 * Instantiates a new BoulderDash controller.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public BoulderDashController(final IBoulderDashView view, final ImyCharacterModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IBoulderDashController#play()
	 */
	@Override
	public final void play() throws InterruptedException {
		
		while (!this.getModel().getMyCharacter().isWon()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				this.getModel().getMyCharacter().moveRight();
				break;
			case LEFT:
				this.getModel().getMyCharacter().moveLeft();
				break;
			case UP:
				this.getModel().getMyCharacter().moveUp();
				break;
			case DOWN:
				this.getModel().getMyCharacter().moveDown();
				break;
			case NOP:
			default:
				this.getModel().getMyCharacter().doNothing();
				break;
			}

		}
		this.getView().displayMessage("YOU WON !!!!!!!!!.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * controller.IOrderPerformer#orderPerform( controller.UserOrder)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * controller.IBoulderDashController#orderPerform
	 * (controller.UserOrder)
	 */
	@Override
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IBoulderDashView getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the view to set
	 */
	private void setView(final IBoulderDashView view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	private ImyCharacterModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the model to set
	 */
	private void setModel(final ImyCharacterModel model) {
		this.model = model;
	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder
	 *            the new stack order
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Clear stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IBoulderDashController#
	 * getOrderPeformer()
	 */
	@Override
	public IOrderPerformer getOrderPeformer() {
		return this;
	}

}
