package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.SupplierDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.SupplierDTO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    public  boolean add(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO Supplier VALUES (?,?,?,?,?)",
                supplierDTO.getSup_Id(),
                supplierDTO.getContact(),
                supplierDTO.getCompany(),
                supplierDTO.getEmail(),
                supplierDTO.getLocation()
        );
    }

    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT sup_Id FROM supplier ORDER BY LENGTH(sup_Id),sup_Id");
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    public SupplierDTO get(String id) throws SQLException, ClassNotFoundException {
        SupplierDTO supplierDTO=new SupplierDTO();
        ResultSet set = SQLUtil.crudUtil("SELECT * from Supplier where Sup_Id=?", id);
        if (set.next()){
            supplierDTO.setSup_Id(set.getString(1));
            supplierDTO.setContact(set.getString(2));
            supplierDTO.setCompany(set.getString(3));
            supplierDTO.setEmail(set.getString(4));
            supplierDTO.setLocation(set.getString(5));
        }
        return supplierDTO;
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set=SQLUtil.crudUtil("SELECT sup_Id  from supplier where Supplier.sup_Id LIKE ? or  Supplier.company  LIKE ? or location LIKE ?",id+"%",id+"%",id+"%");
        while (set.next()){
            ids.add(set.getString(1));
        }
        return ids ;
    }

    public boolean remove(String sup_Id) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("DELETE FROM Supplier WHERE Sup_Id=?",sup_Id);
    }

    public boolean update(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("UPDATE Supplier SET contact=?,company=?,supplier.email=?,supplier.location=? WHERE sup_Id=?",
                supplierDTO.getContact(),
                supplierDTO.getCompany(),
                supplierDTO.getEmail(),
                supplierDTO.getLocation(),
                supplierDTO.getSup_Id()
        );
    }


    public String getSupplierCount() throws SQLException, ClassNotFoundException {
        ResultSet set= SQLUtil.crudUtil("SELECT COUNT(Sup_Id) FROM supplier");
        String count=null;
        if (set.next()){
            count=set.getString(1);
        }
        return count;
    }



}
