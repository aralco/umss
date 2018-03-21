package edu.bo.umss.programming.exercise1.domain;

import java.util.List;

public class GasStation extends Site {
    private List<FuelDispenser> fuelDispensers;

    public GasStation(String location, String name, String description, List<FuelDispenser> fuelDispensers) {
        super(location, name, description);
        this.fuelDispensers = fuelDispensers;
    }

    public List<FuelDispenser> getFuelDispensers() {
        return fuelDispensers;
    }

    public void setFuelDispensers(List<FuelDispenser> fuelDispensers) {
        this.fuelDispensers = fuelDispensers;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", fuelDispensers=" + fuelDispensers +
                '}';
    }
}
