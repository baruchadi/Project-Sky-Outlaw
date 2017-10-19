package com.isolatedpixel.skymission.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.mobs.Player;
import com.isolatedpixel.skymission.world.WorldController;
import com.isolatedpixel.skymission.world.WorldRenderer;

public class TestGraphics implements Screen, InputProcessor {

	private DemoWorld world;
	private WorldRenderer renderer;
	private int width, height;
	private SpriteBatch batcher, b2;

	public Skin skin;

	Stage stage;
	BitmapFont font;
	private WorldController controller;

	int num = 0;

	int textnum = 0;

	float alpha = 1f;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		renderer.Render();
		DemoWorld.bob.getVelocity().x = 0;

		world.getBob().update(delta / 3);
		DemoWorld.bob.getVelocity().x = 0;
		controller.update(delta / 3);

		DemoWorld.bob.getVelocity().x = 0;
	}

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		renderer.setSize(width, height);
	}

	@Override
	public void show() {

		Player.SPEED = 0;

		world = new DemoWorld();
		controller = new WorldController(world);
		renderer = new WorldRenderer(world);
		Gdx.input.setInputProcessor(this);
		skin = Assets.get(Assets.MenuSkin, Skin.class);
		batcher = new SpriteBatch();

		DemoWorld.bob.setPosition(new Vector2(4, 4));

		font = new BitmapFont();

		DemoWorld.bob.getVelocity().x = 0;

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean keyDown(int keycode) {

		if (keycode == Keys.LEFT)
			controller.leftPressed();
		if (keycode == Keys.RIGHT)
			controller.rightPressed();
//		if (keycode == Keys.DOWN)
//			controller.crouchPressed();

		

		DemoWorld.bob.getVelocity().x = 0;

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.R) {
			Assets.loadPlayer(0);
		}
		if (keycode == Keys.LEFT)
			controller.leftReleased();
		if (keycode == Keys.RIGHT)
			controller.rightReleased();

		// if (keycode == Keys.DOWN)
		// controller.crouchReleased();
		DemoWorld.bob.getVelocity().x = 0;

		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
