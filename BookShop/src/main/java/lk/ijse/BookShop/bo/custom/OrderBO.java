package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.model.OrderDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
    public OrderDTO get(String id) throws SQLException, ClassNotFoundException;
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException;
    public boolean remove(String s) throws SQLException, ClassNotFoundException;
   // public  String getOrderCount() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException;
   // public String getCustomerOrder(int i) throws SQLException, ClassNotFoundException;
    public boolean placeOrder(ArrayList<OrderItemTm> list, CustomerDTO customerDTO, OrderDTO orderDTO) throws SQLException;
}
