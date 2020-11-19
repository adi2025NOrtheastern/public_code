/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.EcoSystem;
import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {
     private ArrayList<Restaurant> restaurantList;

    public RestaurantDirectory() {
        restaurantList = new ArrayList();
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }
    
    public Restaurant createRestaurant(String name, String phone, String address){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setNumber(phone);
        //for()
        //restaurant.setManager(manager);
        restaurantList.add(restaurant);
        return restaurant;
    }

    public Restaurant getRestaurantByName(String name){
        Restaurant r=null;
        for(Restaurant rs: restaurantList)
        {
            if(rs.getName() == name)
            {
                r=rs;
            }
        }
        return r;
    }

    
    public void deleteRestaurant(int index,EcoSystem system){
        restaurantList.remove(index);
    }
    
    public Restaurant getRestaurantId(int index){
        return restaurantList.get(index);
    }
    

    public String getRestName(String restaurantId) {
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getId() == Integer.parseInt((restaurantId))){
                return restaurant.getName();
            }
        }
        return "";
    }
    
    public Restaurant getRestaurant(String id){
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getId() == Integer.parseInt(id)){
                return restaurant;
            }
        }
        return null;
    }
    
    public Restaurant getRestaurantByManagerID(int id)
    {
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getManager().getId() == (id)){
                return restaurant;
            }
        }
        return null;
    }
}
