package Resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public BufferedImage	player;
	public BufferedImage	bg;

	public Images() {
		try {
			player = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/BetterTurtle.png"));
			bg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Images/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}