package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;
import com.github.angryweather.flappybird.entities.Pipe;
import com.github.angryweather.flappybird.entities.Player;

import java.util.Iterator;

public class GameScreen implements Screen {
    private final Array<Pipe> activePipes = new Array<>();
    private final Pool<Pipe> pipePool = new Pool<Pipe>() {
        @Override
        protected Pipe newObject() {
            return new Pipe(pipeTexture);
        }
    };
    float timer = 0;

    final FlappyBird game;
    Player player;
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
//        pipe = new Pipe(pipeTexture);
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
            spawnPipes();
            timer = 0;
        }
        System.out.println("Active: " + activePipes.size);
        System.out.println("Pool: " + pipePool.getFree());

        for (Pipe pipe : activePipes) {
            if (pipe.pipeRect.x < -pipe.pipeRect.width) {
                pipe.isAlive = false;
            }
            game.batch.draw(pipeTexture, pipe.pipeRect.x, pipe.pipeRect.y);
            pipe.update(delta);
        }
        removePipes();
        player.update(delta);
        player.move();
        game.batch.end();
    }

    private void spawnPipes() {
        Pipe pipeItem = pipePool.obtain();
        activePipes.add(pipeItem);
    }

    private void removePipes() {
        for (Iterator<Pipe> it = activePipes.iterator(); it.hasNext(); ) {
            Pipe pipe = it.next();
            if (!pipe.isAlive) {
                it.remove();
                pipePool.free(pipe);
            }
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
