package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public abstract class Asset {
    private String id;
    private String name;
    private String description;

    public Asset() {
    }

    protected Asset(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
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
