package lk.ijse.BookShop.model;

public class EmployeeDTO {
    private String Emp_Id;
    private String fistName;
    private String lastName;
    private String street;
    private String city;
    private String lane;
    private String contact;

    public EmployeeDTO(String emp_Id, String fistName, String lastName, String street, String city, String lane, String contact) {
        Emp_Id = emp_Id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.lane = lane;
        this.contact = contact;
    }

    public EmployeeDTO() {

    }

    public String getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        Emp_Id = emp_Id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "Emp_Id='" + Emp_Id + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", lane='" + lane + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
