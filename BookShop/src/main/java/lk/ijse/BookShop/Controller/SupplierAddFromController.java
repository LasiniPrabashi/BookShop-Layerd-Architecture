package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.BookShop.bo.custom.SupplierBO;
import lk.ijse.BookShop.bo.custom.impl.SupplierBOImpl;
import lk.ijse.BookShop.dao.custom.SupplierDAO;
import lk.ijse.BookShop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.BookShop.model.SupplierDTO;
import lk.ijse.BookShop.util.RegexUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierAddFromController {

    //SupplierDAO supplierDAO = new SupplierDAOImpl();
   SupplierBO supplierBO = new SupplierBOImpl();
    public JFXTextField txtcompany;
    public JFXTextField txtlocation;
    public JFXTextField txtemail;
    public JFXTextField txtcontacNumber;
    public JFXButton btnDone;


    public void btnDonOnAction(ActionEvent actionEvent) {

       try {
            if (supplierBO.add(new SupplierDTO(
                    id(),
                    txtcontacNumber.getText(),
                    txtcompany.getText(),
                    txtemail.getText(),
                    txtlocation.getText()


            ))) {
                SupplierFormController.getInstance().pane.getChildren().clear();
                SupplierFormController.getInstance().navigationVisibleTrueController();
                SupplierFormController.getInstance().loadDataTable();


                new Alert(Alert.AlertType.CONFIRMATION, "Supplier Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wong").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private String id() {
        try {
            ArrayList<String> allId = supplierBO.getAllId();
            String lastId = null;
            for (int i = 0; i < allId.size(); i++) {
                lastId = allId.get(i);
                System.out.println(allId.get(i));
            }
           try {
                String[] e00s = lastId.split("S00");
                int idIndex = Integer.parseInt(e00s[1]);
                idIndex++;
                System.out.println(idIndex);
                return "S00" + idIndex;
           } catch (Exception e) {
                return "S001";
            }
       } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            }return null;
    }

    public void closeOnMouseCick(MouseEvent mouseEvent) {
       SupplierFormController.getInstance().pane.getChildren().clear();
       SupplierFormController.getInstance().navigationVisibleTrueController();
   }

    public void companyKeyReleased(KeyEvent keyEvent) {
        System.out.println("companyKeyReleased");
        RegexUtil.regex(btnDone,txtcompany,txtcompany.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");
    }

    public void locationKeyReleased(KeyEvent keyEvent) {
        System.out.println("locationKeyReleased");
        RegexUtil.regex(btnDone,txtlocation,txtlocation.getText(),"[a-zA-Z-'`]+[ a-zA-Z-'`]","-fx-text-fill:black");
    }

    public void ContactNumberKeyReleased(KeyEvent keyEvent) {
        System.out.println("ContactNumberKeyReleased");
        RegexUtil.regex(btnDone,txtcontacNumber,txtcontacNumber.getText(),"^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$","-fx-text-fill:black");
    }

    public void emailKeyReleased(KeyEvent keyEvent) {
        System.out.println("emailKeyReleased");
        RegexUtil.regex(btnDone,txtemail,txtemail.getText(),"([a-zA-Z0-9]+[\\.|_|\\-]*)*@gmail\\.(com|es)?","-fx-text-fill:black");
    }
}
