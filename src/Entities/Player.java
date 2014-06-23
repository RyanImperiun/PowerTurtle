package Entities;

import java.awt.Graphics;

import Core.Game;

public class Player extends Entity {
	private int			shotTimer	= 1000;
	private boolean		canFire		= true;
	private Projectile	test;

	private long		lastTime;

	public Player(Game game) {
		ga = game;
		width = 64;
		height = 64;
		moveSpeed = 5;
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(ga.img.player, (int) x, (int) y, null);
		if (test != null)
			test.render(g);
	}

	@Override
	public void update(double delta) {
		checkShotTimer();

		movement(delta);
		fireProjectile();

		if (test != null)
			test.update(delta);

		boundaryCollision();
	}

	public void fireProjectile() {
		if (canFire && ga.mou.leftButton) {
			test = new Projectile(ga, x, y, ga.mouseP.x, ga.mouseP.y);
			canFire = false;
		}
	}

	private void movement(double delta) {
		if (ga.key.left.down) {
			x -= moveSpeed * delta;
		}
		if (ga.key.right.down) {
			x += moveSpeed * delta;
		}

		if (ga.key.up.down) {
			y -= moveSpeed * delta;
		}
		if (ga.key.down.down) {
			y += moveSpeed * delta;
		}
	}

	private void checkShotTimer() {
		long currentTime = System.currentTimeMillis();
		// This will get every other tick, and then multiply by ticks per second. Should work out to 2 seconds, or whatever "shotTimer" is in seconds
		if (currentTime - lastTime >= shotTimer) {
			canFire = true;
			lastTime = currentTime;
		}
	}

	private void boundaryCollision() {
		if (x <= 0)
			x = 0;
		if (x + width >= ga.ren.getWidth())
			x = ga.ren.getWidth() - width;

		if (y <= 0)
			y = 0;
		if (y + height >= ga.ren.getHeight())
			y = ga.ren.getHeight() - height;
	}
}