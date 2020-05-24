package ch.makery.address.controller;

import ch.makery.address.MainApp;
import ch.makery.address.model.Portfolio;
import javafx.beans.binding.FloatBinding;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.lang.reflect.InvocationTargetException;

public class PortfolioOverview {

    @FXML
    private TableView<Portfolio> potrfolios;
    @FXML
    private TableColumn<Portfolio, String> nameListPortfolios;
//    @FXML
//    private GridPane portfolioTable;

    @FXML
    private TextField assetName1;
    @FXML
    private TextField assetName2;
    @FXML
    private TextField assetName3;
    @FXML
    private TextField assetName4;
    @FXML
    private TextField assetName5;
    @FXML
    private TextField assetName6;
    @FXML
    private TextField assetName7;

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
    private TextField price1;
    @FXML
    private TextField price2;
    @FXML
    private TextField price3;
    @FXML
    private TextField price4;
    @FXML
    private TextField price5;
    @FXML
    private TextField price6;
    @FXML
    private TextField price7;

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
    private Label balancing1;
    @FXML
    private Label balancing2;
    @FXML
    private Label balancing3;
    @FXML
    private Label balancing4;
    @FXML
    private Label balancing5;
    @FXML
    private Label balancing6;
    @FXML
    private Label balancing7;

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
        /*
        * Если нам понадобится использовать IntegerProperty или DoubleProperty, то
        * setCellValueFactory(...) должен иметь дополнительный метод asObject()
        */
        // myIntegerColumn.setCellValueFactory(cellData -> cellData.getValue().myIntegerProperty().asObject());

