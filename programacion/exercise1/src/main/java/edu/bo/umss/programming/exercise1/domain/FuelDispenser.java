package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public class FuelDispenser {

    private String id;
    private String type;
    private String capacity;

    public FuelDispenser(String type, String capacity) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "FuelDispenser{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
