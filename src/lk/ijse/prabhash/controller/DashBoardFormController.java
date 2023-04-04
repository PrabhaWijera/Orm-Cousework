package lk.ijse.prabhash.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.prabhash.util.Navigation;
import lk.ijse.prabhash.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashBoardFormController {
    public AnchorPane loadContext;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane mainpane;



/*    private void loadDateAndTime() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }*/



    public void btnUserManagementOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigation(Routes.USER,loadContext);
    }

    public void btnRoomManagementOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigation(Routes.RM,loadContext);
    }

    public void btnStudentManagement(ActionEvent actionEvent) throws IOException {

        Navigation.navigation(Routes.STUDNT,loadContext);
    }


    public void btnRegistration(ActionEvent actionEvent) throws IOException {

        Navigation.navigation(Routes.REGISTER,loadContext);
    }

    public void btnKeyMoneyOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigation(Routes.KEY,loadContext);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN,mainpane);
    }
}
