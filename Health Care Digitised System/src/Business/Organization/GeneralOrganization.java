/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.LabTechnicianRole;
import Business.Role.NurseRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class GeneralOrganization extends Organization
{
     

    public GeneralOrganization(String type) {
       // super(Organization.Type.Dental.getValue());
       super(type);
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DoctorRole());
        roles.add(new NurseRole());
        //roles.add(new ReceptionistRole());
        return roles;
}
    
}
