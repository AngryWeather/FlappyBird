package com.github.angryweather.flappybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends Game {
	SpriteBatch batch;
	Manager manager = new Manager();

	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MenuScreen(this));

	}

	public void render () {
		super.render();
	}
	
	public void dispose () {
		batch.dispose();
	}
}
