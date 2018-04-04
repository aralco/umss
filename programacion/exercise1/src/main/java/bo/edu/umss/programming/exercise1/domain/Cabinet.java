package bo.edu.umss.programming.exercise1.domain;

import java.util.UUID;

public class Cabinet {
    private String id;
    private Long slotsNumber;

    public Cabinet(Long slotsNumber) {
        this.id = UUID.randomUUID().toString();
        this.slotsNumber = slotsNumber;
    }

    public String getId() {
        return id;
    }

    public Long getSlotsNumber() {
        return slotsNumber;
    }

    public void setSlotsNumber(Long slotsNumber) {
        this.slotsNumber = slotsNumber;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "id='" + id + '\'' +
                ", slotsNumber=" + slotsNumber +
                '}';
    }
}
