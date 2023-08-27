package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureIsBeforeNowFilter implements Filter {

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        LocalDateTime now = LocalDateTime.now();
        return flightsList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(now)))
                .collect(Collectors.toList());
    }
}
