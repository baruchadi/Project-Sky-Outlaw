package com.isolatedpixel.skymission.objects.ammo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.graphics.Assets;

public class Bullet extends Projectile {
	// static final float size = 3f;

	// static final float speed = 2f;

	float maxLife = 3f;
	float life = 0;

	public static int dmg = 1;

	boolean right;
	float b_speed = 8f;

	// float b_speed = 12f;

	// Vector2 position = new Vector2();
	// Rectangle bounds = new Rectangle();

	public Bullet(Vector2 pos, boolean right) {
		super(pos, right, .1f, .05f);
		// super(pos, right, size, size);
		// this.position = pos;
		// bounds.x = pos.x;
		// bounds.y = pos.y;
		// this.bounds.width = .1f;
		// this.bounds.height = .05f;
		if (right) {
			this.position.x += .4f;
		} else {

			b_speed = -b_speed;
		}

	}

	@Override
	public boolean isRight() {
		return right;
	}

	@Override
	public boolean update(float delta) {
		this.position.x += b_speed * delta;
		rect.x = position.x;
		rect.y = position.y;

		life += delta;
		// System.out.println(delta + ", " + life + " / " + maxLife);
		if (life > maxLife) {
			return false;
		} else
			return true;

	}

	@Override
	public Texture getTexture() {

		return Assets.bullet;
	}

	@Override
	public void draw(SpriteBatch b, float delta) {
		
	}

}
