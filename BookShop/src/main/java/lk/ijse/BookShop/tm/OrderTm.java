package lk.ijse.BookShop.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderTm {
    private String id;
    private String cus_id;
    private String date;
    private String time;
    private String total;
    private Button delete;
    private Button view;



}
