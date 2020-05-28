package com.matteopierro.linkstation.domain.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.apache.commons.lang3.Validate.notNull;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Distance distanceFrom(Point anotherPoint) {
        notNull(anotherPoint, "A point must be specified");

        return new Distance(euclideanDistanceFrom(anotherPoint));
    }

    private double euclideanDistanceFrom(Point anotherPoint) {
        return sqrt(square(x - anotherPoint.x) + square(y - anotherPoint.y));
    }

    private static double square(int number) {
        return pow(number, 2);
    }
}
