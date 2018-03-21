package edu.bo.umss.programming.exercise1;

import java.util.List;

/**
 * @author ariel.alcocer
 */
public interface Operation {
    void insertAsset(Asset asset);
    void deleteAsset(String id);
    void showAssets();
    Asset getAssetById(String id);
    List<Weapon> getWeapons();
}