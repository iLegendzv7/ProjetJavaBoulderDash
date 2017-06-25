package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.IElement;
import model.MotionlessElementsFactory;

/**
 * <h1>The Road Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
class Map extends Observable implements IMap {

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	private final int score =5;


	/** The on the road. */
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
	 * Instantiates a new road with the content of the file fileName.
	 *
	 * @param fileName
	 *            the file name where the map of the road is
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	Map(final String fileName) throws IOException {
		super();
		this.loadFile(fileName);
	}

	/**
	 * Loads file.
	 *
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int y = 0;
		line = buffer.readLine();
		this.setWidth(Integer.parseInt(line));
		line = buffer.readLine();
		this.setHeight(Integer.parseInt(line));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = buffer.readLine();
		while (line != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}
	
	
	public IElement[][] updateElement() {
		int nbrColonne = 40;
		int nbrLigne = 22;
		char[][] updateMapArray = new char[nbrColonne][nbrLigne];
		int ligne = 0;
		int colonne = 0;
		IElement[][] tableauTransfert=new IElement[nbrColonne][nbrLigne];
for (IElement lireTableauElement[]:this.getOnTheMap()){
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
				tableauTransfert[colonne][ligne]=lireNewTab;
			//	System.out.print(updateMapArray[colonne][ligne]);

				ligne++;
			}
		//	System.out.println();
			colonne++;
			ligne = 0;

		}
	

	//	System.out.println("\nFIN DE BOUCLE");
		return  tableauTransfert;

}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getWidth()
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
	 * @see fr.exia.insanevehicles.model.IRoad#getHeight()
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
	public void printScoreNeeded(){
		System.out.println("You need "+score+" to end the level");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
	 */
	@Override
	public final IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	public IElement getOnTheNewTabXY(final int x,final int y){
		return this.updateElement()[x][y];
	}
	/**
	 * Sets the on the road XY.
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
	 * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}



	public void watchRoad(IElement[][] onTheRoad){
		if(!this.onTheMap.equals(onTheRoad)){
			
		}
		setChanged();
		notifyObservers(onTheRoad);
		
	}


}
