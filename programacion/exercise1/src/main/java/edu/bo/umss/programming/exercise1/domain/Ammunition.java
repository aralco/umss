package edu.bo.umss.programming.exercise1.domain;

public class Ammunition extends Arm {
    private Integer numberOfRounds;
    private String bulk;


    public Ammunition(String name, String description, String serialNumber, String caliber, String weight, String manufacturer, Integer numberOfRounds, String bulk) {
        super(name, description, serialNumber, caliber, weight, manufacturer);
        this.numberOfRounds = numberOfRounds;
        this.bulk = bulk;
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(Integer numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", serialNumber='" + getSerialNumber() + '\'' +
                ", caliber='" + getCaliber() + '\'' +
                ", weight='" + getWeight() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", numberOfRounds=" + numberOfRounds +
                ", bulk='" + bulk + '\'' +
                '}';
    }
}
