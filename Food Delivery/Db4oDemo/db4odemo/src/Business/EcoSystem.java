/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Customer.CustomerDirectory;
import Business.DB4OUtil.DB4OUtil;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Menu.MenuDirectory;
import Business.Order.OrderDirectory;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
//import Business.Network.Network;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private RestaurantDirectory restaurantDirectory;
    private CustomerDirectory customerDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    private OrderDirectory orderDirectory;
    private MenuDirectory menuDirectory;

    public MenuDirectory getMenuDirectory() {
        return menuDirectory;
    }

    public void setMenuDirectory(MenuDirectory menuDirectory) {
        this.menuDirectory = menuDirectory;
    }
    //private EmployeeDirectory employeeDirectory;
    //private ArrayList<Network> networkList; //-- aj added

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public RestaurantDirectory getRestaurantDirectory() {
        return restaurantDirectory;
    }

    public void setRestaurantDirectory(RestaurantDirectory restaurantDirectory) {
        this.restaurantDirectory = restaurantDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public DeliveryManDirectory getDeliveryManDirectory() {
        return deliveryManDirectory;
    }

    public void setDeliveryManDirectory(DeliveryManDirectory deliveryManDirectory) {
        this.deliveryManDirectory = deliveryManDirectory;
    }

    public EcoSystem(RestaurantDirectory restaurantDirectory, CustomerDirectory customerDirectory, DeliveryManDirectory deliveryManDirectory) {

        this.restaurantDirectory = restaurantDirectory;
        this.customerDirectory = customerDirectory;
        this.deliveryManDirectory = deliveryManDirectory;
    }
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    /*public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }*/
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        //super(null);
        super("OrgName1FromEcosystem()");
        System.out.println("Inside Ecosystem private constructor");
        //networkList=new ArrayList<Network>();
        customerDirectory = new CustomerDirectory();
        restaurantDirectory = new RestaurantDirectory();
        deliveryManDirectory = new DeliveryManDirectory();
        orderDirectory = new OrderDirectory();
        menuDirectory = new MenuDirectory();
    }

    /*public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }*/
    
    public boolean checkIfUserIsUnique(String userName){
      if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
       // for(Network network:networkList){
            
        //}
        return true;
    }
}
