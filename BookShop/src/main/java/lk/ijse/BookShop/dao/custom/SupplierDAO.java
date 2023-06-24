package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.SupplierDTO;

import java.sql.SQLException;

public interface SupplierDAO extends CrudDAO<SupplierDTO,String> {
    String getSupplierCount()throws SQLException,ClassNotFoundException;
}
