package com.isolatedpixel.skymission.objects.ammo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.graphics.Assets;

public class Card extends Projectile {

	float maxLife = 3f;
	float life = 0;

	float b_speed = 10;

	float rotation;

	Sprite s;

	public Card(Vector2 pos, boolean right) {
		super(pos, right, .2f, .4f);

		rotation = 90;

		// s = new Sprite(Assets.card, (int) bounds.getX(), (int) bounds.getY(),
		// (int) bounds.getWidth(), (int) bounds.getHeight());
		// // s.setRotation(rotation);
		if (right) {
			this.position.x += .4f;
		} else {

			b_speed = -b_speed;
		}

	}

	@Override
	public void draw(SpriteBatch b) {

		b.draw(Assets.card1, rect.x, rect.y, rect.width / 2, rect.height / 2,
				rect.width, rect.height, 1, 1f, rotation);

		// s.draw(b);

	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Assets.card;
	}

	@Override
	public boolean update(float delta) {
		rotation += -delta * 1800;
		this.position.x += b_speed * delta;
		rect.x = position.x;
		rect.y = position.y;

		life += delta;
		System.out.println(delta + ", " + life + " / " + maxLife);
		if (life > maxLife) {
			return false;
		} else
			return true;

	}

	@Override
	public void draw(SpriteBatch b, float delta) {
		// TODO Auto-generated method stub

	}

}
