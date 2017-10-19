package com.isolatedpixel.skymission;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = StartPoint.Title + " | " + StartPoint.ver;
		cfg.width = 1280;
		
		cfg.height = 720;
		cfg.fullscreen = false;

		// cfg.vSyncEnabled = true;
		cfg.useGL20 = true;
		cfg.vSyncEnabled = true;
		cfg.resizable = false;
		new LwjglApplication(new StartPoint(), cfg);
	}
}
