/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Operation.Operation;
import Business.Patient.Patient;

/**
 *
 * @author raunak
 */
public class NurseWorkRequest extends WorkRequest{
    /* 
    inherited->
    private String message;
    private UserAccount sender;--> from doctor
    private UserAccount receiver; -->> to nurse
    private String status;  -> new, schduled, on-going, success
    private Date requestDate;
    private Date resolveDate;
    */
    private Appointment appointment;    
    //private Operation operation;
    private Patient patient;

        
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    
    
    
}
