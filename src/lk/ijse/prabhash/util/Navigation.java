package lk.ijse.prabhash.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigation(Routes routes,AnchorPane pane) throws IOException {
        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window=(Stage) Navigation.pane.getScene().getWindow();

        switch (routes){
            case DASH:
                window.setTitle("DashBoard");
                initUI("DashBoardForm.fxml");
                break;

            case STUDNT:
                window.setTitle("StudentForm");
                initUI("StudentManagementForm.fxml");
                break;

            case LOGIN:
                window.setTitle("Login");
                initUI("LoginForm.fxml");
                break;

            case RM:
                window.setTitle("Room");
                initUI("RoomManagementForm.fxml");
                break;

            case KEY:
                window.setTitle("keypayide");
                initUI("PendingKeyMoneyForm.fxml");
                break;

            case REGISTER:
                window.setTitle("register");
                initUI("RegistrationForm.fxml");
                break;

            case USER:
                window.setTitle("userpage");
                initUI("UserForm.fxml");
                break;


            default:
                new Alert(Alert.AlertType.ERROR,"ui not found!!!").show();

        }

    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/prabhash/view/"+location)));
    }
}
