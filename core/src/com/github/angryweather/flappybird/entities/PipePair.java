package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;
import com.github.angryweather.flappybird.FlappyBird;

public class PipePair {
    public static final int GAP_HEIGHT = 90;
    public float x = FlappyBird.WIDTH;
    public static final int PIPE_SPEED = -60;
    public ObjectMap<String, Pipe> pipes = new ObjectMap<>();
    public float y;
    TextureRegion nonFlipped;
    TextureRegion flipped;
    public boolean isAlive = true;
    public boolean isScored = false;

    public PipePair(Texture pipe, float y) {
        this.y = y;
        nonFlipped = new TextureRegion(pipe);
        flipped = new TextureRegion(pipe);
        flipped.flip(false, true);
        addPipes();
    }

    public void update(float delta) {
        if (x > -nonFlipped.getRegionWidth()) {
            x += PIPE_SPEED * delta;
            pipes.get("lower").pipeRect.x = x;
            pipes.get("upper").pipeRect.x = x;
        } else {
            isAlive = false;
        }
    }

    public void addPipes() {
        pipes.put("lower", new Pipe(nonFlipped, y));
        pipes.put("upper", new Pipe(flipped, y + flipped.getRegionHeight() + GAP_HEIGHT));
    }
}
