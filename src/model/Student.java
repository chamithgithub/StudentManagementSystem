package model;

public class Student {
    private String student_Id;
    private String student_name;
    private String email;
    private String contract;
    private String address;
    private String nic;

    public Student(String student_Id, String student_name, String email, String contract, String address, String nic) {
        this.student_Id = student_Id;
        this.student_name = student_name;
        this.email = email;
        this.contract = contract;
        this.address = address;
        this.nic = nic;
    }

    public Student() {
    }

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_Id='" + student_Id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", email='" + email + '\'' +
                ", contract='" + contract + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
