package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Asset implements IAsset {

    private StringProperty name;
    private StringProperty symbol;
    private FloatProperty price;
    private FloatProperty value;
    private ArrayList<Portfolio> portfolioOwnership;  // принадлежность портфелям

    //  TODO добавить срок действия актива
    public Asset(StringProperty name, StringProperty symbol, FloatProperty price, FloatProperty value) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.value = value;
    }
    public Asset(StringProperty name, FloatProperty price, FloatProperty value) {
        this.name = name;
        this.price = price;
        this.value = value;
    }
    public Asset(StringProperty name, FloatProperty value) {
        this.name = name;
        this.value = value;
    }
    public Asset(StringProperty name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name.getValue();
    }
    @Override
    public String getSymbol() {
        return this.symbol.getValue();
    }
    @Override
    public String getValue() {
        return this.value.getValue().toString();
    }
    @Override
    public FloatProperty getBalance() {
        FloatProperty res = new SimpleFloatProperty(price.multiply(value).floatValue());
        return res;
    }
    @Override
    public FloatProperty getPrice() {
        return this.price;
    }
    @Override
    public ArrayList<Portfolio> getPortfolio() {
        return this.portfolioOwnership;
    }
    @Override
    public void setName(StringProperty name) {
        this.name = name;
    }
    @Override
    public void setSymbol(StringProperty symbol) {
        this.symbol = symbol;
    }
    @Override
    public void setValue(FloatProperty value) {
        this.value = value;
    }
    @Override
    public void setPrice(FloatProperty price) {
        this.price = price;
    }
    @Override
    public void addPortfolioOwnership(Portfolio portfolio) {
        this.portfolioOwnership.add(portfolio);
    }
}
