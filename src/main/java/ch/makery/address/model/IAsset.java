package ch.makery.address.model;

import java.util.ArrayList;

public interface IAsset {
    String getName();
    String getSymbol();
    float getValue();
    float getPrice();
    ArrayList<Portfolio> getPortfolio();

    void setName(String name);
    void setSymbol(String symbol);
    void setValue(float value);
    void setPrice(float price);
    void addPortfolioOwnership(Portfolio portfolio);
}
