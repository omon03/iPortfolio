package ch.makery.address.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public interface IAsset {
    StringProperty getName();
    StringProperty getSymbol();
    FloatProperty getValue();
    FloatProperty getPrice();
    ArrayList<Portfolio> getPortfolio();

    void setName(StringProperty name);
    void setSymbol(StringProperty symbol);
    void setValue(FloatProperty value);
    void setPrice(FloatProperty price);
    void addPortfolioOwnership(Portfolio portfolio);
}
