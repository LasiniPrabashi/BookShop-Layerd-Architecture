package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.SalaryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryBO extends SuperBO {

    boolean add(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllSalaryID() throws SQLException, ClassNotFoundException;

    SalaryDTO getData(String id) throws SQLException, ClassNotFoundException;

    String getEmpAttCount(String value) throws SQLException, ClassNotFoundException;
}
