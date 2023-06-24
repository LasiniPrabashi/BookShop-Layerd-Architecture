package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.SalaryDTO;
import lk.ijse.BookShop.tm.SalaryTm;

import java.sql.SQLException;

public interface SalaryDAO extends CrudDAO<SalaryDTO,String> {


    SalaryDTO getData(String id) throws SQLException,ClassNotFoundException;
}
