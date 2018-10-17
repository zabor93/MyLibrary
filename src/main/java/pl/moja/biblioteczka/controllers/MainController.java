package pl.moja.biblioteczka.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.moja.biblioteczka.utils.DialogUtils;
import pl.moja.biblioteczka.utils.FxmlUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);

    }

    public void setCenter(String fxmlPath) {
        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }


    public void closeApplication() {
       Optional<ButtonType> result= DialogUtils.dialogConfirmationExit();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void setCaspian(ActionEvent actionEvent) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);

    }

    public void setModena(ActionEvent actionEvent) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(true);

    }

    public void about(ActionEvent actionEvent) {
        DialogUtils.dialogAboutApplication();
    }
}
