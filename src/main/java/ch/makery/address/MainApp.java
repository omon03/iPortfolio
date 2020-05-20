package ch.makery.address;

import java.io.IOException;
import java.io.InputStream;

import ch.makery.address.model.Asset;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private ObservableList listAssets = FXCollections.observableArrayList();

    public MainApp() {
        listAssets.add(new Asset("USD", "$", 1f, 190f));
        listAssets.add(new Asset("BTC", "₿", 9506f, 0.073f));
        listAssets.add(new Asset("ETH", "Ξ", 209.1f, 1.45f));
        listAssets.add(new Asset("XMR", "", 64.49f, 3.47f));
        listAssets.add(new Asset("BNB", "", 16.79f, 0.85f));
        listAssets.add(new Asset("LTC", "Ł", 44.02f, 5.9f));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("iPortfolio application");

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void showBaseWindow() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("/maket/AssetsWindow.fxml"));
//            rootLayout = loader.load();
//            Scene scene = new Scene(rootLayout);
//            primaryStage.setScene(scene);
//            InputStream iconStream = getClass().getResourceAsStream("/images/icon.png");
//            Image image = new Image(iconStream);
//            primaryStage.getIcons().add(image);
//            BaseController controller = loader.getController();
//            controller.setMainApp(this);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void showCreateWindow(Dog dog) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("/maket/new.fxml"));
//            AnchorPane page = loader.load();
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Wow Wow Wow");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(primaryStage);
//            dialogStage.setScene(new Scene(page));
//            CreateController controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            controller.setDog(dog);
//            dialogStage.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//    @Override
//    public void start(Stage primaryStage) {
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("iPortfolio");
//        this.primaryStage.setWidth(600);
//        this.primaryStage.setHeight(400);
//        this.primaryStage.setMinWidth(600);
//        this.primaryStage.setMinHeight(400);
//
//        InputStream iconStream = getClass().getResourceAsStream("/images/icon.png");
//        Image image = new Image(iconStream);
//        primaryStage.getIcons().add(image);
//
//        initRootLayout();
////        showPortfolioOverview();
//    }
//
//    /**
//     * Initializes the root layout.
//     */
//    public void initRootLayout() {
//        MenuBar rootMenu = new MenuBar();
//        Menu menuFile = new Menu("File");
//        Menu menuEdit = new Menu("Edit");
//        Menu menuView = new Menu("View");
//        rootMenu.getMenus().addAll(menuFile, menuEdit, menuView);
//
//        AnchorPane rootLayout = new AnchorPane();
//        AnchorPane.setTopAnchor(rootMenu, 0.0);
//        AnchorPane.setLeftAnchor(rootMenu, 0.0);
//        AnchorPane.setRightAnchor(rootMenu, 0.0);
////        rootLayout.minHeight(400);
////        rootLayout.minWidth(600);
////        rootLayout.prefHeight(400);
////        rootLayout.prefWidth(600);
//        rootLayout.getChildren().add(rootMenu);
//
//        // Show the scene containing the root layout.
//        Scene scene = new Scene(rootLayout);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * Shows the person overview inside the root layout.
//     */
//    public void showPortfolioOverview() {
//        // Portfolio overview.
////            FXMLLoader loader = new FXMLLoader();
////            loader.setLocation(MainApp.class.getResource("view/PortfolioOverview.fxml"));
////            AnchorPane portfolioOverview = (AnchorPane) loader.load();
//        AnchorPane portfolioOverview = new AnchorPane();
//
//        SplitPane splitPane = new SplitPane();
//        AnchorPane.setTopAnchor(splitPane, 0.0);
//        AnchorPane.setLeftAnchor(splitPane, 0.0);
//        AnchorPane.setRightAnchor(splitPane, 0.0);
//        AnchorPane.setBottomAnchor(splitPane, 0.0);
//
//        AnchorPane anchorPaneLeft = new AnchorPane();
//        AnchorPane anchorPaneRight = new AnchorPane();
//        splitPane.getItems().addAll(anchorPaneLeft, anchorPaneRight);
//        portfolioOverview.getChildren().add(splitPane);
//
//        // Set Portfolio overview into the center of root layout.
//        rootLayout.getChildren().add(portfolioOverview);
//    }
//
//    /**
//     * Returns the main stage.
//     * @return: primaryStage
//     */
//    public Stage getPrimaryStage() {
//        return primaryStage;
//    }

    public static void main(String[] args) {
        launch(args);
    }

//    public ObservableList getListDog() {
//        return listDog;
//    }
}