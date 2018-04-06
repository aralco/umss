package bo.edu.umss.programming.exercise2.solution22;

import bo.edu.umss.programming.exercise2.solution22.domain.Asset;
import bo.edu.umss.programming.exercise2.solution22.domain.AssetFactory;
import bo.edu.umss.programming.exercise2.solution22.domain.PartialArm;
import bo.edu.umss.programming.exercise2.solution22.domain.PartialVehicle;

public class Admin {

    public static void main(String args[]) throws IllegalAccessException, InstantiationException {
        Asset arm = AssetFactory.getAsset(PartialArm.class);
        PartialArm partialArm = (PartialArm) arm;
        partialArm.setId("1");
        partialArm.setName("Arm1");
        partialArm.setDescription("arm1");
        partialArm.setSerialNumber("001");
        partialArm.setCaliber("21");
        partialArm.setWeight("0.5kg");
        partialArm.setManufacturer("Poison");
        System.out.println(arm);

        Asset vehicle = AssetFactory.getAsset(PartialVehicle.class);
        ((PartialVehicle)vehicle).setId("1");
        vehicle.setName("Vehicle1");
        vehicle.setDescription("vehicle1");
        ((PartialVehicle)vehicle).setVin("JDUA312331");
        ((PartialVehicle)vehicle).setLicensePlate("JSL2311");
        ((PartialVehicle)vehicle).setBrand("Toyota");
        ((PartialVehicle)vehicle).setYear(2017);
        ((PartialVehicle)vehicle).setModel("Land Cruiser");
        System.out.println(vehicle);

    }


}
