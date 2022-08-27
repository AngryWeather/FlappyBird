package com.github.angryweather.flappybird;

import com.badlogic.gdx.Screen;

public class MenuScreen implements Screen {
    final FlappyBird game;

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

    }

    @Override
    public void dispose() {

    }
}
