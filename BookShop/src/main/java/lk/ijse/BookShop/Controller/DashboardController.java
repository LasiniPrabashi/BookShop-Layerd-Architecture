package lk.ijse.BookShop.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lk.ijse.BookShop.dao.custom.AttendanceDAO;
import lk.ijse.BookShop.dao.custom.OrderDAO;
import lk.ijse.BookShop.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.OrderDAOImpl;
import lk.ijse.BookShop.util.DateTimeUtil;
import lk.ijse.BookShop.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardController implements Initializable  {
    AttendanceDAO attendanceDAO = new AttendanceDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    public Pane pane;
    public GridPane btnOnActions;
    public Text txtAttCount;
    public Label txtTime;
    public Label txtDate;
    public Label txtOrderCount;
    public LineChart chart;


    public void btnHomeOnAction(ActionEvent actionEvent) {
        pane.getChildren().clear();
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"EmployeeForm.fxml");
    }

    public void CustomerOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"CustomerForm.fxml");

    }

    public void ItemOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"ItemForm.fxml");
    }


    public void SupplierOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"SupplierForm.fxml");
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"OrderForm.fxml");
    }

    public void btnSalaryOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"SalaryForm.fxml");
    }

    public void btnAttendanceOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane,"AttendaceFrom.fxml");
    }

    public void setEmpCount() {
        try {
            txtAttCount.setText(attendanceDAO.getEmpAttCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

    }

 }

   /* public void setOrderCount() {
        try {
            txtOrderCount.setText(OrderModel.getOrderCount());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEmpCount();
        setData();
        txtDate.setText(DateTimeUtil.dateNow());
        txtTime.setText(DateTimeUtil.timeNow());
    }

    private void setData() {
        XYChart.Series series = new XYChart.Series();
        series.setName("Order");
        try {
            String dateNow = DateTimeUtil.dateNow();
            String[] date = dateNow.split("-");
            int days = DateTimeUtil.getDays(Integer.parseInt(date[0]), Integer.parseInt(date[1]));
            String count = null;
            for (int i = 0; i < days; i++) {
                count = orderDAO.getCustomerOrder(i);
                int ii = i;
                ii++;
                /*if (count==null){
                    count="0";
                }*/
                series.getData().add(new XYChart.Data(String.valueOf(ii), Double.parseDouble(count)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        chart.getData().add(series);

     }
}
