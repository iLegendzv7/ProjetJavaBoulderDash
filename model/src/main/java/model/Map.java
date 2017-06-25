package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.IElement;
import model.MotionlessElementsFactory;
import model.dao.Request;

/**
 * <h1>The Map Class.</h1>
 *
 */
class Map extends Observable implements IMap {

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	private final int score = 1;

	/** The on the map. */
	private IElement[][] onTheMap;

	public IElement[][] getOnTheMap() {
		return onTheMap;
	}

	public int getScore() {
		return score;
	}

	public void setOnTheMap(IElement[][] onTheMap) {
		this.onTheMap = onTheMap;
	}

	/**
	 * Instantiates a new map with the content of the String levelName.
	 *
	 * @param levelName
	 *            the level where the map is
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	Map(final String levelName) throws IOException {
		super();

		this.loadMap(levelName);
	}

	/**
	 * Loads map.
	 *
	 * @param levelName
	 *            the level name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */

	private void loadMap(final String levelName) throws IOException {

		this.setWidth(40);
		this.setHeight(22);
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		Request requete = new Request();
		String texte = requete.requestSelect(levelName);
		String ligne;

		int nbLignes = 22;
		int nbCol = 40;
		for (int lignCour = 0; lignCour < nbLignes; lignCour++) {
			ligne = texte.substring(lignCour * 42, (lignCour * 42) + nbCol);

			for (int colCour = 0; colCour < nbCol; colCour++) {

				this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(ligne.toCharArray()[colCour]), colCour,
						lignCour);

			}

		}

	}

	public IElement[][] updateElement() {
		int nbrColonne = 40;
		int nbrLigne = 22;
		char[][] updateMapArray = new char[nbrColonne][nbrLigne];
		int ligne = 0;
		int colonne = 0;
		IElement[][] tableauTransfert = new IElement[nbrColonne][nbrLigne];
		for (IElement lireTableauElement[] : this.getOnTheMap()) {
			for (IElement lireNewTab : lireTableauElement) {
				switch (lireNewTab.getType()) {

				case "Boulder":
					updateMapArray[colonne][ligne] = 'b';// b
					break;
				case "Diamond":
					updateMapArray[colonne][ligne] = '#';// d
					break;
				case "Door":
					updateMapArray[colonne][ligne] = 'a';// a
					break;
				case "Floor":
					updateMapArray[colonne][ligne] = 'v';// v
					break;
				case "unbreakableWall":
					updateMapArray[colonne][ligne] = 'x';// x
					break;
				case "Wall":
					updateMapArray[colonne][ligne] = 'p';// p
					break;
				case "rien":
					updateMapArray[colonne][ligne] = '=';
					break;

				}
				tableauTransfert[colonne][ligne] = lireNewTab;
				// System.out.print(updateMapArray[colonne][ligne]);

				ligne++;
			}
			// System.out.println();
			colonne++;
			ligne = 0;

		}

		// System.out.println("\nFIN DE BOUCLE");
		return tableauTransfert;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getWidth()
	 */
	@Override
	public final int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the new width
	 */
	private void setWidth(final int width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getHeight()
	 */
	@Override
	public final int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	private void setHeight(final int height) {
		this.height = height;
	}

	public void printScoreNeeded() {
		System.out.println("You need " + score + " to end the level");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getOnTheRoadXY(int, int)
	 */
	@Override
	public final IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	public IElement getOnTheNewTabXY(final int x, final int y) {
		return this.updateElement()[x][y];
	}

	/**
	 * Sets the on the map XY.
	 *
	 * @param element
	 *            the element
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void setOnTheMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMap#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	public void watchRoad(IElement[][] onTheRoad) {
		if (!this.onTheMap.equals(onTheRoad)) {

		}
		setChanged();
		notifyObservers(onTheRoad);

	}

}
