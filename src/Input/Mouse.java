package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Core.Game;

public class Mouse implements MouseListener, MouseMotionListener {
	Game			ga;

	public boolean	leftButton	= false;	// MouseEvent.BUTTON1
	public boolean	rightButton	= false;	// MouseEvent.BUTTON3

	public Mouse(Game game) {
		game.ren.addMouseListener(this);
		game.ren.addMouseMotionListener(this);
		ga = game;
	}

	// Don't use
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		ga.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		ga.key.releaseAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftButton = true;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightButton = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftButton = false;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightButton = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		ga.mouseP = e.getPoint();
	}
}