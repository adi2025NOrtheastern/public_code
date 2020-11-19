/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

//import Business.Employee.Employee;

import Business.Employee.Employee;
import Business.Restaurant.Restaurant;


/**
 *
 * @author harold
 */
public class DeliveryMan extends Employee {
 
    
    String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    

    public void updateDeliveryMan(DeliveryMan deliveryMan, String id, String name, String phone) {
        deliveryMan.setName(name);
        deliveryMan.setPhoneNum(phoneNum);
        //deliveryMan.setRestaurant(restaurant);
        //deliveryMa
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.getId());
    }
    
    
}
