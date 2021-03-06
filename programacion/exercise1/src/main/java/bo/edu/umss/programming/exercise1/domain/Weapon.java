package bo.edu.umss.programming.exercise1.domain;

public class Weapon extends Arm {
    private String type;
    private String model;
    private String mode;

    public Weapon(String name, String description, String serialNumber, String caliber, String weight, String manufacturer, String type, String model, String mode) {
        super(name, description, serialNumber, caliber, weight, manufacturer);
        this.type = type;
        this.model = model;
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", serialNumber='" + getSerialNumber() + '\'' +
                ", caliber='" + getCaliber() + '\'' +
                ", weight='" + getWeight() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
