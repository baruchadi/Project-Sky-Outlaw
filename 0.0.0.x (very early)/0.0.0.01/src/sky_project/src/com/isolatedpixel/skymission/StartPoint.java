package com.isolatedpixel.skymission;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.isolatedpixel.skymission.screens.Splash;

public class StartPoint extends Game {

	public static boolean debug = true;

	public static final String Title = "Project Sky", ver = "V. 0.0.0.0";
	
	public static AssetManager assets;

	// private OrthographicCamera camera;
	// private SpriteBatch batch;
	// private Texture texture;
	// private Sprite sprite;
	// private Button button;

	@Override
	public void create() {
		setScreen(new Splash());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

}
