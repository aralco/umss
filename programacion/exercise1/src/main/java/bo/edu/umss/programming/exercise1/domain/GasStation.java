package bo.edu.umss.programming.exercise1.domain;

import java.util.List;
import java.util.ArrayList;

public class GasStation extends Site {
    private List<FuelDispenser> fuelDispensers;

    public GasStation(String location, String name, String description, List<FuelDispenser> fuelDispensers) {
        super(location, name, description);
        this.fuelDispensers = fuelDispensers;
    }
    
    public GasStation(String location, String name, String description) {
        super(location, name, description);
        this.fuelDispensers = new ArrayList<>();
    }

    public List<FuelDispenser> getFuelDispensers() {
        return fuelDispensers;
    }

    public void setFuelDispensers(List<FuelDispenser> fuelDispensers) {
        this.fuelDispensers = fuelDispensers;
    }
    
    public void addFuelDispenser(FuelDispenser fuelDispenser)  {
        this.fuelDispensers.add(fuelDispenser);
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
