package com.github.angryweather.flappybird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;
import com.github.angryweather.flappybird.screens.MenuScreen;

public class FlappyBird extends Game {
	public static final int WIDTH = 512;
	public static final int HEIGHT = 288;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public Viewport viewport;
	public Manager manager = new Manager();

	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(FlappyBird.WIDTH, FlappyBird.HEIGHT);
		viewport = new StretchViewport(FlappyBird.WIDTH, FlappyBird.HEIGHT, camera);
		// the background and the ground used in all screens
		manager.assets.load(Background.BACKGROUND_IMAGE, Texture.class);
		manager.assets.load(Ground.GROUND_IMAGE, Texture.class);
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
