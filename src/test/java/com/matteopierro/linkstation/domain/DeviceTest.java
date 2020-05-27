package com.matteopierro.linkstation.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DeviceTest {

    @Test
    void calculate_distance_from_a_point() {
        var device = new Device(point(-2, -2));

        assertThat(device.distanceFrom(point(-1, -1))).isEqualTo(new Distance(1.41));
    }

    @Test
    void needs_a_position() {
        assertThatThrownBy(() -> new Device(null))
                .isInstanceOf(NullPointerException.class);
    }

    private static Point point(int x, int y) {
        return new Point(x, y);
    }
}
