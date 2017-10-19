package com.isolatedpixel.skymission.screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.isolatedpixel.skymission.mobs.Player;
import com.isolatedpixel.skymission.objects.Block;

public class DemoWorld {

	Array<Block> blocks = new Array<Block>();

	Player bob;

	public Array<Block> getBlocks() {
		return blocks;
	}

	public Player getBob() {
		return bob;
	}

	public DemoWorld() {
		createDemoWorld();
	}

	private void createDemoWorld() {

		bob = new Player(new Vector2(7.25f, 2));

		for (int i = 0; i < 10; i++) {

			blocks.add(new Block(new Vector2(i, 0)));
			blocks.add(new Block(new Vector2(i, 7)));
			if (i > 2)
				blocks.add(new Block(new Vector2(i, 1)));

		}

		blocks.add(new Block(new Vector2(9,2)));
		blocks.add(new Block(new Vector2(9,3)));
		blocks.add(new Block(new Vector2(9,4)));
		blocks.add(new Block(new Vector2(9,5)));
		
		blocks.add(new Block(new Vector2(6,3)));
		blocks.add(new Block(new Vector2(6,4)));
		blocks.add(new Block(new Vector2(6,5)));
		
	}
}
