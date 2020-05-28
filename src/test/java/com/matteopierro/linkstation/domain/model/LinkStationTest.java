package com.matteopierro.linkstation.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.matteopierro.linkstation.domain.model.Power.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkStationTest {

    @Test
    void power_is_zero_when_device_distance_is_greater_than_station_reach() {
        var station = new LinkStation(point(2, 0), new Reach(1));
        var device = new Device(point(0, 0));

        assertThat(station.powerFor(device)).isEqualTo(ZERO);
    }

    @Test
    void power_is_the_square_of_the_difference_between_the_reach_and_the_device_distance() {
        var station = new LinkStation(point(0, 1), new Reach(4));
        var device = new Device(point(0, -1));

        assertThat(station.powerFor(device)).isEqualTo(power(4));
    }

    @Test
    void power_is_zero_when_distance_and_reach_are_the_same() {
        var station = new LinkStation(point(0, 0), new Reach(1));
        var device = new Device(point(0, -1));

        assertThat(station.powerFor(device)).isEqualTo(ZERO);
    }

    private static Power power(int value) {
        BigDecimal power = new BigDecimal(value);
        return new Power(power);
    }

    private static Point point(int x, int y) {
        return new Point(x, y);
    }
}
