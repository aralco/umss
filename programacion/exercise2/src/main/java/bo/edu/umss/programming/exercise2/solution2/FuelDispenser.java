package bo.edu.umss.programming.exercise2.solution2;

public class FuelDispenser implements Asset {

    @Override
    public String name() {
        return "Fuel Dispenser";
    }

    @Override
    public String toString() {
        return name();
    }
}
