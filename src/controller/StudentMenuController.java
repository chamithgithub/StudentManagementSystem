package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentMenuController {
    public TableView tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContract;
    public TableColumn colAddress;
    public TableColumn colNic;

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
