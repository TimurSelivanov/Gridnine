package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.util.FlightBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

class LayoverTimeFilterTest {
    private LayoverTimeFilter layoverTimeFilter;
    private List<Flight> testFlightList;

    @BeforeEach
    void setUp() {
        layoverTimeFilter = new LayoverTimeFilter();
        testFlightList = FlightBuilder.createFlights();
    }

    @AfterEach
    void tearDown() {
        layoverTimeFilter = null;
        testFlightList = null;
    }

    @Test
    void getsTheListWithSizeEqualsToOne() {
        Assertions.assertEquals(2, layoverTimeFilter.apply(testFlightList).size());
    }

    @Test
    void getsFlightWithLayoverTimeMoreThanTwoOurs() {
        long calculatedLayoverTime = 0;
        final List<Segment> segments = layoverTimeFilter.apply(testFlightList).get(0).getSegments();

        for (int i = 1; i < segments.size(); i++)
            calculatedLayoverTime += Duration.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate())
                    .toHours();

        Assertions.assertTrue(calculatedLayoverTime > 2);

    }
}