package bo.edu.umss.programming.exercise2.problem1;


import bo.edu.umss.programming.exercise2.problem1.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static void main(String args[])  {
        Site armory = new Armory();
        armory.setLocation("North");
        List<Asset> arms = new ArrayList<>();
        Asset arm1 = new Arm();
        arms.add(arm1);
        armory.setAssets(arms);
        System.out.println(armory);

        Site fuelStation = new FuelStation();
        fuelStation.setLocation("South");
        List<Asset> fuelDispensers = new ArrayList<>();
        Asset fuelDispenser1 = new FuelDispenser();
        fuelDispensers.add(fuelDispenser1);
        fuelStation.setAssets(fuelDispensers);
        System.out.println(fuelStation);

    }
}
