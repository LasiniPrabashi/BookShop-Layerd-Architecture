package lk.ijse.BookShop.tm;

import javafx.scene.control.Button;


public class CustomerTm {
    private String Cust_Id;
    private String fistName;
    private String lastName;
    private String city;
    private String contact;
    private Button Option;
    private Button view;

    public CustomerTm() {
    }

    public CustomerTm(String cust_Id, String fistName, String lastName, String city, String contact, Button option, Button view) {
        Cust_Id = cust_Id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.city = city;
        this.contact = contact;
        Option = option;
        this.view = view;
    }

    public String getCust_Id() {
        return Cust_Id;
    }

    public void setCust_Id(String cust_Id) {
        Cust_Id = cust_Id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getOption() {
        return Option;
    }

    public void setOption(Button option) {
        Option = option;
    }

    public Button getView() {
        return view;
    }

    public void setView(Button view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "EmployeeTm{" +
                "Emp_Id='" + Cust_Id + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                ", Option=" + Option +
                ", view=" + view +
                '}';
    }
}
