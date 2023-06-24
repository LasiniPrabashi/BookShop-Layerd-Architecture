package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.bo.custom.impl.CustomerBOImpl;
import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;



import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CustomerUpdateFromController implements Initializable {
   // CustomerDAO customerDAO = new CustomerDAOImpl();
    CustomerBO customerBO = new CustomerBOImpl();
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

    @FXML
    private JFXTextField txtSearchId;

    @FXML
    void btnDonOnAction(ActionEvent event) {
        try {
            if (customerBO.update(new CustomerDTO(
                    txtSearchId.getText(),
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

                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wong").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    private void setData() {
        try {
            CustomerDTO customerDTO= customerBO.get(txtSearchId.getText());
            System.out.println(customerDTO.getFistName());
            System.out.println(customerDTO.getFistName()!=null);
            if (customerDTO.getFistName()!=null){
                txtFistName.setText(customerDTO.getFistName());
                txtLastName.setText(customerDTO.getLastName());
                txtcontacNumber.setText(customerDTO.getContact());
                txtCity.setText(customerDTO.getCity());
                txtLane.setText(customerDTO.getLane());
                txtStreet.setText(customerDTO.getStreet());
                txtSearchId.setEditable(false);
            }else {
                txtSearchId.setText("");
                new Alert(Alert.AlertType.WARNING,"enter Correct Id").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public void SearchOnAction(ActionEvent actionEvent) {
        setData();
    }

    public void closeOnMouseCick(MouseEvent mouseEvent) {
        CustomerFormController.getInstance().pane.getChildren().clear();
        CustomerFormController.getInstance().navigationVisibleTrueController();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
