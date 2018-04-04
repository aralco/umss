package bo.edu.umss.programming.exercise2.problem;

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
