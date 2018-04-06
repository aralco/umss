package bo.edu.umss.programming.exercise2.solution23;

import bo.edu.umss.programming.exercise2.solution23.domain.*;

public class Admin {

    public static void main(String args[])  {
        Asset arm = new Arm("1", "Arm1", "arm1", "001", "21", "0.5kg", "Poison");
        Tag rfIdTag = new RFIDTag();
        arm.setTag(rfIdTag);
        System.out.println(arm);

        Asset vehicle = new Vehicle("1", "Vehicle1", "vehicle1", "JDUA312331", "JSL2311", "Toyota", 2017, "Land Cruiser");
        Tag gpsTag = new GPSTag();
        vehicle.setTag(gpsTag);
        System.out.println(vehicle);

    }


}
