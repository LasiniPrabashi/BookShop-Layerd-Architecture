package lk.ijse.BookShop.model;

public class AttendanceDTO {
    private String attendance_Id;
    private String Emp_Id;
    private String workingHourse;
    private String date;


    public AttendanceDTO(String attendance_Id, String emp_Id, String workingHourse, String date) {
        this.attendance_Id = attendance_Id;
        Emp_Id = emp_Id;
        this.workingHourse = workingHourse;
        this.date = date;
    }


    public AttendanceDTO() {

    }


    public String getAttendance_Id() {
        return attendance_Id;
    }

    public void setAttendance_Id(String attendance_Id) {
        this.attendance_Id = attendance_Id;
    }

    public String getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        Emp_Id = emp_Id;
    }

    public String getWorkingHourse() {
        return workingHourse;
    }

    public void setWorkingHourse(String workingHourse) {
        this.workingHourse = workingHourse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "EmployeeAttendanceDTO{" +
                "attendance_Id='" + attendance_Id + '\'' +
                ", Emp_Id='" + Emp_Id + '\'' +
                ", workingHourse='" + workingHourse + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
