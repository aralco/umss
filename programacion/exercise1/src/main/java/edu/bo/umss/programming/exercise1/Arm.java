package edu.bo.umss.programming.exercise1;

/**
 * @author ariel.alcocer
 */
public abstract class Arm extends Asset {
    private String serialNumber;
    private String caliber;
    private String weight;
    private String manufacturer;

    protected Arm(String name, String description, String serialNumber, String caliber, String weight, String manufacturer) {
        super(name, description);
        this.serialNumber = serialNumber;
        this.caliber = caliber;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
