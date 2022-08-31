package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Player;

public class GameScreen implements Screen {
    final FlappyBird game;
    Player player;
    Texture bird;

    public GameScreen(final FlappyBird game) {
        this.game = game;
        System.out.println("game");

    }
    @Override
    public void show() {
        game.manager.loadPlayer();
        game.manager.assets.finishLoading();
        bird = game.manager.assets.get("assets/bird.png");
        player = new Player(bird);
    }

    @Override
    public void render(float delta) {
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(bird, player.flappy.x, player.flappy.y);
        game.batch.end();
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
