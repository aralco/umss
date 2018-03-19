package edu.bo.umss.programming.exercise1;

import java.util.List;

/**
 * @author ariel.alcocer
 */
public class Armory extends Site {

    private List<Cabinet> cabinets;

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
