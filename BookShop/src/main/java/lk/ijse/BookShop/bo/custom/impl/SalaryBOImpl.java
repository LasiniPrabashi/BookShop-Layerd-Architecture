package lk.ijse.BookShop.bo.custom.impl;

import lk.ijse.BookShop.bo.custom.SalaryBO;
import lk.ijse.BookShop.dao.custom.AttendanceDAO;
import lk.ijse.BookShop.dao.custom.EmployeeDAO;
import lk.ijse.BookShop.dao.custom.SalaryDAO;
import lk.ijse.BookShop.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.model.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBOImpl implements SalaryBO {

    SalaryDAO employeeSalaryDAO = new SalaryDAOImpl();

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    AttendanceDAO attendanceDAO = new AttendanceDAOImpl();

    public boolean add(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.add(salaryDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllId();
    }

    @Override
    public ArrayList<String> getAllSalaryID() throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.getAllId();
    }

    public SalaryDTO getData(String id) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.getData(id);
    }

    public String getEmpAttCount(String value) throws SQLException, ClassNotFoundException {
        return attendanceDAO.getEmpAttCount();
    }
}
