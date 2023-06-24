package lk.ijse.BookShop.bo.custom.impl;

import lk.ijse.BookShop.bo.custom.OrderBO;
import lk.ijse.BookShop.dao.custom.ItemDAO;
import lk.ijse.BookShop.dao.custom.OrderDAO;
import lk.ijse.BookShop.dao.custom.OrderDetailsDAO;
import lk.ijse.BookShop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.OrderDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.BookShop.db.DBConnection;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.model.OrderDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();

    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.add(orderDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return orderDAO.getAllId();
    }

    public OrderDTO get(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.get(id);
    }

    public boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return orderDAO.update(orderDTO);
    }


    public boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return orderDAO.remove(cust_id);
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.getSearchIds(id);
    }

    public boolean placeOrder(ArrayList<OrderItemTm> list, CustomerDTO customerDTO, OrderDTO orderDTO) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
           connection.setAutoCommit(false);
           if (orderDAO.add(orderDTO)) {
               if (orderDetailsDAO.add(list, orderDTO)) {
                   if (itemDAO.itemUpdate(list)) {
                       return true;
                   } else {
                       connection.rollback();
                    }
                } else {
                    connection.rollback();
               }
           } else {
              connection.rollback();
          }
       } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
       } finally {
           connection.commit();
           connection.setAutoCommit(true);
       }
        return false;
    }

}