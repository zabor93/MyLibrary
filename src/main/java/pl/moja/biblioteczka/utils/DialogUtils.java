package pl.moja.biblioteczka.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogUtils {

    static ResourceBundle bundle = FxmlUtils.getResourceBundle();

    public static void dialogAboutApplication(){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("about.title"));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> dialogConfirmationExit(){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(bundle.getString("exit.title"));
        confirmationAlert.setHeaderText(bundle.getString("exit.header"));
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }

    public static void errorDialog(String error) {
        Alert alerterror = new Alert(Alert.AlertType.ERROR);
        alerterror.setTitle(bundle.getString("error.title"));
        alerterror.setHeaderText(bundle.getString("error.header"));

        TextArea textArea = new TextArea(error);
        alerterror.getDialogPane().setContent(textArea);
        alerterror.showAndWait();
    }
}
