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
public class Fleet {
    //list of airplane
    
    private List<Airplane> airplaneList;

    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }
    
    public Fleet(){
        airplaneList = new ArrayList<>();
    }
    
    public void addAirplane(Airplane a)
    {
        airplaneList.add(a);
    }
    
}
