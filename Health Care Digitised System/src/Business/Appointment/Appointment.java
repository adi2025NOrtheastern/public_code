/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Bill.Bill;
import Business.Employee.Employee;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Enterprise.LabEnterprise.LabTestDirectory;
import Business.Enterprise.PharmacyEnterprise.Pharmacy;
import Business.Operation.Operation;
import Business.Patient.Patient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aditi
 */
public class Appointment {
    int appointmentId;
    String type; //online, in-person
    Date date;
    Employee doctor;
    Patient patient;
    String status;  //new, booked, cancelled, rescheduled, completed , mark for billing
    String location;
    private Operation operation;
    LabTestDirectory labTestList;
    Prescription prescription;
    Integer time;
    Bill Hospitalbill;

    public Bill getHospitalbill() {
        return Hospitalbill;
    }

    public void setHospitalbill(Bill bill) {
        this.Hospitalbill = bill;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
    String appoitmentHistory;

    public String getAppoitmentHistory() {
        return appoitmentHistory;
    }

    public void setAppoitmentHistory(String appoitmentHistory) {
        this.appoitmentHistory = appoitmentHistory;
    }

    Pharmacy pharmacy;


    public Prescription getPrescription() {
        return prescription;
    }

    public LabTestDirectory getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(LabTestDirectory labTestList) {
        this.labTestList = labTestList;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
    
    public Appointment(int count){
        this.appointmentId = count;
        prescription= new Prescription();
        labTestList = new LabTestDirectory();
        appoitmentHistory="";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status =  status; //this.status + ", " +
        this.appoitmentHistory += " "+ this.status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    

   
    
    
    @Override
    public String toString()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(this.date); 
        //new SimpleDateFormat("yyyy-MM-dd").format(this.date);
        return strDate;
    }
    
    
   // Appointment-> New, markforbilling, markforsurgery, markforTest, close
    
    public enum AppointmentStatus{
        New("New"),
        Markforbilling("Mark for billing"),
        Markforsurgery("Mark for Surgery"),
        MarkforTest("Mark for Test"),
        Close("Close"),
        AnalyseReport("Analyse Report"),
        Cancel("Cancel"),
        GeneratedReport("Generated Report"),
        MarkForInsurance("Mark For Insurance"),
        BedAssigned("Bed Assigned"),
        ApprovedInsurance("ApprovedInsurance"),
        DisapprovedInsurance("DisapprovedInsurance");
        private String value;
        private AppointmentStatus(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
