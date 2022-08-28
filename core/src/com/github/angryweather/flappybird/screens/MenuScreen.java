package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.angryweather.flappybird.Background;
import com.github.angryweather.flappybird.FlappyBird;

public class MenuScreen implements Screen {
    OrthographicCamera camera;
    Viewport viewport;
    final FlappyBird game;
    Texture background;

    public MenuScreen(final FlappyBird game) {
        this.game = game;
        camera = new OrthographicCamera(FlappyBird.width, FlappyBird.height);
        viewport = new StretchViewport(FlappyBird.width, FlappyBird.height, camera);
        System.out.println("Menu!");
    }


    @Override
    public void show() {
        game.manager.loadMenu();
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        if (game.manager.assets.update()) {
            background = game.manager.assets.get("assets/background.png", Texture.class);
            game.batch.begin();
            game.batch.draw(background, 0, 0);
            game.batch.end();
        }



    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        camera.update();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        System.out.println("dispose: ");
        dispose();
    }

    @Override
    public void dispose() {

    }
}
