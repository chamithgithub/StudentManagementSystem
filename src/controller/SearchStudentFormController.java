package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchStudentFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtEmail;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtNic;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }

    private void search() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Student WHERE student_Id=?",txtId.getText());
        if (result.next()) {
            txtName.setText(result.getString(2));
            txtEmail.setText(result.getString(3));
             txtSalary.setText(result.getString((4)));
            txtAddress.setText(result.getString(5));
            txtNic.setText(result.getString(6));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }
}
