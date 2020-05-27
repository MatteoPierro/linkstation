package com.matteopierro.linkstation.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.matteopierro.linkstation.domain.Power.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkStationTest {

    @Test
    void power_is_zero_when_device_distance_is_greater_than_station_reach() {
        var station = new LinkStation(point(10, 10), new Reach(2.23));
        var device = new Device(point(1, 1));

        assertThat(station.powerFor(device)).isEqualTo(ZERO);
    }

    @Test
    void power_is_the_square_of_the_difference_between_the_reach_and_the_device_distance() {
        var station = new LinkStation(point(0, 1), new Reach(4));
        var device = new Device(point(0, -1));

        assertThat(station.powerFor(device)).isEqualTo(new Power(new BigDecimal(4)));
    }

    private static Point point(int x, int y) {
        return new Point(x, y);
    }
}
