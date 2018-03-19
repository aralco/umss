package edu.bo.umss.programming.exercise1;

/**
 * @author ariel.alcocer
 */
public class Vehicle extends Asset {
    private String vin;
    private String licensePlate;
    private String brand;
    private Integer year;
    private String model;

    public Vehicle(String name, String description, String vin, String licensePlate, String brand, Integer year, String model) {
        super(name, description);
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.year = year;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", vin='" + vin + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
