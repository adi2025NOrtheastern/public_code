/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author aditi
 */
public class Airliner {
    private String airLinerName;
    private int rating;
    private double shareRate;
    
    //private Fleet airplaneList;
    //private ArrayList<Flight> fArrayList;
    //private List<Flight> flightList;

    public Airliner(){
    //airplaneList=new Fleet();
    //fArrayList= new ArrayList<>();
    
}
    
    /*public Flight addFlight()
    {
        Flight fl = new Flight();
        fArrayList.add(fl);
        return fl;
    }
    public void deletefleet(Flight flight)
    {
       fArrayList.remove(flight);
    }*/
    
    
    
    
    
    
    
    
    public String getAirLinerName() {
        return airLinerName;
    }

    public void setAirLinerName(String airLinerName) {
        this.airLinerName = airLinerName;
    }
    
    @Override
    public String toString(){
        return this.getAirLinerName();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getShareRate() {
        return shareRate;
    }

    public void setShareRate(double shareRate) {
        this.shareRate = shareRate;
    }

    /*public List<Airplane> getAirplaneList() {
        return airplaneList.getAirplaneList();
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList.setAirplaneList(airplaneList);
    }*/

    
    /*public ArrayList<Flight> getfArrayList() {
        return fArrayList;
    }

    public void setfArrayList(ArrayList<Flight> fArrayList) {
        this.fArrayList = fArrayList;
    }*/
    
}
