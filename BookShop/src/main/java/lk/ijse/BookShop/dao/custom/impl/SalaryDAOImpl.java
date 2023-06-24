package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.SalaryDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.SalaryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDAOImpl implements SalaryDAO {

    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set= SQLUtil.crudUtil("SELECT salary_Id FROM salary ORDER BY LENGTH(salary_Id),salary_Id");
        while (set.next())
        {
            ids.add(set.getString(1));
        }
        return ids;
    }

    @Override
    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean add(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO salary VALUES (?,?,?,?,?,?,?)",
                salaryDTO.getSalary_Id(),
                salaryDTO.getEmp_Id(),
                salaryDTO.getDaily_salary(),
                salaryDTO.getBonus(),
                salaryDTO.getDate(),
                salaryDTO.getTime(),
                salaryDTO.getTotal_salary()
        );
    }

    @Override
    public SalaryDTO get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean remove(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  SalaryDTO getData(String id) throws SQLException, ClassNotFoundException {
        ResultSet set=SQLUtil.crudUtil("SELECT * FROM salary WHERE salary_Id=?",id);
        SalaryDTO salaryDTO=new SalaryDTO();
        if (set.next()){
            salaryDTO.setSalary_Id(set.getString(1));
            salaryDTO.setDate(set.getString(5));
            salaryDTO.setBonus(set.getString(4));
            salaryDTO.setTime(set.getString(6));
            salaryDTO.setTotal_salary(set.getString(7));

        }
        return salaryDTO;
    }
}
