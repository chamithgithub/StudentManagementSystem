package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class SaveStudentFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtEmail;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtNic;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Student c = new Student(
                txtId.getText(),txtName.getText(), txtEmail.getText(),
                txtSalary.getText(),txtAddress.getText(),txtNic.getText()
                );

        try {
            if (CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)",c.getStudent_Id(),
                    c.getStudent_name(),c.getEmail(),c.getContract(),c.getAddress(),c.getNic())){

                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    }
