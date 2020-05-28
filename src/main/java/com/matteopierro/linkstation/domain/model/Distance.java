package com.matteopierro.linkstation.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;
import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;

public class Distance {
    private static final int SCALE = 2;

    private final BigDecimal value;

    public Distance(double value) {
        this(new BigDecimal(value));
    }

    private Distance(BigDecimal value) {
        var v = value.setScale(SCALE, HALF_UP);
        isTrue(v.compareTo(ZERO) >= 0);

        this.value = v;
    }

    public boolean isGreaterThan(Distance distance) {
        notNull(distance);

        return value.compareTo(distance.value) > 0;
    }

    public Distance minus(Distance anotherDistance) {
        notNull(anotherDistance);

        return new Distance(value.subtract(anotherDistance.value));
    }

    public Power square() {
        return new Power(value.pow(2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Distance)) return false;

        Distance distance = (Distance) o;

        return new EqualsBuilder()
                .append(value, distance.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
