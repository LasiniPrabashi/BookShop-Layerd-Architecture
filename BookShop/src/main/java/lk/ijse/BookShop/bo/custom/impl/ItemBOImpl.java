package lk.ijse.BookShop.bo.custom.impl;

import lk.ijse.BookShop.bo.custom.ItemBO;
import lk.ijse.BookShop.dao.custom.ItemDAO;
import lk.ijse.BookShop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.BookShop.model.ItemDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = new ItemDAOImpl();


    public boolean add(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.add(itemDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllId();
    }

    public ItemDTO get(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.get(id);
    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(itemDTO);
    }

    public boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return itemDAO.remove(cust_id);
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.getSearchIds(id);
    }

    public String getItemCount() throws SQLException, ClassNotFoundException {
        return itemDAO.getItemCount();
    }
}
