/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aditi
 */

public class FlightSchedule {
    //private List<Schedule> schedule;
    //private List<Customer> customerList;
    private double price;  
    private String src ;  //source
    private String destination;
    private Date date;  //
    //private List<Seat> seatList;
    private String time; //morning, evening, night
    private String flightNum;
    private Airplane airplane;
    private String fsID;
    private int flightSeatCount;

    public int getFlightSeatCount() {
        return flightSeatCount;
    }

    public void setFlightSeatCount(int flightSeatCount) {
        this.flightSeatCount = flightSeatCount;
    }
    static int count=100;
    public String getFsID() {
        return fsID;
    }

    public void setFsID(String fsID) {
        this.fsID = "FS"+count++;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    
    public String toString(){
        return this.flightNum;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightName) {
        this.flightNum = flightName;
    }
       
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public FlightSchedule(Flight flight)
    {
        //this.flight=flight;
        //schedule = new ArrayList<>();
       // customerList = new ArrayList<>();
        
    }
    
    public FlightSchedule()
    {
        //this.flight=flight;
        //schedule = new ArrayList<>();
       // customerList = new ArrayList<>();
        this.setFsID("F1");
        this.flightSeatCount=130;//130;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //book
    public String bookTicket(String seatType){
        List<RowSeat> sList=this.getAirplane().getSeats();
        int rowCounter=1;
        String seatNum="Not Available";
        boolean seatFound=false;
        for(RowSeat rs: sList)
        {
            switch (seatType)
            {
                case "Middle":
                    if(rs.isMleft())
                    {
                        rs.setMleft(false);
                        seatFound=true;
    
                        seatNum= (rowCounter+"_Middle_left");
                    }
                    else if(rs.isMright())
                    {
                        rs.setMright(false);
                        seatFound=true;
                        seatNum= (rowCounter+"_Middle_right");
                    }
    
                    break;
                    
                case "Window":
                          if(rs.isWleft())
                    {
                        rs.setWleft(false);
                        seatFound=true;
                        seatNum= (rowCounter+"_Window_left");
}
                    else if(rs.isWright())
                    {
                        rs.setWright(false);
                        seatFound=true;
                        seatNum= (rowCounter+"_Window_right");
                    }
                    
                        break;
                        
                        
                case "Aisle":
                      if(rs.isAleft())
                    {
                        rs.setAleft(false);
                        seatFound=true;
                        seatNum= (rowCounter+"_Aisle_left");
                    }
                    else if(rs.isAright())
                    {
                        rs.setAright(false);
                        seatFound=true;
                        seatNum= (rowCounter+"_Aisle_right");
                    }
                    
                    break;
                        
            }
            rowCounter++; 
            if(seatFound==true)
        {
            int count=this.getFlightSeatCount();
            if(count==0)
            {
                
                break;
            }
            else{
            this.setFlightSeatCount(--count);
            
            break;
            }
        }
            
        }//end for
        
        /*if(seatFound==true)
        {
            int count=airplane.getSeatCount();
            airplane.setSeatCount(--count);
        }*/
       return seatNum;
    }
    
    
    
    //book
    public void cancelTicket(String seatType){
        List<RowSeat> sList=this.getAirplane().getSeats();
        int rowCounter=1;
        String[] seatNum=seatType.split("_");
        boolean seatFound=false;
        for(RowSeat rs: sList)
        {
            switch (seatNum[1])
            {
                case "Middle":
                    if(seatNum[2].equals("left"))
                    {
                        rs.setMleft(true);
                        seatFound=true;
                        
                       // seatNum= (rowCounter+"_Middle_left");
                    }
                    else if(seatNum[2].equals("right"))
                    {
                        rs.setMright(true);
                        seatFound=true;
                       // seatNum= (rowCounter+"_Middle_right");
                    }
                    
                    break;
                    
                case "Window":
                          if(seatNum[2].equals("left"))
                    {
                        rs.setWleft(true);
                        seatFound=true;
                       // seatNum= (rowCounter+"_Window_left");
                    }
                    else if(seatNum[2].equals("right"))
                    {
                        rs.setWright(true);
                        seatFound=true;
                       // seatNum= (rowCounter+"_Window_right");
                    }
                    
                        break;
                        
                        
                case "Aisle":
                      if(seatNum[2].equals("left"))
                    {
                        rs.setAleft(true);
                        seatFound=true;
                       // seatNum= (rowCounter+"_Aisle_left");
                    }
                    else if(seatNum[2].equals("right"))
                    {
                        rs.setAright(true);
                        seatFound=true;
                        //seatNum= (rowCounter+"_Aisle_right");
                    }
                    
                    break;
                        
            }
            rowCounter++; 
            if(seatFound==true)
        {
            int count=this.getFlightSeatCount();
            if(count==130){
                break;
            }else{
            this.setFlightSeatCount(++count);
            break;
            }
        }
            
        }//end for
        
        /*if(seatFound==true)
        {
            int count=airplane.getSeatCount();
            airplane.setSeatCount(--count);
        }*/
      // return seatNum;
    }
    
    
}
