package com.isolatedpixel.skymission.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Door {

	static final float size = 2f;

	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();

	public Door(Vector2 pos) {

		this.position = pos;
		this.bounds.width = size/4;
		this.bounds.height = size*4;

	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public static float getSize() {
		return size;
	}
}
