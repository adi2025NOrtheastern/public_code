/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Menu;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author cnakhare
 */
public class MenuDirectory {
    private ArrayList<FoodItem> menuDirectory;
    
    public MenuDirectory(){
        menuDirectory = new ArrayList<FoodItem>();
    }

    public ArrayList<FoodItem> getMenuDirectory() {
        return menuDirectory;
    }

    public void setMenuDirectory(ArrayList<FoodItem> menuDirectory) {
        this.menuDirectory = menuDirectory;
    }

    public void add(String restaurantId, String name, String description, double price) {
        FoodItem item = new FoodItem("F"+(menuDirectory.size()+1),restaurantId,name,description,price);
        menuDirectory.add(item);
    }
    
    public FoodItem getFoodItem(String itemId){
        for(FoodItem item: menuDirectory){
            if(item.getItemId().equalsIgnoreCase(itemId)){
                return item;
            }
        }
        return null;
    }

    public void updateFoodItem(String itemId, String name, String description, Double price) {
        for(FoodItem item: menuDirectory){
            if(item.getItemId().equalsIgnoreCase(itemId)){
                item.setItemName(name);
                item.setDescription(description);
                item.setPrice(price);
                
            }
        }
    }
    
    public void deleteItem(String id){
        for(int i =0; i< menuDirectory.size();i++){
            if(menuDirectory.get(i).getItemId().equalsIgnoreCase(id)){
                menuDirectory.remove(i);
            }
        }
    }
    
    public FoodItem getFoodItemByIndex(int index){
        return menuDirectory.get(index);
    }
}
