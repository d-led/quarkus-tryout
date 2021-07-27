package com.github.d.led.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathsTest {

    Maths maths = new Maths();

    @Test
    void simple_multiplication() {
        assertEquals(4, maths.multiply(2, 2));

        // missing test case for the operation mutation
        assertEquals(6, maths.multiply(3, 2));
    }
}
