package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.github.angryweather.flappybird.FlappyBird;

public class Player {
    public final Rectangle flappy = new Rectangle();
    public static final int GRAVITY = 20;
    public static final int ANTIGRAVITY = -5;
    private float dy = 0f;

    public Player(Texture bird) {
        flappy.x = FlappyBird.WIDTH / 2f - (bird.getWidth() / 2f);
        flappy.y = FlappyBird.HEIGHT / 2f;
        flappy.width = bird.getWidth();
        flappy.height = bird.getHeight();
    }

    public void update(float delta) {
        dy += GRAVITY * delta;
        flappy.y -= dy;
    }

    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            dy = ANTIGRAVITY;
        }
    }
}
