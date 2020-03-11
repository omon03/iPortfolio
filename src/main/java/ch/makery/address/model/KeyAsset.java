package ch.makery.address.model;

/**
 * Singleton keyAsset
 * Опорный актив ($, рубль или пиастры)
 */
// TODO сделать хранение данных в базе
public class KeyAsset implements IKeyAsset {
    private static volatile KeyAsset instance;
    private volatile String name = "USD";
    private volatile String symbol = "$";

    private KeyAsset(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public static KeyAsset getInstance(String name, String shortName) {
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

    public void setKeyAsset(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
