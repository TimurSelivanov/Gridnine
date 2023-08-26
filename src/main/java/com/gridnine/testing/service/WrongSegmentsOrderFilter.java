package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class WrongSegmentsOrderFilter implements Filter {

    @Override
    public List<Segment> apply(List<Flight> flightsList) {
        return flightsList.stream()
                .flatMap(list -> list.getSegments().stream())
                .filter(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate()))
                .collect(Collectors.toList());
    }
}
