package com.github.angryweather.flappybird.entities;

import com.github.angryweather.flappybird.FlappyBird;

public class Ground {
    public static final String GROUND_IMAGE = "assets/ground.png";
    public static float groundScroll = 0f;
    public static final int GROUND_SPEED = 60;
    public static final int GROUND_LOOPING_POINT = FlappyBird.WIDTH;

    public static void updateGroundScroll(float delta) {
        Ground.groundScroll = (Ground.groundScroll + Ground.GROUND_SPEED * delta)
                % Ground.GROUND_LOOPING_POINT;
    }
}
