package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO,String> {
    String getCustomerOrder(int i) throws SQLException,ClassNotFoundException;

}
