/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Customer.Customer;
import Business.EcoSystem;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    public Customer createCustomer(String name,String phone, String address){
        Customer employee = new Customer();
        employee.setName(name);
        employee.setAddress(address);
        employee.setPhone(phone);
        customerList.add(employee);
        return employee;
    }

     public Customer getCustomerId(int index){
       return customerList.get(index);
    }

     public void deleteCustomer(int index,EcoSystem system){
        customerList.remove(index);
    }
    
     public Customer getCustomerByCustomerId(int id)
     {
         Customer cust=null;
         for(Customer c: customerList)
         {
             if(c.getId()  == id)
             {
                 cust =c;
             }
         }
         return cust;
     }
     
}
