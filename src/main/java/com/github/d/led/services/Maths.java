package com.github.d.led.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Maths {
    public int multiply(int a, int b) {
        return a * b;
    }
}
