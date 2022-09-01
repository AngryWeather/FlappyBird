package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;
import com.github.angryweather.flappybird.entities.Player;

public class GameScreen implements Screen {
    final FlappyBird game;
    Player player;
    Texture bird;
    Texture background;
    Texture ground;

    public GameScreen(final FlappyBird game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.manager.loadPlayer();
        game.manager.assets.finishLoading();
        bird = game.manager.assets.get("assets/bird.png");
        background = game.manager.assets.get(Background.BACKGROUND_IMAGE);
        ground = game.manager.assets.get(Ground.GROUND_IMAGE, Texture.class);

        player = new Player(bird);
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, -Background.backgroundScroll, 0);
        Background.updateBackgroundScroll(delta);
        game.batch.draw(ground, -Ground.groundScroll, 0);
        Ground.updateGroundScroll(delta);
        game.batch.draw(bird, player.flappy.x, player.flappy.y);
        player.update(delta);
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
