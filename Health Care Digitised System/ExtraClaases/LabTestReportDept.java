/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Appointment.Appointment;
import Business.Doctor.Doctor;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Patient.Patient;
import Business.Role.LabTechnicianRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author preranaurs
 */
public class LabTestReportDept extends Organization{
    Doctor doctor;
    LabTest labTest;
    Appointment appointment;
    Patient patient;
    
     public LabTestReportDept() {
      super(Organization.Type.Lab.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ReceptionistRole());
        roles.add(new LabTechnicianRole());
        return roles;
    }
    
    
    public void generateReport(LabTest labtest){
    //generates the given lab report     
    }
    
    public void generateBill(LabTest labTest){
       //generates bill for Lab tests conducted 
    }
}
