/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Employee.Employee;
import Business.Patient.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author aditi
 */
public class AppointmentDirectory {
    private int count = 11;
    List<Appointment> appointmentList;
    //private Prescription prescription;
    List<Prescription> prescriptionList;
    List<PatientHistoryDetails> patientHistoryList;

    public AppointmentDirectory(){
        appointmentList = new ArrayList<>();
        prescriptionList = new ArrayList<>();
        patientHistoryList = new ArrayList<>();
        
    }
    
    
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public List<PatientHistoryDetails> getPatientHistoryList() {
        return patientHistoryList;
    }

    public void setPatientHistoryList(List<PatientHistoryDetails> patientHistoryList) {
        this.patientHistoryList = patientHistoryList;
    }
    
    
    //update appointment
    
    void updateAppointment(Appointment app){
        
    }
    
    
    //cancel appointment
    void cancelAppointment(Appointment app){
        appointmentList.remove(app);
    }
    
    //search Appointment by patient and date
    Appointment searchAppointment(Patient patient, Date date){
        Appointment app= null;
        
        
        
        
        return app;
    }
    
    
    //Return List of Appointments by patient
    List<Appointment> searchAppointment(Patient patient){
        List<Appointment> app= null;
        
        
        
        
        return app;
    }

    public Appointment createAppointment(Patient patient, Employee doctor, Date appointmetDate, String appointmentType) { 
        Appointment appointment = new Appointment(count++);
        appointment.setDate(appointmetDate);
        appointment.setDoctor(doctor);
        appointment.setType(appointmentType);
        appointment.setPatient(patient);
        appointment.setStatus(Appointment.AppointmentStatus.New.getValue());
        patient.getAppointmentDirectory().getAppointmentList().add(appointment);
       return appointment;
    }
    
    public Appointment createLabAppointment(Patient patient, Employee doctor, Date appointmetDate, String appointmentType) { 
        Appointment appointment = new Appointment(count++);
        appointment.setDate(appointmetDate);
        appointment.setDoctor(doctor);
        appointment.setType(appointmentType);
        appointment.setPatient(patient);
        appointment.setStatus(Appointment.AppointmentStatus.New.getValue());
        patient.getLabAppointmentDirectory().getAppointmentList().add(appointment);
       return appointment;
    }
    
    public Prescription addPrescription(){
        Prescription prescription = new Prescription();
        prescriptionList.add(prescription);
        return prescription;
    }
    
    public AppointmentDirectory createNewAPPDir()
    {
            AppointmentDirectory appointmentDirectory = new AppointmentDirectory();
            //List<Appointment> appointmentList = new ArrayList<Appointment>();
            //appointmentDirectory.setAppointmentList(appointmentList);
            return appointmentDirectory;
    }
}
