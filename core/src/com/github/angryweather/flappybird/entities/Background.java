package com.github.angryweather.flappybird.entities;

public class Background {
    public static final String BACKGROUND_IMAGE = "assets/background.png";
    public static float backgroundScroll = 0f;
    public static final int BACKGROUND_SPEED = 30;
    public static final int BACKGROUND_LOOPING_POINT = 568;

    public static void updateBackgroundScroll(float delta) {
        Background.backgroundScroll = (Background.backgroundScroll + Background.BACKGROUND_SPEED * delta)
                % Background.BACKGROUND_LOOPING_POINT;
    }
}
