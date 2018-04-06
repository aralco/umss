package bo.edu.umss.programming.exercise2.solution22.domain;

public class PartialVehicle implements Asset, Tag {

    private String id;
    private String name;
    private String description;
    private String vin;
    private String licensePlate;
    private String brand;
    private Integer year;
    private String model;

    public PartialVehicle(String id, String name, String description, String vin, String licensePlate, String brand, Integer year, String model) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.year = year;
        this.model = model;
    }

    public PartialVehicle() {
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Tag getTag() {
        return this;
    }

    @Override
    public void setTag(Tag tag) {
        throw new UnsupportedOperationException("NA");
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
    public String type() {
        return "GPS Tag";
    }

    @Override
    public String toString() {
        return "PartialVehicle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tag=" + type() + '\'' +
                ", vin='" + vin + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", model='" + model + '\'' +
                '}';
    }
}
