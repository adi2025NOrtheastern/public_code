/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Bed;

import Business.Appointment.Appointment;
import Business.Patient.Patient;

/**
 *
 * @author aditi
 */
public class Bed {
    private int bedID;
    private BedType bedType;
    private Double price;
    private BedStatus status;
    private static int count =1;
    private Patient patient;
    private Appointment appointment;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Bed.count = count;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Bed(){
        this.bedID = count++;
        this.status = BedStatus.Available;
        this.bedType = BedType.Normal;
        this.price = 1000.00;
        this.patient = null;
    }
    
    
    public int getBedID() {
        return bedID;
    }

    public void setBedID(int bedID) {
        this.bedID = bedID;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BedStatus getStatus() {
        return status;
    }

    public void setStatus(BedStatus status) {
        this.status = status;
    }
    
            
    public enum BedStatus{
        Available("Available"),
        Occupied("Occupied"),
        AssignedLaundry("Assigned Laundry");
        
        private String status;

        private BedStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return status ;
        }
        
        
    }
    
    public enum BedType{
        Delux("Delux"),
        Normal("Normal");
        
        private String bedType;
        
        private BedType(String bedType){
            this.bedType = bedType;
        }

        public String getBedType() {
            return bedType;
        }

        public void setBedType(String bedType) {
            this.bedType = bedType;
        }

        @Override
        public String toString() {
            return bedType ;
        }
        
    }
    
    @Override
        public String toString() {
            return "Bed"+String.valueOf(this.bedID) ;
            
        }
    
    
      @Override
    public boolean equals(Object o) { 
  

        // typecast o to Complex so that we can compare data members  
        Bed c = (Bed) o; 
          
        // Compare the data members and return accordingly  
        //return Double.compare(re, c.re) == 0
        //        && Double.compare(im, c.im) == 0; 
        
        return (this.bedID==(c.bedID)&&  this.bedType.equals(c.bedType));
    }
    
    
}
