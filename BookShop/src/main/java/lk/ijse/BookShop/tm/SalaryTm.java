package lk.ijse.BookShop.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SalaryTm {
    private String salary_Id;
    private String id;
    private String bonus;
    private String date;
    private String time;
    private String total_salary;
}
