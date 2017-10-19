package com.isolatedpixel.skymission.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.objects.collision.Collideable;

public class Box extends Collideable {

	float x, y;

	int health = 5;

	Rectangle bounds;

	public Box(float x, float y) {
		super(x, y, 1*.5f, 1.5f*.5f);
		this.x = x;
		this.y = y;

		bounds = new Rectangle(x, y, 1*.5f, 1.5f*.5f);

	}

	public Rectangle getBounds() {
		return bounds;

	}


	public boolean hit(int dmg) {
		health -= dmg;
		if (health <= 0) {
			return true;
		} else
			return false;
	}

	@Override
	public void draw(SpriteBatch b, float delta) {
		b.setColor(1, 1, 1, 1);
		b.draw(Assets.box, x, y, bounds.getWidth(), bounds.getHeight());

	}



}
