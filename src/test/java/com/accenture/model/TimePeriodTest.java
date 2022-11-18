package com.accenture.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TimePeriodTest {

    private TimePeriod timePeriodUnderTest;
    private OffsetDateTime offsetDateTime;

    @BeforeEach
    void setUp() {
        timePeriodUnderTest = new TimePeriod();
        offsetDateTime =  OffsetDateTime.now();
    }

    @Test
    void testStartDateEqual() {
        var aux = offsetDateTime;
        timePeriodUnderTest.setStartDateTime(aux);
        assertThat(timePeriodUnderTest.getStartDateTime().equals(aux)).isTrue();
    }

    @Test
    void testEndDateEqual() {
        var aux = offsetDateTime;
        timePeriodUnderTest.setEndDateTime(aux);
        assertThat(timePeriodUnderTest.getEndDateTime().equals(aux)).isTrue();
    }

}
