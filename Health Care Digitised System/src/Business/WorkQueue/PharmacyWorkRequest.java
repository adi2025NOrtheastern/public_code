/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Employee.Employee;
import Business.Medicine.Medicine;
import Business.Patient.Patient;
import java.util.Map;

/**
 *
 * @author raunak
 */
public class PharmacyWorkRequest extends WorkRequest{
        /* inherited
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    
    
    */
    private Appointment appointment;
    private Patient patient;
    private Employee doctor;
    private Map<Medicine,Double> medicineMap;

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

    public Map<Medicine,Double> getMedicineMap() {
        return medicineMap;
    }

    public void setMedicineMap(Map<Medicine,Double> medicineMap) {
        this.medicineMap = medicineMap;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        WorkRequest.count = count;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    
}
