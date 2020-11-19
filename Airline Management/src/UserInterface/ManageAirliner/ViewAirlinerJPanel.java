/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManageAirliner;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Airplane;
import Business.Fleet;
import Business.Flight;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aditi
 */
public class ViewAirlinerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAirlinerJPanel
     */
    Airliner airliner;
    AirlinerDirectory airlinerDir;
    Fleet airplaneList;
    JPanel userProcessContainer;
    List<Flight> flightList;
    
    public ViewAirlinerJPanel(JPanel upc, Airliner airliner, AirlinerDirectory airlinerDir, Fleet airplaneList, List<Flight> flightList) {
        initComponents();
        this.airliner= airliner;
        this.airlinerDir=airlinerDir;
        this.userProcessContainer=upc; 
        this.airplaneList=airplaneList;
        this.flightList=flightList;
        populate();
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
    }

  
    
    public void populate(){
        txtName.setText(airliner.getAirLinerName());
        cmbRating.setSelectedIndex(airliner.getRating());
        txtSharePrice.setText(String.valueOf(airliner.getShareRate()));
        txtName.setEnabled(false);
        cmbRating.setEnabled(false);
        txtSharePrice.setEnabled(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSharePrice = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        cmbRating = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Airliner");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Rating:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Share Price:");

        txtSharePrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSharePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSharePriceActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setToolTipText("");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setToolTipText("");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("<Back");
        btnBack.setToolTipText("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cmbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "1", "2", "3", "4", "5" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnBack)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(btnUpdate))
                            .addComponent(cmbRating, javax.swing.GroupLayout.Alignment.LEADING, 0, 232, Short.MAX_VALUE)
                            .addComponent(txtSharePrice, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRating, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSharePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addContainerGap(260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         backAction();
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void backAction(){
        userProcessContainer.remove(this);
        Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        ManageAirlinersJPanel ms = (ManageAirlinersJPanel) c;
        ms.populateAirlinerList();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    
    }
    
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtName.setEnabled(true);
        cmbRating.setEnabled(true);
        txtSharePrice.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(txtName.getText()==null || "".equals(txtName.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Airliner Name");
            return;
        }
        
        int rating =cmbRating.getSelectedIndex();
        if(rating == 0)
        {
            JOptionPane.showMessageDialog(null, "Please select Rating!");
            return;
        }
        
        if(txtSharePrice.getText()==null || "".equals(txtSharePrice.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Share price");
            return;
        }
        
        //String only
        boolean match = txtName.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Name correctly");
            return;
        }
        
        //digits only
        match = txtSharePrice.getText().matches("[0-9]+.?[0-9]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Share Price correctly");
            return;

        }
        
        String name=txtName.getText();
        //rating =cmbRating.getSelectedIndex();
        double sharePrc = Double.parseDouble(txtSharePrice.getText());
        String oldName= airliner.getAirLinerName();
        //Airliner a = new Airliner();
        airliner.setAirLinerName(name);
        airliner.setRating(rating);
        airliner.setShareRate(sharePrc);
        //removeprevious entry
        //airlinerDir.getAirlinerList().remove(airliner);
        //add new entry
        //airlinerDir.getAirlinerList().add(a);
        JOptionPane.showMessageDialog(null, "Airliner updated successfully!");
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        txtName.setEnabled(false);
        cmbRating.setEnabled(false);
        txtSharePrice.setEnabled(false);
        //update name in airplanes
        
        updateAirplaneAirlinerName(name,oldName);
        updateFlightAirlinerName(name,oldName);
    }//GEN-LAST:event_btnSaveActionPerformed

    
    public void updateAirplaneAirlinerName(String name,String oldName){
        for(Airplane plane : airplaneList.getAirplaneList())
        {
            if(plane.getAirlinerName().equals(oldName))
            {
                plane.setAirlinerName(name);
            }
        }
    }
    
    
    public void updateFlightAirlinerName(String name,String oldName){
        for(Flight fl : flightList)
        {
            if(fl.getAirlinerName().equals(oldName))
            {
                fl.setAirlinerName(name);
            }
        }
    }
    
    private void txtSharePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSharePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSharePriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSharePrice;
    // End of variables declaration//GEN-END:variables
}
