package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.LoginDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.LoginDTO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAOImpl implements LoginDAO {

    public boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO admin VALUES(?,?,?,?)",
                loginDTO.getUserName(),
                loginDTO.getEmp_Id(),
                loginDTO.getPassword(),
                loginDTO.getRole()
        );
    }


    public LoginDTO get(String user_name, String password) throws SQLException, ClassNotFoundException {
        LoginDTO loginDTO = new LoginDTO();
        ResultSet set = SQLUtil.crudUtil("SELECT * from admin where userName=? and password =?",user_name, password);
        if (set.next()) {
            loginDTO.setUserName(set.getString(1));
            loginDTO.setEmp_Id(set.getString(2));
            loginDTO.setPassword(set.getString(3));
            loginDTO.setRole(set.getString(4));

        }
        return loginDTO;
    }

    @Override
    public boolean update(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean remove(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getSearchIds(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    public boolean add(LoginDTO dto) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public LoginDTO get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String check(LoginDTO loginDTO) throws SQLException, ClassNotFoundException {
        ResultSet set=SQLUtil.crudUtil("SELECT role FROM admin WHERE userName=? AND password=?", loginDTO.getUserName(), loginDTO.getPassword());
        while (set.next()){
            return  set.getString(1);
        }
        return"XXX";
    }
}
