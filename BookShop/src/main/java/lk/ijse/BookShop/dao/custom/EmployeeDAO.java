package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.EmployeeDTO;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<EmployeeDTO,String> {
    String getEmployeeCount() throws SQLException,ClassNotFoundException;
}
