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
            ResultSet result =  CrudUtil.execute("SELECT * FROM Student WHERE student_Id=?",txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtEmail.setText(result.getString(3));
                txtSalary.setText(result.getString(4));
                txtAddress.setText(result.getString(5));
                txtNic.setText(result.getString(6));


            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) {

        Student c = new Student(
                txtId.getText(),txtName.getText(), txtEmail.getText(),
                txtSalary.getText(),txtAddress.getText(),txtNic.getText()
        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE Student SET student_name=? , email=? , contract=? , address=? , nic=? WHERE student_Id=?",
                    c.getStudent_Id(),c.getStudent_name(),c.getEmail(),c.getContract(),c.getAddress(),c.getNic());

            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }

    }
}
