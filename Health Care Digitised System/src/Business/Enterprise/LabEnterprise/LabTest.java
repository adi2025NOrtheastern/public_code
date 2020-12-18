/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.LabEnterprise;

import Business.Employee.Employee;
import Business.Patient.Patient;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author aditi
 */
public class LabTest {
    int id;
    String name;
    String type;
    double testCharge;
    Date createdOn;
    String status; //scheduled, in-process, complete
    Employee doctor;
    Employee labTechnician;
    private Patient patient;
    private Lab lab;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTestCharge() {
        return testCharge;
    }

    public void setTestCharge(double testCharge) {
        this.testCharge = testCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public Employee getLabTechnician() {
        return labTechnician;
    }

    public void setLabTechnician(Employee labTechnician) {
        this.labTechnician = labTechnician;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }
    
    
    @Override
    public String toString(){
        return this.getName();
    }
    
    
}
