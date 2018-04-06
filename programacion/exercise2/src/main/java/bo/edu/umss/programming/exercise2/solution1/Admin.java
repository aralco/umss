package bo.edu.umss.programming.exercise2.solution1;


import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static void main(String args[])  {
        SiteAsset armory = new RefactoredArmory();
        armory.setLocation("North");
        List<Asset> arms = new ArrayList<>();
        Asset arm1 = new Arm();
        arms.add(arm1);
        armory.setAssets(arms);
        System.out.println(armory);

        SiteAsset fuelStation = new RefactoredFuelStation();
        fuelStation.setLocation("South");
        List<Asset> fuelDispensers = new ArrayList<>();
        Asset fuelDispenser1 = new FuelDispenser();
        fuelDispensers.add(fuelDispenser1);
        fuelStation.setAssets(fuelDispensers);
        System.out.println(fuelStation);

    }
}
