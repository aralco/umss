package bo.edu.umss.programming.exercise3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;

public class PersonnelAdminTest {
    private PersonnelAdmin personnelAdmin;
    private Personnel personnel;
    private Personnel personnel2;
    private Personnel notValidPersonnel;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void testRegisteredPersonnel() throws NotValidPersonnelException {
        Assert.assertNotNull("Personnel should be registered/created.",
                personnelAdmin.registerPersonnel(personnel));
    }

    @Test
    public void testGeneratedIdentifierByRegister() throws NotValidPersonnelException {
        Assert.assertNotNull("Register Personnel should have a generated identifier.",
                personnelAdmin.registerPersonnel(personnel).getId());
    }

    @Test
    public void testGeneratedIdentifierByRegisterIsUnique() throws NotValidPersonnelException {
        Assert.assertNotEquals(
                personnelAdmin.registerPersonnel(personnel).getId(),
                personnelAdmin.registerPersonnel(personnel2).getId()
        );
    }

    @Test
    public void testGeneratedRegisteredDateByRegister() throws NotValidPersonnelException {
        Assert.assertNotNull(personnelAdmin.registerPersonnel(personnel).getRegistrationDate());
    }

    @Test(expected = NotValidPersonnelException.class)
    public void testRegistrationPersonnelDataIsValid() throws NotValidPersonnelException {
        personnelAdmin.registerPersonnel(notValidPersonnel);
    }

    @Test
    public void testRegistrationPersonnelDataIsValid2() throws NotValidPersonnelException {
        thrown.expect(NotValidPersonnelException.class);
        personnelAdmin.registerPersonnel(notValidPersonnel);
    }

    @Test
    public void isValidPersonnel()  {
        Assert.assertTrue(
                "A person with valid inputs is provided.",
                personnelAdmin.isValidPersonnel(personnel));
    }

    @Test
    public void isNotValidPersonnel()  {
        Assert.assertFalse(
                "A person with not valid inputs is provided.",
                personnelAdmin.isValidPersonnel(notValidPersonnel));
    }

}
