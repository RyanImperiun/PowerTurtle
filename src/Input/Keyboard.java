package Input;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import Core.Game;

public class Keyboard implements KeyListener {

	Game				ga;
	Point				mouseP;

	public List<Key>	keys	= new ArrayList<Key>();

	public Key			left	= new Key();
	public Key			right	= new Key();
	public Key			up		= new Key();
	public Key			down	= new Key();

	public class Key {

		public boolean	down, clicked;
		private short	absorbs, presses;

		public void tick() {
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}

		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}

			if (pressed) {
				presses++;
			}
		}

		public Key() {
			keys.add(this);
		}
	}

	public Keyboard(Game game) {
		game.ren.addKeyListener(this);
		ga = game;
	}

	public void tick() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).tick();
		}
	}

	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}

	public void toggle(KeyEvent e, boolean pressed) {
		// Movement
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
			left.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
			right.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
			up.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
			down.toggle(pressed);
	}

	public void keyPressed(KeyEvent e) {
		toggle(e, true);

		// Misc
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		toggle(e, false);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}