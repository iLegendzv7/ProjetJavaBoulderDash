package view;



import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;



public class ReadSprite extends JFrame {

	private static final long serialVersionUID = 1L;
	static BufferedImage unbreakableWall;
	static BufferedImage breakableWall;
	static BufferedImage floor;
	static BufferedImage boulder;
	static BufferedImage diamond;
	static BufferedImage character;
	static BufferedImage door;
	private Connexion connexion;

	public ReadSprite() throws IOException {
		setSize(656, 384);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Game boulderdash");
		init();

	}

	private void init() {

		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		BufferedImage spriteSheet2 = null;

		try {
			spriteSheet = loader.loadImage("sprite decor.png");
			spriteSheet2 = loader.loadImage("Sprite perso.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		SpriteSheet ss = new SpriteSheet(spriteSheet);
		SpriteSheet player = new SpriteSheet(spriteSheet2);
		unbreakableWall = ss.grabSprite(0, 0, 16, 16);
		breakableWall = ss.grabSprite(17, 0, 16, 16);
		floor = ss.grabSprite(33, 0, 16, 16);
		boulder = ss.grabSprite(49, 0, 16, 16);
		diamond = ss.grabSprite(64, 0, 16, 16);
		door = ss.grabSprite(96, 0, 16, 16);
		character = player.grabSprite(0, 0, 16, 16);

	}

	@Override
	public void paint(Graphics g) {
		try {
			Connexion aled = new Connexion();

			int ligne = 0;

			while (aled.getResult().next()) {
				for (int colonne = 0; colonne < aled.getResult().getObject(2).toString().length(); colonne++) {
					aled.map3[ligne][colonne] = aled.getResult().getObject(2).toString().charAt(colonne);

				}

				ligne++;

			}

			int x = 10;
			int y = 30;
			for (char lireTableau[] : aled.map3) {
				for (char chr : lireTableau) {
					if (chr == 'x') {
						g.drawImage(unbreakableWall, x, y, this);
					} else if (chr == 'p') {
						g.drawImage(breakableWall, x, y, this);
					} else if (chr == 'v') {
						g.drawImage(floor, x, y, this);
					} else if (chr == 'b') {
						g.drawImage(boulder, x, y, this);
					} else if (chr == 'd') {
						g.drawImage(diamond, x, y, this);
					} else if (chr == 'j') {
						g.drawImage(character, x, y, this);
					} else if (chr == 'a') {
						g.drawImage(door, x, y, this);
					}

					x += 16;
					repaint();
				}
				y += 16;
				x = 10;
				repaint();
			}
		repaint();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
