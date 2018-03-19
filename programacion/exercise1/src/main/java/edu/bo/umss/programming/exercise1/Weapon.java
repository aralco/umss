package edu.bo.umss.programming.exercise1;

/**
 * @author ariel.alcocer
 */
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
}
