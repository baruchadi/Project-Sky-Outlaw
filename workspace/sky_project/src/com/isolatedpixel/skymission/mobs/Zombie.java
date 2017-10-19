package com.isolatedpixel.skymission.mobs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.isolatedpixel.skymission.graphics.Assets;

public class Zombie extends BasicAI {

	public static float w = .75f;
	public static float h = 1.8f;

	public Zombie(float x, float y) {
		super(x, y, w, h);

	}

	TextureRegion t;

	boolean oldLeft = false;

	@Override
	public void draw(SpriteBatch b) {
		//t = new TextureRegion(Assets.mosh.getKeyFrame(stateTime));
		t = new TextureRegion(Assets.moshX);
		
			t.flip(left, false);
		

		oldLeft = left;
		
		b.draw(t, rect.x, rect.y, rect.width, rect.height);
	}

	@Override
	public void attack(Player player) {

	}

	@Override
	public void draw(SpriteBatch b, float delta) {
		// TODO Auto-generated method stub
		
	}

}
