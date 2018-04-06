package bo.edu.umss.programming.exercise2.solution21;

import bo.edu.umss.programming.exercise2.solution21.domain.Arm;
import bo.edu.umss.programming.exercise2.solution21.domain.AssetTag;
import bo.edu.umss.programming.exercise2.solution21.domain.Vehicle;

public class Admin {

    public static void main(String args[])  {
        AssetTag arm = new Arm("1", "Arm1", "arm1", "001", "21", "0.5kg", "Poison");
        System.out.println(arm);

        AssetTag vehicle = new Vehicle("1", "Vehicle1", "vehicle1", "JDUA312331", "JSL2311", "Toyota", 2017, "Land Cruiser");
        System.out.println(vehicle);

    }
}
