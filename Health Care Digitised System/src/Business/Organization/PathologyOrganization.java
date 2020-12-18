/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabTechnicianRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PathologyOrganization extends Organization
{
    
    public PathologyOrganization() {
        super(Organization.Type.Pathology.getValue());
    }

    //@Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabTechnicianRole());
        //roles.add(new ReceptionistRole());
        return roles;
    }
     
   
    
    
}
