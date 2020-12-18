/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Bill;

import Business.Appointment.Appointment;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Patient.Patient;

/**
 *
 * @author aditi
 */
public class Bill {
    //cumulative charges->> labs, medicine, consultation, hospital charges
    int billId;
    Patient patient;
    Employee doctor;
    Appointment appointment;
    double totalCharges;
    String status;//paid, unpaid
    //int invoiceNumber;
    private static int count = 1;
    private Enterprise enterprise;

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
    public Bill() {
        billId = count;
        count++;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    @Override 
    public String toString(){
        return ("Bill" + this.getBillId());
    } 
    
    
}
