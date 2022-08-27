package com.github.angryweather.flappybird;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Manager {
    public AssetManager assets;

    public Manager() {
        assets = new AssetManager();
    }

    public void loadMenu() {
        System.out.println("loading");
        assets.load("assets/background.png", Texture.class);
    }


}