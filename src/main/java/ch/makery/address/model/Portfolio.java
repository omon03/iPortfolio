package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Portfolio implements IPortfolio {
    private ObservableList<Asset> assets = FXCollections.observableArrayList();
    private IKeyAsset keyAsset;
    private StringProperty name;
    private ObservableList<FloatProperty> proportions = FXCollections.observableArrayList();

    public Portfolio(StringProperty name, StringProperty nameKeyAsset, StringProperty shortNameKeyAsset){
        this.name = name;
        this.keyAsset = KeyAsset.getInstance(nameKeyAsset, shortNameKeyAsset);
    }
    public Portfolio(StringProperty name){
        this.name = name;
        this.keyAsset = KeyAsset.getInstance();
    }
    public Portfolio(){
        this.keyAsset = KeyAsset.getInstance();
    }

    @Override
    public void addAsset(StringProperty name) {
        this.assets.add(new Asset(name));
    }
    @Override
    public void addAsset(Asset asset) {
        this.assets.add(asset);
    }
    @Override
    public void addAssets(ObservableList<Asset> listAssets) {
        assets.addAll(listAssets);
    }
    @Override
    public void dellAsset(StringProperty name) {
        for (int i = 0; i < assets.size(); i++) {
            if (assets.get(i).getName().equals(name) ||
                    assets.get(i).getSymbol().equals(name)) {
                assets.remove(i);
                break;
            }
        }
    }

    @Override
    public void setName(StringProperty name) {
        this.name = name;
    }
    @Override
    public void setNameAsset(int countAsset, StringProperty newName) {
        try {
            this.assets.get(countAsset).setName(newName);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.assets.add(countAsset, new Asset(newName));
        }
    }
    @Override
    public void setValueAsset(int countAsset, FloatProperty value) {
        this.assets.get(countAsset).setValue(value);
    }
    @Override
    public void setPriceAsset(int countAsset, FloatProperty price) {
        this.assets.get(countAsset).setPrice(price);
    }
    @Override
    public void setProportion(int countAsset, FloatProperty proportion) {
        try {
            proportions.set(countAsset, proportion);
        } catch (IndexOutOfBoundsException e) {
            addProportion(countAsset, proportion);
        }
    }
    @Override
    public void addProportion(int countAsset, FloatProperty proportion) {
        proportions.add(countAsset, proportion);
    }

    @Override
    public Asset getAsset(int countAsset) {
        try {
            return this.assets.get(countAsset);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public Asset getAsset(StringProperty name) {
        for (Asset asset : assets) {
            if (asset.getName().equals(name) ||
                    asset.getSymbol().equals(name)) return asset;
        }
        return null;
    }
    @Override
    public ObservableList<Asset> getAssets() {
        return assets;
    }
    @Override
    public StringProperty getName() {
        return name;
    }
    @Override
    public Float getProportion(int countAsset) {
        try {
            return proportions.get(countAsset).getValue();
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public ObservableList<FloatProperty> getProportions() {
        return proportions;
    }
    @Override
    public FloatProperty getBalance() {
        FloatProperty balance = new SimpleFloatProperty(0f);
        for (Asset asset : assets) {
            if (asset != null)
                balance = new SimpleFloatProperty(asset.getBalance().getValue() + balance.getValue());
        }
        return balance;
    }
    @Override
    public Float getProportionSum(){
        float proportionSum = 0f;
        for (FloatProperty prop :
                this.proportions) {
            proportionSum += prop.floatValue();
        }
        return proportionSum;
    }
    @Override
    public boolean is100percent(){
        return getProportionSum().equals(100f);
    }
}
