package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;

public class MenuScreen implements Screen {
    OrthographicCamera camera;
    Viewport viewport;
    final FlappyBird game;
    Texture background;
    Texture ground;

    public MenuScreen(final FlappyBird game) {
        this.game = game;
        camera = new OrthographicCamera(FlappyBird.WIDTH, FlappyBird.HEIGHT);
        viewport = new StretchViewport(FlappyBird.WIDTH, FlappyBird.HEIGHT, camera);
    }


    @Override
    public void show() {
        game.manager.assets.finishLoading();
        background = game.manager.assets.get(Background.BACKGROUND_IMAGE, Texture.class);
        ground = game.manager.assets.get(Ground.GROUND_IMAGE, Texture.class);
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.batch.draw(ground, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        game.manager.assets.clear();
    }
}
