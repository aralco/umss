package bo.edu.umss.programming.exercise3;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class PersonnelAdminTest {
    private PersonnelAdmin personnelAdmin;
    private Personnel personnel;
    private Personnel personnel2;
    private Personnel notValidPersonnel;

    @Before
    public void setUp() throws Exception {
        personnelAdmin = new PersonnelAdmin();
        Calendar calendar = Calendar.getInstance();

        personnel = new Personnel();
        personnel.setFullName("Pepito Juarez");
        personnel.setCi("65452 TJA");
        calendar.set(1999, Calendar.MAY, 6);//YYYY,MM,DD
        personnel.setBirthDate(calendar.getTime());
        personnel.setPhone(76587222);
        personnel.setAddress("B. Las Cuadras");
        personnel.setPosition("Cabo");

        personnel2 = new Personnel();
        personnel2.setFullName("Jon Doe");
        personnel2.setCi("7686555 CBB");
        calendar.set(1995, Calendar.DECEMBER, 21);//YYYY,MM,DD
        personnel2.setBirthDate(calendar.getTime());
        personnel2.setPhone(70770777);
        personnel2.setAddress("Av. Sucre #1999");
        personnel2.setPosition("Capitán");

        notValidPersonnel = new Personnel();
    }

    @Test
    public void testRegisteredPersonnelIsReturned() throws Exception {
        assertNotNull(personnelAdmin.registerPersonnel(personnel));
    }

    @Test
    public void testRegisteredPersonnelHasId() throws Exception {
        assertNotNull((personnelAdmin.registerPersonnel(personnel)).getId());
    }

    @Test
    public void testRegisteredPersonnelHasRegistrationDate() throws Exception {
        assertNotNull((personnelAdmin.registerPersonnel(personnel)).getRegistrationDate());
    }

    @Test
    public void testRegisteredPersonnelHasUniqueId() throws Exception {;
        assertNotEquals(
                personnelAdmin.registerPersonnel(personnel).getId(),
                personnelAdmin.registerPersonnel(personnel2).getId());
    }

    @Test
    public void testPersonnelToBeRegisteredIsValid() throws Exception {
        assertTrue(personnelAdmin.isValidPersonnel(personnel));
    }

    @Test
    public void testPersonnelToBeRegisteredIsNotValid() throws Exception {
        assertFalse(personnelAdmin.isValidPersonnel(notValidPersonnel));
    }

    @Test(expected = NotValidPersonnelException.class)
    public void testx() throws Exception {
        personnelAdmin.registerPersonnel(notValidPersonnel);
    }
}
