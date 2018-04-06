package bo.edu.umss.programming.exercise2.solution23.domain;

public class RFIDTag implements Tag {

    @Override
    public String type() {
        return "RFID Tag";
    }

    @Override
    public String toString() {
        return "RFIDTag{" +
                "type='" + type() + '\'' +
                '}';
    }
}
