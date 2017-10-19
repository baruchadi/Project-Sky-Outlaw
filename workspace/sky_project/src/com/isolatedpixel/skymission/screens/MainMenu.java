package com.isolatedpixel.skymission.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.isolatedpixel.skymission.StartPoint;
import com.isolatedpixel.skymission.graphics.Assets;

public class MainMenu implements Screen {

	private Stage stage;

	private Skin skin; // done
	private Table table;

	@Override
	public void show() {
		Assets.get(Assets.Splash, Texture.class).dispose();

		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		skin = Assets.get(Assets.MenuSkin, Skin.class);

		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		Label header = new Label("Project Sky", skin, "large");
		header.setFontScale(2);

		TextButton bPlay = new TextButton("PLAY", skin);
		bPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				stage.addAction(Actions.sequence(Actions.fadeOut(.2f),
						Actions.run(new Runnable() {
							@Override
							public void run() {
								((Game) Gdx.app.getApplicationListener())
										.setScreen(new DifficultySelectorScreen());

							}
						})));

			}
		});
		bPlay.pad(15);

		TextButton bExit = new TextButton("EXIT", skin, "small");
		bExit.addListener(new ClickListener() {
			@Override
			public void clicked(
					com.badlogic.gdx.scenes.scene2d.InputEvent event, float x,
					float y) {
				Gdx.app.exit();
			}
		});
		bExit.pad(15);

		table.pad(20);

		table.add(header);
		table.getCell(header).spaceBottom(100);
		table.row();
		table.add(bPlay).spaceBottom(20);
		table.row();
		table.add(bExit).spaceBottom(20);
		table.debug();
		table.pad(20);
		stage.addActor(table);
		stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(.2f)));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.35f, 0.64f, 0.65f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (StartPoint.debug)
			Table.drawDebug(stage);

		stage.act(delta);
		stage.draw();

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
		stage.dispose();

	}

}
