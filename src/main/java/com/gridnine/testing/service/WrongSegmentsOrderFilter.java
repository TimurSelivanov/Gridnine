package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class WrongSegmentsOrderFilter implements Filter {

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        return flightsList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
