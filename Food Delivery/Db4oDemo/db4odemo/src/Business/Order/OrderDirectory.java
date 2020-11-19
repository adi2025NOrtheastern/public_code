/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author cnakhare
 */
public class OrderDirectory {
    private ArrayList<Order> orderDirectory;

    public OrderDirectory(){
        orderDirectory = new ArrayList<Order>();
    }
    
    public ArrayList<Order> getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(ArrayList<Order> orderDirectory) {
        this.orderDirectory = orderDirectory;
    }
    
    public Order addOrder(){
        Order order = new Order();
        orderDirectory.add(order);
        return order;
    }
    
    public Order getOrderById(int index){
        return orderDirectory.get(index);
    }
    
    public Order getOrderByOrderId(String id){
        for(Order order: orderDirectory){
            if(order.getOrderId().equalsIgnoreCase(id)){
                return order;
            }
        }
        return null;
    }
}
