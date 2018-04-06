package bo.edu.umss.programming.exercise2.solution12.domain;

import java.util.List;

public interface Site {
    void setLocation(String location);
    String getLocation();
    List<Asset> getAssets();
    void setAssets(List<Asset> assets);
}
