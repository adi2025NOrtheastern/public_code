/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import java.util.Date;

/**
 *
 * @author aditi
 */
public class Medicine {
    int id;
    String name;
    Date expiryDate;
    String dosage;
    double price;
    int quantity;
    String type;//liquid, tablet, gel
    static int count =1;
    
    public Medicine(){
        this.id= count++;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValues(String name, Date date1, String dosage, double price, int quantity, String type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.setDosage(dosage);
        this.setExpiryDate(date1);
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setType(type);
    
    
    }
    
    
    @Override
    public String toString(){
        return "Med " +String.valueOf(this.getId()) +  " "+this.getName();
    }
    
    
}
