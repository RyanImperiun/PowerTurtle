package Core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Rendering extends Canvas {
	private static final long	serialVersionUID	= 1L;

	Game						ga;
	BufferedImage				image;

	public Rendering(Game game, JFrame frame) {
		ga = game;
		setMinimumSize(ga.gameDim);
		setMaximumSize(ga.gameDim);
		setPreferredSize(ga.gameDim);
		frame.add(this, BorderLayout.CENTER);

		image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

		/*
		 * Draw stuff below here to appear
		 */
		g.drawImage(ga.img.bg, 0, 0, getWidth(), getHeight(), null);

		ga.pla.render(g);

		/*
		 * Touch nothing below here, unless you want crashing
		 */

		g.dispose();
		bs.show();
	}
}