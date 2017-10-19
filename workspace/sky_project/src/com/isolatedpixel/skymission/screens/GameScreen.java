package com.isolatedpixel.skymission.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.isolatedpixel.skymission.StartPoint;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.mobs.Player;
import com.isolatedpixel.skymission.world.WorldController;
import com.isolatedpixel.skymission.world.WorldRenderer;

public class GameScreen implements Screen, InputProcessor {

	private DemoWorld world;
	private WorldRenderer renderer;
	private WorldController controller;
	private SpriteBatch batcher, b2;

	private int width, height;

	private Label l_speed, l_width, l_height;

	String s_speed, s_width, s_height;

	public Skin skin;

	Stage stage;
	BitmapFont font;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		if (renderer.getAlpha() < .9f) {
			renderer.setAlpha(renderer.getAlpha() + (2 * delta));
		} else {
			renderer.setAlpha(1);
		}

		controller.update(delta);
		renderer.Render();

		l_height.setText(s_height + DemoWorld.bob.getBounds().height);
		l_speed.setText(s_speed + Player.SPEED);
		l_width.setText(s_width + DemoWorld.bob.getBounds().width);
		if (StartPoint.debug) {
			batcher.begin();
			l_height.draw(batcher, 1);
			l_speed.draw(batcher, 1);
			l_width.draw(batcher, 1);

			batcher.end();

		}
	}

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		renderer.setSize(width, height);

	}

	@Override
	public void show() {
		world = new DemoWorld();
		renderer = new WorldRenderer(world);
		controller = new WorldController(world);
		Gdx.input.setInputProcessor(this);
		skin = Assets.get(Assets.MenuSkin, Skin.class);
		batcher = new SpriteBatch();
		b2 = new SpriteBatch();

		stage = new Stage();

		s_speed = "speed: ";
		s_width = "width: ";
		s_height = "height: ";

		font = new BitmapFont();

		l_speed = new Label(s_speed + Player.SPEED, skin, "small");
		l_width = new Label(s_width + DemoWorld.bob.getBounds().width, skin,
				"small");
		l_height = new Label(s_height + DemoWorld.bob.getBounds().height, skin,
				"small");

		l_height.setPosition(10, 5);
		l_width.setPosition(10, 55);
		l_speed.setPosition(10, 105);
		batcher.begin();
		l_height.draw(batcher, 1);
		l_speed.draw(batcher, 1);
		l_width.draw(batcher, 1);
		batcher.end();

	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public boolean keyDown(int keycode) {

		if (keycode == Keys.LEFT)
			controller.leftPressed();
		if (keycode == Keys.RIGHT)
			controller.rightPressed();
		if (keycode == Keys.DOWN)
			controller.downPressed();
		if (keycode == Keys.UP)
			controller.upPressed();
		if (keycode == Keys.C)
			controller.crouchPressed();
		if (keycode == Keys.Z)
			controller.jumpPressed();
		if (keycode == Keys.X)
			controller.firePressed();

		// ========== //

		if (keycode == Keys.Q)
			controller.incSPressed();
		if (keycode == Keys.A)
			controller.decSPressed();
		if (keycode == Keys.W)
			controller.incWPressed();
		if (keycode == Keys.S)
			controller.decWPressed();
		if (keycode == Keys.E)
			controller.incHPressed();
		if (keycode == Keys.D)
			controller.decHPressed();

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftReleased();
		if (keycode == Keys.RIGHT)
			controller.rightReleased();

		if (keycode == Keys.DOWN)
			controller.downReleased();
		if (keycode == Keys.UP)
			controller.upReleased();

		if (keycode == Keys.C)
			controller.crouchReleased();

		if (keycode == Keys.Z)
			controller.jumpReleased();
		if (keycode == Keys.X)
			controller.fireReleased();

		// ================== //

		if (keycode == Keys.J) {
			controller.tDebugPressed();
		}

		// ================== //

		if (keycode == Keys.Q)
			controller.incSReleased();
		if (keycode == Keys.A)
			controller.decSReleased();
		if (keycode == Keys.W)
			controller.incWReleased();
		if (keycode == Keys.S)
			controller.decWReleased();
		if (keycode == Keys.E)
			controller.incHReleased();
		if (keycode == Keys.D)
			controller.decHReleased();

		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {

		if (x < width / 2 && y > height / 2)
			controller.leftPressed();
		if (x > width / 2 && y > height / 2)
			controller.rightPressed();
		if (x > width / 2 && y < height / 2)
			controller.firePressed();
		return true;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if (x < width / 2 && y > height / 2)
			controller.leftReleased();
		if (x > width / 2 && y > height / 2)
			controller.rightReleased();
		if (x > width / 2 && y < height / 2)
			controller.fireReleased();
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
