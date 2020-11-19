/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employee.Employee;

/**
 *
 * @author harold
 */
public class Customer extends Employee{
    String phone;
    String address;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void updateCustomer(Customer cust,String id, String name, String phone, String address) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        cust.setAddress(address);
        cust.setName(name);
        cust.setPhone(phone);
    
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.getId());
    }
    
}
