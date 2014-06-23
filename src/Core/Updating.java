package Core;

public class Updating {
	Game			ga;
	public double	delta;

	public Updating(Game game) {
		ga = game;
	}

	public void tick() {
		ga.key.tick();
		ga.pla.update(delta);
	}
}