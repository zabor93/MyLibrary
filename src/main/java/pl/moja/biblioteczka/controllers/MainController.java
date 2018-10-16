package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private TopMenuButtonsController topMenuButtonsController;
    @FXML
    private BorderPane borderPane;

    private void initialize() {
        topMenuButtonsController.setMainController(this);

    }


}
