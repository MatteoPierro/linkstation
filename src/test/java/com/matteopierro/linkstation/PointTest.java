package com.matteopierro.linkstation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void calculate_distance_between_origin_and_1_1() {
        Point origin = new Point(0, 0);
        Point point_1_1 = new Point(1, 1);

        assertThat(origin.distanceFrom(point_1_1)).isEqualTo(new Distance(1.41));
    }

    @Test
    void calculate_distance_between_1_1_and_4_5() {
        Point point_1_1 = new Point(1, 1);
        Point point_4_5 = new Point(4, 5);

        assertThat(point_1_1.distanceFrom(point_4_5)).isEqualTo(new Distance(5.00));
    }
}
