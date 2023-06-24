package lk.ijse.BookShop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String Cust_Id;
    private String fistName;
    private String lastName;
    private String street;
    private String city;
    private String lane;
    private String contact;
}
