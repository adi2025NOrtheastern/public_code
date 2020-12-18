/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Appointment.Appointment;
import Business.Appointment.AppointmentDirectory;
import Business.Appointment.PatientHistoryDetails;
import Business.Bill.Bill;
import Business.Employee.Employee;
import Business.Enterprise.InsuranceEnterprise.Insurance;
import Business.Enterprise.LabEnterprise.LabTestDirectory;
import Business.Location.LocationPoint;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aditi
 */
public class Patient extends Employee{
    
    //String phoneNum;
    AppointmentDirectory appointmentDirectory;
    AppointmentDirectory labAppointmentDirectory;
    LabTestDirectory labTestList;
    String patientSex;
    //private String address;
    private LocationPoint address;
    private String bloodGroup;
    //private String emailId;
    private String insuranceId;
    private Insurance insuranceE;
    private ArrayList<PatientHistoryDetails> patHistorydtls;
    private String SSN;

    public AppointmentDirectory getLabAppointmentDirectory() {
        return labAppointmentDirectory;
    }

    public void setLabAppointmentDirectory(AppointmentDirectory labAppointmentDirectory) {
        this.labAppointmentDirectory = labAppointmentDirectory;
    }
    
    

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    
    public Patient()
    {
        super();
        this.patHistorydtls= new ArrayList<>();
        this.appointmentDirectory = new AppointmentDirectory();
        this.labAppointmentDirectory = new AppointmentDirectory();
        this.labTestList = new LabTestDirectory();
    }
    
    
    public ArrayList<PatientHistoryDetails> getPatHistorydtls() {
        return patHistorydtls;
    }

    public void setPatHistorydtls(ArrayList<PatientHistoryDetails> patHistorydtls) {
        this.patHistorydtls = patHistorydtls;
    }
    
    public String getInsuranceId() {
        return insuranceId;
    }

    public Insurance getInsuranceE() {
        return insuranceE;
    }

    public void setInsuranceE(Insurance insuranceE) {
        this.insuranceE = insuranceE;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }
    
    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
public void createNewAppointmentDirectory(){
    appointmentDirectory = new AppointmentDirectory();
}
    
    
    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public LocationPoint getAddress() {
        return address;
    }

    public void setAddress(LocationPoint address) {
        this.address = address;
    }
    
    

    public AppointmentDirectory getAppointmentDirectory() {
        return appointmentDirectory;
    }

    public void setAppointmentDirectory(AppointmentDirectory appointmentDirectory) {
        this.appointmentDirectory = appointmentDirectory;
    }

    public LabTestDirectory getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(LabTestDirectory labTestList) {
        this.labTestList = labTestList;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }
    
    
    
    void bookAppointment(Appointment app )
    {
        
    }
    
    Appointment viewAppointment(Date date){
        Appointment app=null;
        return app;
    }
    
    void rescheduleAppointment(Appointment app )
    {
        //update the appointment
        //
    }
    
    Bill viewBills(Appointment app){
      Bill b=null;
      
      return b;
    }
    
    
    
    
    @Override
    public String toString(){
        return this.getName();
    }
}
