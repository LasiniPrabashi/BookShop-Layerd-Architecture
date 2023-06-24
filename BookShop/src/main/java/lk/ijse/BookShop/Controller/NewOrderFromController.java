package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.bo.custom.ItemBO;
import lk.ijse.BookShop.bo.custom.OrderBO;
import lk.ijse.BookShop.bo.custom.impl.CustomerBOImpl;
import lk.ijse.BookShop.bo.custom.impl.ItemBOImpl;
import lk.ijse.BookShop.bo.custom.impl.OrderBOImpl;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.model.ItemDTO;
import lk.ijse.BookShop.model.OrderDTO;
import lk.ijse.BookShop.model.OrderItemDTO;
import lk.ijse.BookShop.tm.OrderItemTm;
import lk.ijse.BookShop.util.DateTimeUtil;
import lk.ijse.BookShop.util.Navigation;
import lk.ijse.BookShop.util.RegexUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class
NewOrderFromController implements Initializable {
  //CustomerDAO customerDAO = new CustomerDAOImpl();
  //  ItemDAO itemDAO = new ItemDAOImpl();
  //  OrderDAO orderDAO = new OrderDAOImpl();
  OrderBO orderBO = new OrderBOImpl();
  CustomerBO customerBO = new CustomerBOImpl();
  ItemBO itemBO = new ItemBOImpl();

    public JFXComboBox cmbCustomerId;
    public JFXComboBox cmbItem;
    public Text txtName;
    public Text txtItemName;
    public Text txtPrice;
    public JFXTextField txtQty;
    public Text txtTotalPrice;
    public Text txtTotal;
    public TableView tbl;
    public TableColumn tblId;
    public TableColumn tblItem;
    public TableColumn tblPrice;
    public TableColumn tblQty;
    public TableColumn tblRemove;
    public JFXButton btnDone;

    ArrayList<ItemDTO> items = new ArrayList<>();

    ItemDTO itemDTO;
    CustomerDTO customerDTO;

    ObservableList<OrderItemTm> tms = FXCollections.observableArrayList();

 //  public boolean placeOrder(ArrayList<OrderItemTm> list, CustomerDTO customerDTO, OrderDTO orderDTO) throws SQLException {
 //       Connection connection = null;

//        try {
//            connection = DBConnection.getInstance().getConnection();
//            connection.setAutoCommit(false);
//            if (OrderDAO.add(orderDTO)) {
//                if (OrderDetailsDAO.add(list, orderDTO)) {
//                    if (ItemDAO.update(list)) {
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
//       return false;
//   }


    public void btnDonOnAction(ActionEvent actionEvent)  {
        ArrayList<OrderItemTm> list = new ArrayList<>();
        for (int i = 0; i < tms.size(); i++) {
            list.add(tms.get(i));
        }
        OrderDTO orderDTO = new OrderDTO(
                id(),
                customerDTO.getCust_Id(),
                DateTimeUtil.dateNow(),
                txtTotal.getText(),
                DateTimeUtil.timeNow()
        );

        try {

            if (orderBO.placeOrder(list, customerDTO, orderDTO)) {
                OrderFormController.getInstance().loadDataTable();
                Navigation.close(actionEvent);
                new Alert(Alert.AlertType.INFORMATION, "Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "something Wong").show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private String id() {
        try {
            ArrayList<String> allId = orderBO.getAllId();
            String lastId = null;
            for (int i = 0; i < allId.size(); i++) {
                lastId = allId.get(i);
                System.out.println(allId.get(i));
            }
            try {
                String[] e00s = lastId.split("O00");
                int idIndex = Integer.parseInt(e00s[1]);
                idIndex++;
                System.out.println(idIndex);
                return "O00" + idIndex;
            } catch (Exception e) {
                return "O001";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void cIdOnAction(ActionEvent actionEvent) {

        try {
            customerDTO = customerBO.get(String.valueOf(cmbCustomerId.getValue()));
            txtName.setText(customerDTO.getFistName() + " " + customerDTO.getLastName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void iIdOnAction(ActionEvent actionEvent) {
        try {
            itemDTO = itemBO.get(String.valueOf(cmbItem.getValue()));
            txtItemName.setText(itemDTO.getItemName());
            txtPrice.setText(String.valueOf(itemDTO.getUnitPrice()));
            items.add(itemDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   public void btnAddOnAction(ActionEvent actionEvent) {
        boolean isNotDuplicate=true;
        for (int i = 0; i < tms.size(); i++) {
            if (tms.get(i).getId().equals(cmbItem.getValue())){
                tms.get(i).setQty(String.valueOf(Integer.parseInt(txtQty.getText())+Integer.parseInt(tms.get(i).getQty())));
                tms.get(i).setPrice(String.valueOf(Double.parseDouble(tms.get(i).getPrice())+Double.parseDouble(txtPrice.getText())*Integer.parseInt(txtQty.getText())));
                isNotDuplicate=false;
            }
        }
        if (isNotDuplicate){
            OrderItemTm tm = new OrderItemTm();
            tm.setId(itemDTO.getItem_Id());
            tm.setItem(itemDTO.getItemName());
            tm.setQty(txtQty.getText());
            tm.setPrice(String.valueOf(itemDTO.getUnitPrice()));
            Button button = new Button();
            button.setText("Remove");
            button.setStyle("   -fx-text-fill:#ffff ;\n" +
                    "   -fx-font-weight: bold;\n" +
                    "   -fx-font-size: 15;\n" +
                    "   -fx-background-color: #03DE5A;\n" +
                    "   -fx-background-radius: 20;");
            button.setOnAction(actionEvent1 -> {
                for (int i = 0; i < tms.size(); i++) {
                    if (tms.get(i).equals(tm)){
                        tms.remove(tm);
                        tbl.refresh();
                    }
                }
            });
            tm.setButton(button);
            tms.add(tm);
            setTotal();
        }

    }

    private void setTotal() {
        double t=0;
        for (int i = 0; i < tms.size(); i++) {
            String price = tms.get(i).getPrice();
            t+=Double.parseDouble(price);
        }
        txtTotal.setText(String.valueOf(t));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemIds();
        loadCustomerIds();
        loadTableProperty();
    }

    private void loadTableProperty() {

        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        tblPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblRemove.setCellValueFactory(new PropertyValueFactory<>("button"));
        tbl.setItems(tms);
    }

    private void loadCustomerIds() {
        try {
            ArrayList<String> allId = customerBO.getAllId();
            cmbCustomerId.getItems().addAll(allId);

        } catch (SQLException throwables) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadItemIds() {
        try {
            ArrayList<String> allId = itemBO.getAllId();
            cmbItem.getItems().addAll(allId);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void qtyOnAction(ActionEvent actionEvent) {
        double totalPrice = Double.parseDouble(txtPrice.getText()) * Double.parseDouble(txtQty.getText());
        txtTotalPrice.setText(String.valueOf(totalPrice));
    }

    public void QtyKeyReleased(KeyEvent keyEvent) {
        System.out.println("QtyKeyReleased");
        RegexUtil.regex(btnDone,txtQty,txtQty.getText(),"[^a-z ]\\ *([.0-9])*\\d","-fx-text-fill:black");
    }
}
