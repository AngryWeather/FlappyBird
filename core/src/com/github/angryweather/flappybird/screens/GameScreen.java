package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.*;

import java.util.Iterator;
import java.util.Random;

public class GameScreen implements Screen {
    final FlappyBird game;
    private BitmapFont font = new BitmapFont();
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
    boolean scrolling = true;

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
        if (scrolling) {
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
                activePipes.add(new PipePair(pipeTexture, lastY));
                timer = 0;
            }

            for (PipePair pair : activePipes) {
                pair.update(delta);
                for (ObjectMap.Entry<String, Pipe> pairs : pair.pipes) {
                    game.batch.draw(pairs.value.pipe, pairs.value.pipeRect.x, pairs.value.pipeRect.y);
                    if (player.flappy.overlaps(pairs.value.pipeRect)) {
                        game.setScreen(new MenuScreen(game));
                    } else if (!pair.isScored) {
                        if (pair.x + pairs.value.pipeRect.width < player.flappy.x) {
                            player.increaseScore();
                            pair.isScored = true;
                        }
                    }
                }
            }
            font.draw(game.batch, "Score: " + player.getScore(), 10, FlappyBird.HEIGHT - 20);
            removePairs();
            player.update(delta);
            player.move();
            game.batch.end();
        }

    }

    public void removePairs() {
        for (Iterator<PipePair> it = activePipes.iterator(); it.hasNext(); ) {
            PipePair pair = it.next();
            if (!pair.isAlive) {
                it.remove();
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
        dispose();
    }

    @Override
    public void dispose() {

    }
}
