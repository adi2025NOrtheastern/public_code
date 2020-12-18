/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Appointment.AppointmentDirectory;
import Business.Patient.Patient;

/**
 *
 * @author raunak
 */
public class DoctorWorkRequest extends WorkRequest{
    /* inherited
    
    private String message;
    private UserAccount sender;  -- nurse useraccount
    private UserAccount receiver;  -- docrtor user account
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    
    
    */
    //private String testResult;
     private Appointment appointment;

    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
   
   
    
    public DoctorWorkRequest(){
        //appointment = new Appointment();
    }
    
    
}
