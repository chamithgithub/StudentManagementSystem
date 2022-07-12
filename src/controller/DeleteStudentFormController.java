package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteStudentFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtEmail;
    public TextField txtSalary;
    public TextField txtAddress;
    public TextField txtNic;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        search();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try{
            if (CrudUtil.execute("DELETE FROM Student WHERE student_Id=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }

    }
    private void search() {
        try {
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
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
