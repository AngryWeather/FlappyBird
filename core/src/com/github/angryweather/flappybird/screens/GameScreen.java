package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;
import com.github.angryweather.flappybird.entities.Pipe;
import com.github.angryweather.flappybird.entities.Player;

public class GameScreen implements Screen {
    final FlappyBird game;
    Player player;
    Pipe pipe;
    Texture bird;
    Texture background;
    Texture ground;
    Texture pipeTexture;

    public GameScreen(final FlappyBird game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.manager.loadGameScreen();
        game.manager.assets.finishLoading();
        bird = game.manager.assets.get("assets/bird.png");
        pipeTexture = game.manager.assets.get("assets/pipe.png");
        background = game.manager.assets.get(Background.BACKGROUND_IMAGE);
        ground = game.manager.assets.get(Ground.GROUND_IMAGE, Texture.class);

        player = new Player(bird);
        pipe = new Pipe(pipeTexture);
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, -Background.backgroundScroll, 0);
        Background.updateBackgroundScroll(delta);
        game.batch.draw(ground, -Ground.groundScroll, 0);
        Ground.updateGroundScroll(delta);
        game.batch.draw(bird, player.flappy.x, player.flappy.y);
        System.out.println(pipe.pipeRect.x);
        game.batch.draw(pipeTexture, pipe.pipeRect.x, pipe.pipeRect.y);
        pipe.update(delta);
        player.update(delta);
        player.move();
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
