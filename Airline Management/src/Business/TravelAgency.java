/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.List;

/**
 *
 * @author aditi
 */
public class TravelAgency {
    //private String travelAgencyName;
    private List<TravelOffice> officeList;
    //private List<Airliner> airlinerList;
    private MasterTravelSchedule masterTravelSchedule;

    public List<TravelOffice> getOfficeList() {
        return officeList;
    }

    public void setOfficeList(List<TravelOffice> officeList) {
        this.officeList = officeList;
    }

    /*public List<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(List<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }*/
}
