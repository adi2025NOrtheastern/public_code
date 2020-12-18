/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.HospitalEnterprise;

import Business.Department.DepartmentDirectory;
import Business.Enterprise.Enterprise;
import Business.Location.Location;
import Business.Nurse.NurseDirectory;
import Business.Patient.PatientDirectory;
import Business.Department.Receptionist;
import Business.Person.EmployeeDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class Hospital extends Enterprise {
    int id;
    EmployeeDirectory doctorList;
    NurseDirectory nurseList;
    Location location;
    DepartmentDirectory departmentList;
    PatientDirectory patientList;
    Receptionist receptionist;
    
    
    //String enterpriseType;
    public Hospital(String name){
        super(name,EnterpriseType.Hospital);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}
