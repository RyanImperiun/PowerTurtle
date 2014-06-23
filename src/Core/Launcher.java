package Core;

import javax.swing.JFrame;

public class Launcher extends JFrame {
	private static final long	serialVersionUID	= 1L;
	// Window related things
	public static final String	TITLE				= "Power Turtle - InDev 0.0.1";
	private int					width				= 640;
	private int					height				= 480;

	public Launcher() {
		setTitle(TITLE);
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Game();
	}
}