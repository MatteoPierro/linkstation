package com.matteopierro.linkstation.domain.model;

import static com.matteopierro.linkstation.domain.model.Power.ZERO;

public class LinkStation {
    private final Point point;
    private final Reach reach;

    public LinkStation(Point point, Reach reach) {
        this.point = point;
        this.reach = reach;
    }

    public Power powerFor(Device device) {
        var distanceFromDevice = device.distanceFrom(point);
        if (distanceFromDevice.isGreaterThan(reach)) {
            return ZERO;
        } else {
            return reach.minus(distanceFromDevice).square();
        }
    }

    @Override
    public String toString() {
        return "LinkStation at (" + point + ")";
    }
}
