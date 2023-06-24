package lk.ijse.BookShop.bo;

import lk.ijse.BookShop.bo.custom.CustomerBO;
import lk.ijse.BookShop.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null)? boFactory = new BOFactory() :boFactory;
    }



    public enum BOTypes{
        Customer,Employee,Item,Supplier,Salary,Order,Attendance
    }
    public <T extends SuperBO> T getDAO(BOFactory.BOTypes res){
        switch (res){
            case Customer:
                return (T) new CustomerBOImpl();
            case Employee:
                return (T) new EmployeeBOImpl();
            case Item:
                return (T) new ItemBOImpl();
            case Supplier:
                return (T) new SupplierBOImpl();
            case Salary:
                return (T) new SalaryBOImpl();
            case Order:
                return (T) new OrderBOImpl();
            case Attendance:
                return (T) new AttendanceBOImpl();
            default:
                return null;
        }
    }
}
