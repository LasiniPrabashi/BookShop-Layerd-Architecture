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
import lk.ijse.BookShop.bo.custom.ItemBO;
import lk.ijse.BookShop.bo.custom.impl.ItemBOImpl;
import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.dao.custom.ItemDAO;
import lk.ijse.BookShop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.BookShop.model.ItemDTO;
import lk.ijse.BookShop.tm.ItemTm;
import lk.ijse.BookShop.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {
   // ItemDAO itemDAO = new ItemDAOImpl();
    ItemBO itemBO = new ItemBOImpl();
    private static ItemFormController controller;
    public Pane pane;
    public TableColumn tblIName;
    public TableColumn tblMType;
    public TableColumn tblQOH;
    public TableColumn tblDiscription;
    public TableColumn tblUnitPrice;
    @FXML
    public JFXTextField txtSearch;
    public Text txtItemCount;
    ObservableList<ItemTm> list = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private TableView tbl;
    @FXML
    private TableColumn tblid;


    @FXML
    private TableColumn tbloption;

    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;


    public ItemFormController() {
        controller = this;
    }

    public static ItemFormController getInstance() {
        return controller;
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        navigationVisibleFalseController();
        Navigation.onTheTopNavigation(pane, "ItemAddFrom.fxml");


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
        Navigation.onTheTopNavigation(pane,"ItemUpdateFrom.fxml");
    }

    @FXML
    void txtsearchKeyReleased(KeyEvent event) {
        tbl.getItems().clear();
        list.clear();
        try {
            ArrayList<String> ids= itemBO.getSearchIds(txtSearch.getText());
            for (int i = 0; i < ids.size(); i++) {
                setItemData(ids.get(i));
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

    public void setItemCount() {
        try {
            txtItemCount.setText(itemBO.getItemCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getAllIds() {
        try {
            ArrayList<String> list = itemBO.getAllId();
            for (int i = 0; i < list.size(); i++) {
                setItemData(list.get(i));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setItemData(String id) {
        try {
            ItemDTO itemDTO = itemBO.get(id);
            ItemTm tm = new ItemTm();
            tm.setItem_Id(itemDTO.getItem_Id());
            tm.setItemName(itemDTO.getItemName());
            tm.setDiscription(itemDTO.getDiscription());
            tm.setMatiriyalType(itemDTO.getMatiriyalType());
            tm.setQtyOnHand(itemDTO.getQtyOnHand());
            tm.setUnitPrice(itemDTO.getUnitPrice());

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
                        if (itemBO.remove(itemDTO.getItem_Id())) {
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

            tm.setView(button);
            list.add(tm);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataTable();
        setTablaPropriety();
        setItemCount();
    }

    private void setTablaPropriety() {
        tblid.setCellValueFactory(new PropertyValueFactory<>("item_Id"));
        tblIName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblMType.setCellValueFactory(new PropertyValueFactory<>("MatiriyalType"));
        tblDiscription.setCellValueFactory(new PropertyValueFactory<>("discription"));
        tblQOH.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        tbloption.setCellValueFactory(new PropertyValueFactory<>("view"));
        tbl.setItems(list);
    }
}
