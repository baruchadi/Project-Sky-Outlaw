package com.isolatedpixel.skymission.objects.collision;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Collideable {

	public Rectangle rect;

	public Collideable(Rectangle rect) {
		this.rect = rect;
	}

	public Collideable(float x, float y, float width, float height) {
		this.rect = new Rectangle(x, y, width, height);
	}
	public Collideable(Vector2 pos,float width, float height) {
		this.rect = new Rectangle(pos.x, pos.y, width, height);
	}
	public float getY() {
		return rect.getY();
	}

	public float getHeight() {
		return rect.getHeight();
	}

	public float getX() {
		return rect.getX();
	}

	public float getWidth() {
		return rect.getWidth();
	}
	
	
	public abstract void draw(SpriteBatch b, float delta);
}
