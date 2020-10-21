/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Interface.CarMainJFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditi
 */
public class Uber {
    List<Car> availableCarList;
    List<Car> bookedCarList;
    int carCount;
    String modifiedDate;
    String createdDate;
    //String geolocation;

    public Uber(){
        availableCarList= new ArrayList<Car>();
        bookedCarList= new ArrayList<Car>();
    }
    
    public List<Car> getAvailableCarList() {
        return availableCarList;
    }

    public void setAvailableCarList(List<Car> availableCarList) {
        this.availableCarList = availableCarList;
    }

    public List<Car> getBookedCarList() {
        return bookedCarList;
    }

    public void setBookedCarList(List<Car> bookedCarList) {
        this.bookedCarList = bookedCarList;
    }

    public int getCarCount() {
        carCount=availableCarList.size() + bookedCarList.size();
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
        this.modifiedDate = new Date().toString();
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = new Date().toString();
    }

    /*public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }*/
    
    //How many cars are currently available. How many are not.
    public int getAvailableCarCount(){
        return availableCarList.size();
    }
    
    //unavailable car count
    public int getUnavailableCarCount(){
        return bookedCarList.size();
    }
    
    
    //Find me the first available passenger car
    public Car getFirstAvlblPassngrCar(){
        Car carPassngr= null;
        for(Car car: availableCarList)
        {
            if( car.getCarType().equals("Passenger"))
            {
                carPassngr=car;
                break;
            }
        }
        return carPassngr;
    }
    
    //List all cars that are made by Toyota, GM, etc.
    public Map<String,ArrayList<Car>> getCarListByManufacturer(){
        HashMap<String,ArrayList<Car>> result= new HashMap<String,ArrayList<Car>>();
        for(Car car: availableCarList)
        {
            if( result.containsKey(car.getManufacturer()))
            {
                ArrayList<Car> temp = result.get(car.getManufacturer());
                temp.add(car);
                result.put(car.getManufacturer(), temp);
                
            }
            else{
                ArrayList<Car> addNewManufacturerList = new ArrayList<>();
                addNewManufacturerList.add(car);
                result.put(car.getManufacturer(), addNewManufacturerList);
            }
        }
        
        for(Car car: bookedCarList)
        {
            if( result.containsKey(car.getManufacturer()))
            {
                ArrayList<Car> temp = result.get(car.getManufacturer());
                temp.add(car);
                result.put(car.getManufacturer(), temp);
                
            }
            else{
                ArrayList<Car> addNewManufacturerList = new ArrayList<>();
                addNewManufacturerList.add(car);
                result.put(car.getManufacturer(), addNewManufacturerList);
            }
        }
        
        return result;
    }
    
    //List all cars that were manufactured in a given year, ‘x’.
    public List<Car> getCarListByYear(String year){
        ArrayList<Car> carList= new ArrayList<>();
        for(Car car: availableCarList)
        {
            if(car.getManufactureYear().equals(year)){
                carList.add(car);
            }
        }
        for(Car car: bookedCarList)
        {
            if(car.getManufactureYear().equals(year)){
                carList.add(car);
            }
        }
        return carList;
    }
    
    //Find an available car with a minimum of x seats but no more than y seats.
    public Car getCarBySeatRange(int x,int y){
        Car result=null;
        for(Car car:availableCarList)
        {
            if(car.getSeatCount()>=x && car.getSeatCount()<=y){
                result=car;
                break;
            }
        }
        return result;
    }
    
    //Find a car with the given serial number. List the attributes of the found car.
    public Car getCarBySNO(String sno){
        Car r=null;
        for(Car car:availableCarList){
            if(car.getSerialNumber().equals(sno))
            {
                r=car;
                return r;
            }
        }
        
        for(Car car:bookedCarList){
            if(car.getSerialNumber().equals(sno))
            {
                r=car;
                break;
            }
        }
        return r;
    }
    
    //List all cars given the model number.
    public List<Car> getCarListByModel(String model){
        ArrayList<Car> carList= new ArrayList<>();
        for(Car car: availableCarList)
        {
            if(car.getModelNumber().equals(model)){
                carList.add(car);
            }
        }
        for(Car car: bookedCarList)
        {
            if(car.getModelNumber().equals(model)){
                carList.add(car);
            }
        }
        return carList;
    }
    
    //tricky!!!!!!!!!!!!!!
    //List all the car manufacturers used by the (this) Uber.
    public List<String> getFleetManufacturerList(){
        List<String> result = new ArrayList<>();
        for(Car car: bookedCarList)
        {
            if(!result.contains(car.getManufacturer()))
            result.add(car.getManufacturer());
                
            }
        for(Car car: availableCarList)
        {
            if(!result.contains(car.getManufacturer()))
            result.add(car.getManufacturer());
                
            }
        return result;
    }
    
    
    //When was the last time the fleet catalog was updated.
    public String getFleetModifiedDate(){
        return this.getModifiedDate();
    }
    
    //List all cars that are available in a given city.
    public List<Car> getAvailableCarbyCity(String city){
        List<Car> result= new ArrayList<>();
        for(Car car:availableCarList){
            if(car.getCity().equals(city)){
                result.add(car);
            }
        }
        return result;
    }
    
    //List all cars that have expired maintenance certificate.
    public List<Car> getCarListByExpCerti() {
        
        ArrayList<Car> carList= new ArrayList<>();
        try{
        //String date = java.time.LocalDate.now().toString();
        SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy");
        Date d1;
        //d1 = sdformat.parse(date);
       // d1 = new SimpleDateFormat("MM/dd/yyyy").format(new Date(date));
        Date sdate = new Date();
        String modifiedDate= new SimpleDateFormat("MM/dd/yyyy").format(sdate);
        d1=sdformat.parse(modifiedDate);
        Date d2;
        for(Car car: availableCarList)
        {
            d2=sdformat.parse(car.getMaintenanceCertiDate());
            if(d1.compareTo(d2) > 0){
                carList.add(car);  //Date 1 occurs after Date 2
            }
        }
        for(Car car: bookedCarList)
        {
            d2=sdformat.parse(car.getMaintenanceCertiDate());
            if(d1.compareTo(d2) > 0){
                carList.add(car);
            }
        }
        
        }
        catch(Exception e){
            System.out.println("Parse exception in getting date certificate");
        }
        return carList;
    }
    
    
    
    public void populate(ArrayList<Car> availableCarList,ArrayList<Car> bookedCarList)
    {
        this.setAvailableCarList(availableCarList);
        this.setBookedCarList(bookedCarList);
    }
}
    
    

