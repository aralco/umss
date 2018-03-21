package edu.bo.umss.programming.exercise1.domain;

import java.util.List;

public interface Operation {
    void insertAsset(Asset asset);
    void deleteAsset(String id);
    void showAssets();
    Asset getAssetById(String id);
    List<Weapon> getWeapons();
}