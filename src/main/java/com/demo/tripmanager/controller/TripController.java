package com.demo.tripmanager.controller;

import com.demo.tripmanager.model.Trip;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final Map<Long, Trip> trips = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TripController() {
        Trip t1 = new Trip(idGenerator.getAndIncrement(), "Chicago", 3);
        Trip t2 = new Trip(idGenerator.getAndIncrement(), "New York", 5);
        trips.put(t1.getId(), t1);
        trips.put(t2.getId(), t2);
    }

    @GetMapping
    public Collection<Trip> getAll() {
        return trips.values();
    }

    @GetMapping("/{id}")
    public Trip getById(@PathVariable("id") long id) {

        return trips.get(id);
    }

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        long id = idGenerator.getAndIncrement();
        trip.setId(id);
        trips.put(id, trip);
        return trip;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trips.remove(id);
    }
}
