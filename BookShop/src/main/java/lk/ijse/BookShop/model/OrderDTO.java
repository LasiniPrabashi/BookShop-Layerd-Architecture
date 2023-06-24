package lk.ijse.BookShop.model;

import javafx.scene.control.Button;
import lk.ijse.BookShop.tm.OrderTm;

public class OrderDTO extends OrderTm {
    private String order_Id;
    private String cust_Id;
    private String date;
    private String time;
    private String grand_total;
    private Button view;

    public OrderDTO(String order_Id, String cust_Id, String date, String time, String grand_total) {
        this.order_Id = order_Id;
        this.cust_Id = cust_Id;
        this.date = date;
        this.time = time;
        this.grand_total = grand_total;
    }

    public OrderDTO() {

    }

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public String getCust_Id() {
        return cust_Id;
    }

    public void setCust_Id(String cust_Id) {
        this.cust_Id = cust_Id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(String grand_total) {
        this.grand_total = grand_total;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "order_Id='" + order_Id + '\'' +
                ", cust_Id='" + cust_Id + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", grand_total='" + grand_total + '\'' +
                '}';
    }

    public void setView(Button view) {
        this.view = view;
    }
}
