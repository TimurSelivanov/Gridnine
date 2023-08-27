package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class WrongSegmentsOrderFilterTest {
    private WrongSegmentsOrderFilter wrongSegmentsOrderFilter;
    private List<Flight> testFlightList;
    @BeforeEach
    void setUp() {
        wrongSegmentsOrderFilter = new WrongSegmentsOrderFilter();
        testFlightList = FlightBuilder.createFlights();
    }

    @AfterEach
    void tearDown() {
        wrongSegmentsOrderFilter = null;
        testFlightList = null;
    }

    @Test
    void getsTheListWithSizeEqualsToOne() {
        Assertions.assertEquals(1, wrongSegmentsOrderFilter.apply(testFlightList).size());
    }

    @Test
    void getsFlightWithWrongSegmentsOrder() {
        Assertions.assertTrue(wrongSegmentsOrderFilter.apply(testFlightList).get(0).getSegments().get(0).getDepartureDate()
                .isAfter(wrongSegmentsOrderFilter.apply(testFlightList).get(0).getSegments().get(0).getArrivalDate()));
    }
}