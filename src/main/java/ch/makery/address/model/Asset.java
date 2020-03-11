package ch.makery.address.model;

import java.util.ArrayList;

public class Asset implements IAsset {

    private String name;
    private String symbol;
    private float price;
    private float value;
    private ArrayList<Portfolio> portfolioOwnership;  // принадлежность портфелям

    //  TODO добавить срок действия актива
    public Asset(String name, String symbol, float price, float value) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.value = value;
    }
    public Asset(String name, float price, float value) {
        this.name = name;
        this.price = price;
        this.value = value;
    }
    public Asset(String name, float value) {
        this.name = name;
        this.value = value;
    }
    public Asset(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public float getValue() {
        return this.value;
    }

    public float getPrice() {
        return this.price;
    }

    public ArrayList<Portfolio> getPortfolio() {
        return this.portfolioOwnership;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void addPortfolioOwnership(Portfolio portfolio) {
        this.portfolioOwnership.add(portfolio);
    }
}
