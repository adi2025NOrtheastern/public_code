/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;

/**
 *
 * @author raunak
 */
public class LabTechnicianWorkRequest extends WorkRequest{
        /* inherited
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    
    
    */
    private Patient patient;
    private Appointment appointment;
    private LabTest labTest;
    //private UserAccount doctorUserAccount;

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }


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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    
    
}
