package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.OrderDetailsDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.OrderDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    public boolean add(ArrayList<OrderItemTm> list, OrderDTO orderDTO)  {
        boolean added =true;
        for (int i = 0; i < list.size(); i++) {
            try {
                if (SQLUtil.crudUtil("INSERT INTO orderdetail VALUES (?,?,?)",
                        list.get(i).getId(),
                        orderDTO.getOrder_Id(),
                        list.get(i).getQty()
                )){
                    added=true;
                }else {
                    return false;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return added;
    }


    @Override
    public boolean add(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean remove(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> getSearchIds(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
