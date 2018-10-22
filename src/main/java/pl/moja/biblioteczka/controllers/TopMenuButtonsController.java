package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {


    public static final String LIBRARY_FXML="/fxml/Library.fxml";
    public static final String LISTBOOKS_FXML="/fxml/ListBooks.fxml";
    public static final String STATISTICS_FXML="/fxml/Statistics.fxml";
    public static final String ADDBOOK_FXML="/fxml/AddBook.fxml";
    public static final String ADDCATEGORY_FXML="/fxml/AddCategory.fxml";


    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openLibrary() {
       mainController.setCenter(LIBRARY_FXML);
    }

    @FXML
    public void openListBooks() {
        mainController.setCenter(LISTBOOKS_FXML);
    }

    @FXML
    public void openStatistic() {
        mainController.setCenter(STATISTICS_FXML);
    }

    @FXML
    public void addBook() {
        resetToggleButtons();
        mainController.setCenter(ADDBOOK_FXML);
    }

    private void resetToggleButtons() {
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }

    public void addCategory(ActionEvent event) {
        resetToggleButtons();
        mainController.setCenter(ADDCATEGORY_FXML);
    }
}
