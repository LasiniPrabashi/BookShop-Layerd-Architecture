package lk.ijse.BookShop.model;

import lk.ijse.BookShop.tm.SalaryTm;

public class SalaryDTO {
    private String salary_Id;
    private String Emp_Id;
    private String daily_salary;
    private String bonus;
    private String date;
    private String time;
    private String total_salary;

    public SalaryDTO(String salary_Id, String emp_Id, String daily_salary, String bonus, String date, String time, String total_salary) {
        this.salary_Id = salary_Id;
        Emp_Id = emp_Id;
        this.daily_salary = daily_salary;
        this.bonus = bonus;
        this.date = date;
        this.time = time;
        this.total_salary = total_salary;
    }

    public SalaryDTO() {

    }

    public String getSalary_Id() {
        return salary_Id;
    }

    public void setSalary_Id(String salary_Id) {
        this.salary_Id = salary_Id;
    }

    public String getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        Emp_Id = emp_Id;
    }

    public String getDaily_salary() {
        return daily_salary;
    }

    public void setDaily_salary(String daily_salary) {
        this.daily_salary = daily_salary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(String total_salary) {
        this.total_salary = total_salary;
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salary_Id='" + salary_Id + '\'' +
                ", Emp_Id='" + Emp_Id + '\'' +
                ", daily_salary='" + daily_salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", total_salary='" + total_salary + '\'' +
                '}';
    }
}
