package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Singleton keyAsset
 * Опорный актив ($, рубль или пиастры)
 */
// TODO сделать хранение данных в базе
public class KeyAsset implements IKeyAsset {
    private static volatile KeyAsset instance;
    private volatile StringProperty name;
    private volatile StringProperty symbol;

    private KeyAsset(StringProperty name, StringProperty symbol) {
        this.name = name;
        this.symbol = symbol;
    }

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

    public void setKeyAsset(StringProperty name, StringProperty symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public StringProperty getName() {
        return this.name;
    }

    public StringProperty getSymbol() {
        return this.symbol;
    }
}
