package lk.ijse.BookShop.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import lk.ijse.BookShop.bo.custom.AttendanceBO;
import lk.ijse.BookShop.bo.custom.EmployeeBO;
import lk.ijse.BookShop.bo.custom.SalaryBO;
import lk.ijse.BookShop.bo.custom.impl.AttendanceBOImpl;
import lk.ijse.BookShop.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.BookShop.bo.custom.impl.SalaryBOImpl;
import lk.ijse.BookShop.model.EmployeeDTO;
import lk.ijse.BookShop.model.SalaryDTO;
import lk.ijse.BookShop.tm.SalaryTm;
import lk.ijse.BookShop.util.DateTimeUtil;
import lk.ijse.BookShop.util.RegexUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SalaryFormController implements Initializable {
    //EmployeeSalaryDAO employeeSalaryDAO = new EmployeeSalaryDAOImpl();

    SalaryBO salaryBO = new SalaryBOImpl();

    //EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    EmployeeBO employeeBO = new EmployeeBOImpl();

    //AttendanceDAO attendanceDAO = new AttendanceDAOImpl();
    AttendanceBO attendanceBO = new AttendanceBOImpl();

    public JFXTextField txtSearch;
    public JFXButton btnAdd;
    public TableColumn tblid;
    public TableColumn tblBonus;
    public TableColumn tblDate;
    public TableColumn tblTime;
    public TableColumn tblSalary;
    public TableView tbl;
    public JFXComboBox cmbIds;
    public Text txtName;
    public Text txtAttCount;
    public Text txtSalary;
    public JFXTextField txtDSalary;
    public JFXTextField txtBonus;
    public JFXButton btnDone;
    ObservableList<SalaryTm> list= FXCollections.observableArrayList();

    public void txtsearchKeyReleased(KeyEvent keyEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        try {
            if (salaryBO.add(new SalaryDTO(
                    id(),
                    (String) cmbIds.getValue(),
                    txtDSalary.getText(),
                    txtBonus.getText(),
                    DateTimeUtil.dateNow(),
                    DateTimeUtil.timeNow(),
                    txtSalary.getText()

            ))) {
                new Alert(Alert.AlertType.INFORMATION, "Ok").show();
                txtSalary.setText("");
                txtDSalary.setText("");
                txtName.setText("");
                txtAttCount.setText("00.00");
                txtBonus.setText("");

                cmbIds.getItems().clear();
                loadIds();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private String id() {
        try {
            ArrayList<String> allId = salaryBO.getAllId();
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
        }
        return null;
    }

    public void idOnAction(ActionEvent actionEvent) {
        try {
            EmployeeDTO employeeDTO = employeeBO.get((String) cmbIds.getValue());
            txtName.setText(employeeDTO.getFistName() + " " + employeeDTO.getLastName());
            String count = attendanceBO.getEmpAttCount((String) cmbIds.getValue());
            txtAttCount.setText(count);

        } catch (SQLException throwables) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadIds();
        loadTableProperty();
        getAllIdsForLoadTable();
    }

    private void getAllIdsForLoadTable() {
        try {
            ArrayList<String> allId = salaryBO.getAllSalaryID();
            for (int i = 0; i < allId.size(); i++) {
                loadData(allId.get(i));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //
    private void loadData(String id) {
        System.out.println(id);
        try {
            SalaryDTO data = salaryBO.getData(id);
            SalaryTm salaryTm = new SalaryTm();
            System.out.println(data);
            System.out.println(data.getSalary_Id());
            salaryTm.setId(data.getSalary_Id());
            salaryTm.setBonus(data.getBonus());
            salaryTm.setDate(data.getDate());
            salaryTm.setTime(data.getTime());
            salaryTm.setTotal_salary(data.getTotal_salary());
            list.add(salaryTm);


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void loadTableProperty() {
        tblid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBonus.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tblSalary.setCellValueFactory(new PropertyValueFactory<>("total_salary"));
        tbl.setItems(list);

    }

    private void loadIds() {
        try {
            ArrayList<String> ids = employeeBO.getAllId();
            ArrayList<String> aIds = attendanceBO.getAllEmpId();
            for (int i = 0; i < ids.size(); i++) {
                for (int j = 0; j < aIds.size(); j++) {
                    if (ids.get(i).equals(aIds.get(j))) {
                        ids.remove(i);
                    }
                }
            }
            cmbIds.getItems().addAll(ids);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void DailySalaryOnkeyReleasd(KeyEvent keyEvent) {
        try {
            if (!txtDSalary.getText().equals("")) {
                double salary = Double.parseDouble(txtDSalary.getText()) * Double.parseDouble(txtAttCount.getText());
                txtSalary.setText(String.valueOf(salary));
            } else {
                txtSalary.setText("0.00");
            }
        } catch (NumberFormatException e) {
        }

    }

    public void BonusKeyReleased(KeyEvent keyEvent) {
        System.out.println("BonusKeyReleased");
        RegexUtil.regex(btnAdd,txtBonus,txtBonus.getText(),"([+-]?[0-9]+(?:\\.[0-9]*)?)","-fx-text-fill:black");
    }

    public void DalySalaryKeyReleased(KeyEvent keyEvent) {
        System.out.println("DalySalaryKeyReleased");
        RegexUtil.regex(btnAdd,txtDSalary,txtDSalary.getText(),"([+-]?[0-9]+(?:\\.[0-9]*)?)","-fx-text-fill:black");
    }
}
