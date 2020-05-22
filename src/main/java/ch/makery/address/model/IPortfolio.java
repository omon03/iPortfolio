package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public interface IPortfolio {
    void addAsset(StringProperty name);
    void addAsset(Asset asset);
    void addAssets(ObservableList<Asset> listAssets);
    void dellAsset(StringProperty name);
    void setName(StringProperty name);
    void setNameAsset(int countAsset, StringProperty newName);
    void setValueAsset(int countAsset, FloatProperty value);
    void setPriceAsset(int countAsset, FloatProperty price);
    Asset getAsset(int countAsset);
    Asset getAsset(StringProperty name);
    ObservableList<Asset> getAssets();
    StringProperty getName();
}
