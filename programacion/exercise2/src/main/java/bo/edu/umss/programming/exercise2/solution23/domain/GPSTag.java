package bo.edu.umss.programming.exercise2.solution23.domain;

public class GPSTag implements Tag {

    @Override
    public String type() {
        return "GPS Tag";
    }

    @Override
    public String toString() {
        return "GPSTag{" +
                "type='" + type() + '\'' +
                '}';
    }
}
