package com.github.angryweather.flappybird.entities;

public class Background {
    public static final String BACKGROUND_IMAGE = "assets/background.png";
    public static float backgroundScroll = 0f;
    public static final int BACKGROUND_SPEED = 60;
    public static final int BACKGROUND_LOOPING_POINT = 50;

    public static float updateBackgroundScroll(float delta) {
        return Background.backgroundScroll = (Background.backgroundScroll + Background.BACKGROUND_SPEED * delta)
                % Background.BACKGROUND_LOOPING_POINT;
    }


}
