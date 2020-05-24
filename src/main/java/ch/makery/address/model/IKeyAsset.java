package ch.makery.address.model;

import javafx.beans.property.StringProperty;

public interface IKeyAsset {
    void setKeyAsset(StringProperty name, StringProperty symbol);
    void setName(String name);
    void setSymbol(String symbol);
    StringProperty getName();
    StringProperty getSymbol();
}
