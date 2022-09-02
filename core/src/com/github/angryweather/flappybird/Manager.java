package com.github.angryweather.flappybird;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Manager {
    public AssetManager assets;

    public Manager() {
        assets = new AssetManager();
    }

    public void loadGameScreen() {
        assets.load("assets/bird.png", Texture.class);
        assets.load("assets/pipe.png", Texture.class);
    }
}
