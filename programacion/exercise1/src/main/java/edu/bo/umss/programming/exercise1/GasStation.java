package edu.bo.umss.programming.exercise1;

import java.util.List;

/**
 * @author ariel.alcocer
 */
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
}
