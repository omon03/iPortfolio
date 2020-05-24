package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Singleton keyAsset
 * Опорный актив ($, рубль или пиастры)
 */
public class KeyAsset implements IKeyAsset {
    private static volatile KeyAsset instance;
    private volatile StringProperty name;
    private volatile StringProperty symbol;

    private KeyAsset(StringProperty name, StringProperty symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    private KeyAsset(){}

    public static KeyAsset getInstance(StringProperty name, StringProperty shortName) {
        KeyAsset localInstance = instance;
        if (localInstance == null) {
            synchronized (KeyAsset.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new KeyAsset(name, shortName);
                }
            }
        }
        return localInstance;
    }
    public static KeyAsset getInstance() {
        KeyAsset localInstance = instance;
        if (localInstance == null) {
            synchronized (KeyAsset.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new KeyAsset();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void setKeyAsset(StringProperty name, StringProperty symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = new SimpleStringProperty(symbol);
    }

    @Override
    public StringProperty getName() {
        return this.name;
    }
    @Override
    public StringProperty getSymbol() {
        return this.symbol;
    }
}
