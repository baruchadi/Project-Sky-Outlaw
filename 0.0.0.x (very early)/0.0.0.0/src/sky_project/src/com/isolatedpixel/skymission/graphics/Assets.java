package com.isolatedpixel.skymission.graphics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
	static AssetManager manager = new AssetManager();

	public static final String MenuSkin ="json/menuSkin.json",Splash = "gfx/logo.png"; 
	
	public static void loadMenus() {

		// manager.load("ui/utils.pack", TextureAtlas.class);
		manager.load(Splash,Texture.class);
		manager.finishLoading();
		manager.load(MenuSkin, Skin.class,
				new SkinLoader.SkinParameter("ui/utils.pack"));

	}

	
	public synchronized static <T> T get (String fileName, Class<T> type) {
		return manager.get(fileName, type);	
	}
	public static boolean update() {
		return manager.update();
	}

	public static float getProgress() {
		// TODO Auto-generated method stub
		return manager.getProgress();
		
	}
	
	public static boolean isLoaded(String fileName){
		return manager.isLoaded(fileName);
	}

}
