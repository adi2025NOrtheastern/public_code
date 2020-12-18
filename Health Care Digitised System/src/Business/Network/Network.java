/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
      @Override
    public boolean equals(Object o) { 
  

        // typecast o to Complex so that we can compare data members  
        Network c = (Network) o; 
          
        // Compare the data members and return accordingly  
        //return Double.compare(re, c.re) == 0
        //        && Double.compare(im, c.im) == 0; 
        
        return (this.name.equals(c.name));
    }
    
}
