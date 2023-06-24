package lk.ijse.BookShop.model;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderTmDTO {
    private String id;
    private String cus_id;
    private String date;
    private String time;
    private String total;
    private Button delete;
    private Button view;

}
