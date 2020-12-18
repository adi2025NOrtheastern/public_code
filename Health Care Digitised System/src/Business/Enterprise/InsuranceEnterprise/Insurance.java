/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.InsuranceEnterprise;

import Business.Enterprise.HospitalEnterprise.*;
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
public class Insurance extends Enterprise {
    int id;
    EmployeeDirectory doctorList;
    //NurseDirectory nurseList;
    Location location;
    DepartmentDirectory departmentList;
    PatientDirectory patientList;
    Receptionist receptionist;
    InsuranceDirectory indir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeDirectory getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(EmployeeDirectory doctorList) {
        this.doctorList = doctorList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DepartmentDirectory getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(DepartmentDirectory departmentList) {
        this.departmentList = departmentList;
    }

    public PatientDirectory getPatientList() {
        return patientList;
    }

    public void setPatientList(PatientDirectory patientList) {
        this.patientList = patientList;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public InsuranceDirectory getIndir() {
        return indir;
    }

    public void setIndir(InsuranceDirectory indir) {
        this.indir = indir;
    }
    
    //String enterpriseType;
    public Insurance(String name){
        super(name,EnterpriseType.Insurance);
        
        indir= new InsuranceDirectory();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}
