package bo.edu.umss.programming.exercise2.solution11.domain;

import java.util.List;

public interface SiteAsset{
    void setLocation(String location);
    String getLocation();
    List<Object> getAssets();
    void setAssets(List<Object> assets);
    String name();
}
