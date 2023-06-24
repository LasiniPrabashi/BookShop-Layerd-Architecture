package lk.ijse.BookShop.dao;

import lk.ijse.BookShop.tm.SalaryTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,ID> extends SuperDAO{
    boolean add(T dto) throws SQLException, ClassNotFoundException;
    T get(ID id) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean remove(ID id) throws SQLException, ClassNotFoundException;
    ArrayList<ID> getAllId() throws SQLException, ClassNotFoundException;
    ArrayList<ID> getSearchIds(String id) throws SQLException, ClassNotFoundException;

    //ID getCustomerCount() throws SQLException,ClassNotFoundException;
   // ID getEmployeeCount() throws SQLException,ClassNotFoundException;
  //  ID getItemCount() throws SQLException,ClassNotFoundException;
  //  ID getSupplierCount()throws SQLException,ClassNotFoundException;


}
