/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Bed.Bed;
import Business.Role.NurseRole;
import Business.Role.Role;
import java.util.ArrayList;
import Business.Bed.BedDirectory;
import Business.Patient.Patient;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditi
 */


public class BedManagementDepartment extends Organization {

    
    private BedDirectory bedList;
    private int bedCount;
//    private Map<Date,BedPatient> assignedBedtoPatientMap;
//    private List<Bed> assignedLaundryBedMap;

    
//    public Map<Date, BedPatient> getAssignedBedMap() {
//        return assignedBedtoPatientMap;
//    }
//
//    public void setAssignedBedMap(Map<Date, BedPatient> assignedBedMap) {
//        this.assignedBedtoPatientMap = assignedBedMap;
//    }
    

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public BedDirectory getBedList() {
        return bedList;
    }

    
    
    public void setBedList(BedDirectory bedList) {
        
        this.bedList = bedList;
    }
    
    
    public BedDirectory createBedList(int count){
        this.bedList = new BedDirectory(count);
        this.bedCount=count * 2;
        return bedList;
    }
    
    public void addBedInBedList(int count){
        this.bedList.addBeds(count);
    }
    
    public BedManagementDepartment() {
        super(Organization.Type.BedManagement.getValue());
        
//        assignedBedtoPatientMap = new HashMap<>();
//        assignedLaundryBedMap = new ArrayList<>();
        
    }
    
    
//    public void assignBedToPatientOnDate(Patient patient,Date date, Bed bed)
//    {
//        BedPatient bp = new BedPatient();
//        bp.setPatient(patient);
//        bp.setDate(date);
//        bp.setBed(bed);
//       assignedBedtoPatientMap.put(date,bp);
//    }
    
//    public void assignBedToLaundryOnDate(Date date, Bed bed)
//    {
//       assignedLaundryBedMap.add(bed);
//    }
    
    
    
    
//    public boolean checkIfBedAvailbleOnDate(Date date, Bed bed){
//        
//         if(assignedLaundryBedMap.contains(bed))
//            {
//                return false; // as bed is in assigned laundry
//            }
//            
//        
//        
//        
//        
//        for (Map.Entry<Date, BedPatient> entry : assignedBedtoPatientMap.entrySet()) {
//        Date k = entry.getKey();
//        BedPatient v = entry.getValue();
//        
//        if(k.equals(date) && v.getBed().equals(bed) )//&& bed.getStatus()!= Bed.BedStatus.Available)
//        {
//            return false;
//        }
//        
//        System.out.println("Key: " + k + ", Value: " + v.bed);
//    }
        
        
        //return true if entry is not present
//        return true;
//    }
    
//    public List<Bed> getBedAvailableListOnDate(Date date){
//        
//        List<Bed> availBedList=new ArrayList<>();
//        
//        for(Bed bed: this.bedList.getBedList())
//        {
//            if(assignedLaundryBedMap.contains(bed))
//            {
//                continue;
//            }
//            
//            //check in assigned date map
//            
//            boolean isAvail = checkIfBedAvailbleOnDate(date,bed);
//            if(isAvail == true)
//            {
//                availBedList.add(bed);
//            }
//            
//            
//        }
//        
//        
//        return availBedList;
//        
//    }
    
    
//    public List<Bed> getBedOccupiedListOnDate(Date date){
//        
//        List<Bed> availBedList=new ArrayList<>();
//        
//        for(Bed bed: this.bedList.getBedList())
//        {
//            if(assignedLaundryBedMap.contains(bed))
//            {
//                continue;
//            }
//            
//            //check in assigned date map
//            
//            boolean isAvail = checkIfBedAvailbleOnDate(date,bed);
//            if(isAvail == false && bed.getPatient() == null)
//            {
//                availBedList.add(bed);
//            }
//            
//            
//        }
//        
//        
//        return availBedList;
//        
//    }
//    public List<Bed> getBedAssignedLaundry(){
//        
//       return assignedLaundryBedMap;
//    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NurseRole());
        return roles;
    }

//    public Patient getPatientByBedNDate(Bed bed, Date date) {
//            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            
//            Patient p = null;
//            
//            for (Map.Entry<Date, BedPatient> entry : assignedBedtoPatientMap.entrySet()) {
//        Date k = entry.getKey();
//        BedPatient v = entry.getValue();
//        
//        if(k.equals(date) && v.getBed().equals(bed))// && bed.getStatus()!= Bed.BedStatus.Available)
//        {
//            return v.getPatient();
//        }
//        
//    }
//            return p;
//    }
    
}

