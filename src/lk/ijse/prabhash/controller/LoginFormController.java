package lk.ijse.prabhash.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.prabhash.dto.UserDTO;
import lk.ijse.prabhash.services.ServiceFactory;
import lk.ijse.prabhash.services.ServiceType;
import lk.ijse.prabhash.services.custom.LogService;
import lk.ijse.prabhash.util.Navigation;
import lk.ijse.prabhash.util.Routes;


import java.io.IOException;
import java.net.URL;
import java.util.List;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public Label lblWrong;
    public AnchorPane loginFormContext;
    private final LogService logBO = (LogService) ServiceFactory.getInstance().getService(ServiceType.LOG);


    public void btnLoginOnAction(ActionEvent actionEvent) throws Exception {
      /*  if(txtUserName.getText().equals("pr") && txtPassword.getText().equals("11")){
            lblWrong.setText("Please enter your UserName and Password");
            System.out.println("eeeeee");

        }else if (txtUserName.getText()!=null&& txtPassword.getText()!=null){
            List<UserDTO> userDetails = logBO.getUserDetails(txtUserName.getText(), txtPassword.getText());
            UserDTO userDTO = new UserDTO();
            for (UserDTO u:userDetails
                 ) {
                userDTO.setUserName(u.getUserName());
                userDTO.setPassword(u.getPassword());
            }

            if (txtUserName.getText().equals(userDTO.getUserName()) &&  txtPassword.getText().equals(userDTO.getPassword())){


            }else {
                new Alert(Alert.AlertType.WARNING,"Wrong UserName OR Password, Try Again!").show();
            }

        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again !").show();
        }*/

        System.out.println(txtUserName.getText());
        String tempUsername = txtUserName.getText();
        String tempPassword = txtPassword.getText();
        System.out.println(txtPassword.getText());
        if (tempUsername.equals("prabhash") && tempPassword.equals("2001")) {
            Navigation.navigation(Routes.DASH,loginFormContext);
            System.out.println(txtUserName.getText());
        }else {
            new Alert(Alert.AlertType.WARNING,"nionononono");
        }
    }
}
