package com.isolatedpixel.skymission.mobs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.objects.collision.Collideable;

public abstract class BasicAI extends Collideable {

	// Close Range

//	Rectangle bounds;

	public BasicAI(float x, float y, float width, float height) {
		super(new Vector2(x,y),width,height);

	}

	public abstract void draw(SpriteBatch b);

	public abstract void attack(Player player);

	float speed = .5f;

	public void moveLeft(float s1) {
		left = true;
		if (rect.x - s1 > 0)
			rect.x -= s1;
	}

	public void moveRight(float s1) {
		left = false;
		if (rect.x + s1 < 15)
			rect.x += s1;
	}

	public void moveUp(float s1) {
		if (rect.y + s1 < 3.5f)
			rect.y += s1;
	}

	public void moveDown(float s1) {
		if (rect.y - s1 > .25f)
			rect.y -= s1;
	}

	boolean left = true;
	
	float stateTime = 0;
	float x1, y1;
	float s;

	public void update(Player bob, float delta) {

		stateTime += delta;
		x1 = bob.position.x;
		y1 = bob.position.y;
		s = speed * delta;

		if (Math.abs(rect.getY() - y1) < range
				&& Math.abs(rect.getX() - x1) < range) {
			attack(bob);
		} else {

			if (x1 > this.rect.x)
				moveRight(s);
			else if (x1 < this.rect.x)
				moveLeft(s);

			if (y1 > this.rect.getY())
				moveUp(s / 2);
			else if (y1 < this.rect.getY())
				moveDown(s / 2);
		}

	}

	float range = 1;

}
