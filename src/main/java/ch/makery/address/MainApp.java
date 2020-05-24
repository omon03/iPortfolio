package ch.makery.address;

import ch.makery.address.controller.NewPortfolio;
import ch.makery.address.controller.PortfolioOverview;
import ch.makery.address.model.Asset;
import ch.makery.address.model.Portfolio;
import javafx.application.Application;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private ObservableList<Asset> listAssets = FXCollections.observableArrayList();
    private ObservableList<Portfolio> listPortfolios = FXCollections.observableArrayList();

    public MainApp() {
        // В качестве образца добавляем некоторые данные
        listAssets.add(new Asset(new SimpleStringProperty("USD"),
                new SimpleStringProperty("$"),
                new SimpleFloatProperty(1f),
                new SimpleFloatProperty(190f)));
        listAssets.add(new Asset(new SimpleStringProperty("BTC"),
                new SimpleStringProperty("₿"),
                new SimpleFloatProperty(9506f),
                new SimpleFloatProperty(0.073f)));
        listAssets.add(new Asset(new SimpleStringProperty("ETH"),
                new SimpleStringProperty("Ξ"),
                new SimpleFloatProperty(209.1f),
                new SimpleFloatProperty(1.45f)));
        listAssets.add(new Asset(new SimpleStringProperty("XMR"),
                new SimpleStringProperty(""),
                new SimpleFloatProperty(64.49f),
                new SimpleFloatProperty(3.47f)));
        listAssets.add(new Asset(new SimpleStringProperty("BNB"),
                new SimpleStringProperty(""),
                new SimpleFloatProperty(16.79f),
                new SimpleFloatProperty(0.85f)));
        listAssets.add(new Asset(new SimpleStringProperty("LTC"),
                new SimpleStringProperty("Ł"),
                new SimpleFloatProperty(44.02f),
                new SimpleFloatProperty(5.9f)));
        listPortfolios.add(new Portfolio(new SimpleStringProperty("crypto"),
                new SimpleStringProperty("USD"),
                new SimpleStringProperty("$")));
        listPortfolios.get(0).addAssets(listAssets);
        listPortfolios.get(0).addProportion(0, new SimpleFloatProperty(10f));
        listPortfolios.get(0).addProportion(1, new SimpleFloatProperty(50f));
        listPortfolios.get(0).addProportion(2, new SimpleFloatProperty(30f));
        listPortfolios.get(0).addProportion(3, new SimpleFloatProperty(2.5f));
        listPortfolios.get(0).addProportion(4, new SimpleFloatProperty(5f));
        listPortfolios.get(0).addProportion(5, new SimpleFloatProperty(2.5f));
    }

    /**
     * Возвращает данные в виде наблюдаемого списка портфелей.
     * @return: listPortfolios
     */
    public ObservableList<Portfolio> getPortfoliosList() {
        return listPortfolios;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("iPortfolio application");
        this.primaryStage.setMinHeight(340);
        this.primaryStage.setMinWidth(616);
        this.primaryStage.setMaxHeight(340);
        this.primaryStage.setMaxWidth(616);

        InputStream iconStream = getClass().getResourceAsStream("/images/icon.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

        initRootLayout();
        showPortfolioOverview();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/maket/RootLayout.fxml"));
            rootLayout = loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведения о портфелях.
     */
    public void showPortfolioOverview() {
        try {
            // Загружаем сведения о портфелях.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/maket/PortfolioOverview.fxml"));
            AnchorPane personOverview = loader.load();

            // Помещаем сведения о портфелях в центр корневого макета.
            rootLayout.getChildren().add(personOverview);
            rootLayout.setCenterShape(true);

            // Даём контроллеру доступ к главному приложению.
            PortfolioOverview controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateWindow(Portfolio portfolio) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/maket/newName.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New portfolio");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setScene(new Scene(page));
            NewPortfolio controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPortfolio(portfolio);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает главную сцену.
     * @return: primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
