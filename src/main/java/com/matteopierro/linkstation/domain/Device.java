package com.matteopierro.linkstation.domain;

public class Device {
    private final Point point;

    public Device(Point point) {
        this.point = point;
    }

    public Distance distanceFrom(Point point) {
        return this.point.distanceFrom(point);
    }
}
