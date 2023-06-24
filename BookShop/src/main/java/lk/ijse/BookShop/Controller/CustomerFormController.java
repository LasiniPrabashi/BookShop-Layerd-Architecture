package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.bo.custom.impl.CustomerBOImpl;
import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.BookShop.model.CustomerDTO;
import lk.ijse.BookShop.tm.CustomerTm;
import lk.ijse.BookShop.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    //CustomerDAO customerDAO = new CustomerDAOImpl();
    CustomerBO customerBO = new CustomerBOImpl();
    private static CustomerFormController controller;
    public Pane pane;
    public Text txtCustCount;
    ObservableList<CustomerTm> list = FXCollections.observableArrayList();
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private TableView tbl;
    @FXML
    private TableColumn tblid;
    @FXML
    private TableColumn tblfName;
    @FXML
    private TableColumn tbllName;
    @FXML
    private TableColumn tblcity;
    @FXML
    private TableColumn tblcontactNumber;
    @FXML
    private TableColumn tbloption;
    @FXML
    private TableColumn tbloption2;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;


    public CustomerFormController() {
        controller = this;
    }

    public static CustomerFormController getInstance() {
        return controller;
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        navigationVisibleFalseController();
        Navigation.onTheTopNavigation(pane, "CustomeAddFrom.fxml");


    }

    public void navigationVisibleFalseController() {
        pane1.setVisible(false);
        pane2.setVisible(false);
        btnAdd.setVisible(false);
        btnUpdate.setVisible(false);
    }

    public void navigationVisibleTrueController() {
        pane1.setVisible(true);
        pane2.setVisible(true);
        btnAdd.setVisible(true);
        btnUpdate.setVisible(true);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        navigationVisibleFalseController();
        try {
            FXMLLoader loader = new FXMLLoader(CustomerFormController.class.getResource("/view/CustomerUpdateFrom.fxml"));
            Parent root = loader.load();
            pane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void txtsearchKeyReleased(KeyEvent event) {
        tbl.getItems().clear();
        list.clear();
        try {
            ArrayList<String> ids= customerBO.getSearchIds(txtSearch.getText());
            for (int i = 0; i < ids.size(); i++) {
                setCustomerData(ids.get(i));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadDataTable() {
        tbl.getItems().clear();
        list.clear();
        getAllIds();
    }

    public void setCustCount() {
        try {
            txtCustCount.setText(customerBO.getCustomerCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getAllIds() {
        try {
            ArrayList<String> list = customerBO.getAllId();
            for (int i = 0; i < list.size(); i++) {
                setCustomerData(list.get(i));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setCustomerData(String id) {
        try {
            CustomerDTO customerDTO = customerBO.get(id);
            CustomerTm tm = new CustomerTm();
            tm.setCust_Id(customerDTO.getCust_Id());
            tm.setFistName(customerDTO.getFistName());
            tm.setLastName(customerDTO.getLastName());
            tm.setCity(customerDTO.getCity());
            tm.setContact(customerDTO.getContact());

            Button button = new Button();
            button.setText("Delete");
            button.setStyle("   -fx-text-fill:#ffff ;\n" +
                    "   -fx-font-weight: bold;\n" +
                    "   -fx-font-size: 15;\n" +
                    "   -fx-background-color:#F13030 ;\n" +
                    "   -fx-background-radius: 20;");
            button.setOnAction(actionEvent -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You sure");

                alert.showAndWait();
                if (alert.getResult().equals(ButtonType.OK)) {
                    try {
                        if (customerBO.remove(customerDTO.getCust_Id())) {
                            loadDataTable();
                            new Alert(Alert.AlertType.INFORMATION, "Deleted").show();
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            tm.setOption(button);

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
            tm.setView(button2);
            list.add(tm);


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataTable();
        setTablaPropriety();
        setCustCount();
    }

    private void setTablaPropriety() {
        tblid.setCellValueFactory(new PropertyValueFactory<>("Cust_Id"));
        tblfName.setCellValueFactory(new PropertyValueFactory<>("fistName"));
        tbllName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tblcontactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tbloption.setCellValueFactory(new PropertyValueFactory<>("Option"));
        tbloption2.setCellValueFactory(new PropertyValueFactory<>("view"));
        tbl.setItems(list);
    }

}
