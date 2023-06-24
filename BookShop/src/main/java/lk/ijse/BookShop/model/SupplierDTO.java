package lk.ijse.BookShop.model;

public class SupplierDTO {
    private String Sup_Id;
    private String contact ;
    private String company;
    private String email;
    private String location;

    public SupplierDTO(String sup_Id, String contact, String company, String email, String location) {
        Sup_Id = sup_Id;
        this.contact = contact;
        this.company = company;
        this.email = email;
        this.location = location;
    }

    public SupplierDTO() {

    }

    public String getSup_Id() {
        return Sup_Id;
    }

    public void setSup_Id(String sup_Id) {
        Sup_Id = sup_Id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "Sup_Id='" + Sup_Id + '\'' +
                ", contact='" + contact + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
