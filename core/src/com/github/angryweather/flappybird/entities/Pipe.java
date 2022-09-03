package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.github.angryweather.flappybird.FlappyBird;

import java.util.Random;

public class Pipe {
    public final Rectangle pipeRect = new Rectangle();
    public static final int PIPE_SCROLL = -60;
    final Random random = new Random();

    public Pipe(Texture pipe) {
        pipeRect.x = FlappyBird.WIDTH;
        pipeRect.y = random.nextFloat(-350, -300);
        pipeRect.width = pipe.getWidth();
        pipeRect.height = pipe.getHeight();
    }

    public void update(float delta) {
        pipeRect.x = pipeRect.x + PIPE_SCROLL * delta;
    }

}
