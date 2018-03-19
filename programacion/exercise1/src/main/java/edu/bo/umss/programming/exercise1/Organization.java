package edu.bo.umss.programming.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ariel.alcocer
 */
public class Organization {
    private String id;
    private String name;
    private String description;
    private List<Asset> assets;
    private List<Site> sites;
    private List<Personnel> personnels;

    public Organization(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        assets = new ArrayList<>(0);
        sites = new ArrayList<>(0);
        personnels = new ArrayList<>(0);

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

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assets=" + assets +
                ", sites=" + sites +
                ", personnels=" + personnels +
                '}';
    }
}
