package com.isolatedpixel.skymission.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.tween.SpriteAccessor;

public class Splash implements Screen {

	private Sprite splashSprite;

	private SpriteBatch batcher;

	private TweenManager tweenManager;
	Texture splashTexture;

	@Override
	public void show() {
		batcher = new SpriteBatch();

		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		Assets.loadMenus();
		splashTexture = Assets.get(Assets.Splash, Texture.class);
		splashSprite = new Sprite(splashTexture);
		splashSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		Tween.set(splashSprite, SpriteAccessor.ALPHA).target(0)
				.start(tweenManager);
		Tween.to(splashSprite, SpriteAccessor.ALPHA, 1f).target(1).start(tweenManager);
		// .repeatYoyo(1, .5f).setCallback(new TweenCallback() {
		//
		// @Override
		// public void onEvent(int type, BaseTween<?> source) {
		// ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
		//
		// }
		// }).start(tweenManager);
		//
		tweenManager.update(Float.MIN_VALUE);

		// StartPoint.assets.lo
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batcher.begin();
		splashSprite.draw(batcher);
		batcher.end();
		
		if (Assets.update()) {
			Tween.to(splashSprite, SpriteAccessor.ALPHA, 1f).target(0)
					.delay(1.5f).setCallback(new TweenCallback() {

						@Override
						public void onEvent(int type, BaseTween<?> source) {
							((Game) Gdx.app.getApplicationListener())
									.setScreen(new MainMenu());

						}
					}).start(tweenManager);
		}

		

		System.out.println(Assets.getProgress());

		tweenManager.update(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		batcher.dispose();

	}

}
