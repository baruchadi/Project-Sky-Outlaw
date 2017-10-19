package com.isolatedpixel.skymission.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
	static AssetManager manager = new AssetManager();

	public static final String MenuSkin = "json/menuSkin.json",
			Splash = "gfx/logo.png";

	public static Animation walkLeftAnimation;
	public static Animation walkRightAnimation;
	public static Animation IdleLeftAnimation;
	public static Animation IdleRightAnimation;
	
	public static TextureAtlas screens, container;
	
	public static Animation blueScreen1, redScreen, wallScreen, deskScreen, w_container,tubes;
	
	
	public static TextureRegion bobIdleLeft;
	public static TextureRegion bobIdleRight;
	public static TextureRegion bobCrouchLeft;
	public static TextureRegion bobCrouchRight;
	public static TextureRegion wood, dirt, door;

	public static TextureRegion[] mBox;
	public static Animation boxAnim, dinoAnim, mosh;

	public static TextureRegion bar, shelf, selected;

	static TextureAtlas playerAtlas, floorAtlas, dAtlas, nums, boxes, dino,
			tMosh;
	public static Texture moshX;
	public static TextureRegion[] numbers;

	public static Texture bullet, background, mBackground, box, pepper, floor, triangle, background0,
			background1, light, shadow, l1, light2, card, floor1;

	public static void loadPlayer() {
		playerAtlas = new TextureAtlas(
				Gdx.files.internal("textures/bounty.pack"));

		bobIdleRight = playerAtlas.findRegion("bh_2iss");
		TextureRegion idle2 = playerAtlas.findRegion("b_2iss");
		IdleRightAnimation = new Animation(.85f, bobIdleRight, idle2);

		TextureRegion idle1 = new TextureRegion(idle2);
		idle1.flip(true, false);
		bobIdleLeft = new TextureRegion(bobIdleRight);
		bobIdleLeft.flip(true, false);

		IdleLeftAnimation = new Animation(.85f, bobIdleLeft, idle1);

		TextureRegion walkRight = playerAtlas.findRegion("w_2iss");
		TextureRegion walkLeft = new TextureRegion(walkRight);
		walkLeft.flip(true, false);

		walkRightAnimation = new Animation(.1f, bobIdleRight, walkRight);
		walkLeftAnimation = new Animation(.1f, bobIdleLeft, walkLeft);

		bobCrouchRight = playerAtlas.findRegion("crouch_ss");
		bobCrouchLeft = new TextureRegion(bobCrouchRight);
		bobCrouchLeft.flip(true, false);
	}

	public static void loadPlayer(int o) {
		playerAtlas = new TextureAtlas(Gdx.files.local("test/test.pack"));

		bobIdleRight = playerAtlas.findRegion("idle1");
		TextureRegion idle2 = playerAtlas.findRegion("breathe1");
		IdleRightAnimation = new Animation(.85f, bobIdleRight, idle2);

		TextureRegion idle1 = playerAtlas.findRegion("breathe1");
		idle1.flip(true, false);
		bobIdleLeft = playerAtlas.findRegion("idle1");
		bobIdleLeft.flip(true, false);

		IdleLeftAnimation = new Animation(.85f, bobIdleLeft, idle1);

		TextureRegion walkRight = playerAtlas.findRegion("walk1");
		TextureRegion walkLeft = new TextureRegion(walkRight);
		walkLeft.flip(true, false);

		walkRightAnimation = new Animation(.1f, bobIdleRight, walkRight);
		walkLeftAnimation = new Animation(.1f, bobIdleLeft, walkLeft);

		bobCrouchRight = playerAtlas.findRegion("crouch1");
		bobCrouchLeft = new TextureRegion(bobCrouchRight);
		bobCrouchLeft.flip(true, false);
	}

	public static void loadFloor() {
		floorAtlas = new TextureAtlas(Gdx.files.internal("textures/floor.pack"));
		// **
		boxes = new TextureAtlas(Gdx.files.internal("textures/boxes.pack"));
		// **

		mBox = new TextureRegion[] { (boxes.findRegion("box0")),
				(boxes.findRegion("box1")), (boxes.findRegion("box2")),
				(boxes.findRegion("box3")), (boxes.findRegion("box4")) };
		boxAnim = new Animation(.1f, boxes.findRegion("break1"),
				boxes.findRegion("break2"), boxes.findRegion("break3"),
				boxes.findRegion("break4"), boxes.findRegion("break5"),
				boxes.findRegion("break6"));
		boxAnim.setPlayMode(Animation.NORMAL);
		dAtlas = new TextureAtlas(Gdx.files.internal("ui/utils.pack"));

		selected = dAtlas.findRegion("default.selected");

		wood = floorAtlas.findRegion("wood_floor");
		dirt = floorAtlas.findRegion("dirt_floor");

		bar = floorAtlas.findRegion("bar");
		shelf = floorAtlas.findRegion("shelf");

	}

	public static void LoadGameStuff() {
		loadScreens();
		loadPlayer();
		loadFloor();
		door = floorAtlas.findRegion("door");
		bullet = new Texture(Gdx.files.internal("textures/bb1.png"));
		mBackground = new Texture(Gdx.files.internal("background/newbackground.png"));
		background = new Texture(Gdx.files.internal("background/layer1.png"));
		background1 = new Texture(Gdx.files.internal("background/layer2_1.png"));
		background0 = new Texture(Gdx.files.internal("background/moon_bg.png"));
		box = new Texture(Gdx.files.internal("textures/box.png"));
		pepper = new Texture(Gdx.files.internal("textures/peppers.png"));
		floor = new Texture(Gdx.files.internal("background/platform0.png"));
		floor1 = new Texture(Gdx.files.internal("background/newplatform.png"));
		triangle = new Texture(Gdx.files.internal("background/triangle.png"));
		nums = new TextureAtlas(Gdx.files.internal("textures/nums.pack"));
		numbers = new TextureRegion[10];
		for (int i = 0; i < 10; i++) {

			numbers[i] = nums.findRegion(i + "");
			System.out.println(i + ".png");
		}
		light = new Texture(Gdx.files.internal("lights/light.png"));
		shadow = new Texture(Gdx.files.internal("lights/shadow.png"));
		shadow.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		light.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		light2 = new Texture(Gdx.files.internal("lights/light2.png"));
		light2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		l1 = new Texture(Gdx.files.internal("lights/l1.png"));
		dino = new TextureAtlas(Gdx.files.internal("textures/dino.pack"));
		dinoAnim = new Animation(.2f, dino.findRegion("d1"),
				dino.findRegion("d2"));
		card = new Texture(Gdx.files.internal("textures/card1.png"));
		card1 = new TextureRegion(card);
		tMosh = new TextureAtlas(Gdx.files.internal("textures/mosh.pack"));
		mosh = new Animation(.2f, tMosh.findRegion("mob1"),
				tMosh.findRegion("mob2"), tMosh.findRegion("mob3"),
				tMosh.findRegion("mob4"), tMosh.findRegion("mob5"),
				tMosh.findRegion("mob6"));
		mosh = new Animation(.2f,tMosh.findRegion("mob1"),
				tMosh.findRegion("mob2"), tMosh.findRegion("mob3"),
				tMosh.findRegion("mob4"), tMosh.findRegion("mob5"),
				tMosh.findRegion("mob6"));
		
		 moshX = new Texture(Gdx.files.internal("textures/monster.png"));
		
		mosh.setPlayMode(Animation.LOOP);
	}

	public static void loadScreens(){
		
		screens = new TextureAtlas(Gdx.files.internal("screens/screens.pack"));
		
		wallScreen = new Animation(.2f, screens.findRegion("walllayer1"),screens.findRegion("walllayer2"),screens.findRegion("walllayer3"));
		
		blueScreen1 = new Animation(.2f, screens.findRegion("rooflayer1"),screens.findRegion("rooflayer2"),screens.findRegion("rooflayer3"),screens.findRegion("rooflayer4"),screens.findRegion("rooflayer5"),screens.findRegion("rooflayer6"),screens.findRegion("rooflayer7"));
		
		deskScreen =new Animation(1f, screens.findRegion("desklayer1"),screens.findRegion("desklayer2"),screens.findRegion("desklayer3"),screens.findRegion("desklayer4"),screens.findRegion("desklayer5"),screens.findRegion("desklayer6"),screens.findRegion("desklayer7"),screens.findRegion("desklayer8"),screens.findRegion("desklayer9"));
		
		redScreen = new Animation(1f, screens.findRegion("redlayer1"),screens.findRegion("redlayer2"),screens.findRegion("redlayer3"));
		
		container = new TextureAtlas(Gdx.files.internal("textures/container.pack"));
		
		w_container = new Animation(.3f, container.findRegion("cw1"),container.findRegion("cw2"),container.findRegion("cw3"),container.findRegion("cw4"),container.findRegion("cw5"),container.findRegion("cw6"),container.findRegion("cw7"));
		tubes = new Animation(.2f,container.findRegion("t1"),container.findRegion("t2"),container.findRegion("t3"),container.findRegion("t4"),container.findRegion("t5"),container.findRegion("t6"),container.findRegion("t7"),container.findRegion("t8"),container.findRegion("t9"));
	}
	
	public static TextureRegion card1;

	public static void loadMenus() {

		// manager.load("ui/utils.pack", TextureAtlas.class);
		manager.load(Splash, Texture.class);
		manager.finishLoading();
		manager.load(MenuSkin, Skin.class, new SkinLoader.SkinParameter(
				"ui/utils.pack"));

	}

	public synchronized static <T> T get(String fileName, Class<T> type) {
		return manager.get(fileName, type);
	}

	public static boolean update() {
		return manager.update();
	}

	public static float getProgress() {
		// TODO Auto-generated method stub
		return manager.getProgress();

	}

	public static boolean isLoaded(String fileName) {
		return manager.isLoaded(fileName);
	}

	public static void disposeMenu() {

		manager.unload(Splash);

	}

}