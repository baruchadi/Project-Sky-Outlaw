package com.isolatedpixel.skymission.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.isolatedpixel.skymission.StartPoint;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.mobs.Player;
import com.isolatedpixel.skymission.objects.Wood;
import com.isolatedpixel.skymission.screens.DemoWorld;

public class WorldRenderer {

	public static final float CAMERA_WIDTH = 10f;
	public static final float CAMERA_HEIGHT = 8f;

	private DemoWorld world;
	public OrthographicCamera cam, hud_cam, bg_cam, bg_cam2;

	ShapeRenderer debugRenderer = new ShapeRenderer();

	private Texture bobTexture;
	private Texture blockTexture;

	static private SpriteBatch batcher = new SpriteBatch();

	BitmapFont font;

	private int width;
	private int height;
	private float ppuX;
	private float ppuY;
	FPSLogger logger;
	private boolean debug = StartPoint.debug;

	float bgZoom = 2;

	// Texture bh1;
	// Sprite s;

	public float getAlpha() {
		return batcher.getColor().a;

	}

	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = width / CAMERA_WIDTH;
		ppuY = height / CAMERA_HEIGHT;

	}

	Skin s;

	public WorldRenderer(DemoWorld world) {

		this.world = world;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(5, 4f, 0);
		this.cam.update();

		hud_cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		hud_cam.position.set(5, 4, 0);
		hud_cam.update();

		bg_cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		bg_cam.position.set(5, 4, 0);

		bg_cam.update();

		bg_cam2 = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		bg_cam2.position.set(5, 4, 0);

		bg_cam2.update();

		logger = new FPSLogger();
		s = Assets.get(Assets.MenuSkin, Skin.class);
		font = new BitmapFont();
		font.setScale(.6f);
		// world.setTextures();

		// bh1 = new Texture(Gdx.files.internal("textures/bh1.png"));
		// s = new Sprite(bh1);
		// s.setPosition(world.getBob().getBounds().x,
		// world.getBob().getBounds().y);
		// s.setSize(world.getBob().getBounds().width,
		// world.getBob().getBounds().height);

	}

	// boolean flipped = false;
	// boolean b2 = false;

	public void setAlpha(float a) {

		batcher.setColor(1f, 1f, 1f, a);

	}

	float delta;
	float stateTime = 0;

	public static float testY = 3.20f, testH = .404494f,testX = 8,testW=.4f;

	public void Render() {
		stateTime += Gdx.graphics.getDeltaTime();
		Player bob = world.getBob();
		delta = Gdx.graphics.getDeltaTime();
		batcher.disableBlending();
		batcher.begin();
		batcher.setColor(1, 1, 1, 1);
		// batcher.setProjectionMatrix(hud_cam.combined);

		// batcher.draw(Assets.background0, 0, world.wood.get(0).getPosition().y
		// + world.wood.get(0).getBounds().height, CAMERA_WIDTH,
		// CAMERA_HEIGHT
		// - (world.wood.get(0).getPosition().y + world.wood
		// .get(0).getBounds().height));

		batcher.end();

		if (bob.getPosition().x + CAMERA_WIDTH * (2 / 3) < CAMERA_WIDTH / 2) {
			cam.position.set(5, cam.position.y, 0);

		} else if (bob.getPosition().x + CAMERA_WIDTH * (2 / 3) > world
				.getMaxWidth() - CAMERA_WIDTH / 2) {
			cam.position.set(world.getMaxWidth() - CAMERA_WIDTH / 2,
					cam.position.y, 0);
		} else {
			cam.position.set(bob.getPosition().x + CAMERA_WIDTH * (2 / 3),
					cam.position.y, 0);

		}

		if (bob.getPosition().x + CAMERA_WIDTH * (2 / 3) > CAMERA_WIDTH / 2
				&& bob.getPosition().x + CAMERA_WIDTH * (2 / 3) < world
						.getMaxWidth() - CAMERA_WIDTH / 2
				&& bob.getVelocity().x != 0) {

			bg_cam.position.add(-bob.getCamSpeed() * delta / 10, 0, 0);
			bg_cam2.position.add(-bob.getCamSpeed() * delta * 2 / 10, 0, 0);

		}
		// if(bob.getPosition().x>bg_cam.position.x+2){
		//
		// bg_cam.position.add(.05f, 0, 0);
		//
		// }

		bg_cam.update();
		bg_cam2.update();
		// batcher.disableBlending();
		batcher.setProjectionMatrix(bg_cam.combined);
		batcher.enableBlending();
		batcher.begin();
		// batcher.draw(Assets.background, 0, world.wood.get(0).getPosition().y
		// + world.wood.get(0).getBounds().height, CAMERA_WIDTH * 1.25f,
		// CAMERA_HEIGHT
		// - (world.wood.get(0).getPosition().y + world.wood
		// .get(0).getBounds().height));

		batcher.setProjectionMatrix(bg_cam2.combined);
		// batcher.draw(Assets.background1, 0, world.wood.get(0).getPosition().y
		// + world.wood.get(0).getBounds().height,
		// (float) (CAMERA_WIDTH * 1.5), CAMERA_HEIGHT
		// - (world.wood.get(0).getPosition().y + world.wood
		// .get(0).getBounds().height));
		cam.update();
		batcher.setProjectionMatrix(cam.combined);

		batcher.draw(Assets.mBackground, 0, world.wood.get(0).getPosition().y
				+ world.wood.get(0).getBounds().height, 20, CAMERA_HEIGHT
				- (world.wood.get(0).getPosition().y + world.wood.get(0)
						.getBounds().height));

		for (int i = 0; i < world.wood.size; i++) {
			batcher.draw(Assets.floor1, world.wood.get(i).getPosition().x,
					world.wood.get(i).getPosition().y, world.wood.get(i)
							.getBounds().width,
					world.wood.get(i).getBounds().height);
		}
		batcher.setColor(1, 1, 1, 1);

		// batcher.draw(Assets.l1, 7.5f, 2.5f, 1, 4);
		batcher.draw(Assets.wallScreen.getKeyFrame(bob.getST(), true),
				9.59375f, 3.188218f, .6875f, 0.45649332f);

		batcher.draw(Assets.blueScreen1.getKeyFrame(bob.getST(), true), 4.625f,
				6.090008f, .9375f, 0.3404948f);

		batcher.draw(Assets.redScreen.getKeyFrame(bob.getST(), true),
				5.7718716f, 6.268995f, 0.44299945f, 0.22649592f);
		
		batcher.draw(Assets.deskScreen.getKeyFrame(bob.getST(), true), 11.308337f,
				3.2759945f, 0.46099922f, 0.3494947f);

		
		
		batcher.draw(Assets.w_container.getKeyFrame(stateTime), .5f, world.wood.get(0).getPosition().y
				+ world.wood.get(0).getBounds().height, 1f, 2.3f);
		batcher.draw(Assets.tubes.getKeyFrame(stateTime), -.15f, world.wood.get(0).getPosition().y
				+ world.wood.get(0).getBounds().height, 2.18f, 3f);
		
		for (int i = 0; i < world.boxes.size(); i++) {
			world.boxes.get(i).draw(batcher, delta);
		}
		for (int i = 0; i < world.removeBox.size(); i++) {
			world.removeBox.get(i).draw(batcher, delta);
		}
		batcher.setColor(1, 1, 1, 1);
		// for (int i = 1; i < world.objects.size(); i++) {
		// world.objects.get(i).draw(batcher);
		// }

		for (int i = 0; i < world.projectiles.size(); i++) {

			if (world.projectiles.get(i).update(Gdx.graphics.getDeltaTime()))
				world.projectiles.get(i).draw(batcher);
			else
				world.projectiles.remove(world.projectiles.get(i));
		}

		batcher.draw(bob.getFrame(), bob.getPosition().x, bob.getPosition().y
				+ bob.JumpY, bob.getBounds().width, bob.getBounds().height);

		for (int i = 0; i < world.enemies.size(); i++) {
			world.enemies.get(i).draw(batcher);
		}

		// batcher.draw(Assets.dinoAnim.getKeyFrame(stateTime,true), 5, 2, 4,
		// 3);

		/**
		 * lights batcher.setBlendFunction(GL20.GL_SRC_ALPHA,
		 * GL20.GL_DST_ALPHA);//
		 * 
		 * batcher.setColor(1, 1, 1, 1f);
		 * 
		 * batcher.draw(Assets.light2, 4, 0, 8, 6.5f);
		 * 
		 * batcher.setBlendFunction(GL20.GL_SRC_ALPHA,
		 * GL20.GL_ONE_MINUS_SRC_ALPHA);//
		 * 
		 * batcher.setColor(1, 1, 1, 1);
		 **/

		// for (int i = 0; i < world.wood.size; i++) {
		// batcher.draw(Assets.triangle, world.wood.get(i).getPosition().x
		// + Wood.getSize() - 4, world.wood.get(i).getPosition().y, 4,
		// 2.75f);
		//
		// }
		for (int d = 0; d < world.damage.size(); d++) {

			if (world.damage.get(d).update(world.damage,
					Gdx.graphics.getDeltaTime())) {
				world.damage.get(d).draw(batcher);
			}

		}

		batcher.end();

		if (debug) {
			debugRenderer.setProjectionMatrix(cam.combined);
			debugRenderer.begin(ShapeType.Line);
			for (Wood block : world.getBlocks()) {
				Rectangle rect = block.getBounds();
				float x1 = block.getPosition().x + rect.x;
				float y1 = block.getPosition().y + rect.y;
				debugRenderer.setColor(new Color(1, 0, 0, 1));
				debugRenderer.rect(x1, y1, rect.width, rect.height);
			}

			Rectangle rect = bob.getBounds();
			float x1 = bob.getPosition().x + rect.x;
			float y1 = bob.getPosition().y + rect.y;
			debugRenderer.setColor(new Color(0, 1, 0, 1));
			debugRenderer.rect(x1, y1, rect.width, rect.height);
			debugRenderer.end();

		}
		logger.log();
		debug = StartPoint.debug;

	}

}