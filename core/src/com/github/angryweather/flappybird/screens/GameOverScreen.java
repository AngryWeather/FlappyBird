package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;

public class GameOverScreen implements Screen {
    private BitmapFont font = new BitmapFont();
    private final FlappyBird game;
    private Texture background;
    private Texture ground;
    private final int score;
    private float positionFontX = FlappyBird.WIDTH / 2f - 20;

    public GameOverScreen(final FlappyBird game, final int score) {
        this.game = game;
        this.score = score;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int key) {
                if (key == Input.Keys.ENTER) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
        background = game.manager.assets.get(Background.BACKGROUND_IMAGE);
        ground = game.manager.assets.get(Ground.GROUND_IMAGE, Texture.class);

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, -Background.backgroundScroll, 0);
        Background.updateBackgroundScroll(delta);
        game.batch.draw(ground, -Ground.groundScroll, 0);
        Ground.updateGroundScroll(delta);
        font.draw(game.batch, "You lost!", positionFontX , FlappyBird.HEIGHT / 2f + 60);
        font.draw(game.batch, "Score: " + score, positionFontX, FlappyBird.HEIGHT / 2f + 40);
        font.draw(game.batch, "Press Enter to play again", positionFontX - 45, FlappyBird.HEIGHT / 2f + 20);
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
        Gdx.input.setInputProcessor(null);
        dispose();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
