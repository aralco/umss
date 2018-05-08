package bo.edu.umss.programming.exercise3;

import java.util.Calendar;
import java.util.UUID;

public class PersonnelAdmin {
    public Personnel registerPersonnel(Personnel personnel) throws NotValidPersonnelException {
        personnel.setId(UUID.randomUUID().toString());
        personnel.setRegistrationDate(Calendar.getInstance().getTime());
        if(!isValidPersonnel(personnel))   {
            throw new NotValidPersonnelException();
        }
        System.out.println(personnel);
        return personnel;
    }

    public Boolean isValidPersonnel(Personnel personnel) {
        Boolean isValid = true;
        if(personnel.getFullName()==null
                || personnel.getCi()==null
                || personnel.getBirthDate()==null
                || personnel.getPhone()==null
                || personnel.getAddress()==null
                || personnel.getPosition()==null)   {
            isValid = false;
        }
        return isValid;
    }

    public static void main(String args []) throws NotValidPersonnelException{
        PersonnelAdmin personnelAdmin = new PersonnelAdmin();
        Personnel personnel = new Personnel();
        personnel.setFullName("Pepito Juarez");
        personnel.setCi("65452 TJA");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.MAY, 6);//YYYY,MM,DD
        personnel.setBirthDate(calendar.getTime());
        personnel.setPhone(76587222);
        personnel.setAddress("B. Las Cuadras");
        personnel.setPosition("Cabo");

        personnelAdmin.registerPersonnel(personnel);
    }
}
