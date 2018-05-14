package bo.edu.umss.programming.exercise3;

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

    public static void main(String args[]) throws NotValidPersonnelException {
        PersonnelAdmin personnelAdmin;
        Personnel personnel;
        Personnel personnel2;
        Personnel personnel3;
        Personnel personnel4;

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

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("Register new Personnel: %s \n", personnel);
        personnelAdmin.registerPersonnel(personnel);
        List<Personnel> personnels = personnelAdmin.retrieveRegisteredPersonnelList();
        displayPersonnelList(personnels);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("Register new Personnel: %s \n", personnel2);
        personnelAdmin.registerPersonnel(personnel2);
        personnels = personnelAdmin.retrieveRegisteredPersonnelList();
        displayPersonnelList(personnels);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("Register new Personnel: %s \n", personnel3);
        personnelAdmin.registerPersonnel(personnel3);
        personnels = personnelAdmin.retrieveRegisteredPersonnelList();
        displayPersonnelList(personnels);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("Register new Personnel: %s \n", personnel4);
        personnelAdmin.registerPersonnel(personnel4);
        personnels = personnelAdmin.retrieveRegisteredPersonnelList();
        displayPersonnelList(personnels);

        System.out.println("********************************************************************************************");
        System.out.println("SortBy FullName, ASC");
        personnels = personnelAdmin.retrieveRegisteredPersonnelList("fullName", "ASC");
        displayPersonnelList(personnels);

        System.out.println("********************************************************************************************");
        System.out.println("SortBy BirthDate, DESC");
        personnels = personnelAdmin.retrieveRegisteredPersonnelList("birthDate", "DESC");
        displayPersonnelList(personnels);

        System.out.println("********************************************************************************************");
        System.out.println("Search for: Pepito Juarez");
        Personnel found = personnelAdmin.searchByFullName("Pepito Juarez");
        List<Personnel> personnelList = new ArrayList<>(1);
        personnelList.add(found);
        displayPersonnelList(personnelList);

    }

    public static void displayPersonnelList(List<Personnel> personnels)    {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.printf("| Id | \t Name | \t NationalID | \t BirthDate | \t Phone | \t Address | \t Position | \t Registration Date | \n");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for(Personnel p : personnels)   {
            System.out.printf("%s \n", p);
        }
    }
}
