package lk.ijse.BookShop.dao.custom;

import lk.ijse.BookShop.dao.CrudDAO;
import lk.ijse.BookShop.model.AttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceDAO extends CrudDAO<AttendanceDTO,String> {

    String getEmpAttCount(String value) throws SQLException,ClassNotFoundException;

    public String getEmpCount()throws SQLException,ClassNotFoundException;

    public String getAttendanceCount()throws SQLException,ClassNotFoundException;

    ArrayList<String> getTodayAllId()throws SQLException,ClassNotFoundException;

    public String getEmpAttCount() throws SQLException,ClassNotFoundException;

    ArrayList<String> getAllEmpId() throws SQLException,ClassNotFoundException;
}
