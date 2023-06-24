package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean add(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
    public  CustomerDTO get(String id) throws SQLException, ClassNotFoundException;
    public  ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException;
    public  boolean remove(String cust_id) throws SQLException, ClassNotFoundException;
    public  boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    String getCustomerCount()throws SQLException,ClassNotFoundException;

}
