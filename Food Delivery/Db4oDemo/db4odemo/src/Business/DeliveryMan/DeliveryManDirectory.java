/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
    private ArrayList<DeliveryMan> deliveryManList;

    public DeliveryManDirectory() {
        deliveryManList = new ArrayList();
    }

    public ArrayList<DeliveryMan> getDeliveryManList() {
        return deliveryManList;
    }
    
    public DeliveryMan createDeliveryMan(String name,String phone){
        DeliveryMan deliveryMan = new DeliveryMan();
        deliveryMan.setName(name);
        deliveryMan.setPhoneNum(phone);
       // deliveryMan.setRestaurant(restaurant);
        deliveryManList.add(deliveryMan);
        return deliveryMan;
    }

 public void deleteDeliveryMan(int index,EcoSystem system){
        //deliveryManList.remove(this)
        deliveryManList.remove(index);
    }
    
    public DeliveryMan getDeliveryManId(int index){
        return deliveryManList.get(index);
    }
    
    public boolean isPhoneUnique(String phone){
        for(DeliveryMan deliveryMan: deliveryManList){
            if(deliveryMan.getPhoneNum().equalsIgnoreCase(phone)){
                return false;
            }
        }
        return true;
    }
    
    public void updateDeliveryMan(String id,String name,String phone){
        for(DeliveryMan deliveryMan: deliveryManList){
            if(deliveryMan.getId()==(Integer.parseInt(id))){
                deliveryMan.setName(name);
                deliveryMan.setPhoneNum(phone);
               // deliveryMan.setAddress(address);
            }
        }
    }
    
    public DeliveryMan getDeliveryMan(String id){
        for(DeliveryMan deliveryMan: deliveryManList){
            if(deliveryMan.getId()==(Integer.parseInt(id))){
                return deliveryMan;
            }
        }
        return null;
    }   
}
