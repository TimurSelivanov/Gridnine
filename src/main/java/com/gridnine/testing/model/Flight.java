package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {
    private final int id;
    private final List<Segment> segments;

    public Flight(int id, final List<Segment> segs) {
        this.id = id;
        segments = segs;
    }

    public int getId() {
        return id;
    }
    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return "Flight # " + id + " " + segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
