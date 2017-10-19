package com.isolatedpixel.skymission.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObj {
	
	TextureRegion t;
	Vector2 vector;
	Rectangle rec;
	
	
	public GameObj(TextureRegion tex,Rectangle rec) {
		t = tex;
		this.rec = rec;
	
	}
	
	public void draw(SpriteBatch batcher){
		batcher.draw(t, rec.x, rec.y,
				rec.width, rec.height);
	}
	
	public void setT(TextureRegion t) {
		this.t = t;
	}
}
