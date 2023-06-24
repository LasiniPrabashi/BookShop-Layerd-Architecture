package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.BookShop.bo.custom.EmployeeBO;
import lk.ijse.BookShop.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.BookShop.dao.custom.EmployeeDAO;
import lk.ijse.BookShop.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.BookShop.model.EmployeeDTO;
import lk.ijse.BookShop.util.RegexUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddFromController {

   // EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    EmployeeBO employeeBO = new EmployeeBOImpl();
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
            if (employeeBO.add(new EmployeeDTO(
                    id(),
                    txtFistName.getText(),
                    txtLastName.getText(),
                    txtStreet.getText(),
                    txtCity.getText(),
                    txtLane.getText(),
                    txtcontacNumber.getText()

            ))) {
                EmployeeFormController.getInstance().pane.getChildren().clear();
                EmployeeFormController.getInstance().btnUpdate.setVisible(true);
                EmployeeFormController.getInstance().btnAdd.setVisible(true);
                EmployeeFormController.getInstance().pane2.setVisible(true);
                EmployeeFormController.getInstance().pane1.setVisible(true);
                EmployeeFormController.getInstance().loadDataTable();

                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wong").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private String id() {
        try {
            ArrayList<String> allId = employeeBO.getAllId();
            String lastId = null;
            for (int i = 0; i < allId.size(); i++) {
                lastId = allId.get(i);
                System.out.println(allId.get(i));
            }
            try {
                String[] e00s = lastId.split("e00");
                int idIndex = Integer.parseInt(e00s[1]);
                idIndex++;
                System.out.println(idIndex);
                return "e00" + idIndex;
            } catch (Exception e) {
                return "e001";
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void closeOnMouseCick(MouseEvent mouseEvent) {
        EmployeeFormController.getInstance().pane.getChildren().clear();
        EmployeeFormController.getInstance().btnUpdate.setVisible(true);
        EmployeeFormController.getInstance().btnAdd.setVisible(true);
        EmployeeFormController.getInstance().pane2.setVisible(true);
        EmployeeFormController.getInstance().pane1.setVisible(true);
    }

    public void fistNameKeyReleased(KeyEvent keyEvent) {
        System.out.println("fistNameKeyReleased");
        RegexUtil.regex(btnDone, txtFistName, txtFistName.getText(), "[a-zA-Z-'`]+[ a-zA-Z-'`]", "-fx-text-fill:black");
    }

    public void lastNameKeyReleased(KeyEvent keyEvent) {
        System.out.println("lastNameKeyReleased");
        RegexUtil.regex(btnDone, txtLastName, txtLastName.getText(), "[a-zA-Z-'`]+[ a-zA-Z-'`]", "-fx-text-fill:black");
    }

    public void CityKeyReleased(KeyEvent keyEvent) {
        System.out.println("CityKeyReleased");
        RegexUtil.regex(btnDone, txtCity, txtCity.getText(), "[a-zA-Z-'`]+[ a-zA-Z-'`]", "-fx-text-fill:black");
    }

    public void laneKeyReleased(KeyEvent keyEvent) {
        System.out.println("laneKeyReleased");
        RegexUtil.regex(btnDone, txtLane, txtLane.getText(), "[a-zA-Z-'`]+[ a-zA-Z-'`]", "-fx-text-fill:black");
    }

    public void StreetKeyReleased(KeyEvent keyEvent) {
        System.out.println("StreetKeyReleased");
        RegexUtil.regex(btnDone, txtStreet, txtStreet.getText(), "[a-zA-Z-'`]+[ a-zA-Z-'`]", "-fx-text-fill:black");
    }

    public void ContactNumberKeyReleased(KeyEvent keyEvent) {
        System.out.println("ContactNumberKeyReleased");
        RegexUtil.regex(btnDone, txtcontacNumber, txtcontacNumber.getText(), "^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$", "-fx-text-fill:black");
    }

}


