/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author aditi
 */
public class TravelOffice {
    private String trvlOffcID;
    private String trvlOffcName;
    private CustomerDirectory custDir;
    
    public String getTrvlOffcID() {
        return trvlOffcID;
    }

    public void setTrvlOffcID(String trvlOffcID) {
        this.trvlOffcID = trvlOffcID;
    }

    public String getTrvlOffcName() {
        return trvlOffcName;
    }

    public void setTrvlOffcName(String trvlOffcName) {
        this.trvlOffcName = trvlOffcName;
    }

    public CustomerDirectory getCustDir() {
        return custDir;
    }

    public void setCustDir(CustomerDirectory custDir) {
        this.custDir = custDir;
    }
    
}
