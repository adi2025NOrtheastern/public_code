/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Employee.Employee;
import Business.Patient.Patient;

/**
 *
 * @author raunak
 */
public class ReceptionistWorkRequest extends WorkRequest{
        /* inherited
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    
    
    */
    
    //set its parameter
    private Appointment app;
    private Patient patient;
 private Employee doctor;

    public Appointment getApp() {
        return app;
    }

    public void setApp(Appointment app) {
        this.app = app;
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
   
    
    
   
    
    
}
