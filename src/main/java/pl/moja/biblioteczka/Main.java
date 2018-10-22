package pl.moja.biblioteczka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.moja.biblioteczka.database.dbUtils.HibernateUtil;
import pl.moja.biblioteczka.utils.FxmlUtils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) throws Exception {
//        Locale.setDefault(new Locale("en"));
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primarystage.setScene(scene);
        primarystage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primarystage.show();
        HibernateUtil.initDatabase();


    }
}
