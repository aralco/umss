package bo.edu.umss.programming.exercise3.service;

import bo.edu.umss.programming.exercise3.domain.Personnel;
import bo.edu.umss.programming.exercise3.exception.NotValidPersonnelException;

import java.util.*;

public class PersonnelAdmin {
    private List<Personnel> registeredPersonnels = new ArrayList<>();

    public Personnel registerPersonnel(Personnel personnel) throws NotValidPersonnelException {
        if(!isValidPersonnel(personnel))    {
            throw new NotValidPersonnelException();
        }
        personnel.setId(UUID.randomUUID().toString());
        personnel.setRegistrationDate(Calendar.getInstance().getTime());
        registeredPersonnels.add(personnel);
        return personnel;
    }

    public Boolean isValidPersonnel(Personnel personnel)    {
        Boolean isValid = true;
        if(personnel.getFullName()==null
                || personnel.getNationalID()==null
                || personnel.getBirthDate()==null
                || personnel.getPhone()==null
                || personnel.getAddress()==null
                || personnel.getPosition()==null)   {
            isValid = false;
        }
        return isValid;
    }

    public List<Personnel> retrieveRegisteredPersonnelList() {
        return registeredPersonnels;
    }

    public List<Personnel> retrieveRegisteredPersonnelList(String criteria, String order) {
//        Comparator<Personnel> c = (o1, o2) -> o1.getBirthDate().compareTo(o2.getBirthDate();
        Comparator<Personnel> comparator = null;
        switch (criteria)   {
            case "id":
                comparator = Comparator.comparing(Personnel::getId);
                break;
            case "fullName":
                comparator = Comparator.comparing(Personnel::getFullName);
                break;
            case "birthDate":
                comparator = Comparator.comparing(Personnel::getBirthDate);
                break;
            case "nationalID":
                comparator = Comparator.comparing(Personnel::getNationalID);
                break;
            case "registrationDate":
                comparator = Comparator.comparing(Personnel::getRegistrationDate);
                break;
        }
        Collections.sort(registeredPersonnels, comparator);
        if(order.equals("DESC"))
            Collections.reverse(registeredPersonnels);
        return registeredPersonnels;
    }

    public Personnel searchById(String s) {
        Comparator<Personnel> comparator = Comparator.comparing(Personnel::getId);
        Personnel target = new Personnel();
        target.setId(s);
        registeredPersonnels.sort(comparator);
        int found = Collections.binarySearch(registeredPersonnels, target, comparator);
        return registeredPersonnels.get(found);
    }

    public Personnel searchByFullName(String s) {
        Comparator<Personnel> comparator = Comparator.comparing(Personnel::getFullName);
        Personnel target = new Personnel();
        target.setFullName(s);
        registeredPersonnels.sort(comparator);
        int found = Collections.binarySearch(registeredPersonnels, target, comparator);
        return registeredPersonnels.get(found);
    }

    public Personnel searchByNationalID(String s) {
        Comparator<Personnel> comparator = Comparator.comparing(Personnel::getNationalID);
        Personnel target = new Personnel();
        target.setNationalID(s);
        registeredPersonnels.sort(comparator);
        int found = Collections.binarySearch(registeredPersonnels, target, comparator);
        return registeredPersonnels.get(found);
    }

}
