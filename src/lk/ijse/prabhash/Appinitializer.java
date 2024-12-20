package lk.ijse.prabhash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Appinitializer extends Application {
    public static void main(String[] args) {
     launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("/lk/ijse/prabhash/view/LoginForm.fxml");
        Parent load= FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
