package bo.edu.umss.programming.exercise3;

import java.util.UUID;

public class Personnel {

    private String id;


    public Personnel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
