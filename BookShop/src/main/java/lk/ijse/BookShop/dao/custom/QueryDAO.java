package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.SuperDAO;
import lk.ijse.BookShop.model.CustomEntityDTO;

import java.sql.SQLException;

public interface QueryDAO extends SuperDAO {
       CustomEntityDTO get(String id) throws SQLException,ClassNotFoundException;
}
