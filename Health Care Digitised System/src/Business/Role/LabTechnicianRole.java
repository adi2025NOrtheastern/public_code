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
import userinterface.LabTechnicianRole.LabAssistantMainAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class LabTechnicianRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LabAssistantMainAreaJPanel(userProcessContainer, account, organization, business, enterprise);
    }
    
    @Override
    public String roleValue()
    {
        return "Lab Technician Role";
    }
    
}
