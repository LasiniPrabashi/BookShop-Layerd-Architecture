package lk.ijse.BookShop.model;

public class LoginDTO {
    private String UserName;
    private String Emp_Id;
    private String password;
    private String role;

    public LoginDTO(String userName, String emp_Id, String password, String role) {
        UserName = userName;
        Emp_Id = emp_Id;
        this.password = password;
        this.role = role;
    }

    public LoginDTO() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        Emp_Id = emp_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "UserName='" + UserName + '\'' +
                ", Emp_Id='" + Emp_Id + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
