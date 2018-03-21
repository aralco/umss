package edu.bo.umss.programming.exercise1.domain;

import java.util.List;

public class Armory extends Site {

    private List<Cabinet> cabinets;

    public Armory(String location, String name, String description, List<Cabinet> cabinets){
        super(location, name, description);
        this.cabinets = cabinets;
    }

    public List<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }

    @Override
    public String toString() {
        return "Armory{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", cabinets=" + cabinets +
                '}';
    }
}
