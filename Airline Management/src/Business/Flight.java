/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
public class Flight {
    private String flightNum;
    private String flightName;
    //private int seatCount;
    private String airlinerName;

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }
    //private List<FlightSchedule> flightSchedule;
    //private FlightSchedule flightSchedule;
    
    public Flight(){
       //flightSchedule= new FlightSchedule();
     //  flightSchedule= new ArrayList<>();
      
    }
   
    
    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    /*public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }*/
    
    
    /* public List<FlightSchedule> getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(List<FlightSchedule> flightSchedule) {
        this.flightSchedule = flightSchedule;
    }
    */
    
    
     @Override
    public String toString()
    {
        return this.getFlightNum();
    }
   
}
