package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Student;
import util.CrudUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMenuController {
    public TableView<Student> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContract;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory("student_Id"));
        colName.setCellValueFactory(new PropertyValueFactory("student_name"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colContract.setCellValueFactory(new PropertyValueFactory("contract"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));

        try {
            loadAllCustomers();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Student");
        ObservableList<Student> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Student(
                            result.getString("student_Id"),
                            result.getString("student_name"),
                            result.getString("email"),
                            result.getString("contract"),
                            result.getString("address"),
                            result.getString("nic")
                    )
            );
        }
        tblStudent.setItems(obList);

    }

    public void searchStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SearchStudentForm");
    }

    public void saveStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SaveStudentForm");
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DeleteStudentForm");
    }

    public void updateStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("UpdateStudentForm");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
}
