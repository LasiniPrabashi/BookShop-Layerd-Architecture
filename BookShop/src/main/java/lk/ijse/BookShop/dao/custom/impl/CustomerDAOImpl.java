package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

 public class CustomerDAOImpl implements CustomerDAO {
    public boolean add(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)",
                customerDTO.getCust_Id(),
                customerDTO.getFistName(),
                customerDTO.getLastName(),
                customerDTO.getStreet(),
                customerDTO.getCity(),
                customerDTO.getLane(),
                customerDTO.getContact()
        );
    }

    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT cust_Id FROM customer ORDER BY LENGTH(Cust_Id),Cust_Id");
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    public  CustomerDTO get(String id) throws SQLException, ClassNotFoundException {
        CustomerDTO customerDTO=new CustomerDTO();
        ResultSet set = SQLUtil.crudUtil("SELECT * from customer where cust_Id=?", id);
        if (set.next()){
            customerDTO.setCust_Id(set.getString(1));
            customerDTO.setFistName(set.getString(2));
            customerDTO.setLastName(set.getString(3));
            customerDTO.setStreet(set.getString(4));
            customerDTO.setCity(set.getString(5));
            customerDTO.setLane(set.getString(6));
            customerDTO.setContact(set.getString(7));
        }
        return customerDTO;
    }

    public  ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set=SQLUtil.crudUtil("SELECT Cust_Id from Customer where Cust_Id LIKE ? or fristName LIKE ? or lastName LIKE ?",id+"%",id+"%",id+"%");
        while (set.next()){
            ids.add(set.getString(1));
        }
        return ids ;
    }

    public  boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("DELETE FROM Customer WHERE cust_Id=?",cust_id);
    }

    public  boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("UPDATE Customer SET fristName=?,lastName=?,city=?,lane=?,street=?,contact=? WHERE Cust_Id=?",
                customerDTO.getFistName(),
                customerDTO.getLastName(),
                customerDTO.getCity(),
                customerDTO.getLane(),
                customerDTO.getStreet(),
                customerDTO.getContact(),
                customerDTO.getCust_Id()

        );
    }


    public String getCustomerCount() throws SQLException, ClassNotFoundException {
        ResultSet set= SQLUtil.crudUtil("SELECT COUNT(Cust_Id) FROM Customer");
        String count=null;
        if (set.next()){
            count=set.getString(1);
        }
        return count;
    }




 }


