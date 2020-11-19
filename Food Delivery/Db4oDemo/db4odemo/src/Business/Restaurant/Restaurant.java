/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.Employee;
import Business.Menu.MenuDirectory;
import java.util.UUID;

/**
 *
 * @author harold
 */
public class Restaurant {
    private String name;
    private int id;
    private static int count = 100;//UUID.randomUUID().toString();
    private Employee manager;
    //private ArrayList<Employee> deliverManList;
    private String address;
    private String number;
    private MenuDirectory menuDirectory;

    public MenuDirectory getMenuDirectory() {
        return menuDirectory;
    }

    public void setMenuDirectory(MenuDirectory menuDirectory) {
        this.menuDirectory = menuDirectory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Restaurant() {
        id = (int) (Math.random() *1000);//count;
        count++;
        //menuDirectory= new MenuDirectory();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
}
