package com.matteopierro.linkstation.domain;

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

    @Test
    void distance_between_point_A_and_point_B_is_the_same_distance_between_point_B_and_point_A() {
        Point pointA = new Point(4,5);
        Point pointB = new Point(3,7);

        assertThat(pointA.distanceFrom(pointB)).isEqualTo(pointB.distanceFrom(pointA));
    }

    @Test
    void distance_from_itself_is_zero() {
        Point point = new Point(7,13);

        assertThat(point.distanceFrom(point)).isEqualTo(new Distance(0));
    }
}
