package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class LayoverTimeFilter implements Filter {

    private final static int LAYOVER_TIME_LIMIT = 2; //TODO: move variable to a util or validation class

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        return flightsList.stream()
                .filter(flight -> isLayoverTimeMoreThanLimit(flight))
                .collect(Collectors.toList());
    }

    private static boolean isLayoverTimeMoreThanLimit(Flight flight) {
        int calculatedLayoverTime = 0;
        List<Segment> segments = flight.getSegments();
        for(int i = 1; i < segments.size(); i++) {
            calculatedLayoverTime += (segments.get(i).getDepartureDate().getHour() - segments.get(i - 1).getArrivalDate().getHour());
        }
        return calculatedLayoverTime > LAYOVER_TIME_LIMIT;
    }
}
