/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Dental.getValue())){
            organization = new GeneralOrganization(Type.Dental.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Pathology.getValue())){
            organization = new PathologyOrganization();//GeneralOrganization(Type.Pathology.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Billing.getValue())){
            organization = new BillingDepartment();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.BedManagement.getValue())){
            organization = new BedManagementDepartment();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Cardiology.getValue())){
            organization = new GeneralOrganization(Type.Cardiology.getValue());
            organizationList.add(organization);    
        }    
        else if (type.getValue().equals(Type.ENT.getValue())){
            organization = new GeneralOrganization(Type.ENT.getValue());
            organizationList.add(organization);   
        }
        else if (type.getValue().equals(Type.CovidCenter.getValue())){
            organization = new GeneralOrganization(Type.CovidCenter.getValue());
            organizationList.add(organization);   
        }
        else if (type.getValue().equals(Type.UrgentCare.getValue())){
            organization = new GeneralOrganization(Type.UrgentCare.getValue());
            organizationList.add(organization);   
        }
        else if (type.getValue().equals(Type.Radiology.getValue())){
            organization = new RadiologyOrganization();//GeneralOrganization(Type.Radiology.getValue());
            organizationList.add(organization);   
        }
        else if (type.getValue().equals(Type.MedicalStore.getValue())){
            organization = new MedicalStoreDept();
            organizationList.add(organization);   
        }
        
        else if (type.getValue().equals(Type.Insurance.getValue())){
            organization = new InsuranceOrganization();
            organizationList.add(organization);
        }
        
        //else if (type.getValue().equals(Type.Inventory.getValue())){
        //    organization = new InventoryManagementDept();
       //     organizationList.add(organization);   
        //}
        
        return organization;
    }
}