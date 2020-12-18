/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Medicine.MedicineDirectory;
import Business.Employee.Employee;
//import static Business.Enterprise.Enterprise.EnterpriseType.Pharmacy;
import Business.Enterprise.LabEnterprise.LabTestDirectory;
import Business.Enterprise.PharmacyEnterprise.Pharmacy;
import Business.Medicine.Medicine;
import Business.Patient.Patient;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditi
 */
public class Prescription {
    LabTestDirectory labTestList;
    //MedicineDirectory medicineList;
    Map<Medicine, Double> medicinePrescribed;
    Map<Medicine, Integer> medicineListquanity;
    private Pharmacy phmacy;
    private String status;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public Pharmacy getPhmacy() {
        return phmacy;
    }

    public void setPhmacy(Pharmacy phmacy) {
        this.phmacy = phmacy;
    }
    private Date createdOn;
    Employee doctor;
    Patient patient;
    private String history;

    public Prescription() {
        this.createdOn = new Date();
        medicinePrescribed = new HashMap<>();
        medicineListquanity = new HashMap<>();
    }

    
    public LabTestDirectory getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(LabTestDirectory labTestList) {
        this.labTestList = labTestList;
    }

    public Map<Medicine, Double> getMedicinePrescribed() {
        return medicinePrescribed;
    }

    public void setMedicinePrescribed(Map<Medicine, Double> medicinePrescribed) {
        this.medicinePrescribed = medicinePrescribed;
    }

    public Map<Medicine, Integer> getMedicineListquanity() {
        return medicineListquanity;
    }

    public void setMedicineListquanity(Map<Medicine, Integer> medicineListquanity) {
        this.medicineListquanity = medicineListquanity;
    }

    

    public Date getCreatedOn() {
        return createdOn;
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    
    
    
    
}
