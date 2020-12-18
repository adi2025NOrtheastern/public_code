/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Bill.Bill;
import Business.Bill.BillDirectory;
import Business.Employee.Employee;
import Business.Employee.PersonDirectory;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private String location;
    private WorkQueue workQueue;
    private PersonDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private PatientDirectory patientDirectory;
    private BillDirectory billDirectory;
    //private BedManagementDepartment 
    private int organizationID;
    private static int counter=1;
    
    public enum Type{
        Admin("Admin"),
        //Doctor("Doctor"),        
        Dental("Dental Department"),
        ENT("ENT Department"),
        CovidCenter("Covid-19 Treatment Department"),
        MedicalStore("Medical Store Department"),
        BedManagement("Bed Management Department"),
        //Laundry("Laundry Service Department"),
        Pathology("Pathology Department"),
        Radiology("Radiology Department"),
        //Inventory("Inventory Management Department"),
        UrgentCare("Urgent Care Department"),
        Cardiology("Cardiology Department"),
        Billing("Billing Department"),
        Lab("Lab"),
        Insurance("Insurance"),
        Other("Other Department");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        patientDirectory = new PatientDirectory();
        if(patientDirectory.getPatientList() == null){
            patientDirectory.setPatientList(new ArrayList<Patient>());
        }
        billDirectory = new BillDirectory();
        if(billDirectory.getBillList() == null){
            billDirectory.setBillList(new ArrayList<Bill>());
        }
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public BillDirectory getBillDirectory() {
        return billDirectory;
    }

    public void setBillDirectory(BillDirectory billDirectory) {
        this.billDirectory = billDirectory;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
    public void removeAllUserAccount(){
        for(UserAccount ua : userAccountDirectory.getUserAccountList())
        {
            this.userAccountDirectory.removeUserAccount(ua);
        }
        
    } 
    
    public void removeAllEmployee(){
                 for(Employee ua : employeeDirectory.getEmployeeList())
        {
            this.employeeDirectory.removeEmployee(ua);
        }    
                }
    
}
