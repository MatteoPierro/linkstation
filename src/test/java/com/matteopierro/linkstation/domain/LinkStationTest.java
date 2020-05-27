package com.matteopierro.linkstation.domain;

import org.junit.jupiter.api.Test;

import static com.matteopierro.linkstation.domain.Power.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkStationTest {

    @Test
    void power_is_zero_when_device_distance_is_greater_than_station_reach() {
        var station = new Station(point(10, 10), new Reach(2.23));
        var device = new Device(point(1, 1));

        assertThat(station.powerFor(device)).isEqualTo(ZERO);
    }

    private static Point point(int x, int y) {
        return new Point(x, y);
    }
}
