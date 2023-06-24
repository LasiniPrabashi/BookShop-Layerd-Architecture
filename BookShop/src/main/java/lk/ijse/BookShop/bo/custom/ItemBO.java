package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.model.ItemDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public  boolean add(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
    public ItemDTO get(String id) throws SQLException, ClassNotFoundException;
    public boolean remove(String item_Id) throws SQLException, ClassNotFoundException;
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    //public  boolean itemUpdate(ArrayList<OrderItemTm> list) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException;

    String getItemCount()throws SQLException,ClassNotFoundException;
    // public String getItemCount() throws SQLException, ClassNotFoundException;
}
