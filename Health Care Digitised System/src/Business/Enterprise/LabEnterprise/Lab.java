/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.LabEnterprise;

import Business.Department.Receptionist;
import Business.Department.DepartmentDirectory;
import Business.Enterprise.Enterprise;
import Business.Location.Location;
import Business.Nurse.NurseDirectory;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class Lab extends Enterprise {

    int id;
    //DoctorDirectory doctorList;
    //NurseDirectory nurseList;
    Location location;
    DepartmentDirectory departmentList;
    PatientDirectory patientList;
    Receptionist receptionist;
    LabTechnicianDirectory labTechnicianList;
    
    //String enterpriseType;
    public Lab(String name){
        super(name,Enterprise.EnterpriseType.Lab);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
