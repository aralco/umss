package bo.edu.umss.programming.exercise2.problem1.domain;

public class Arm implements Asset {
    @Override
    public String name() {
        return "Arm";
    }

    @Override
    public String toString() {
        return name();
    }
}
