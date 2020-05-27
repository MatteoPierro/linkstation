package com.matteopierro.linkstation.domain;

import static com.matteopierro.linkstation.domain.Power.ZERO;

public class Station {
    private final Point point;
    private final Reach reach;

    public Station(Point point, Reach reach) {
        this.point = point;
        this.reach = reach;
    }

    public Power powerFor(Device device) {
        return ZERO;
    }
}
