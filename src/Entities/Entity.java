package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Core.Game;

public abstract class Entity {
	public Game				ga;
	public BufferedImage	entityImage;
	public double			x, y, width, height, moveSpeed;
	public Rectangle		boundingBox;

	public abstract void render(Graphics g);

	public abstract void update(double delta);
}