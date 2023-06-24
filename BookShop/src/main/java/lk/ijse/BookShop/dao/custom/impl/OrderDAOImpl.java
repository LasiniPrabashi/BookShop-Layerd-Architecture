package lk.ijse.BookShop.dao.custom.impl;

import javafx.scene.control.Button;
import lk.ijse.BookShop.dao.custom.OrderDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.OrderDTO;
import lk.ijse.BookShop.util.DateTimeUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

//    public static boolean placeOrder(ArrayList<OderItemTm> list, Customer customer, Order order) throws SQLException {
//        Connection connection = null;
//
//        try {
//            connection = DBConnection.getInstance().getConnection();
//            connection.setAutoCommit(false);
//            if (OrderModel.addOrder(order)) {
//                if (OrderDetailsModel.add(list, order)) {
//                    if (ItemModel.itemUpdate(list)) {
//                        return true;
//                    } else {
//                        connection.rollback();
//                    }
//                } else {
//                    connection.rollback();
//                }
//            } else {
//                connection.rollback();
//            }
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            connection.commit();
//            connection.setAutoCommit(true);
//        }
//        return false;
//    }

     public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        System.out.println(orderDTO.getTime());
        return SQLUtil.crudUtil("INSERT INTO `order` VALUES (?,?,?,?,?)",
                orderDTO.getOrder_Id(),
                orderDTO.getCust_Id(),
                orderDTO.getDate(),
                orderDTO.getTime(),
                orderDTO.getGrand_total()
        );

    }

    public  ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String> id = new ArrayList<>();
        ResultSet set = SQLUtil.crudUtil("SELECT order_Id FROM `order` ORDER BY LENGTH(order_Id),order_Id");
        while (set.next()) {
            id.add(set.getString(1));
        }
        return id;
    }

    public OrderDTO get(String id) throws SQLException, ClassNotFoundException {
        OrderDTO orderDTO=new OrderDTO();
        ResultSet set= SQLUtil.crudUtil("SELECT o.order_Id,c.cust_Id,o.date,o.time,o.grand_total FROM `order` o INNER JOIN customer c on o.cust_Id = c.cust_Id WHERE order_Id=?",id);

        while (set.next()){
            orderDTO.setOrder_Id(set.getString(1));
            orderDTO.setCust_Id(set.getString(2));
            orderDTO.setDate(set.getString(3));
            orderDTO.setTime(set.getString(4));
            orderDTO.setGrand_total(set.getString(5));
        }

        Button button2 = new Button();
        button2.setText("View");
        button2.setStyle("   -fx-text-fill:#ffff ;\n" +
                "   -fx-font-weight: bold;\n" +
                "   -fx-font-size: 15;\n" +
                "   -fx-background-color: #03DE5A;\n" +
                "   -fx-background-radius: 20;");
        button2.setOnAction(actionEvent -> {
            System.out.println("click2");
        });
        orderDTO.setView(button2);

        return orderDTO;
        //
    }


    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean remove(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  String getOrderCount() throws SQLException, ClassNotFoundException {
        ResultSet set= SQLUtil.crudUtil("SELECT COUNT(Order_Id) FROM `order`");
        String count=null;
        if (set.next()){
            count=set.getString(1);
        }
        return count;
    }


    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String>ids=new ArrayList<>();
        ResultSet set=SQLUtil.crudUtil("SELECT order_Id from `order` where `order`.order_Id LIKE ? or `order`.date LIKE ? or `order`.grand_total LIKE ?",id+"%",id+"%",id+"%");
        while (set.next()){
            ids.add(set.getString(1));
        }
        return ids ;
    }

    public String getCustomerOrder(int i) throws SQLException, ClassNotFoundException {
        i++;
        String dateNow = DateTimeUtil.dateNow();
        String[] date = dateNow.split("-");
        String currentDate=null;
        if (String.valueOf(i).length()==1){
            currentDate="0"+i;
        }else {
            currentDate= String.valueOf(i);
        }
        System.out.println(date[0]+"-"+date[1]+"-"+currentDate);
        ResultSet set=SQLUtil.crudUtil("SELECT grand_total FROM `order` WHERE date=?;",date[0]+"-"+date[1]+"-"+currentDate);
        double t=0;
        while (set.next()){
            t+=set.getDouble(1);
        }
        return String.valueOf(t);
    }
}
