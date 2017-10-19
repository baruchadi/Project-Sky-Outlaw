package com.isolatedpixel.skymission.screens.cutscenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.screens.DemoWorld;
import com.isolatedpixel.skymission.screens.GameScreen;
import com.isolatedpixel.skymission.world.WorldController;
import com.isolatedpixel.skymission.world.WorldRenderer;

public class Tavern implements Screen, InputProcessor {

	private DemoWorld world;
	private WorldRenderer renderer;
	private int width, height;
	private SpriteBatch batcher, b2;

	public Skin skin;

	Stage stage;
	BitmapFont font;
	private WorldController controller;

	int num = 0;

	public OrthographicCamera textCam;

	String[] text = new String[] { "You ain’t got a chance boy!",
			"Gunslingers like you aren’t wanted around here anymore!",
			"YA HEAR ME!?", "GET HIM BOYS!", "..." };

	int textnum = 0;

	float alpha = 1f;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		renderer.Render();

		world.getBob().update(delta / 3);

		switch (num) {
		default:
		case 0: {
			if (world.getBob().getPosition().x < 10f)
				controller.rightPressed();
			else {
				controller.rightReleased();
				num++;
			}
		}
			break;
		case 1:
			if (textnum <= text.length - 1) {

				// renderer.cam.position.set(world.getBob().getPosition().x+3,
				// world.getBob().getPosition().y-4, 0);
				// renderer.cam.update();

				batcher.begin();
				batcher.setProjectionMatrix(textCam.combined);

				
				
				if (textnum == text.length - 1)
					font.setColor(0, 0, 1, .8f);
				else
					font.setColor(1, 0, 0, .8f);

				// font.setScale(-5, -5);
				
				batcher.setColor(1, 1, 1, .5f);
				
				batcher.draw(Assets.selected, 0, 150, 600,50);
				
				
				font.draw(batcher, text[textnum], 20, 190);
				batcher.end();
			} else {
				alpha -= (2f * delta);
				renderer.setAlpha(alpha);
				if (alpha <= .05f) {
					((Game) Gdx.app.getApplicationListener())
							.setScreen(new GameScreen());
				}
			}
			break;

		}

		controller.update(delta / 3);
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
		controller = new WorldController(world);
		renderer = new WorldRenderer(world);
		Gdx.input.setInputProcessor(this);
		skin = Assets.get(Assets.MenuSkin, Skin.class);
		batcher = new SpriteBatch();

		textCam = new OrthographicCamera(600, 200);

		textCam.position.set(300, 100, 0);
		textCam.update();
		font = new BitmapFont();

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
		if (num == 1) {
			if (keycode == Keys.X) {
				textnum++;
			}
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
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
