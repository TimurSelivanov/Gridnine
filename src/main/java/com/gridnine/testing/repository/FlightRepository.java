package com.gridnine.testing.repository;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;

public class FlightRepository {

    public List<Flight> getAllFlights() {
        return FlightBuilder.createFlights();
    }
}