        // Очистка дополнительной информации об Portfolio.
        showPortfolioDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        potrfolios.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPortfolioDetails(newValue));
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param: mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Добавление в таблицу данных из наблюдаемого списка
        potrfolios.setItems(mainApp.getPortfoliosList());
    }

    /**
     * getAssetName
     * @param count - индекс актива в портфеле
     * @param portfolio - объект Portfolio
     * @return String name - имя актива в портфеле. Если указанный актив = null, то пустая строка.
     * */
    private String getAssetName(Portfolio portfolio, int count){
        return (portfolio.getAsset(count) != null)? portfolio.getAsset(count).getName() : "";
    }

    /**
     * getAssetValue
     * @param count - индекс актива в портфеле
     * @param portfolio - объект Portfolio
     * @return String value - Value актива в портфеле. Если указанный актив = null, то пустая строка.
     * */
    private String getAssetValue(Portfolio portfolio, int count){
        return (portfolio.getAsset(count) != null)? portfolio.getAsset(count).getValue() : "";
    }

    /**
     * getAssetPrice
     * @param count - индекс актива в портфеле
     * @param portfolio - объект Portfolio
     * @return String price - Price актива в портфеле. Если указанный актив = null, то пустая строка.
     * */
    private String getAssetPrice(Portfolio portfolio, int count){
        return (portfolio.getAsset(count) != null)? Float.toString(portfolio.getAsset(count).getPrice().getValue()) : "";
    }

    /**
     * getAssetProportion
     * @param count - индекс актива в портфеле
     * @param portfolio - объект Portfolio
     * @return String proportion - Proportion(%) актива в портфеле. Если указанный актив = null, то пустая строка.
     * */
    private String getAssetProportion(Portfolio portfolio, int count){
        try {
            portfolio.getAsset(count);
            return portfolio.getProportion(count).toString();
        }catch (Exception e){
            return "";
        }
    }

    /**
     * getAssetBalancing
     * @param countAsset - индекс актива в портфеле
     * @param portfolio - объект Portfolio
     * @return String balancing - Balancing(% ФАКТИЧЕСКИЙ) актива в портфеле. Если указанный актив = null, то пустая строка.
     * */
    private String getAssetBalancing(Portfolio portfolio, int countAsset){
        try {
            FloatProperty assetBalance = portfolio.getAsset(countAsset).getBalance();
            FloatProperty portfolioBalance = portfolio.getBalance();
            // цена одного процента портфеля
            float priceOnePercent = (portfolioBalance.divide(100)).floatValue();
            // процент актива в портфеле
            float percentAsset = assetBalance.floatValue() / priceOnePercent;
            return Float.toString(percentAsset);
        }catch (Exception e){
            return "";
        }
    }

    /**
     * getDeviationAsset
     * @param countAsset - индекс актива в портфеле
     * @param portfolio - объект Portfolio
     * @return String deviation - Deviation(%) - отклонение актива от пропорции. Если указанный актив = null, то пустая строка.
     * */
    private String getDeviationAsset(Portfolio portfolio, int countAsset){
        try {
            float assetProportion = portfolio.getProportion(countAsset);
            FloatProperty assetBalance = portfolio.getAsset(countAsset).getBalance();
            FloatProperty portfolioBalance = portfolio.getBalance();
            // цена одного процента портфеля
            float priceOnePercent = (portfolioBalance.divide(100)).floatValue();
            // процент актива в портфеле
            float percentAsset = assetBalance.floatValue() / priceOnePercent;
            // отклонение от заданной пропорции
            float deviationAsset = assetProportion - percentAsset;
            return Float.toString(deviationAsset * priceOnePercent);
        }catch (Exception e){
            return "";
        }
    }

    /**
     * Заполняет все текстовые поля, отображая подробности о портфеле.
     * Если указанный портфель = null, то все текстовые поля очищаются.
     *
     * @param portfolio — портфель типа Portfolio или null
     */
    private void showPortfolioDetails(Portfolio portfolio) {
        if (portfolio != null) {
            // Заполняем метки информацией из объекта Portfolio.
            assetName1.setText(getAssetName(portfolio, 0));
            assetName2.setText(getAssetName(portfolio, 1));
            assetName3.setText(getAssetName(portfolio, 2));
            assetName4.setText(getAssetName(portfolio, 3));
            assetName5.setText(getAssetName(portfolio, 4));
            assetName6.setText(getAssetName(portfolio, 5));
            assetName7.setText(getAssetName(portfolio, 6));

            assetVal1.setText(getAssetValue(portfolio,0));
            assetVal2.setText(getAssetValue(portfolio,1));
            assetVal3.setText(getAssetValue(portfolio,2));
            assetVal4.setText(getAssetValue(portfolio,3));
            assetVal5.setText(getAssetValue(portfolio,4));
            assetVal6.setText(getAssetValue(portfolio,5));
            assetVal7.setText(getAssetValue(portfolio,6));

            price1.setText(getAssetPrice(portfolio,0));
            price2.setText(getAssetPrice(portfolio,1));
            price3.setText(getAssetPrice(portfolio,2));
            price4.setText(getAssetPrice(portfolio,3));
            price5.setText(getAssetPrice(portfolio,4));
            price6.setText(getAssetPrice(portfolio,5));
            price7.setText(getAssetPrice(portfolio,6));

            assetBalance1.setText(getAssetProportion(portfolio,0));
            assetBalance2.setText(getAssetProportion(portfolio,1));
            assetBalance3.setText(getAssetProportion(portfolio,2));
            assetBalance4.setText(getAssetProportion(portfolio,3));
            assetBalance5.setText(getAssetProportion(portfolio,4));
            assetBalance6.setText(getAssetProportion(portfolio,5));
            assetBalance7.setText(getAssetProportion(portfolio,6));

            balancing1.setText(getAssetBalancing(portfolio,0));
            balancing2.setText(getAssetBalancing(portfolio,1));
            balancing3.setText(getAssetBalancing(portfolio,2));
            balancing4.setText(getAssetBalancing(portfolio,3));
            balancing5.setText(getAssetBalancing(portfolio,4));
            balancing6.setText(getAssetBalancing(portfolio,5));
            balancing7.setText(getAssetBalancing(portfolio,6));

            Buy1.setText(getDeviationAsset(portfolio,0));
            Buy2.setText(getDeviationAsset(portfolio,1));
            Buy3.setText(getDeviationAsset(portfolio,2));
            Buy4.setText(getDeviationAsset(portfolio,3));
            Buy5.setText(getDeviationAsset(portfolio,4));
            Buy6.setText(getDeviationAsset(portfolio,5));
            Buy7.setText(getDeviationAsset(portfolio,6));

//            lastNameLabel.setText(person.getLastName());
//            streetLabel.setText(person.getStreet());
//            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
//            cityLabel.setText(person.getCity());

            // TODO: Нам нужен способ для перевода дня рождения в тип String!
            // birthdayLabel.setText(...);
        } else {
            // Если Portfolio = null, то убираем весь текст.
            assetName1.setText("");
            assetName2.setText("");
            assetName3.setText("");
            assetName4.setText("");
            assetName5.setText("");
            assetName6.setText("");
            assetName7.setText("");

            assetVal1.setText("");
            assetVal2.setText("");
            assetVal3.setText("");
            assetVal4.setText("");
            assetVal5.setText("");
            assetVal6.setText("");
            assetVal7.setText("");

            price1.setText("");
            price2.setText("");
            price3.setText("");
            price4.setText("");
            price5.setText("");
            price6.setText("");
            price7.setText("");

            assetBalance1.setText("");
            assetBalance2.setText("");
            assetBalance3.setText("");
            assetBalance4.setText("");
            assetBalance5.setText("");
            assetBalance6.setText("");
            assetBalance7.setText("");

            balancing1.setText("");
            balancing2.setText("");
            balancing3.setText("");
            balancing4.setText("");
            balancing5.setText("");
            balancing6.setText("");
            balancing7.setText("");

            Buy1.setText("");
            Buy2.setText("");
            Buy3.setText("");
            Buy4.setText("");
            Buy5.setText("");
            Buy6.setText("");
            Buy7.setText("");
        }
    }

    /**
     * Обработчик кнопки "New Portfolio"
     */
    @FXML
    private void newPortfolio() {
        Portfolio portfolio = new Portfolio();
        mainApp.showCreateWindow(portfolio);
        if (portfolio.getName() != null && !portfolio.getName().getValue().isEmpty()) {
            mainApp.getPortfoliosList().add(portfolio);
        }
    }
    @FXML
    private void editPortfolio() {
        int selectedIndex = potrfolios.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Portfolio portfolio = mainApp.getPortfoliosList().get(selectedIndex);
            portfolio.setNameAsset();

//            potrfolios.getItems().set(selectedIndex,
//                                      new Portfolio(
//                                          name.getText(),
//                                          breed.getText(),
//                                          Integer.valueOf(age.getText()),
//                                          city.getText(),
//                                          Integer.valueOf(levelOfTraining.getText())
//                                          )
//                                      );
        }
        else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Portfolio Selected");
            alert.setContentText("Please select a portfolio in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Обработчик кнопки Delete
    */
    @FXML
    private void deletePortfolio() {
        int selectedIndex = potrfolios.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0)
            potrfolios.getItems().remove(selectedIndex);
        else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Portfolio Selected");
            alert.setContentText("Please select a portfolio in the table.");

            alert.showAndWait();
        }
    }
}
