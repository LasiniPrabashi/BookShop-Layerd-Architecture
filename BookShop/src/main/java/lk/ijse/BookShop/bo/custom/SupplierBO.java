package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    boolean add(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;

    ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException;

    String getSupplierCount() throws SQLException, ClassNotFoundException;

    SupplierDTO get(String id) throws SQLException, ClassNotFoundException;

    boolean remove(String sup_Id) throws SQLException, ClassNotFoundException;

    boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;

}
