package com.isolatedpixel.skymission.objects.ammo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.objects.collision.Collideable;

public abstract class Projectile extends Collideable {
	// static final float size = .4f;

	// static final float speed = 2f;

	float maxLife = 3f;
	float life = 0;

//	public static int dmg = 1;

	boolean right;

	Vector2 position = new Vector2();
//	Rectangle bounds = new Rectangle();

	public Projectile(Vector2 pos, boolean right, float width, float height) {
		super(pos,width,height);
		this.position = pos;
//		bounds.x = pos.x;
//		bounds.y = pos.y;
//		this.bounds.width = width;
//		this.bounds.height = height;

	}
	
	public static int dmg = 1;

	public abstract Texture getTexture();

	public void draw(SpriteBatch b) {

		b.draw(getTexture(), rect.getX(), rect.getY(), rect.getWidth(),
				rect.getHeight());

	}

	public boolean isRight() {
		return right;
	}

	public Rectangle getBounds() {
		return rect;
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getHeight() {
		return rect.height;
	}

	public float getWidth() {
		return rect.width;
	}

float b_speed;
	public float getSpeed() {
		return b_speed;
	}
	
	public abstract boolean update(float delta);

}
