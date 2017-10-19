package com.isolatedpixel.skymission.mobs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isolatedpixel.skymission.graphics.Assets;
import com.isolatedpixel.skymission.objects.collision.Collideable;
import com.isolatedpixel.skymission.screens.DemoWorld;

public class Player extends Collideable{
	public enum State {
		IDLE, WALKING, JUMPING, DYING
	}

	public static float SPEED = 1.55f; // unit per second
	public static final float JUMP_VELOCITY = 1f;
	public static float width1 = 0.6f, height1 = 1.70f;
	public static float GRAVITY = .98f;

	public int guns = 2;
	public static final float reload_delay = .75f;
	public float reload_time = 0;
	public int max_bullets = 6;
	public int bullets = max_bullets * guns;

	boolean reload = false;

	public boolean g = true;

	public float bottom = 0;

	Vector2 position = new Vector2();
	Vector2 accelaration = new Vector2();
	Vector2 Velocity = new Vector2();
	//Rectangle rect = new Rectangle();
	State state = State.IDLE;
	boolean facingLeft = true;

	public static final float frameDuration = .85f;

	private TextureRegion bobFrame;

	public static final float FLOOR = .25f;

	public float stateTime = 0;
	public boolean crouching = false;

	public float getST(){
		return stateTime;
		
	}
	
	public float getCamSpeed() {
		if (facingLeft)
			return SPEED;
		else
			return -SPEED;
	}

	public Player(Vector2 pos, float bot) {
		super(pos.x,pos.y,width1,height1);
		this.position = pos;
		this.rect.height = height1;
		this.rect.width = width1;
		this.bottom = bot;
	}

	public float JumpY = 0;

	public void update(float delta) {
		stateTime += delta;

		JumpY -= (Velocity.cpy().y);
		position.x += (Velocity.cpy().scl(delta).x);
		if (position.y + JumpY > position.y)
			g = false;

		else {
			JumpY = 0;
			g = true;
			// position.y = FLOOR;
		}
		if (!g) {
			Velocity.add(0, GRAVITY * delta);
		}
		// System.out.println(g);
		if (reload) {
			reload_time += delta;
			System.out.println("reloading" + reload_time);
			if (reload_time >= reload_delay * guns) {
				reload = false;
				reload_time = 0;
				bullets = max_bullets * guns;
			}
		}
	}

	public TextureRegion getFrame() {

		if (crouching) {
			bobFrame = this.isFacingLeft() ? Assets.bobCrouchLeft
					: Assets.bobCrouchRight;
		} else {
			switch (this.getState()) {

			case IDLE:
				bobFrame = this.isFacingLeft() ? Assets.IdleLeftAnimation
						.getKeyFrame(stateTime, true)
						: Assets.IdleRightAnimation
								.getKeyFrame(stateTime, true);
				break;
			case WALKING:
				bobFrame = this.isFacingLeft() ? Assets.walkLeftAnimation
						.getKeyFrame(stateTime, true)
						: Assets.walkRightAnimation
								.getKeyFrame(stateTime, true);
				break;

			}
		}
		if (this.getState().equals(State.WALKING)) {
			// bobFrame = this.isFacingLeft() ? walkLeftAnim

		}

		return bobFrame;

	}

	public void shoot(DemoWorld world) {

		if (!reload && bullets > 0) {
			world.addProjectile(rect.getHeight() / 8 * 5);
			bullets--;
			reload = false;
			reload_time = 0;
		} else {
			reload = true;
		}
	}

	public Rectangle getBounds() {
		return rect;
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

	public void setBounds(Rectangle rect) {
		this.rect = rect;
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

	public void crouch() {

		this.getVelocity().set(this.getVelocity().x / 2, this.getVelocity().y);
		this.rect.height = height1 / 3 * 2;

		this.crouching = true;
	}

	@Override
	public void draw(SpriteBatch b, float delta) {
		// TODO Auto-generated method stub
		
	}

}
