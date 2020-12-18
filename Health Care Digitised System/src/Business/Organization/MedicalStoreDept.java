/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.LabEnterprise.LabTest;
import Business.Location.Location;
import Business.Medicine.MedicineDirectory;
import Business.Appointment.Prescription;
import Business.Enterprise.PharmacyEnterprise.Pharmacy;
import Business.Role.DoctorRole;
import Business.Role.NurseRole;
import Business.Role.PharmacyWorkerRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author preranaurs
 */
public class MedicalStoreDept extends Organization {
    MedicineDirectory medicineList;
    String pharmacistName;
    Location location;
    Prescription prescription;

    public MedicalStoreDept() {
        super(Organization.Type.MedicalStore.getValue());
        //this.medicineList= this.
       // medicineList = new MedicineDirectory();
      // super(type);
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PharmacyWorkerRole());
        //roles.add(new WorkerRole());
        return roles;
}

    
    
    public void generateBill(Prescription prescription){
       //generates bill for medicines bought at the store
    }
}
