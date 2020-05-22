package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Portfolio implements IPortfolio {
    private ObservableList<Asset> assets = FXCollections.observableArrayList();
    private KeyAsset keyAsset;
    private StringProperty name;

    public Portfolio(StringProperty name, StringProperty nameKeyAsset, StringProperty shortNameKeyAsset){
        this.name = name;
        this.keyAsset = KeyAsset.getInstance(nameKeyAsset, shortNameKeyAsset);
    }

    public void addAsset(StringProperty name) {
        this.assets.add(new Asset(name));
    }

    public void addAsset(Asset asset) {
        this.assets.add(asset);
    }

    public void addAssets(ObservableList<Asset> listAssets) {
        assets.addAll(listAssets);
    }

    public void dellAsset(StringProperty name) {
        for (int i = 0; i < assets.size(); i++) {
            if (assets.get(i).getName().equals(name) ||
                    assets.get(i).getSymbol().equals(name)) {
                assets.remove(i);
                break;
            }
        }
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public void setNameAsset(int countAsset, StringProperty newName) {
        this.assets.get(countAsset).setName(newName);
    }

    public void setValueAsset(int countAsset, FloatProperty value) {
        this.assets.get(countAsset).setValue(value);
    }

    public void setPriceAsset(int countAsset, FloatProperty price) {
        this.assets.get(countAsset).setPrice(price);
    }

    public Asset getAsset(int countAsset) {
        return this.assets.get(countAsset);
    }

    public Asset getAsset(StringProperty name) {
        for (Asset asset : assets) {
            if (asset.getName().equals(name) ||
                    asset.getSymbol().equals(name)) return asset;
        }
        return null;
    }

    public ObservableList<Asset> getAssets() {
        return assets;
    }

    public StringProperty getName() {
        return name;
    }
}
