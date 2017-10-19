package com.isolatedpixel.skymission.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

	static final float size = 1f;

	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();

	public Block(Vector2 pos) {

		this.position = pos;
		this.bounds.width = size;
		this.bounds.height = size;

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
