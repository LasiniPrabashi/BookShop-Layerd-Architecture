package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.ItemDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.ItemDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    public  boolean add(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO item VALUES (?,?,?,?,?,?)",
                itemDTO.getItem_Id(),
                itemDTO.getItemName(),
                itemDTO.getMatiriyalType(),
                itemDTO.getDiscription(),
                itemDTO.getQtyOnHand(),
                itemDTO.getUnitPrice()
        );
    }
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT item_Id FROM item ORDER BY LENGTH(item_Id),item_Id");
        ArrayList<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;

    }

    public ItemDTO get(String id) throws SQLException, ClassNotFoundException {
        ItemDTO itemDTO=new ItemDTO();
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * From item WHERE item_Id=?", id);
        while (resultSet.next()){
            itemDTO.setItem_Id(resultSet.getString(1));
            itemDTO.setItemName(resultSet.getString(2));
            itemDTO.setMatiriyalType(resultSet.getString(3));
            itemDTO.setDiscription(resultSet.getString(4));
            itemDTO.setQtyOnHand(Integer.parseInt(resultSet.getString(5))); ;
            itemDTO.setUnitPrice(Double.parseDouble(resultSet.getString(6)));

        }
        return itemDTO;
    }


    public boolean remove(String item_Id) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("DELETE FROM item WHERE item_Id=? ",item_Id);
    }

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("UPDATE item SET itemName=?,MatiriyalType=?,discription=?,QtyOnHand=?,UnitPrice=? WHERE item_Id=?",
                itemDTO.getItemName(),
                itemDTO.getMatiriyalType(),
                itemDTO.getDiscription(),
                itemDTO.getQtyOnHand(),
                itemDTO.getUnitPrice(),
                itemDTO.getItem_Id()
        );
    }

    public  boolean itemUpdate(ArrayList<OrderItemTm> list) throws SQLException, ClassNotFoundException {
        boolean updated=true;
        for (int i = 0; i < list.size(); i++) {
            if (SQLUtil.crudUtil("UPDATE item SET QtyOnHand=QtyOnHand-? WHERE item_Id=?",
                    list.get(i).getQty(),
                    list.get(i).getId()
            )){

            }else {
                return false;
            }

        }
        return updated;
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set=SQLUtil.crudUtil("SELECT item_Id from item where item.item_Id LIKE ? or item.itemName LIKE ? or item.MatiriyalType LIKE ?",id+"%",id+"%",id+"%");
        while (set.next()){
            ids.add(set.getString(1));
        }
        return ids ;
    }

    public String getItemCount() throws SQLException, ClassNotFoundException {
        ResultSet set= SQLUtil.crudUtil("SELECT COUNT(Cust_Id) FROM Customer");
        String count=null;
        if (set.next()){
            count=set.getString(1);
        }
        return count;
    }

}
