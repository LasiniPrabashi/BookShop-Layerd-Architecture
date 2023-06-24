package lk.ijse.BookShop.bo.custom.impl;


import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.dao.DAOFactory;
import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
     CustomerDAO customerDAO = new CustomerDAOImpl();
    public boolean add(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.add(customerDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return customerDAO.getAllId();
    }

    public CustomerDTO get(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.get(id);
    }

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }

    public String getCustomerCount() throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerCount();
    }


    public boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return customerDAO.remove(cust_id);
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getSearchIds(id);
    }
}