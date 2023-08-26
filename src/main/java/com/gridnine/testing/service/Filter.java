package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;

public interface Filter {
    public List<Flight> apply(List<Flight> flightsList);
}
