/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        Doctor("Doctor"),
        Nurse("Nurse"),
        LabTechnician("Lab Technician"),
        Receptionist("Receptionist"),
        Patient("Patient"),
        MedicalStoreHead("Medical Store Head"),
        PharmacyHead("Pharmacy Head"),
        LabHead("Lab Head"),
        HospitalHead("Hospital Head"),
        LaundryHead("Laundy Head");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business
            
            );

    public abstract String roleValue();
    
    @Override
    public String toString() {
        return this.roleValue();  //.getClass().getName();
    }
    
    
}