package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

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


    public void addBook() {
        if (toggleButtons.getSelectedToggle()!=null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }
}
