/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.InsuranceEnterprise;

import Business.Enterprise.HospitalEnterprise.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
public class InsuranceDirectory {
    
    List<InsuranceDetails> insuranceDir ;
    
    
    
    public InsuranceDirectory(){
     insuranceDir = new ArrayList<>();
    }
    
    public List<InsuranceDetails> getInsuranceDetailsBySSN(String SSN){
         List<InsuranceDetails> list = new  ArrayList<InsuranceDetails>();
        for(InsuranceDetails indt: insuranceDir)
        {
            if(indt.getSSN().equals(SSN))
            {
                list.add(indt);
            }
        }
        
        return list;
    } 

    public List<InsuranceDetails> getInsuranceDir() {
        return insuranceDir;
    }

    public void setInsuranceDir(List<InsuranceDetails> insuranceDir) {
        this.insuranceDir = insuranceDir;
    }
    
    
}
