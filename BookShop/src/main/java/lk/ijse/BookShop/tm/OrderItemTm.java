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

public class OrderItemTm {
    private String id;
    private String item;
    private String price;
    private String qty;
    private Button button;
}