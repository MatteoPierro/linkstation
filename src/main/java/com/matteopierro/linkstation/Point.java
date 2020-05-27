package com.matteopierro.linkstation;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Distance distanceFrom(Point anotherPoint) {
        var distance = sqrt(square(x - anotherPoint.x) + square(y - anotherPoint.y));
        return new Distance(distance);
    }

    private static double square(int number) {
        return pow(number, 2);
    }
}
