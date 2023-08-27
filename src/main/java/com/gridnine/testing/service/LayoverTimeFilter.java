package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LayoverTimeFilter implements Filter {

    private final static long LAYOVER_TIME_LIMIT = 2;

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        return flightsList.stream()
                .filter(LayoverTimeFilter::isLayoverTimeMoreThanLimit)
                .collect(Collectors.toList());
    }

    private static boolean isLayoverTimeMoreThanLimit(Flight flight) {
        long calculatedLayoverTime = 0;
        List<Segment> segments = flight.getSegments();
        for (int i = 1; i < segments.size(); i++)
            calculatedLayoverTime += Duration.between(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate())
                    .toHours();
        return calculatedLayoverTime > LAYOVER_TIME_LIMIT;
    }
}
