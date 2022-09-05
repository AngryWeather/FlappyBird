package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.*;

import java.util.Random;

public class GameScreen implements Screen {
    final FlappyBird game;
    private final Array<PipePair> activePipes = new Array<>();
    float timer = 0;
    PipePair pipes;
    Player player;
    Texture bird;
    Texture background;
    Texture ground;
    Texture pipeTexture;
    TextureRegion pipeRegion;
    TextureRegion flippedPipeRegion;
    float lastY;
    Random random = new Random();

    public GameScreen(final FlappyBird game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.manager.loadGameScreen();
        bird = game.manager.assets.get("assets/bird.png");
        pipeTexture = game.manager.assets.get("assets/pipe.png");
        background = game.manager.assets.get(Background.BACKGROUND_IMAGE);
        ground = game.manager.assets.get(Ground.GROUND_IMAGE, Texture.class);
        pipeRegion = new TextureRegion(pipeTexture);
        flippedPipeRegion = new TextureRegion(pipeTexture);
        flippedPipeRegion.flip(false, true);
        player = new Player(bird);
        // value for the gap
        lastY = -pipeRegion.getRegionHeight() + random.nextFloat(0, 80) + 20;
        pipes = new PipePair(pipeTexture, lastY);
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, -Background.backgroundScroll, 0);
        Background.updateBackgroundScroll(delta);
        game.batch.draw(ground, -Ground.groundScroll, 0);
        Ground.updateGroundScroll(delta);
        game.batch.draw(bird, player.flappy.x, player.flappy.y);

        timer += delta;
        if (timer > 2) {

            lastY = Math.max(-pipeRegion.getRegionHeight() + 10,
                    Math.min(lastY + random.nextFloat(-20, 20), FlappyBird.HEIGHT - 90 -
                            pipeRegion.getRegionHeight()));
            timer = 0;
        }

        for (ObjectMap.Entry<String, Pipe> pipePairs : pipes.pipes) {
            pipePairs.value.update(delta);
            game.batch.draw(pipePairs.value.pipe, pipePairs.value.pipeRect.x, pipePairs.value.pipeRect.y);

        }

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
        dispose();
    }

    @Override
    public void dispose() {

    }
}
