package ch.makery.address;

import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("iPortfolio");
        this.primaryStage.setWidth(600);
        this.primaryStage.setHeight(400);
        this.primaryStage.setMinWidth(600);
        this.primaryStage.setMinHeight(400);
        InputStream iconStream =
                getClass().getResourceAsStream("/images/icon.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

        initRootLayout();
//        showPortfolioOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        MenuBar rootMenu = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        rootMenu.getMenus().addAll(menuFile, menuEdit, menuView);

        AnchorPane rootLayout = new AnchorPane();
        AnchorPane.setTopAnchor(rootMenu, 0.0);
        AnchorPane.setLeftAnchor(rootMenu, 0.0);
        AnchorPane.setRightAnchor(rootMenu, 0.0);
//        rootLayout.minHeight(400);
//        rootLayout.minWidth(600);
//        rootLayout.prefHeight(400);
//        rootLayout.prefWidth(600);
        rootLayout.getChildren().add(rootMenu);

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPortfolioOverview() {
        // Portfolio overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("view/PortfolioOverview.fxml"));
//            AnchorPane portfolioOverview = (AnchorPane) loader.load();
        AnchorPane portfolioOverview = new AnchorPane();

        SplitPane splitPane = new SplitPane();
        AnchorPane.setTopAnchor(splitPane, 0.0);
        AnchorPane.setLeftAnchor(splitPane, 0.0);
        AnchorPane.setRightAnchor(splitPane, 0.0);
        AnchorPane.setBottomAnchor(splitPane, 0.0);

        AnchorPane anchorPaneLeft = new AnchorPane();
        AnchorPane anchorPaneRight = new AnchorPane();
        splitPane.getItems().addAll(anchorPaneLeft, anchorPaneRight);
        portfolioOverview.getChildren().add(splitPane);

        // Set Portfolio overview into the center of root layout.
        rootLayout.setCenter(portfolioOverview);
    }

    /**
     * Returns the main stage.
     * @return: primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}