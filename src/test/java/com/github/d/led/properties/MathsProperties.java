package com.github.d.led.properties;

import com.github.d.led.services.Maths;
import net.jqwik.api.*;
import org.junit.jupiter.api.Tag;

@Tag("property")
class MathsProperties {
    Maths maths = new Maths();

    @Property
    boolean multiplying_positive_numbers_returns_positive_number(@ForAll("positive") int a,
                                                                 @ForAll("positive") int b) {
        return maths.multiply(a, b) > 0;
    }

    @Provide
    Arbitrary<Integer> positive() {
        return Arbitraries.integers().filter(i -> i > 0);
    }
}
