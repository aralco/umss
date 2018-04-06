package bo.edu.umss.programming.exercise2.solution2;


import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static void main(String args[]) throws IllegalAccessException, InstantiationException {
        Site armory = SiteFactory.getSite(PartialArmory.class);
        armory.setLocation("North");
        List<Asset> arms = new ArrayList<>();
        Asset arm = new Arm();
        arms.add(arm);
        armory.setAssets(arms);
        System.out.println(armory);

        Site fuelStation = SiteFactory.getSite(PartialFuelStation.class);
        fuelStation.setLocation("South");
        List<Asset> fuelDispensers = new ArrayList<>();
        Asset fuelDispenser = new FuelDispenser();
        fuelDispensers.add(fuelDispenser);
        fuelStation.setAssets(fuelDispensers);
        System.out.println(fuelStation);

    }
}
