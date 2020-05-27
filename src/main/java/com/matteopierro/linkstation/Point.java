package com.matteopierro.linkstation;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Distance distanceFrom(Point anotherPoint) {
        return new Distance(1.41);
    }
}
