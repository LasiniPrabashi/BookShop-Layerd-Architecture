package lk.ijse.BookShop.model;

import javafx.scene.control.Button;
import lk.ijse.BookShop.tm.OrderItemTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderItemDTO {
    private String id;
    private String item;
    private String price;
    private String qty;
    private Button button;
}
