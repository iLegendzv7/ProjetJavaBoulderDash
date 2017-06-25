package model;

import java.awt.Image;
import java.io.IOException;

public interface ISprite {
	public  Image getImage();
	public  char getConsoleImage();
	public  void loadImage() throws IOException;
}
