package com.demo.tripmanager.model;

public class Trip {
    private Long id;
    private String destination;
    private int days;

    public Trip() {}

    public Trip(Long id, String destination, int days) {
        this.id = id;
        this.destination = destination;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public int getDays() {
        return days;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
