package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
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

    public StringProperty getName() {
        return this.name;
    }

    public StringProperty getSymbol() {
        return this.symbol;
    }

    public FloatProperty getValue() {
        return this.value;
    }

    public FloatProperty getPrice() {
        return this.price;
    }

    public ArrayList<Portfolio> getPortfolio() {
        return this.portfolioOwnership;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public void setSymbol(StringProperty symbol) {
        this.symbol = symbol;
    }

    public void setValue(FloatProperty value) {
        this.value = value;
    }

    public void setPrice(FloatProperty price) {
        this.price = price;
    }

    public void addPortfolioOwnership(Portfolio portfolio) {
        this.portfolioOwnership.add(portfolio);
    }
}
