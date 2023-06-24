package lk.ijse.BookShop.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.BookShop.dao.custom.LoginDAO;
import lk.ijse.BookShop.dao.custom.impl.LoginDAOImpl;
import lk.ijse.BookShop.model.LoginDTO;
import lk.ijse.BookShop.util.Navigation;
import lk.ijse.BookShop.util.RegexUtil;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

   LoginDAO loginDAO = new LoginDAOImpl();


    public TextField Admin_name;
    public TextField Admin_password;


    public void btnStartOnAction(ActionEvent actionEvent) throws IOException {

      LoginDTO loginDTO = new LoginDTO();
      loginDTO.setUserName(Admin_name.getText());
       loginDTO.setPassword(Admin_password.getText());

       try {
           String role = loginDAO.check(loginDTO);

           if (role.equals("Admin 01")){
                Navigation.switchNavigation("dashbord_form.fxml",actionEvent);
           }else {
               new Alert(Alert.AlertType.ERROR, "Invalid username or password ").show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
   }


}
