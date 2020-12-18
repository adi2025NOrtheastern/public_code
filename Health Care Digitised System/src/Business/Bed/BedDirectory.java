/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Bed;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
public class BedDirectory {
    List<Bed> bedList;

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }
    static int count=1;
    
    public BedDirectory(int count){
        bedList = new ArrayList<Bed>();
        //create beds-->> todo
        for(int i=0;i<count;i++){
        
            Bed bed = new Bed();
            bedList.add(bed);
        
        }
        
        
        for(int i=0;i<count;i++){
        
            Bed bed = new Bed();
            bed.setBedType(Bed.BedType.Delux);
            bedList.add(bed);
        
        }
        
    }
    
    public void addBeds(int count){
        for(int i=0;i<count;i++){
        
            Bed bed = new Bed();
            bedList.add(bed);
        
        }
        
        
    }
    
    
    //create bed
    Bed createBed(){
        Bed bed= new Bed();//null;
        //bed.setBedID();
        return bed;
    }
    
    
       
    //update bed
    void updateBedStatus(Bed bed,Bed.BedStatus bedStatus){
        bed.setStatus(bedStatus);
    }
    
    
    
    
    //search available Bed in bedlist
    List<Bed> getAvailableBed(){
        List<Bed> availableBedList = null;
        for(Bed bed: bedList)
        {
            if(bed.getStatus().equals(Bed.BedStatus.Available))
            {
                availableBedList.add(bed);
                
            }
        }
        return availableBedList;
       // return null;
    }
    
    
    //search bed by bed id
    Bed getBedbyBedId(int id){
        Bed bed=null;
       for(Bed bedA: bedList)
        {
            if(bedA.getBedID() == id)
            {
                bed = bedA;//bedA
                break;
            }
        }
       return bed;
    }
    
    
    
    
    
    //
}
