package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.LoginDTO;

import java.sql.SQLDataException;
import java.sql.SQLException;

public interface LoginDAO extends CrudDAO<LoginDTO,String> {

    String check(LoginDTO loginDTO)throws SQLException,ClassNotFoundException;
}
