package bo.edu.umss.programming.exercise2.solution2;

import java.util.List;

public class PartialArmory implements  Site, Asset {

    private String location;
    private List<Asset> assets;

    @Override
    public String name() {
        return "Arm";
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public List<Asset> getAssets() {
        return assets;
    }

    @Override
    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "PartialArmory{" +
                "location='" + location + '\'' +
                ", assets=" + assets +
                '}';
    }
}
