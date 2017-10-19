package com.isolatedpixel.skymission.screens;

import java.util.LinkedList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.graphics.Damage;
import com.isolatedpixel.skymission.mobs.BasicAI;
import com.isolatedpixel.skymission.mobs.Player;
import com.isolatedpixel.skymission.mobs.Zombie;
import com.isolatedpixel.skymission.objects.Dirt;
import com.isolatedpixel.skymission.objects.Door;
import com.isolatedpixel.skymission.objects.Pepper;
import com.isolatedpixel.skymission.objects.Wood;
import com.isolatedpixel.skymission.objects.ammo.Bullet;
import com.isolatedpixel.skymission.objects.ammo.Projectile;
import com.isolatedpixel.skymission.objects.collision.QuadTree;

public class DemoWorld {

	public Array<Wood> wood = new Array<Wood>();
	public Array<Dirt> dirt = new Array<Dirt>();
	public LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
	public LinkedList<Pepper> boxes = new LinkedList<Pepper>();
	public LinkedList<Damage> damage = new LinkedList<Damage>();
	public Door door;
	public LinkedList<BasicAI> enemies = new LinkedList<BasicAI>();
	public LinkedList<Pepper> removeBox = new LinkedList<Pepper>();
	// public Box box;
	static Player bob = null;

	public QuadTree objects;
	
	// Quadtree<QuadtreeElement> elements;

	public float getMaxWidth() {
		return wood.size * Wood.getSize();

	}

	public Array<Wood> getBlocks() {
		return wood;
	}

	public Player getBob() {
		return bob;
	}

	public DemoWorld() {
		Assets.LoadGameStuff();
		createDemoWorld();
		objects = new QuadTree(0, new Rectangle(0,0,wood.size*Wood.getSize(),20));
		// elements = new Quadtree<QuadtreeElement>(0, 0, 100, 10);
	}

	private void createDemoWorld() {

		// for (int i = 0; i < 15; i++) {

//		for(int i = 0; i <26/2; i++){
		wood.add(new Wood(new Vector2(0, 0f)));
		
//		}
		
//		for(int i = 0; i < 10/2; i++){
//			wood.add(new Wood(new Vector2(3+i*Wood.getSize(), 2.5f)));
//		}
		enemies.add(new Zombie(5, 2));
		// wood.add(new Wood(new Vector2(i, 7.75f)));
		// if (i > 2)
		// blocks.add(new Block(new Vector2(i, 1)));

		// }

		// for (int i = 0; i < 15; i++) {
		//
		// dirt.add(new Dirt(new Vector2(i, 0f)));
		// // dirt.add(new Dirt(new Vector2(i, 7.75f)));
		// // if (i > 2)
		// // blocks.add(new Block(new Vector2(i, 1)));
		//
		// }
		if (bob == null) {
			bob = new Player(new Vector2(2f, wood.get(0).getBounds().height
					+ wood.get(0).getPosition().y), wood.get(0).getPosition().y
					+ wood.get(0).getBounds().height);
			bob.setFacingLeft(false);
		}
		//door = new Door(new Vector2(0, wood.get(0).getPosition().y));

		boxes.add(new Pepper(5, 3));

		// objects.add(new GameObj(Assets.door, new Rectangle(0, wood.get(0)
		// .getPosition().y, .5f, 2)));
		//
		// objects.add(new GameObj(Assets.bar,new Rectangle(7,bob.bottom,1,1)));
		// objects.add(new GameObj(Assets.shelf,new
		// Rectangle(9.25f,bob.bottom,.75f,4f)));

		// batcher.draw(Assets.door,world.door.getPosition().x,world.door.getPosition().y,world.door.getBounds().width,world.door.getBounds().height);
		// batcher.draw(Assets.bar, 7, bob.bottom,
		// 1, 1);
		// batcher.draw(Assets.shelf, 9.25f, bob.bottom,
		// .75f, 4f);
		// blocks.add(new Block(new Vector2(9,2)));
		// blocks.add(new Block(new Vector2(9,3)));
		// blocks.add(new Block(new Vector2(9,4)));
		// blocks.add(new Block(new Vector2(9,5)));
		//
		// blocks.add(new Block(new Vector2(6,3)));
		// blocks.add(new Block(new Vector2(6,4)));
		// blocks.add(new Block(new Vector2(6,5)));

	}

	public void addProjectile(float height) {
		projectiles.add(new Bullet(new Vector2(bob.getPosition().x, bob
				.getPosition().y + height + bob.JumpY), !bob.isFacingLeft()));
	}

	public void addDmgLbl(int dmg, float x, float y, float dX, boolean right) {

		damage.add(new Damage(dmg, x, y, dX, right));

	}

	// public void setTextures() {
	// objects.get(0).setT(Assets.door);
	// objects.get(1).setT(Assets.bar);
	// objects.get(2).setT(Assets.shelf);
	//
	// }
}
