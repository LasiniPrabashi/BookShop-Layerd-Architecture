package lk.ijse.BookShop.bo.custom;

import lk.ijse.BookShop.bo.SuperBO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.AttendanceDTO;
import lk.ijse.BookShop.util.DateTimeUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBO extends SuperBO {
    public boolean add(AttendanceDTO Attendance) throws SQLException, ClassNotFoundException;
    public AttendanceDTO get(String s) throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getTodayAllId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException;
    public boolean update(AttendanceDTO dto) throws SQLException, ClassNotFoundException;
    public boolean remove(String s) throws SQLException, ClassNotFoundException;
    public  String getAttendanceCount() throws SQLException, ClassNotFoundException;

    public  String getEmpCount() throws SQLException, ClassNotFoundException;

    String getEmpAttCount(String value)throws SQLException,ClassNotFoundException;

    ArrayList<String> getAllEmpId() throws SQLException,ClassNotFoundException;
}
