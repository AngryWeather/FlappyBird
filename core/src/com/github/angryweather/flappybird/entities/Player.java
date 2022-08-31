package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.github.angryweather.flappybird.FlappyBird;

public class Player {
    public Rectangle flappy = new Rectangle();
    private Texture bird;

    public Player(Texture bird) {
        this.bird = bird;
        flappy.x = 30;
        flappy.y = FlappyBird.HEIGHT / 2f;
        flappy.width = bird.getWidth();
        flappy.height = bird.getHeight();
    }
}
