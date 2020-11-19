/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aditi
 */
public class CustomerDirectory {
    private List<Customer> customerList;
    
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public CustomerDirectory(){
        customerList = new ArrayList<>();
        
    }    
    public void addCustomer(Customer c)
    {
        this.customerList.add(c);
    }
    
     public void removeCustomer(Customer c)
    {
        this.customerList.remove(c);
    }
 
     
     
}
