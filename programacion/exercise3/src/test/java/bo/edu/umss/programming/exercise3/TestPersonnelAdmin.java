package bo.edu.umss.programming.exercise3;

import org.junit.gen5.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPersonnelAdmin {

    @Test
    public void testIdentifierIsGenerated()    {
        Personnel personnel = new Personnel();
        PersonnelAdmin personnelAdmin = new PersonnelAdmin();
        assertNotNull(personnelAdmin.registerPersonnel(personnel).getId());
    }

    @Test
    public void testIdentifierIsUnique()    {
        Personnel personnel1 = new Personnel();
        Personnel personnel2 = new Personnel();
        assertNotEquals(personnel1.getId(),personnel2.getId());
    }

}
