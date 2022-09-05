package com.github.angryweather.flappybird.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;
import com.github.angryweather.flappybird.FlappyBird;

public class PipePair {
    public static final int GAP_HEIGHT = 90;
    public float x = FlappyBird.WIDTH;
    public ObjectMap<String, Pipe> pipes = new ObjectMap<>();
    public float y;
    TextureRegion nonFlipped;
    TextureRegion flipped;

    public PipePair(Texture pipe, float y) {
        this.y = y;
        nonFlipped = new TextureRegion(pipe);
        flipped = new TextureRegion(pipe);
        flipped.flip(false, true);
        addPipes();
    }

    public void addPipes() {
        pipes.put("lower", new Pipe(nonFlipped, y));
        pipes.put("upper", new Pipe(flipped, y + flipped.getRegionHeight() + GAP_HEIGHT));
    }
}
