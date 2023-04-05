package com.exercise.topic.eight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GovernmentTest {

    @Test
    void testMultipleCallsReturnTheSameObjectInSameThread() {
        Government government1 = Government.getInstance();
        Government government2 = Government.getInstance();
        assertSame(government1, government2);
    }
}