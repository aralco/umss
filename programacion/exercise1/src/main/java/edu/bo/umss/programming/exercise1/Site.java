package edu.bo.umss.programming.exercise1;

import java.util.UUID;

/**
 * @author ariel.alcocer
 */
public abstract class Site {
    private String id;
    private String location;
    private String name;
    private String description;

    public Site() {
    }

    protected Site(String location, String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
