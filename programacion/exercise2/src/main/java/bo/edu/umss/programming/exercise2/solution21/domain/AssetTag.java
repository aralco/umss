package bo.edu.umss.programming.exercise2.solution21.domain;

public interface AssetTag {
    //ASSET
    String getId();
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);

    //TAG
    String type();
}
