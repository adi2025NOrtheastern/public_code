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
public class Airplane {
    private String airlinerName;

    private String airplaneName;
    private List<RowSeat> availableSeats;  

    public List<RowSeat> getSeats() {
        return availableSeats;
    }

    public void setSeats(List<RowSeat> seats) {
        this.availableSeats = seats;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
    
    
    private int seatCount; 
   
    //private String planeClass;
    //private List<Person> crew;
    //private double fuelCapacity;
    //private String model;
    private String modelNum;
    //private List<Flight> flightList;
    //private Date nextMaintDate;
    //private List<FlightSchedule> flightSchedule;
    
    
    public Airplane(){
        //new RowSeat();
        //this.flightList = flightList;

        availableSeats= new ArrayList<>();
        for(int i=0;i<25;i++)
        {
            RowSeat s = new RowSeat();
            availableSeats.add(s);
    }

        this.setSeatCount(25*6);


    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }



    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    /*public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }*/

    
    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }
     @Override
    public String toString(){
        return this.getAirplaneName();
    }
}
