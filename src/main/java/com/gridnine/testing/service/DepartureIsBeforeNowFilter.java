package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureIsBeforeNowFilter implements Filter {

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        LocalDateTime now = LocalDateTime.now();
//        return flightsList.stream()
//                .flatMap(list -> list.getSegments().stream())
//                .filter(segment -> segment.getDepartureDate().isBefore(now))
//                .collect(Collectors.toList());
        return null;
    }
}