package com.gridnine.testing.repository;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;

public class FlightRepository {
    private List<Flight> flightList;

    public FlightRepository() {
        this.flightList = FlightBuilder.createFlights();
    }

    public List<Flight> getAllFlights() {
        return flightList;
    }
}
