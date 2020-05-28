package com.matteopierro.linkstation.domain.model;

import static org.apache.commons.lang3.Validate.notNull;

public class Device {
    private final Point point;

    public Device(Point point) {
        this.point = notNull(point);
    }

    public Distance distanceFrom(Point point) {
        return this.point.distanceFrom(point);
    }

    @Override
    public String toString() {
        return "Device at (" + point + ")";
    }
}
