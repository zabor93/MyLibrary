package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openLibrary() {
        System.out.println("Open libraty");
    }
    @FXML
    public void openListBooks() {
        System.out.println("Open list books");
    }
    @FXML
    public void openStatistic() {
        System.out.println("Open statustsaic");
    }


}
