package com.isolatedpixel.skymission.mobs;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	public enum State {
		IDLE, WALKING, JUMPING, DYING
	}

	public static float SPEED = 3.55f; // unit per second
	public static final float JUMP_VELOCITY = 1f;
	public static float width1 = 0.6f, height1 = 3.70f; 

	Vector2 position = new Vector2();
	Vector2 accelaration = new Vector2();
	Vector2 Velocity = new Vector2();
	Rectangle bounds = new Rectangle();
	State state = State.IDLE;
	boolean facingLeft = true;

	public Player(Vector2 pos) {
		this.position = pos;
		this.bounds.height = height1;
		this.bounds.width = width1;

	}

	
	
	public Rectangle getBounds() {
		return bounds;
	}

	public Vector2 getPosition() {
		return position;
	}

	public State getState() {
		return state;
	}

	public static float getSpeed() {
		return SPEED;
	}

	public static float getJumpVelocity() {
		return JUMP_VELOCITY;
	}

	public Vector2 getVelocity() {
		return Velocity;
	}

	public boolean isFacingLeft() {
		return facingLeft;
	}
	
	
	

	public Vector2 getAccelaration() {
		return accelaration;
	}

	public void setAccelaration(Vector2 accelaration) {
		this.accelaration = accelaration;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public void setFacingLeft(boolean facingLeft) {
		this.facingLeft = facingLeft;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setVelocity(Vector2 velocity) {
		Velocity = velocity;
	}
	
	public void update(float delta){
		position.add(Velocity.cpy().scl(delta));
	}
}
