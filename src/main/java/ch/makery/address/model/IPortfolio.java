package ch.makery.address.model;

import java.util.ArrayList;

public interface IPortfolio {
    void addAsset(String name);
    void dellAsset(String name);
    void setName(String name);
    void setNameAsset(int countAsset, String newName);
    void setValueAsset(int countAsset, float value);
    void setPriceAsset(int countAsset, float price);
    Asset getAsset(int countAsset);
    Asset getAsset(String name);
    ArrayList<Asset> getAssets();
}
