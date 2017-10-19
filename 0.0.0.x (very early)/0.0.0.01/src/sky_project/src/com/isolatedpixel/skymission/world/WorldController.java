package com.isolatedpixel.skymission.world;

import java.util.HashMap;
import java.util.Map;

import com.isolatedpixel.skymission.StartPoint;
import com.isolatedpixel.skymission.mobs.Player;
import com.isolatedpixel.skymission.mobs.Player.State;
import com.isolatedpixel.skymission.screens.DemoWorld;

public class WorldController {
	enum Keys {
		LEFT, RIGHT, JUMP, FIRE,

		incH, incW, incS,

		decH, decW, decS,
		
		t_debug
	}

	// jump -z shoot -x interact -c

	private DemoWorld world;
	private Player bob;

	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();

	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.JUMP, false);
		keys.put(Keys.FIRE, false);
		
		keys.put(Keys.incH, false);
		keys.put(Keys.incS, false);
		keys.put(Keys.incW, false);
		keys.put(Keys.decH, false);
		keys.put(Keys.decS, false);
		keys.put(Keys.decW, false);
		
		keys.put(Keys.t_debug, false);
	}

	public WorldController(DemoWorld world) {
		this.world = world;
		this.bob = world.getBob();
	}

	/* Key Presses / touches */

	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}

	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}

	public void jumpPressed() {
		keys.get(keys.put(Keys.JUMP, true));
	}

	public void firePressed() {
		keys.get(keys.put(Keys.FIRE, true));
	}

	public void incHPressed() {
		keys.get(keys.put(Keys.incH, true));
	}

	public void incWPressed() {
		keys.get(keys.put(Keys.incW, true));
	}

	public void incSPressed() {
		keys.get(keys.put(Keys.incS, true));
	}

	public void decHPressed() {
		keys.get(keys.put(Keys.decH, true));
	}

	public void decWPressed() {
		keys.get(keys.put(Keys.decW, true));
	}

	public void decSPressed() {
		keys.get(keys.put(Keys.decS, true));
	}
	
	public void tDebugPressed(){
		keys.get(keys.put(Keys.t_debug, true));
	}
	
	/** ===== **/

	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}

	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}

	public void jumpReleased() {
		keys.get(keys.put(Keys.JUMP, false));
	}

	public void fireReleased() {
		keys.get(keys.put(Keys.FIRE, false));
	}

	public void incHReleased() {
		keys.get(keys.put(Keys.incH, false));
	}

	public void incWReleased() {
		keys.get(keys.put(Keys.incW, false));
	}

	public void incSReleased() {
		keys.get(keys.put(Keys.incS, false));
	}

	public void decHReleased() {
		keys.get(keys.put(Keys.decH, false));
	}

	public void decWReleased() {
		keys.get(keys.put(Keys.decW, false));
	}

	public void decSReleased() {
		keys.get(keys.put(Keys.decS, false));
	}

	public void tDebugReleased(){
		keys.get(keys.put(Keys.t_debug, false));
	}
	
	public void update(float delta) {
		processInput();
		bob.update(delta);
	}

	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			// left is pressed
			bob.setFacingLeft(true);
			bob.setState(State.WALKING);
			bob.getVelocity().x = -Player.SPEED;
		}
		if (keys.get(Keys.RIGHT)) {
			// right is pressed
			bob.setFacingLeft(false);
			bob.setState(State.WALKING);
			bob.getVelocity().x = Player.SPEED;
		}

		if (keys.get(Keys.incH)) {
			bob.getBounds().height += .05f;
		}
		if (keys.get(Keys.decH)) {
			bob.getBounds().height -= .05f;
		}
		if (keys.get(Keys.decS)) {
			Player.SPEED -= .05f;
		}
		if (keys.get(Keys.incS)) {
			Player.SPEED += .05f;
		}
		if (keys.get(Keys.decW)) {
			bob.getBounds().width -= .05f;
		}
		if (keys.get(Keys.incW)) {
			bob.getBounds().width += .05f;
		}

		if(keys.get(Keys.t_debug)){
			StartPoint.debug = !StartPoint.debug;
		}
		
		// check if both/none directions are pressed

		if (((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) || (!keys
				.get(Keys.LEFT) && !keys.get(Keys.RIGHT)))) {
			bob.setState(State.IDLE);
			bob.getAccelaration().x = 0;
			bob.getVelocity().x = 0;
		}
	}
}
