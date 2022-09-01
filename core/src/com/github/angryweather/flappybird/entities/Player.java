package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.github.angryweather.flappybird.FlappyBird;

public class Player {
    public Rectangle flappy = new Rectangle();
    public static final int GRAVITY = 20;
    private float dy = 0f;

    public Player(Texture bird) {
        flappy.x = 30;
        flappy.y = FlappyBird.HEIGHT / 2f;
        flappy.width = bird.getWidth();
        flappy.height = bird.getHeight();
    }

    public void update(float delta) {
        dy += GRAVITY * delta;
        flappy.y -= dy;
    }
}
