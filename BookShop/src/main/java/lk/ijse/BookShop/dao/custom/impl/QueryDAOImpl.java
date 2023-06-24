package lk.ijse.BookShop.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.BookShop.dao.custom.QueryDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.CustomEntityDTO;
import lk.ijse.BookShop.tm.AttendanceTm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {

    public CustomEntityDTO get(String id) throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT a.attendance_Id,e.fristName,e.lastName,a.date,a.workingHourse FROM employeeattendance a JOIN employee e On a.Emp_Id = e.Emp_Id where attendance_Id=?", id);
        CustomEntityDTO customEntityDTO = new CustomEntityDTO();
       ObservableList<AttendanceTm> list = FXCollections.observableArrayList();

       while (set.next()) {
            customEntityDTO.setId(set.getString(1));
            customEntityDTO.setFist_name(set.getString(2));
            customEntityDTO.setLast_name(set.getString(3));
            customEntityDTO.setDate(set.getString(4));
           customEntityDTO.setTime(set.getString(5));

        }
        return customEntityDTO;
    }

}
