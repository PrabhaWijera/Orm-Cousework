package lk.ijse.prabhash.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.prabhash.dto.Room;
import lk.ijse.prabhash.services.ServiceFactory;
import lk.ijse.prabhash.services.ServiceType;
import lk.ijse.prabhash.services.custom.Room_Service;
import lk.ijse.prabhash.util.ValidationUtil;
import lk.ijse.prabhash.view.tm.RoomTM;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class RoomManagementFormController {
    public TableView <RoomTM>tblRoom;
    public JFXTextField txtQty;
    public JFXComboBox<String> cmbType;
    public JFXButton btnDelete;
    public JFXButton btnNew;
    public TableColumn colRoomId;
    public TableColumn colType;
    public TableColumn colQty;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtKeyMoney;
    public TableColumn colKeyMoney;
    public JFXButton btnSave;
    private final Room_Service roomBO = (Room_Service) ServiceFactory.getInstance().getService(ServiceType.ROOM);
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

 /*   public void initialize(){

        textClearAndBtnDisable();
        cmbType.getItems().addAll("Non-AC","Non-AC / Food","AC","AC / Food");
        loadAllRooms();

        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtRoomTypeId.setText(newValue.getRoom_type_id());
                cmbType.setValue(newValue.getType());
                txtKeyMoney.setText(String.valueOf(newValue.getKey_money()));
                txtQty.setText(String.valueOf(newValue.getQty()));

                txtRoomTypeId.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtQty.setDisable(false);
                cmbType.setDisable(false);

            }
        });
        Pattern idPattern = Pattern.compile("^RM-[0-9]{4}$");
        Pattern keyMoneyPattern = Pattern.compile("^[1-9][0-9]*(.[0-9]{1,2})?$");
        Pattern qtyPattern = Pattern.compile("^[1-9][0-9]*$");

        map.put(txtRoomTypeId,idPattern);
        map.put(txtKeyMoney,keyMoneyPattern);
        map.put(txtQty,qtyPattern);

    }*/

    private void loadAllRooms() {
        List<Room> allRooms = roomBO.getAllRooms();
        for (Room roomDTO:allRooms) {
            tblRoom.getItems().add(
                   new RoomTM(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(),roomDTO.getQty())
            );
        }
    }

    private void textClearAndBtnDisable() {
        txtRoomTypeId.clear();
        txtKeyMoney.clear();
        txtQty.clear();
        cmbType.getSelectionModel().clearSelection();

        txtRoomTypeId.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtQty.setDisable(true);
        cmbType.setDisable(true);

        btnSave.setDisable(true);
        btnDelete.setDisable(true);

    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        txtRoomTypeId.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtQty.setDisable(false);
        cmbType.setDisable(false);

        txtRoomTypeId.clear();
        txtKeyMoney.clear();
        txtQty.clear();
        cmbType.getSelectionModel().clearSelection();

        txtRoomTypeId.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblRoom.getSelectionModel().clearSelection();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you Want Delete", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType =alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            try {
                String roomId = tblRoom.getSelectionModel().getSelectedItem().getRoom_type_id();
                boolean b = roomBO.deleteRoom(roomId);
                if (b){
                    new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                }
                tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
                tblRoom.getSelectionModel().clearSelection();
                textClearAndBtnDisable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {


        String roomID = txtRoomTypeId.getText();
        String type = cmbType.getValue();
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());
        int qty = Integer.parseInt(txtQty.getText());


        try {
            if (btnSave.getText().equalsIgnoreCase("save")) {
                boolean save= roomBO.saveRoom(new Room(roomID,type,keyMoney,qty));

                tblRoom.getItems().add(new RoomTM(roomID,type,keyMoney,qty));
                if (!save){
                    new Alert(Alert.AlertType.ERROR,"Failed to Saved the User").show();
                }
                textClearAndBtnDisable();

            }else {
                boolean updated= roomBO.updateRoom(new Room(roomID,type,keyMoney,qty));

                if (updated){
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }

                RoomTM selectedItem = tblRoom.getSelectionModel().getSelectedItem();
                selectedItem.setRoom_type_id(roomID);
                selectedItem.setType(type);
                selectedItem.setKey_money(keyMoney);
                selectedItem.setQty(qty);

                tblRoom.refresh();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
