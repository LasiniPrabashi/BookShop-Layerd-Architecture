package lk.ijse.BookShop.tm;

import javafx.scene.control.Button;


public class SupplierTm {
    private String Sup_Id;
    private String company;
    private String location;
    private String email;
    private String contact;
    private Button Option;
    private Button view;

    public SupplierTm() {
    }

    public SupplierTm(String sup_Id, String fistName, String lastName, String city, String contact, Button option, Button view) {
        Sup_Id = sup_Id;
        this.company = company;
        this.location = location;
        this.email = email;
        this.contact = contact;
        Option = option;
        this.view = view;
    }

    public String getSup_Id() {
        return Sup_Id;
    }

    public void setSup_Id(String sup_Id) {
        Sup_Id = sup_Id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "SupplierTm{" +
                "Sup_Id='" + Sup_Id + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", Option=" + Option +
                ", view=" + view +
                '}';
    }


}
