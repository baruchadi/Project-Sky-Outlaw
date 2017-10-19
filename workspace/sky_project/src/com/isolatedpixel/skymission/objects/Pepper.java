package com.isolatedpixel.skymission.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.objects.collision.Collideable;

public class Pepper extends Collideable {
	float x, y;

	final float maxHealth = 100;

	float health;

	Rectangle bounds;

	Sprite sprite;

	public Pepper(float x, float y) {
		super(x, y, 1 * .8f, 1.5f * .8f);
		this.x = x;
		this.y = y;
		stateTime = 0;

		bounds = new Rectangle(x, y, 1 * .8f, 1.5f * .8f);
		sprite = new Sprite(Assets.mBox[0]);
		health = maxHealth;
		Vector2 v;

	}

	// public float rotate_point(float pointX,float pointY, float originX,float
	// originY,float angle) {
	// angle = (float) (angle * Math.PI / 180.0);
	//
	// return {
	// x:(float)( Math.cos(angle) * (pointX-originX) - Math.sin(angle) *
	// (pointY-originY) + originX),
	// y: (float)(Math.sin(angle) * (pointX-originX) + Math.cos(angle) *
	// (pointY-originY) + originY)
	// };
	// }

	public Rectangle getBounds() {
		return bounds;

	}

	int r;
//
//	public void draw(SpriteBatch b, float delta) {
//		// sprite.setRotation(sprite.getRotation() + 2);
//		b.setColor(1, 1, 1, a);
//		if (!des) {
//			r = (Assets.mBox.length - 1)
//					- (int) (health / maxHealth * (Assets.mBox.length - 1));
//
//			sprite.setRegion(Assets.mBox[r]);
//
//			b.draw(sprite, x, y, bounds.getWidth(), bounds.getHeight());
//		} else {
//			stateTime += delta;
//
//			b.draw(Assets.boxAnim.getKeyFrame(stateTime), x, y,
//					bounds.getWidth(), bounds.getHeight());
//
//		}
//		// rotate_point(bounds.getX(), bounds.getY(), 4, 2, 4);
//	}

	public void update(float delta) {
		// r++;
		// s.setRotation(s.getRotation()+25);
		// if (des)
		// stateTime += delta;
	}

	float delta = 0;

	public boolean hit(int dmg) {
		health -= dmg;
		if (health <= 0) {
			this.destroy(0);
			return true;
		} else
			return false;
	}

	boolean des = false;
	float stateTime;

	public boolean destroy(float d) {
		this.des = true;
		// this.stateTime += delta;

		// this.sprite.setRegion(Assets.boxAnim.getKeyFrame(stateTime));
		if (Assets.boxAnim.isAnimationFinished(stateTime))
			if (a < .3f)
				return true;
			else {
				a -= 1f * d;
				return false;
			}

		else
			return false;
	}

	public float a = 1;


	@Override
	public void draw(SpriteBatch b, float delta) {
		// sprite.setRotation(sprite.getRotation() + 2);
		b.setColor(1, 1, 1, a);
		if (!des) {
			r = (Assets.mBox.length - 1)
					- (int) (health / maxHealth * (Assets.mBox.length - 1));

			sprite.setRegion(Assets.mBox[r]);

			b.draw(sprite, x, y, bounds.getWidth(), bounds.getHeight());
		} else {
			stateTime += delta;

			b.draw(Assets.boxAnim.getKeyFrame(stateTime), x, y,
					bounds.getWidth(), bounds.getHeight());

		}
		// rotate_point(bounds.getX(), bounds.getY(), 4, 2, 4);
		
	}


}
