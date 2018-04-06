package bo.edu.umss.programming.exercise2.solution23.domain;

public interface Asset {
    String getId();
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    Tag getTag();
    void setTag(Tag tag);
}
