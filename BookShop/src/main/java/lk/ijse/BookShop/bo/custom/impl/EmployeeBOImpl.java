package lk.ijse.BookShop.bo.custom.impl;

import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.bo.custom.EmployeeBO;
import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.EmployeeDAO;
import lk.ijse.BookShop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public boolean add(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(employeeDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllId();
    }

    public EmployeeDTO get(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.get(id);
    }

    public boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(employeeDTO);
    }

    public boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return employeeDAO.remove(cust_id);
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.getSearchIds(id);
    }

    public String getEmployeeCount() throws SQLException,ClassNotFoundException{
        return employeeDAO.getEmployeeCount();
    }
}