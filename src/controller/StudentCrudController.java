package controller;

import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCrudController {
    public static ArrayList<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT id FROM Student");
        ArrayList<String> ids= new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }

    public static Student getCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet result= CrudUtil.execute("SELECT * FROM Student WHERE id=?", id);
        if (result.next()){
            return new Student(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }

}
