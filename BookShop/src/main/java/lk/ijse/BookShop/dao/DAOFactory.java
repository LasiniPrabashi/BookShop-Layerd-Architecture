package lk.ijse.BookShop.dao;

import lk.ijse.BookShop.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,Employee,Item,Order,OrderDetails,Supplier,Salary,EmployeeAttendance,Login
    }

    public <T extends SuperDAO> T getDAO(DAOTypes res) {
        switch (res) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case Employee:
                return (T) new EmployeeDAOImpl();
            case Item:
                return (T) new ItemDAOImpl();
            case Order:
                return (T) new OrderDAOImpl();
            case OrderDetails:
                return (T) new OrderDetailsDAOImpl();
            case Supplier:
                return (T) new SupplierDAOImpl();
            case Salary:
                return (T) new SalaryDAOImpl();
            case EmployeeAttendance:
                return (T) new AttendanceDAOImpl();
            case Login:
                return (T) new LoginDAOImpl();
            default:
                return null;
        }
    }

}
