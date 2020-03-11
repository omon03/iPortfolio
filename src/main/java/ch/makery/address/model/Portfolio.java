package ch.makery.address.model;

import java.util.ArrayList;

public class Portfolio implements IPortfolio {
    private ArrayList<Asset> assets;
    private KeyAsset keyAsset;
    private String name;

    public Portfolio(String name, String nameKeyAsset, String shortNameKeyAsset){
        this.name = name;
        this.keyAsset = KeyAsset.getInstance(nameKeyAsset, shortNameKeyAsset);
    }

    public void addAsset(String name) {
        this.assets.add(new Asset(name));
    }

    public void dellAsset(String name) {
        for (int i = 0; i < assets.size(); i++) {
            if (assets.get(i).getName().equals(name) ||
                    assets.get(i).getSymbol().equals(name)) {
                assets.remove(i);
                break;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameAsset(int countAsset, String newName) {
        this.assets.get(countAsset).setName(newName);
    }

    public void setValueAsset(int countAsset, float value) {
        this.assets.get(countAsset).setValue(value);
    }

    public void setPriceAsset(int countAsset, float price) {
        this.assets.get(countAsset).setPrice(price);
    }

    public Asset getAsset(int countAsset) {
        return this.assets.get(countAsset);
    }

    public Asset getAsset(String name) {
        for (Asset asset : assets) {
            if (asset.getName().equals(name) ||
                    asset.getSymbol().equals(name)) return asset;
        }
        return null;
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }
}
