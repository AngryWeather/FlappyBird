package com.github.angryweather.flappybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.angryweather.flappybird.screens.MenuScreen;

public class FlappyBird extends Game {
	public static int width = 1157;
	public static int height = 288;
	public SpriteBatch batch;
	public Manager manager = new Manager();

	public void create () {
		batch = new SpriteBatch();
		// the background and the ground used in all screens
		manager.assets.load(Background.BACKGROUND_IMAGE, Texture.class);
		this.setScreen(new MenuScreen(this));

	}

	public void render () {
		super.render();
	}
	
	public void dispose () {
		super.dispose();
		batch.dispose();
		manager.assets.dispose();
	}
}
