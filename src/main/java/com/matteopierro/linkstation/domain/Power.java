package com.matteopierro.linkstation.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;
import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notNull;

public class Power {
    public static final Power ZERO = new Power(BigDecimal.ZERO);
    private static final int SCALE = 2;

    private final BigDecimal value;

    public Power(BigDecimal value) {
        notNull(value);
        var v = value.setScale(SCALE, HALF_UP);
        isTrue(v.compareTo(BigDecimal.ZERO) >= 0);

        this.value = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Power)) return false;

        Power power = (Power) o;

        return new EqualsBuilder()
                .append(value, power.value)
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
