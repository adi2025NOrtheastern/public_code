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
public class RowSeat {
    private String seatNumber;
    //private boolean isAvailable;//Unavailable -booked reserved, 
    //private String type; //- window/mid,aisle
    //private String columnNumber;
    //private String seatStatus;
    
    private boolean wleft;
    private boolean wright;
    private boolean aleft;
    private boolean aright;
    private boolean mleft;
    private boolean mright;
    //true- available
    public RowSeat(){
        wleft=true;
        wright=true;
        aleft=true;
        aright=true;
        mleft=true;
        mright=true;
    }
   
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isWleft() {
        return wleft;
    }

    public void setWleft(boolean wleft) {
        this.wleft = wleft;
    }

    public boolean isWright() {
        return wright;
    }

    public void setWright(boolean wright) {
        this.wright = wright;
    }

    public boolean isAleft() {
        return aleft;
    }

    public void setAleft(boolean aleft) {
        this.aleft = aleft;
    }

    public boolean isAright() {
        return aright;
    }

    public void setAright(boolean aright) {
        this.aright = aright;
    }

    public boolean isMleft() {
        return mleft;
    }

    public void setMleft(boolean mleft) {
        this.mleft = mleft;
    }

    public boolean isMright() {
        return mright;
    }

    public void setMright(boolean mright) {
        this.mright = mright;
    }

    
}
