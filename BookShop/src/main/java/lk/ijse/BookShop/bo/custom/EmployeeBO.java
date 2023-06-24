package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public  boolean add(EmployeeDTO employee) throws SQLException, ClassNotFoundException;
    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
    public  EmployeeDTO get(String id) throws SQLException, ClassNotFoundException;
    public  ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException;
    public  boolean remove(String emp_id) throws SQLException, ClassNotFoundException;
    public  boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    String getEmployeeCount() throws SQLException,ClassNotFoundException;



}
