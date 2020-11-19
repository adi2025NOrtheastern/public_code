/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
/**
 *
 * @author aditi
 */
public class AirlinerDirectory {
    private List<Airliner> airlinerList;

    
    public AirlinerDirectory(){
    airlinerList = new ArrayList<>();
    
    }
    
   
   
    
    public List<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(List<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }

    public void addAirline(Airliner airlinerNew) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    airlinerList.add(airlinerNew);
    
    }
    
    
    
    
    
    
    
}
