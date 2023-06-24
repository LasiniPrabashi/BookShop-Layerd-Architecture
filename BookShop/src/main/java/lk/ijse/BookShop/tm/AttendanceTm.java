package lk.ijse.BookShop.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AttendanceTm {
    private String id;
    private String fist_name;
    private String last_name;
    private String date;
    private String time;
}
