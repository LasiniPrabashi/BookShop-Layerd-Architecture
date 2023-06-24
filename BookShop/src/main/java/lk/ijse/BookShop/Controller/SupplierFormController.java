package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.BookShop.bo.custom.SupplierBO;
import lk.ijse.BookShop.bo.custom.impl.SupplierBOImpl;
import lk.ijse.BookShop.dao.custom.SupplierDAO;
import lk.ijse.BookShop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.BookShop.model.SupplierDTO;
import lk.ijse.BookShop.tm.SupplierTm;
import lk.ijse.BookShop.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {
    //SupplierDAO supplierDAO = new SupplierDAOImpl();

    SupplierBO supplierBO = new SupplierBOImpl();

    private static SupplierFormController controller;
    public Pane pane;
    public TableColumn tblId;
    public TableColumn tblcompany;
    public TableColumn tbllocation;
    public TableColumn tblemail;
    public JFXTextField txtcompany;
    public JFXTextField txtemail;
    public JFXTextField txtcontactNumber;
    public Text txtSupCount;
    ObservableList<SupplierTm> list = FXCollections.observableArrayList();
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private TableView tbl;

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

    public SupplierFormController() {
        controller = this;
    }

    public static SupplierFormController getInstance() {
        return controller;
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        navigationVisibleFalseController();
        Navigation.onTheTopNavigation(pane, "SupplierAddFrom.fxml");


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
        Navigation.onTheTopNavigation(pane, "SupplierUpdateFrom.fxml");
    }

    @FXML
    void txtsearchKeyReleased(KeyEvent event) {
        tbl.getItems().clear();
        list.clear();
        try {
            ArrayList<String> searchIds = supplierBO.getSearchIds(txtSearch.getText());
            if (!searchIds.isEmpty()){
                for (int i = 0; i < searchIds.size(); i++) {
                    setCustomerData(searchIds.get(i));
                }
            }  if (txtSearch.getText().equals("")){
                System.out.println("else");
                loadDataTable();
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

    public void setSupCount() {
        try {
            txtSupCount.setText(supplierBO.getSupplierCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getAllIds() {
        // tbl.getItems().clear();
        //  list.clear();
        try {
            ArrayList<String> list = supplierBO.getAllId();

            for (int i = 0; i < list.size(); i++) {
                setCustomerData(list.get(i));

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        tbl.refresh();
    }

    private void setCustomerData(String id) {

        try {
            SupplierDTO supplierDTO = supplierBO.get(id);
            SupplierTm tm = new SupplierTm();
            tm.setSup_Id(supplierDTO.getSup_Id());
            tm.setContact(supplierDTO.getContact());
            tm.setCompany(supplierDTO.getCompany());
            tm.setEmail(supplierDTO.getEmail());
            tm.setLocation(supplierDTO.getLocation());

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
                        if (supplierBO.remove(supplierDTO.getSup_Id())) {
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
        setSupCount();
    }

    private void setTablaPropriety() {
        tblId.setCellValueFactory(new PropertyValueFactory<>("Sup_Id"));
        tblcompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        tbllocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        tblemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblcontactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tbloption.setCellValueFactory(new PropertyValueFactory<>("Option"));
        tbloption2.setCellValueFactory(new PropertyValueFactory<>("view"));
        tbl.setItems(list);
    }
}
