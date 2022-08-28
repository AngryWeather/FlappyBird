package com.github.angryweather.flappybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.angryweather.flappybird.screens.MenuScreen;

public class FlappyBird extends Game {
	public static int width = 1157;
	public static int height = 288;
	public SpriteBatch batch;
	public Manager manager = new Manager();

	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));

	}

	public void render () {
		super.render();
	}
	
	public void dispose () {
		super.dispose();
		batch.dispose();
	}
}
