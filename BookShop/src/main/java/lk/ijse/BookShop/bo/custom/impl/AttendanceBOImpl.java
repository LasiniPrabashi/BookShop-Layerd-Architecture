package lk.ijse.BookShop.bo.custom.impl;

import lk.ijse.BookShop.bo.custom.AttendanceBO;
import lk.ijse.BookShop.dao.custom.AttendanceDAO;
import lk.ijse.BookShop.dao.custom.CustomerDAO;
import lk.ijse.BookShop.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.BookShop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.BookShop.model.AttendanceDTO;
import lk.ijse.BookShop.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {
    AttendanceDAO attendanceDAO = new AttendanceDAOImpl();

    public boolean add(AttendanceDTO attendanceDTO) throws SQLException, ClassNotFoundException {
        return attendanceDAO.add(attendanceDTO);
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return attendanceDAO.getAllId();
    }

    @Override
    public ArrayList<String> getTodayAllId() throws SQLException, ClassNotFoundException {
        return attendanceDAO.getTodayAllId();
    }

    public AttendanceDTO get(String id) throws SQLException, ClassNotFoundException {
        return attendanceDAO.get(id);
    }

    public boolean update(AttendanceDTO attendanceDTO) throws SQLException, ClassNotFoundException {
        return attendanceDAO.update(attendanceDTO);
    }

    public boolean remove(String cust_id) throws SQLException, ClassNotFoundException {
        return attendanceDAO.remove(cust_id);
    }

    @Override
    public String getAttendanceCount() throws SQLException, ClassNotFoundException {
        return attendanceDAO.getAttendanceCount();
    }

    @Override
    public String getEmpCount() throws SQLException, ClassNotFoundException {
        return attendanceDAO.getEmpCount();
    }

    @Override
    public String getEmpAttCount(String value) throws SQLException, ClassNotFoundException {
        return attendanceDAO.getEmpAttCount();
    }

    @Override
    public ArrayList<String> getAllEmpId() throws SQLException, ClassNotFoundException {
        return attendanceDAO.getAllEmpId();
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        return attendanceDAO.getSearchIds(id);
    }
}
