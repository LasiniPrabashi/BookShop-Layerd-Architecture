package lk.ijse.BookShop.bo.custom.impl;

import lk.ijse.BookShop.bo.custom.SupplierBO;
import lk.ijse.BookShop.dao.custom.SupplierDAO;
import lk.ijse.BookShop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.model.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = new SupplierDAOImpl();

    public boolean add(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(supplierDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAllId();
    }

    public SupplierDTO get(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.get(id);
    }

    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(supplierDTO);
    }


    public boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return supplierDAO.remove(cust_id);
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.getSearchIds(id);
    }

    @Override
    public String getSupplierCount() throws SQLException, ClassNotFoundException {
        return supplierDAO.getSupplierCount();
    }
}
