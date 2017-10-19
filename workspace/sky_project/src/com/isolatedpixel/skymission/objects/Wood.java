package com.isolatedpixel.skymission.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.objects.collision.Collideable;

public class Wood extends Collideable{

	static final float size = 20;

	Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();

	public Wood(Vector2 pos) {
		super(pos.x,pos.y,size,1);
		this.position = pos;
		this.bounds.width = size;
		this.bounds.height = 2.5f;

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

	@Override
	public void draw(SpriteBatch b, float delta) {
		
		
	}
}
