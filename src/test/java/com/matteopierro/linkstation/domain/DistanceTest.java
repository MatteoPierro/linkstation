package com.matteopierro.linkstation.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DistanceTest {

    @Test
    void cannot_be_negative() {
        assertThatThrownBy(() -> new Distance(-12.23))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void distances_grater_than_to_minus_zero_zero_five_are_zero() {
        assertThat(new Distance(-0.004)).isEqualTo(new Distance(0));
        assertThat(new Distance(-0.0049)).isEqualTo(new Distance(0));
        assertThatThrownBy(() -> new Distance(-0.005))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
