package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.EmployeeDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    public  boolean add(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO Employee VALUES (?,?,?,?,?,?,?)",
                employee.getEmp_Id(),
                employee.getFistName(),
                employee.getLastName(),
                employee.getStreet(),
                employee.getCity(),
                employee.getLane(),
                employee.getContact()
        );
    }

    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT Emp_Id FROM employee ORDER BY LENGTH(Emp_Id),Emp_Id");
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    public  EmployeeDTO get(String id) throws SQLException, ClassNotFoundException {
        EmployeeDTO employee=new EmployeeDTO();
        ResultSet set = SQLUtil.crudUtil("SELECT * from Employee where Emp_Id=?", id);
        if (set.next()){
            employee.setEmp_Id(set.getString(1));
            employee.setFistName(set.getString(2));
            employee.setLastName(set.getString(3));
            employee.setStreet(set.getString(4));
            employee.setCity(set.getString(5));
            employee.setLane(set.getString(6));
            employee.setContact(set.getString(7));
        }
        return employee;
    }

    public  ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set=SQLUtil.crudUtil("SELECT Emp_Id from Employee where Emp_Id LIKE ? or fristName LIKE ? or lastName LIKE ?",id+"%",id+"%",id+"%");
        while (set.next()){
            ids.add(set.getString(1));
        }
        return ids ;
    }

    public  boolean remove(String emp_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("DELETE FROM Employee WHERE Emp_Id=?",emp_id);
    }

    public  boolean update(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("UPDATE Employee SET fristName=?,lastName=?,city=?,lane=?,street=?,contact=? WHERE Emp_Id=?",
                employeeDTO.getFistName(),
                employeeDTO.getLastName(),
                employeeDTO.getCity(),
                employeeDTO.getLane(),
                employeeDTO.getStreet(),
                employeeDTO.getContact(),
                employeeDTO.getEmp_Id()

        );
    }


    public  String getEmployeeCount() throws SQLException, ClassNotFoundException {
        ResultSet set= SQLUtil.crudUtil("SELECT COUNT(Emp_Id) FROM Employee");
        String count=null;
        if (set.next()){
            count=set.getString(1);
        }
        return count;
    }


}
