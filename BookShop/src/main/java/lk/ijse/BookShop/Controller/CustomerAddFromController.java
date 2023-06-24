package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.BookShop.bo.BOFactory;
import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.bo.custom.impl.CustomerBOImpl;
import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.util.RegexUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerAddFromController {
  //  CustomerDAO customerDAO = new CustomerDAOImpl();
  CustomerBO customerBO=  BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Customer);
    public JFXButton btnDone;
    @FXML
    private JFXTextField txtFistName;

    @FXML
    private JFXTextField txtLastName;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtStreet;

    @FXML
    private JFXTextField txtLane;

    @FXML
    private JFXTextField txtcontacNumber;

    public void btnDonOnAction(ActionEvent actionEvent) {

       try {
            if (customerBO.add(new CustomerDTO(
                    id(),
                    txtFistName.getText(),
                    txtLastName.getText(),
                    txtStreet.getText(),
                    txtCity.getText(),
                    txtLane.getText(),
                    txtcontacNumber.getText()

            ))) {
                CustomerFormController.getInstance().pane.getChildren().clear();
                CustomerFormController.getInstance().navigationVisibleTrueController();
                CustomerFormController.getInstance().loadDataTable();


                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wong").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private String id() {
        try {
            ArrayList<String> allId = customerBO.getAllId();
            String lastId = null;
            for (int i = 0; i < allId.size(); i++) {
                lastId = allId.get(i);
                System.out.println(allId.get(i));
            }
           try {
                String[] e00s = lastId.split("C00");
                int idIndex = Integer.parseInt(e00s[1]);
                idIndex++;
                System.out.println(idIndex);
                return "C00" + idIndex;
           } catch (Exception e) {
                return "C001";
            }
       } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            }return null;
    }

    public void closeOnMouseCick(MouseEvent mouseEvent) {
        CustomerFormController.getInstance().pane.getChildren().clear();
        CustomerFormController.getInstance().navigationVisibleTrueController();
   }

    public void fistNameKeyReleased(KeyEvent keyEvent) {
        System.out.println(" fistNameKeyReleased ");
        RegexUtil.regex(btnDone,txtFistName,txtFistName.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");
    }

    public void lastNameKeyReleased(KeyEvent keyEvent) {
        System.out.println("lastNameKeyReleased");
        RegexUtil.regex(btnDone,txtLastName,txtLastName.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");

    }

    public void CityKeyReleased(KeyEvent keyEvent) {
        System.out.println("CityKeyReleased");
        RegexUtil.regex(btnDone,txtCity,txtCity.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");
    }

    public void laneKeyReleased(KeyEvent keyEvent) {
        System.out.println("laneKeyReleased");
        RegexUtil.regex(btnDone,txtLane,txtLane.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");
    }

    public void StreetKeyReleased(KeyEvent keyEvent) {
        System.out.println("StreetKeyReleased");
        RegexUtil.regex(btnDone,txtStreet,txtStreet.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");
    }

    public void ContactKeyReleased(KeyEvent keyEvent) {
        System.out.println("ContactKeyReleased");
      RegexUtil.regex(btnDone,txtcontacNumber,txtcontacNumber.getText(),"^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$","-fx-text-fill:black");
   }
}
