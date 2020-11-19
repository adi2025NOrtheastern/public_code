package Business;

import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryMan;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Menu.FoodItem;
import Business.Order.Order;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    private  CustomerDirectory customerDirectory;
    private  RestaurantDirectory restaurantDirectory;
    private  DeliveryManDirectory deliveryManDirectory;
    private  EmployeeDirectory employeeDirectory;
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("SysAdmin1");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        
        //employee = system.getEmployeeDirectory().createEmployee("Customer1");
        employee=system.getCustomerDirectory().createCustomer("Customer1", "903456700", "Boston flat 90");
        Customer c1=(Customer) employee;
        ua = system.getUserAccountDirectory().createUserAccount("Cust1", "Cust1", employee, new CustomerRole());
        
        
        //employee = system.getEmployeeDirectory().createEmployee("Customer2");
        employee=system.getCustomerDirectory().createCustomer("Customer2", "123456700", "Boston flat 1");
        ua = system.getUserAccountDirectory().createUserAccount("Cust2", "Cust2", employee, new CustomerRole());
        
        
        //employee = system.getEmployeeDirectory().createEmployee("Customer3");
        employee=system.getCustomerDirectory().createCustomer("Customer3", "193456700", "Boston flat 2");
        
        ua = system.getUserAccountDirectory().createUserAccount("Cust3", "Cust3", employee, new CustomerRole());
        
        //create rest1
        employee = system.getEmployeeDirectory().createEmployee("DunkinManager");
        ua = system.getUserAccountDirectory().createUserAccount("DUMngr1", "DUMngr1", employee, new AdminRole());
        
        Restaurant rest1 = system.getRestaurantDirectory().createRestaurant("Dunkin","290909090","Address2");
        rest1.setManager(employee);
        DeliveryMan deliverMan = system.getDeliveryManDirectory().createDeliveryMan("DUDMan1","321212123");
        ua = system.getUserAccountDirectory().createUserAccount("DUDMan1", "DUDMan1", deliverMan, new DeliverManRole());
        
        //deliverMan.setRestaurant(rest1);
        deliverMan = system.getDeliveryManDirectory().createDeliveryMan("DUDMan2","12111111");
        ua = system.getUserAccountDirectory().createUserAccount("DUDMan2", "DUDMan2", deliverMan, new DeliverManRole());
        
       // deliverMan.setRestaurant(rest1);
        
        
        
        //create rest1
        employee = system.getEmployeeDirectory().createEmployee("StarBucksManager");
        ua = system.getUserAccountDirectory().createUserAccount("SBMngr1", "SBMngr1", employee, new AdminRole());
        
        Restaurant rest2 = system.getRestaurantDirectory().createRestaurant("StarBucks","190909090","Address1");
        rest2.setManager(employee);
        deliverMan = system.getDeliveryManDirectory().createDeliveryMan("SBDMan1","11111111");
        ua = system.getUserAccountDirectory().createUserAccount("SBDMan1", "SBDMan1", deliverMan, new DeliverManRole());
        
        //deliverMan.setRestaurant(rest2);
        deliverMan = system.getDeliveryManDirectory().createDeliveryMan("SBDMan2","9090909090");
        ua = system.getUserAccountDirectory().createUserAccount("SBDMan2", "SBDMan2", deliverMan, new DeliverManRole());
        
       // deliverMan.setRestaurant(rest2);
         
        system.getMenuDirectory().add(String.valueOf(rest1.getId()), "Coffee DD", "Hot coffee", 100);
        system.getMenuDirectory().add(String.valueOf(rest1.getId()), "Donut DD", "Hot Donuts", 200);
        
        system.getMenuDirectory().add(String.valueOf(rest2.getId()), "Coffee SB", "Hot coffee", 140);
        system.getMenuDirectory().add(String.valueOf(rest2.getId()), "Tea SB", "Hot Tea", 190);
        
        /*FoodItem fi1 = system.getMenuDirectory().getFoodItem("F1");
        Order o1=system.getOrderDirectory().addOrder();
        o1.setCustomer(c1);
        o1.setFoodItem(fi1);
        o1.setDeliveryMan(deliverMan);
        o1.setOrderId("O01");
        o1.setRestaurant(rest1);
        //o1.set*/
        return system;
    }
    
}
