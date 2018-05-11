package bo.edu.umss.programming.exercise3;

import java.util.Calendar;
import java.util.UUID;

public class PersonnelAdmin {
    public Personnel registerPersonnel(Personnel personnel) throws NotValidPersonnelException {
        if(!isValidPersonnel(personnel))    {
            throw new NotValidPersonnelException();
        }
        personnel.setId(UUID.randomUUID().toString());
        personnel.setRegistrationDate(Calendar.getInstance().getTime());
        return personnel;
    }

    public Boolean isValidPersonnel(Personnel personnel)    {
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
}
