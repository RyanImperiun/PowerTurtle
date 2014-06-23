package Core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import Entities.Player;
import Input.Keyboard;
import Input.Mouse;
import Resources.Images;

public class Game extends JFrame {
	private static final long	serialVersionUID	= 1L;

	// Classes
	public Rendering			ren;
	public Updating				upd;
	public GameLoop				gl;
	public Images				img;
	public Keyboard				key;
	public Mouse				mou;
	public Player				pla;

	// Window related things
	public boolean				running				= false;
	private final int			WIDTH				= 1280;
	private final int			HEIGHT				= 720;
	public final Dimension		gameDim				= new Dimension(WIDTH, HEIGHT);

	public int					xOffset				= 0;
	public int					yOffset				= 0;
	public Point				mouseP				= new Point(-1, -1);

	public Game() {
		createFrame();

		ren.requestFocus();
	}

	private void createFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		setMinimumSize(gameDim);
		setMaximumSize(gameDim);
		setPreferredSize(gameDim);

		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		init();
		pack();

		addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent arg0) {
			}

			public void windowClosed(WindowEvent arg0) {
			}

			public void windowClosing(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent arg0) {
			}

			public void windowDeiconified(WindowEvent arg0) {
			}

			public void windowIconified(WindowEvent arg0) {
			}

			public void windowOpened(WindowEvent arg0) {
			}
		});
	}

	private void init() {
		img = new Images();
		gl = new GameLoop(this);
		ren = new Rendering(this, this);
		upd = new Updating(this);
		key = new Keyboard(this);
		mou = new Mouse(this);
		pla = new Player(this);

		gl.start();
	}
}