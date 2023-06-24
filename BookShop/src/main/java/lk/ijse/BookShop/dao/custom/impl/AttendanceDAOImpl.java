package lk.ijse.BookShop.dao.custom.impl;

import lk.ijse.BookShop.dao.custom.AttendanceDAO;
import lk.ijse.BookShop.dao.custom.impl.util.SQLUtil;
import lk.ijse.BookShop.model.AttendanceDTO;
import lk.ijse.BookShop.util.DateTimeUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO {
    public boolean add(AttendanceDTO Attendance) throws SQLException, ClassNotFoundException {
        return SQLUtil.crudUtil("INSERT INTO  EmployeeAttendance VALUES (?,?,?,?)",
                Attendance.getAttendance_Id(),
                Attendance.getEmp_Id(),
                Attendance.getWorkingHourse(),
                Attendance.getDate()
        );
    }

    @Override
    public AttendanceDTO get(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        ResultSet set = SQLUtil.crudUtil("SELECT attendance_Id FROM EmployeeAttendance ORDER BY LENGTH(attendance_Id),attendance_Id");

        while (set.next()) {
            list.add(set.getString(1));
        }

        return list;
    }

    public ArrayList<String> getTodayAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        ResultSet set = SQLUtil.crudUtil("SELECT attendance_Id FROM EmployeeAttendance WHERE date=?", DateTimeUtil.dateNow());

        while (set.next()) {
            list.add(set.getString(1));
        }

        return list;
    }

    public ArrayList<String> getSearchIds(String id) throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        String editId = id + "%";
        ResultSet set = SQLUtil.crudUtil("SELECT  attendance_Id FROM EmployeeAttendance INNER JOIN Employee WHERE attendance_Id LIKE ? OR Employee.Emp_Id LIKE ? OR  fristName LIKE ? OR lastName LIKE ?", editId, editId, editId, editId);
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    @Override
    public boolean update(AttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

//   public EmployeeAttendanceTm get(String id) throws SQLException, ClassNotFoundException {
//        ResultSet set = SQLUtil.crudUtil("SELECT a.attendance_Id,e.fristName,e.lastName,a.date,a.workingHourse FROM employeeattendance a JOIN employee e On a.Emp_Id = e.Emp_Id where attendance_Id=?", id);
//        EmployeeAttendanceTm attendance = new EmployeeAttendanceTm();
//
//        ObservableList<EmployeeAttendanceTm> list = FXCollections.observableArrayList();
//
//
//        while (set.next()) {
//            attendance.setId(set.getString(1));
//            attendance.setFist_name(set.getString(2));
//            attendance.setLast_name(set.getString(3));
//            attendance.setDate(set.getString(4));
//            attendance.setTime(set.getString(5));
//
//        }
//        return attendance;
//    }

    @Override
    public boolean remove(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  String getAttendanceCount() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT COUNT(Emp_Id) FROM EmployeeAttendance");
        while (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    public  String getEmpCount() throws SQLException, ClassNotFoundException {
        ResultSet set = SQLUtil.crudUtil("SELECT COUNT(Emp_Id) FROM Employee");
        while (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    public  ArrayList<String> getAllEmpId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        String month = DateTimeUtil.dateNow();
        String[] split = month.split("-");
        System.out.println(split[0] + "-" + split[1] + "%");
        ResultSet set = SQLUtil.crudUtil("SELECT Emp_Id FROM salary where date LIKE ?", split[0] + "-" + split[1] + "%");

        while (set.next()) {
            list.add(set.getString(1));
        }

        return list;
    }

    public  String getEmpAttCount(String value) throws SQLException, ClassNotFoundException {
        String month = DateTimeUtil.dateNow();
        String[] split = month.split("-");
        ResultSet set = SQLUtil.crudUtil("SELECT COUNT(Emp_Id) FROM EmployeeAttendance WHERE Emp_Id=? AND date LIKE ?", value, split[0] + "-" + split[1] + "%");
        if (set.next()){
            return set.getString(1);
        }
        return null;
    }

    public  String getEmpAttCount() throws SQLException, ClassNotFoundException {
        ResultSet set= SQLUtil.crudUtil("SELECT COUNT(Emp_Id) FROM employeeattendance");
        String count=null;
        if (set.next()){
            count=set.getString(1);
        }
        return count;

    }
}
