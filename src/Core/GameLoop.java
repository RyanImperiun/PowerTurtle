package Core;

public class GameLoop implements Runnable {
	private Game	ga;
	private Thread	gameThread;

	// Variables for the FPS and UPS counter
	public double	ticksPerSecond	= 60D;
	public int		ticks			= 0;
	private int		frames			= 0;
	private int		FPS				= 0;
	private int		UPS				= 0;

	// Used in the "run" method to limit the frame rate to the UPS
	boolean			limitFrameRate	= false;
	boolean			shouldRender;

	public GameLoop(Game game) {
		ga = game;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / ticksPerSecond;

		long lastTimer = System.currentTimeMillis();
		ga.upd.delta = 0D;

		while (ga.running) {
			long now = System.nanoTime();
			ga.upd.delta += (now - lastTime) / nsPerTick;
			lastTime = now;

			// If you want to limit frame rate, shouldRender = false
			shouldRender = false;

			// If the time between ticks = 1, then various things (shouldRender = true, keeps FPS locked at UPS)
			while (ga.upd.delta >= 1) {
				ticks++;
				ga.upd.tick();
				ga.upd.delta = 0;
				shouldRender = true;
			}
			if (!limitFrameRate && ticks > 0)
				shouldRender = true;

			// If you should render, render!
			if (shouldRender) {
				frames++;
				ga.ren.render();
			}

			// Reset stuff every second for the new "FPS" and "UPS"
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer = System.currentTimeMillis();
				FPS = frames;
				UPS = ticks;
				frames = 0;
				ticks = 0;
				ga.setTitle(Launcher.TITLE + " FPS: " + FPS + " UPS: " + UPS);
			}
		}
	}

	public synchronized void start() {
		ga.running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public synchronized void stop() {
		ga.running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}