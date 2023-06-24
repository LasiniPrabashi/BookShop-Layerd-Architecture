package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.ItemDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO,String> {
    String getItemCount() throws SQLException,ClassNotFoundException;
    public boolean itemUpdate(ArrayList<OrderItemTm> list) throws SQLException, ClassNotFoundException;
}
