package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import lk.ijse.BookShop.bo.custom.SupplierBO;
import lk.ijse.BookShop.bo.custom.impl.SupplierBOImpl;
import lk.ijse.BookShop.dao.custom.SupplierDAO;
import lk.ijse.BookShop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.BookShop.model.SupplierDTO;


import java.sql.SQLException;


public class SupplierUpdateFormController {
   // SupplierDAO supplierDAO = new SupplierDAOImpl();
     SupplierBO supplierBO = new SupplierBOImpl();
    public JFXTextField txtcompany;
    public JFXTextField txtLocation;
    public JFXTextField txtEamil;
    public JFXTextField txtSearchId;
    public JFXTextField txtContactNumber;

    public void btnDonOnAction(ActionEvent actionEvent) {
        try {
            if (supplierBO.update(new SupplierDTO(
                    txtSearchId.getText(),
                    txtContactNumber.getText(),
                    txtcompany.getText(),
                    txtEamil.getText(),
                    txtLocation.getText()

            ))) {
                SupplierFormController.getInstance().pane.getChildren().clear();
                SupplierFormController.getInstance().navigationVisibleTrueController();
                SupplierFormController.getInstance().loadDataTable();


                new Alert(Alert.AlertType.INFORMATION, "OK").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        try {
            SupplierDTO supplierDTO = supplierBO.get(txtSearchId.getText());
            if (!supplierDTO.getSup_Id().equals(null)) {
                txtcompany.setText(supplierDTO.getCompany());
                txtContactNumber.setText(supplierDTO.getContact());
                txtEamil.setText(supplierDTO.getEmail());
                txtLocation.setText(supplierDTO.getLocation());
                txtSearchId.setEditable(false);
            } else {
                new Alert(Alert.AlertType.WARNING, "something Wong").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeOnMouseCick(MouseEvent mouseEvent) {
        SupplierFormController.getInstance().pane.getChildren().clear();
        SupplierFormController.getInstance().navigationVisibleTrueController();

    }
}
