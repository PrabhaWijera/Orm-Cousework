package lk.ijse.prabhash.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.prabhash.dto.Student;
import lk.ijse.prabhash.services.ServiceFactory;
import lk.ijse.prabhash.services.ServiceType;
import lk.ijse.prabhash.services.custom.Student_Service;
import lk.ijse.prabhash.services.custom.impl.Student_Service_impl;
import lk.ijse.prabhash.util.ValidationUtil;
import lk.ijse.prabhash.view.tm.StudentTM;
import lombok.SneakyThrows;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


public class StudentManagementFormController {
    public TableView <StudentTM>tblStudent;
    public JFXTextField txtStudentId;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXTextField txtAddress;
    public JFXButton btnSave;
    public JFXTextField txtContactNo;
    public JFXButton btnNew;
    public JFXButton btnDelete;
    public JFXTextField txtName;
    public JFXTextField txtDOB;
    private final Student_Service student_service = (Student_Service) ServiceFactory.getInstance().getService(ServiceType.STUDENT);
    public JFXComboBox <String>cmbGender;
    public TableColumn colContactNo;

    public JFXButton btnupdate;
    public AnchorPane StudentContext;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();
/*
    public void initialize(){


        cmbGender.getItems().addAll("Male","Female","Other");

        loadAllStudents();

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtStudentId.setText(newValue.getStudent_id());
                txtName.setText(newValue.getName());
                txtContactNo.setText(newValue.getContact_no());
                txtAddress.setText(newValue.getAddress());
                txtDOB.setText(String.valueOf(newValue.getDob()));
                cmbGender.setValue(newValue.getGender());

                txtStudentId.setDisable(false);
                txtName.setDisable(false);
                txtAddress.setDisable(false);
                txtContactNo.setDisable(false);
                txtDOB.setDisable(false);
                cmbGender.setDisable(false);

            }
        });*/
       /* Pattern namePattern = Pattern.compile("^[A-z ]{3,30}$");
        Pattern addressPattern = Pattern.compile("^[A-z0-9 /,]{4,20}$");
        Pattern contactNoPattern = Pattern.compile("^(?:7|0|(?:\\+94))(70|77|78|74|76|72|71)[0-9]{7}$");
        Pattern date = Pattern.compile("^[1-9]{1}[0-9]{3}-[0-9]{2}-[0-9]{2}$");

        map.put(txtName,namePattern);
        map.put(txtAddress,addressPattern);
        map.put(txtContactNo,contactNoPattern);
        map.put(txtDOB,date);*/
  //  }

    private void loadAllStudents() {
        try {
            List<Student> allStudents = student_service.getAllStudents();
            for (Student dto:allStudents
            ) {
                tblStudent.getItems().add(
                       new StudentTM(dto.getStudent_id(), dto.getName(), dto.getAddress(), dto.getContact_no(),dto.getDob(), dto.getGender())
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void generateNewId() {
        try {
            String lastStudentId = student_service.generateStudentId();
            int newId = Integer.parseInt(lastStudentId.substring(1, 4))+1;
            if (newId < 10) {
                txtStudentId.setText("S00"+newId);
            }else if (newId < 100) {
                txtStudentId.setText("S0"+newId);
            }else {
                txtStudentId.setText("S"+newId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
       String student_id=txtStudentId.getText();
       String name=txtName.getText();
       String address=txtAddress.getText();
       String contact_no=txtContactNo.getText();
       LocalDate dob= LocalDate.parse(txtDOB.getText());
       String gender=cmbGender.getValue();

        System.out.println(txtDOB.getText());

        Student studentDto=new Student(student_id,name,address,contact_no,dob,gender);
        Student_Service_impl css=ServiceFactory.getInstance().getService(ServiceType.STUDENT);
        try{
            student_service.saveStudent(studentDto);
            if (css!=null){
                new Alert(Alert.AlertType.WARNING,"Add").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Not Add").show();
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent)  {
        String student_id=txtStudentId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String contact_no=txtContactNo.getText();
        LocalDate dob= LocalDate.parse(txtDOB.getText());
        String gender=cmbGender.getValue();

        System.out.println(txtDOB.getText());

        Student studentDto=new Student(student_id,name,address,contact_no,dob,gender);
        Student_Service_impl css=ServiceFactory.getInstance().getService(ServiceType.STUDENT);
        try{
            boolean c=student_service.deleteStudent(student_id);
            if (c!=true){
                new Alert(Alert.AlertType.WARNING,"Delete").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"no").show();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        String student_id=txtStudentId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String contact_no=txtContactNo.getText();
        LocalDate dob= LocalDate.parse(txtDOB.getText());
        String gender=cmbGender.getValue();

        System.out.println(txtDOB.getText());
        Student studentDto=new Student(student_id,name,address,contact_no,dob,gender);
        student_service.updateStudent(studentDto);
        if (studentDto!=null){
            new Alert(Alert.AlertType.WARNING,"Update").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"No").show();
        }
        txtStudentId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDOB.clear();

    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        txtStudentId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        txtContactNo.setDisable(false);
        txtDOB.setDisable(false);
        cmbGender.setDisable(false);

        txtStudentId.clear();
        generateNewId();
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        txtDOB.clear();
        cmbGender.getSelectionModel().clearSelection();

        txtName.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblStudent.getSelectionModel().clearSelection();
    }



}
