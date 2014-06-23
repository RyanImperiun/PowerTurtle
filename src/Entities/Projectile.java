package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Core.Game;

public class Projectile extends Entity {
	double	dX, dY, angle, diffX, diffY, sX, sY, xVel, yVel;

	public Projectile(Game game, double startX, double startY, double destX, double destY) {
		ga = game;
		moveSpeed = 5;
		dX = destX;
		dY = destY;
		x = startX;
		y = startY;
		sX = startX;
		sY = startY;

		determineVelocities();
	}

	private void determineVelocities() {
		diffX = dX - sX;
		diffY = dY - sY;

		double length = Math.sqrt((diffX * diffX) + (diffY * diffY));

		xVel = (diffX) / length * moveSpeed;
		yVel = (diffY) / length * moveSpeed;
	}

	@Override
	public void render(Graphics g) {
		// g.drawImage(entityImage, x, y, null);
		g.setColor(Color.BLACK);
		g.fillOval((int) x, (int) y, 32, 32);
	}

	@Override
	public void update(double delta) {
		x += xVel;
		y += yVel;
	}
}