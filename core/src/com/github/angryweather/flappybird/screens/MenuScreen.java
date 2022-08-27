package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.github.angryweather.flappybird.Background;
import com.github.angryweather.flappybird.FlappyBird;

public class MenuScreen implements Screen {
    final FlappyBird game;
    Texture background;

    public MenuScreen(final FlappyBird game) {
        this.game = game;
        System.out.println("Menu!");
    }


    @Override
    public void show() {
        game.manager.loadMenu();
    }

    @Override
    public void render(float delta) {
        if (game.manager.assets.update()) {
            background = game.manager.assets.get("assets/background.png", Texture.class);
            game.batch.begin();
            game.batch.draw(background, 0, 0);
            game.batch.end();
        }



    }

    @Override
    public void resize(int width, int height) {

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
