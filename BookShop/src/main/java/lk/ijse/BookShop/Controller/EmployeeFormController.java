package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.BookShop.bo.custom.EmployeeBO;
import lk.ijse.BookShop.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.BookShop.dao.custom.EmployeeDAO;
import lk.ijse.BookShop.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.BookShop.model.EmployeeDTO;
import lk.ijse.BookShop.tm.EmployeeTm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeeFormController implements Initializable {
   // EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    EmployeeBO employeeBO = new EmployeeBOImpl();
    public Pane pane;
    public JFXButton btnAdd;
    public Pane pane1;
    public Pane pane2;
    public JFXButton btnUpdate;
    public TableColumn tbloption2;
    public JFXTextField txtSearch;
    public Text txtEmpCount;

    ObservableList<EmployeeTm>list= FXCollections.observableArrayList();

    private static EmployeeFormController controller;
    public TableView tbl;
    public TableColumn tblid;
    public TableColumn tblfName;
    public TableColumn tbllName;
    public TableColumn tblcity;
    public TableColumn tblcontactNumber;
    public TableColumn tbloption;

    public EmployeeFormController() {
        controller=this;
    }
    public static EmployeeFormController getInstance(){
        return controller;
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        btnAdd.setVisible(false);
        btnUpdate.setVisible(false);
        pane1.setVisible(false);
        pane2.setVisible(false);
        try {
            FXMLLoader loader = new FXMLLoader(DashboardController.class.getResource("/view/EmployeeAddFrom.fxml"));
            Parent root = loader.load();
            pane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEmpCount();
        getAllIds();
        tblid.setCellValueFactory(new PropertyValueFactory<>("Emp_Id"));
        tblfName.setCellValueFactory(new PropertyValueFactory<>("fistName"));
        tbllName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tblcontactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tbloption.setCellValueFactory(new PropertyValueFactory<>("Option"));
        tbloption2.setCellValueFactory(new PropertyValueFactory<>("view"));
        tbl.setItems(list);
    }

    public void setEmpCount() {
        try {
            txtEmpCount.setText(employeeBO.getEmployeeCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getAllIds() {
        try {
            ArrayList<String> list= employeeBO.getAllId();
            for (int i = 0; i < list.size(); i++) {
                setEmployeeData(list.get(i));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setEmployeeData(String id) {
        try {
            EmployeeDTO employeeDTO=employeeBO.get(id);
            EmployeeTm tm=new EmployeeTm();
            tm.setEmp_Id(employeeDTO.getEmp_Id());
            tm.setFistName(employeeDTO.getFistName());
            tm.setLastName(employeeDTO.getLastName());
            tm.setCity(employeeDTO.getCity());
            tm.setContact(employeeDTO.getContact());

            Button button=new Button();
            button.setText("Delete");
            button.setStyle("   -fx-text-fill:#ffff ;\n" +
                    "   -fx-font-weight: bold;\n" +
                    "   -fx-font-size: 15;\n" +
                    "   -fx-background-color:#F13030 ;\n" +
                    "   -fx-background-radius: 20;");
            button.setOnAction(actionEvent -> {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure");

                alert.showAndWait();
                if (alert.getResult().equals(ButtonType.OK)){
                    try {
                        if (employeeBO.remove(employeeDTO.getEmp_Id())){
                           loadDataTable();
                            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            tm.setOption(button);

            Button button2=new Button();
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

    public void loadDataTable() {
        list.clear();
        tbl.getItems().clear();
        getAllIds();
        setEmpCount();
    }

    public void txtsearchKeyReleased(KeyEvent keyEvent) {
        try {
            list.clear();
            tbl.getItems().clear();
            ArrayList<String>id=employeeBO.getSearchIds(txtSearch.getText());

            for (int i = 0; i < id.size(); i++) {
                setEmployeeData(id.get(i));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        btnAdd.setVisible(false);
        btnUpdate.setVisible(false);
        pane1.setVisible(false);
        pane2.setVisible(false);
        try {
            FXMLLoader loader = new FXMLLoader(DashboardController.class.getResource("/view/EmployeeUpdateFrom.fxml"));
            Parent root = loader.load();
            pane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
