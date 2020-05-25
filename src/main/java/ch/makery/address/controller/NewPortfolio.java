package ch.makery.address.controller;

import ch.makery.address.model.Portfolio;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPortfolio {

    private Stage dialogStage;
    private Portfolio portfolio;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    @FXML
    private TextField newName;

    @FXML
    private void ok() {
        if (newName != null && !newName.getText().isEmpty()) {
            portfolio.setName(new SimpleStringProperty(newName.getText()));
            dialogStage.close();
        }
    }

    @FXML
    private void canсel() {
        dialogStage.close();
    }
}
