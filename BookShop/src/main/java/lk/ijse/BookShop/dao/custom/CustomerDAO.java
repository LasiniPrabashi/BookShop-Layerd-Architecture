package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.entity.Customer;
import lk.ijse.BookShop.model.CustomerDTO;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<CustomerDTO, String> {
    String getCustomerCount() throws SQLException,ClassNotFoundException;

}
