package com.isolatedpixel.skymission.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.isolatedpixel.skymission.StartPoint;
import com.isolatedpixel.skymission.graphics.Assets;

public class DifficultySelectorScreen implements Screen {

	private Stage stage;
	private Table table;

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
	public void show() {
		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		System.out.println(Assets.isLoaded(Assets.MenuSkin));

		Skin skin = Assets.get(Assets.MenuSkin, Skin.class);

		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table.debug();

		Label header = new Label("Project Sky", skin, "large");
		header.setFontScale(2);

		List list = new List(new String[] { "noob", "amateur", "boss" }, skin);

		// list.scale(1.5f);

		TextButton bGo = new TextButton("GO!", skin);
		bGo.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.addAction(Actions.sequence(Actions.fadeOut(.2f),
						Actions.run(new Runnable() {
							@Override
							public void run() {
								((Game) Gdx.app.getApplicationListener())
										.setScreen(new GameScreen());
							}
						})));
			}
		});
		bGo.pad(30);

		TextButton bBack = new TextButton("BACK", skin, "small");
		bBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.addAction(Actions.sequence(Actions.fadeOut(.2f),
						Actions.run(new Runnable() {
							@Override
							public void run() {
								((Game) Gdx.app.getApplicationListener())
										.setScreen(new MainMenu());

							}
						})));
			}
		});
		bBack.pad(10);

		table.add(header).center().spaceTop(100).colspan(3).row();
		table.add().colspan(3).width(Gdx.graphics.getWidth()).spaceBottom(100)
				.row();
		table.add(list);
		table.add(bGo);
		table.add(bBack).bottom().right();

		stage.addActor(table);

		stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(.2f)));
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
