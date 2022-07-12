package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtEmail;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtNic;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM Student WHERE id=?",txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtAddress.setText(result.getString(3));
                txtSalary.setText(String.valueOf(result.getDouble(4)));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }
}
