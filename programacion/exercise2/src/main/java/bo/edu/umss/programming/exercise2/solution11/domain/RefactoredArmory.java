package bo.edu.umss.programming.exercise2.solution11.domain;

import java.util.List;

public class RefactoredArmory implements SiteAsset {
    private String location;
    private List<Object> assets;

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
    public List<Object> getAssets() {
        return assets;
    }

    @Override
    public void setAssets(List<Object> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "RefactoredArmory{" +
                "location='" + location + '\'' +
                ", assets=" + assets +
                '}';
    }
}
