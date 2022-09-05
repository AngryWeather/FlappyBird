package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;
import com.github.angryweather.flappybird.FlappyBird;

import java.util.Random;

public class Pipe implements Pool.Poolable{
    public final Rectangle pipeRect = new Rectangle();
    public static final int PIPE_SCROLL = -60;
    final Random random = new Random();
    public boolean isAlive = true;
    public TextureRegion pipe;

    public Pipe(TextureRegion pipe, float y) {
        this.pipe = pipe;
        pipeRect.x = FlappyBird.WIDTH;
        pipeRect.y = y;
        pipeRect.width = pipe.getRegionWidth();
        pipeRect.height = pipe.getRegionHeight();
    }

    public void update(float delta) {
        pipeRect.x = pipeRect.x + PIPE_SCROLL * delta;
    }

    @Override
    public void reset() {
        pipeRect.x = FlappyBird.WIDTH;
        pipeRect.y = random.nextFloat(-350, -250);
        isAlive = true;
    }
}
