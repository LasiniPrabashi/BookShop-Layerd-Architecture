package lk.ijse.BookShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomEntityDTO {
    private String id;
    private String fist_name;
    private String last_name;
    private String date;
    private String time;
}
