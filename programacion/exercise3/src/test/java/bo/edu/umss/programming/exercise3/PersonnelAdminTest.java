package bo.edu.umss.programming.exercise3;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

public class PersonnelAdminTest {
    private PersonnelAdmin personnelAdmin;
    private Personnel personnel;
    private Personnel personnel2;
    private Personnel personnel3;
    private Personnel personnel4;
    private Personnel notValidPersonnel;

    @Before
    public void setUp() throws Exception {
        personnelAdmin = new PersonnelAdmin();
        Calendar calendar = Calendar.getInstance();

        personnel = new Personnel();
        personnel.setFullName("Pepito Juarez");
        personnel.setNationalID("654520 TJ");
        calendar.set(1999, Calendar.MAY, 6);//YYYY,MM,DD
        personnel.setBirthDate(calendar.getTime());
        personnel.setPhone(76587222);
        personnel.setAddress("B. Las Cuadras");
        personnel.setPosition("Cabo");

        personnel2 = new Personnel();
        personnel2.setFullName("Jon Doe");
        personnel2.setNationalID("212735 SC");
        calendar.set(1987, Calendar.APRIL, 7);//YYYY,MM,DD
        personnel2.setBirthDate(calendar.getTime());
        personnel2.setPhone(70770777);
        personnel2.setAddress("Av. Sucre #1999");
        personnel2.setPosition("Cabo");

        personnel3 = new Personnel();
        personnel3.setFullName("Marco Botton");
        personnel3.setNationalID("134056 CB");
        calendar.set(1989, Calendar.MAY, 13);//YYYY,MM,DD
        personnel3.setBirthDate(calendar.getTime());
        personnel3.setPhone(70770777);
        personnel3.setAddress("Av. Sucre #1999");
        personnel3.setPosition("Sargento");

        personnel4 = new Personnel();
        personnel4.setFullName("Valerie Liberty");
        personnel4.setNationalID("231256 LP");
        calendar.set(1993, Calendar.NOVEMBER, 18);//YYYY,MM,DD
        personnel4.setBirthDate(calendar.getTime());
        personnel4.setPhone(74392312);
        personnel4.setAddress("Av. Pando #121");
        personnel4.setPosition("Sargento");

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
    public void testExceptionThrownWhenPersonnelToBeRegisteredIsNotValid() throws Exception {
        personnelAdmin.registerPersonnel(notValidPersonnel);
    }

    @Test
    public void testRegisteredPersonnelListExists() throws Exception {
        assertNotNull(personnelAdmin.retrieveRegisteredPersonnelList());
    }

    @Test
    public void testRegisteredPersonnelListIsNotEmpty() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList(), not(empty()));
    }

    @Test
    public void testRegisteredPersonnelIsOnRegisteredPersonnelList() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList(), hasItems(personnel, personnel2));
    }

    @Test
    public void testSortByNameAsc() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        personnelAdmin.registerPersonnel(personnel3);
        personnelAdmin.registerPersonnel(personnel4);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList("name","ASC"), contains(personnel2, personnel3, personnel, personnel4));

    }

    @Test
    public void testSortByNationalIDAsc() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        personnelAdmin.registerPersonnel(personnel3);
        personnelAdmin.registerPersonnel(personnel4);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList("nationalID","ASC"), contains(personnel3, personnel2, personnel4, personnel));
    }

    @Test
    public void testSortByBirthDateAsc() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        personnelAdmin.registerPersonnel(personnel3);
        personnelAdmin.registerPersonnel(personnel4);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList("birthDate","ASC"), contains(personnel2, personnel3, personnel4, personnel));
    }

    @Test
    public void testSortByNameDesc() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        personnelAdmin.registerPersonnel(personnel3);
        personnelAdmin.registerPersonnel(personnel4);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList("name","DESC"), contains(personnel4, personnel, personnel3, personnel2));

    }

    @Test
    public void testSortByNationalIDDesc() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        personnelAdmin.registerPersonnel(personnel3);
        personnelAdmin.registerPersonnel(personnel4);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList("nationalID","DESC"), contains(personnel, personnel4, personnel2, personnel3));
    }

    @Test
    public void testSortByBirthDateDesc() throws Exception {
        personnelAdmin.registerPersonnel(personnel);
        personnelAdmin.registerPersonnel(personnel2);
        personnelAdmin.registerPersonnel(personnel3);
        personnelAdmin.registerPersonnel(personnel4);
        assertThat(personnelAdmin.retrieveRegisteredPersonnelList("birthDate","DESC"), contains(personnel, personnel4, personnel3, personnel2));
    }


}
