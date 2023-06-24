package lk.ijse.BookShop.model;

public class CustomerDTO {
    private String Cust_Id;
    private String fistName;
    private String lastName;
    private String street;
    private String city;
    private String lane;
    private String contact;

    public CustomerDTO(String cust_Id, String fistName, String lastName, String street, String city, String lane, String contact) {
        Cust_Id = cust_Id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.lane = lane;
        this.contact = contact;
    }

    public CustomerDTO() {}


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
        return "CustomerDTO{" +
                "Cust_Id='" + Cust_Id + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", lane='" + lane + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
