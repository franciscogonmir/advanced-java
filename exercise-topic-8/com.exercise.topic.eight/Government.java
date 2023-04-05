package com.exercise.topic.eight;

public class Government {
    private static final Government INSTANCE = new Government();

    private Government() {
    }

    public static Government getInstance() {
        return INSTANCE;
    }
}
