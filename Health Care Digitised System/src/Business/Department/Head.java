/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Bed.Bed;
import Business.Organization.Organization;
import Business.Role.Role.RoleType;
import java.util.List;

/**
 *
 * @author Suhani
 */
public class Head {
    private RoleType staffType;
    private List<Bed> bedList;
    private List<Organization> orgList;

    public RoleType getStaffType() {
        return staffType;
    }

    public void setStaffType(RoleType staffType) {
        this.staffType = staffType;
    }

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    public List<Organization> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<Organization> orgList) {
        this.orgList = orgList;
    }
    
    
}
