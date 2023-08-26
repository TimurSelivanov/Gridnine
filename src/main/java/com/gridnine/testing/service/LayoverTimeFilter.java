package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.repository.FlightRepository;

import java.util.List;

public class LayoverTimeFilter implements Filter {
    private final FlightRepository flightRepository;

    public LayoverTimeFilter(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> apply(List<Flight> flightsList) {
        return null;
    }
}
