package com.github.angryweather.flappybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.angryweather.flappybird.FlappyBird;
import com.github.angryweather.flappybird.entities.Background;
import com.github.angryweather.flappybird.entities.Ground;

public class MenuScreen implements Screen {
//    OrthographicCamera camera;
//    Viewport viewport;
    final FlappyBird game;
    Texture background;
    Texture ground;
    float flappyFontCenterX = FlappyBird.WIDTH / 2f - 30;
    float flappyFontY = FlappyBird.HEIGHT - 30;
    BitmapFont flappyFont = new BitmapFont();
    GlyphLayout flappy = new GlyphLayout();
    GlyphLayout pressEnter = new GlyphLayout();

    public MenuScreen(final FlappyBird game) {
        this.game = game;
//        camera = new OrthographicCamera(FlappyBird.WIDTH, FlappyBird.HEIGHT);
//        viewport = new StretchViewport(FlappyBird.WIDTH, FlappyBird.HEIGHT, camera);
        flappy.setText(flappyFont, "Flappy Bird");
        pressEnter.setText(flappyFont, "Press Enter to start");
    }


    @Override
    public void show() {
        game.manager.assets.finishLoading();
        background = game.manager.assets.get(Background.BACKGROUND_IMAGE, Texture.class);
        ground = game.manager.assets.get(Ground.GROUND_IMAGE, Texture.class);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int key) {
                switch (key) {
                    case Input.Keys.ENTER:
                        game.setScreen(new GameScreen(game));
                        break;
                }
            return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(background, -Background.backgroundScroll, 0);
        Background.updateBackgroundScroll(delta);

        game.batch.draw(ground, -Ground.groundScroll, 0);
        Ground.updateGroundScroll(delta);
        flappyFont.draw(game.batch, flappy, flappyFontCenterX, flappyFontY);
        flappyFont.draw(game.batch, pressEnter, flappyFontCenterX - 25, FlappyBird.HEIGHT - 60);
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
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
        flappyFont.dispose();
    }
}
