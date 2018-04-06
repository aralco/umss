package bo.edu.umss.programming.exercise2.solution11;


import bo.edu.umss.programming.exercise2.solution11.domain.RefactoredArmory;
import bo.edu.umss.programming.exercise2.solution11.domain.RefactoredFuelStation;
import bo.edu.umss.programming.exercise2.solution11.domain.SiteAsset;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public static void main(String args[])  {
        SiteAsset armory = new RefactoredArmory();
        armory.setLocation("North");
        List<Object> arms = new ArrayList<>();
        SiteAsset arm1 = new RefactoredArmory();
        SiteAsset arm2 = new RefactoredArmory();
        arms.add(arm1);
        arms.add(arm2);
        armory.setAssets(arms);
        System.out.println(armory);

        SiteAsset fuelStation = new RefactoredFuelStation();
        fuelStation.setLocation("South");
        List<Object> fuelDispensers = new ArrayList<>();
        SiteAsset fuelDispenser1 = new RefactoredFuelStation();
        fuelDispensers.add(fuelDispenser1);
        fuelStation.setAssets(fuelDispensers);
        System.out.println(fuelStation);

    }
}
