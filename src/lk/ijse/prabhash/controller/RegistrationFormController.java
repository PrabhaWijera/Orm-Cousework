package lk.ijse.prabhash.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import lk.ijse.prabhash.dto.Room;
import lk.ijse.prabhash.dto.Student;
import lk.ijse.prabhash.services.ServiceFactory;
import lk.ijse.prabhash.services.ServiceType;
import lk.ijse.prabhash.services.custom.Registation_Service;
import lk.ijse.prabhash.view.tm.CartTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RegistrationFormController {
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colPaymentStatus;
    public TableColumn colDelete;
    public JFXButton btnAddToCart;
    public JFXComboBox<String> cmbStudentId;
    public JFXComboBox<String> cmbRoomTypeId;
    public JFXButton btnRegister;
    public Label lblReservation;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtName;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public JFXComboBox<String> cmbPaymentStatus;
    private final Registation_Service registrationservice = (Registation_Service) ServiceFactory.getInstance().getService( ServiceType.REGISTRATION);
    public TableView<CartTM> tblCart;
/*
    public void initialize(){
        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPaymentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        TableColumn<CartTM, Button> lastCol = (TableColumn<CartTM, Button>) tblCart.getColumns().get(4);
        lastCol.setCellValueFactory(param -> {
            Button btnDelete = new Button("Delete");

            btnDelete.setOnAction(event -> {
                tblCart.getItems().remove(param.getValue());
                tblCart.getSelectionModel().clearSelection();
                enableOrDisableRegisterButton();
            });

            return new ReadOnlyObjectWrapper<>(btnDelete);
        });

        setStudentId();
        setRoomId();
        generateNewId();
        
        txtName.setEditable(false);
        txtAddress.setEditable(false);
        txtContactNo.setEditable(false);
        txtType.setEditable(false);
        txtKeyMoney.setEditable(false);
        txtQty.setEditable(false);
        btnAddToCart.setDisable(true);
        btnRegister.setDisable(true);

        btnAddToCart.setDisable(true);


        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            enableOrDisableRegisterButton();
            if (newValue != null) {
                try {
                    List<Student> list = registrationservice.getStudentDetailUsingId(newValue);
                    for (Student dto : list
                    ) {
                        txtName.setText(dto.getName());
                        txtAddress.setText(dto.getAddress());
                        txtContactNo.setText(dto.getContact_no());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                txtName.clear();
                txtAddress.clear();
                txtContactNo.clear();
            }
        });

        cmbRoomTypeId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnAddToCart.setDisable(newValue==null);
           if (newValue != null){
               try {
                   List<Room> list = registrationservice.getRoomDetailUsingId(newValue);
                   for (Room dto:list
                   ) {
                       txtType.setText(dto.getType());
                       Optional<CartTM> tm = tblCart.getItems().stream().filter(detail -> detail.getRoom_type_id().equals(newValue)).findFirst();

                       txtQty.setText(String.valueOf(tm.isPresent() ? dto.getQty()- 1 : dto.getQty()));
                       txtKeyMoney.setText(String.valueOf(dto.getKey_money()));
                   }

               } catch (Exception e) {
                   e.printStackTrace();
               }
           }else {
               txtType.clear();
               txtKeyMoney.clear();
               txtQty.clear();

           }

        });

        cmbPaymentStatus.getItems().addAll("Paid","Paid Later");

    }*/

    private void setRoomId() {
        try {
            List<Room> allRooms = registrationservice.getAllRooms();
            for (Room dto:allRooms
                 ) {
             cmbRoomTypeId.getItems().add(dto.getRoom_type_id());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setStudentId() {
        try {
            List<Student> allStudents =registrationservice.getAllStudents();
            for (Student dto:allStudents
                 ) {
                cmbStudentId.getItems().add(dto.getStudent_id());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
       String roomTypeId = cmbRoomTypeId.getValue();
       String type = txtType.getText();
       Double keyMoney = Double.valueOf(txtKeyMoney.getText());
       String status = cmbPaymentStatus.getValue();

       if(btnAddToCart.getText().equals("Save")){

       }else {
           tblCart.getItems().add(new CartTM(roomTypeId,type,keyMoney,status));
       }
        cmbPaymentStatus.getSelectionModel().clearSelection();
        cmbRoomTypeId.getSelectionModel().clearSelection();
        btnRegister.requestFocus();
        enableOrDisableRegisterButton();


    }
    private void enableOrDisableRegisterButton() {
        btnRegister.setDisable(!(cmbStudentId.getSelectionModel().getSelectedItem() != null && !tblCart.getItems().isEmpty()));
    }
    public void btnRegisterOnAction(ActionEvent actionEvent) {
        try {
            registrationservice.Register(tblCart.getItems(),cmbStudentId.getValue(),lblReservation.getText());
            new Alert(Alert.AlertType.CONFIRMATION,"Register Complete").show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        generateNewId();
        cmbStudentId.getSelectionModel().clearSelection();
        cmbRoomTypeId.getSelectionModel().clearSelection();
        cmbPaymentStatus.getSelectionModel().clearSelection();
        tblCart.getItems().clear();
    }

    private void generateNewId() {
        try {
            String lastRegistrationId = registrationservice.generateRegistrationId();
            System.out.println(lastRegistrationId);
            int newId = Integer.parseInt(lastRegistrationId.substring(2, 5))+1;
            System.out.println(newId);
            if (newId < 10) {
                lblReservation.setText("RS00"+newId);
            }else if (newId < 100) {
                lblReservation.setText("RS0"+newId);
            }else {
                lblReservation.setText("RS"+newId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
