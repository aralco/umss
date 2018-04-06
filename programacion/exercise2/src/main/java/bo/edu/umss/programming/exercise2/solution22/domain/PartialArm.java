package bo.edu.umss.programming.exercise2.solution22.domain;

public class PartialArm implements Asset, Tag {
    private String id;
    private String name;
    private String description;
    private String serialNumber;
    private String caliber;
    private String weight;
    private String manufacturer;

    public PartialArm(String id, String name, String description, String serialNumber, String caliber, String weight, String manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.caliber = caliber;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public PartialArm() {
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

    @Override
    public String type() {
        return "RFID Tag";
    }

    @Override
    public String toString() {
        return "PartialArm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tag=" + type() + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", caliber='" + caliber + '\'' +
                ", weight='" + weight + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
