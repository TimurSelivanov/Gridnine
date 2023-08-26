package com.gridnine.testing.repository;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;

public class FlightRepository {

    List<Flight> flightList;

    public FlightRepository(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getAllFlights() {
        return flightList;
    }
}
