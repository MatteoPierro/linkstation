package com.matteopierro.linkstation.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Distance {
    private final BigDecimal value;

    public Distance(double value) {
        this.value = new BigDecimal(value).setScale(2, HALF_UP);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Distance)) return false;

        Distance distance = (Distance) o;

        return new EqualsBuilder().append(value, distance.value).isEquals();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
