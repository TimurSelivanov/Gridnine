package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.FlightRepository;

import java.util.List;

public class WrongSegmentsOrderFilter implements Filter {
    private final FlightRepository flightRepository;

    public WrongSegmentsOrderFilter(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        return null;
    }
}
