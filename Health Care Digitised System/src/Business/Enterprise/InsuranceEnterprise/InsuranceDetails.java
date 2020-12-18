/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.InsuranceEnterprise;

import Business.Employee.Employee;
import Business.Patient.Patient;
import java.util.Date;

/**
 *
 * @author aditi
 */
public class InsuranceDetails {
    private String id;
    private Patient patient;
    private Date createdOndate;
    private Date validity;
   private  String type;
private String SSN;

private Employee insuranceDealer;

    public Employee getInsuranceDealer() {
        return insuranceDealer;
    }

    public void setInsuranceDealer(Employee insuranceDealer) {
        this.insuranceDealer = insuranceDealer;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
   static int count =10020;
   
   public InsuranceDetails(){
       this.id = "INSUR" + count ++;
       this.createdOndate = new Date();
   }
   
   
   @Override 
   public String toString(){
       return this.id;
   }
   
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getCreatedOndate() {
        return createdOndate;
    }

    public void setCreatedOndate(Date createdOndate) {
        this.createdOndate = createdOndate;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private double price;
    
    
}
