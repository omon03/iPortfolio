package ch.makery.address.controller;

import ch.makery.address.MainApp;
import ch.makery.address.model.Portfolio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PortfolioOverview {

    @FXML
    private TableView<Portfolio> potrfolios;
    @FXML
    private TableColumn<Portfolio, String> nameListPortfolios;

    @FXML
    private Label assetName1;
    @FXML
    private Label assetName2;
    @FXML
    private Label assetName3;
    @FXML
    private Label assetName4;
    @FXML
    private Label assetName5;
    @FXML
    private Label assetName6;
    @FXML
    private Label assetName7;

    @FXML
    private TextField assetVal1;
    @FXML
    private TextField assetVal2;
    @FXML
    private TextField assetVal3;
    @FXML
    private TextField assetVal4;
    @FXML
    private TextField assetVal5;
    @FXML
    private TextField assetVal6;
    @FXML
    private TextField assetVal7;

    @FXML
    private TextField assetBalance1;
    @FXML
    private TextField assetBalance2;
    @FXML
    private TextField assetBalance3;
    @FXML
    private TextField assetBalance4;
    @FXML
    private TextField assetBalance5;
    @FXML
    private TextField assetBalance6;
    @FXML
    private TextField assetBalance7;

    @FXML
    private Label Buy1;
    @FXML
    private Label Buy2;
    @FXML
    private Label Buy3;
    @FXML
    private Label Buy4;
    @FXML
    private Label Buy5;
    @FXML
    private Label Buy6;
    @FXML
    private Label Buy7;

    @FXML
    private Label Sell1;
    @FXML
    private Label Sell2;
    @FXML
    private Label Sell3;
    @FXML
    private Label Sell4;
    @FXML
    private Label Sell5;
    @FXML
    private Label Sell6;
    @FXML
    private Label Sell7;

    // Ссылка на главное приложение.
    private MainApp mainApp;

    /**
     * Конструктор вызывается раньше метода initialize().
     */
    public PortfolioOverview() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        // первый столбец
        nameListPortfolios.setCellValueFactory(cellData -> cellData.getValue().getName());
        // второй столбец
        // lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param: mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        potrfolios.setItems(mainApp);
    }

    public void newPortfolio(ActionEvent actionEvent) {

    }

    public void editPortfolio(ActionEvent actionEvent) {

    }

    public void deletePortfolio(ActionEvent actionEvent) {

    }
}
