package com.ecs.tutorial.jpa.model;

import java.util.Random;

public enum PromotionCode {

    YELLOW,
    BLUE,
    RED;

    private static final PromotionCode[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static PromotionCode getRandomPromotionCode() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
