/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.InsuranceDealerRole;
import Business.Role.LabTechnicianRole;
import Business.Role.NurseRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class InsuranceOrganization extends Organization
{
     

    public InsuranceOrganization() {
       // super(Organization.Type.Dental.getValue());
       super(Organization.Type.Insurance.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InsuranceDealerRole());
        //roles.add(new NurseRole());
        //roles.add(new ReceptionistRole());
        return roles;
}
    
}
