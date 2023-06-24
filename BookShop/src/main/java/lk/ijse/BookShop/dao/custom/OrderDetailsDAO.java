package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.OrderDTO;
import lk.ijse.BookShop.tm.OrderItemTm;

import java.util.ArrayList;

public interface OrderDetailsDAO extends CrudDAO<OrderDTO,String> {
      boolean add(ArrayList<OrderItemTm> list, OrderDTO orderDTO);
}
