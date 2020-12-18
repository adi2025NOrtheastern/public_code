/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Bed.Bed;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BedManagementDepartment;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Patient.Patient;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditi
 */
public class ManageBedJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    OrganizationDirectory organizationDirectory;
    Organization organization;
    BedManagementDepartment bedorg;
    Enterprise ent;
    EcoSystem system;
    /**
     * Creates new form ManageBedJPanel
     */
    public ManageBedJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, Organization organization, BedManagementDepartment bedorg, Enterprise ent, EcoSystem system) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.organizationDirectory= organizationDirectory;
        this.organization=organization;
        this.bedorg = bedorg;
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        bedCountTxt.setEditable(false);
        currentBedCountTxt.setText(String.valueOf(this.bedorg.getBedCount()));
        currentBedCountTxt.setEditable(false);
        this.system= system;
        this.ent = ent;
        populateBedTable();
        
    }

    
    void populateBedTable(){
        DefaultTableModel model = (DefaultTableModel) bedJTable.getModel();
        
        model.setRowCount(0);
        String bedStatus = (String)bedStatusCmb.getSelectedItem();
        for (Bed bed : bedorg.getBedList().getBedList()){
            if(bed.getStatus().getStatus().equals(bedStatus)){
            Object[] row = new Object[3];
            row[0] = bed.getBedID();
            row[1] = bed.getStatus().getStatus();
            Patient p = bed.getPatient();
            row[2] = p == null ? "": p;
            model.addRow(row);
            //row[2] = 
            }//end if
            
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        bedCountTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        bedJTable = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bedStatusCmb = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        currentBedCountTxt = new javax.swing.JTextField();
        btnViewGraph = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnViewApptntStatus = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("New Bed Count");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 373, -1, -1));
        add(bedCountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 370, 146, -1));

        bedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Bed ID", "Status", "Patient"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bedJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 114, 480, 149));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 405, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 307, -1, -1));

        jLabel5.setText("Bed Status");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 57, -1, -1));

        bedStatusCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Occupied", "Assigned Laundry" }));
        bedStatusCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedStatusCmbActionPerformed(evt);
            }
        });
        add(bedStatusCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 54, 146, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Bed Management");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 13, -1, -1));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 53, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 80, -1));

        jLabel4.setText("Current Bed Count");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 344, -1, -1));
        add(currentBedCountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 341, 146, -1));

        btnViewGraph.setText("View Bed Graph");
        btnViewGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewGraphActionPerformed(evt);
            }
        });
        add(btnViewGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 180, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BedMangmt.PNG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 289, 299, 227));

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel13.setBackground(new java.awt.Color(96, 83, 150));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        btnViewApptntStatus.setText("View Appointment Status");
        btnViewApptntStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewApptntStatusActionPerformed(evt);
            }
        });
        add(btnViewApptntStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
       // organization.g
        String count = bedCountTxt.getText();
        if(count.equals("") || count == null){
             JOptionPane.showMessageDialog(null, "Please enter value!");
            return;
        }
        int newCountBed = Integer.parseInt(bedCountTxt.getText());
        int currentCount = bedorg.getBedCount();
        
        if(currentCount > newCountBed){
            JOptionPane.showMessageDialog(null, "Cannot decrease bed Count!");
            return;

        }
        
        if(currentCount == newCountBed){
            JOptionPane.showMessageDialog(null, "No change in bed Count!");
            return;

        }
        
        newCountBed = newCountBed - currentCount;
        
        bedorg.addBedInBedList(newCountBed);
        JOptionPane.showMessageDialog(null, "Beds added successfully!");
            //return;

        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        bedCountTxt.setEditable(false);
        currentBedCountTxt.setText(String.valueOf(bedorg.getBedCount()));
        bedCountTxt.setText("");
        populateBedTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        bedCountTxt.setEditable(true);
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void bedStatusCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedStatusCmbActionPerformed
       // Organization organization = (Organization) bedStatusCmb.getSelectedItem();
        //if (organization != null){
            //populateEmployeeComboBox(organization);
           // populateRoleComboBox(organization);
        //}
    }//GEN-LAST:event_bedStatusCmbActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        populateBedTable();
        
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnViewGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewGraphActionPerformed
        // TODO add your handling code here:

        BedCountGraph manageOrganizationJPanel = new BedCountGraph(userProcessContainer, system ,ent);
        userProcessContainer.add("BedCountGraph", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewGraphActionPerformed

    private void btnViewApptntStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewApptntStatusActionPerformed
        // TODO add your handling code here:
        
        AppointmentStatusGraphInEnterprise manageOrganizationJPanel = new AppointmentStatusGraphInEnterprise(userProcessContainer, system, ent );
        userProcessContainer.add("AppointmentStatusGraphInEnterprise", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewApptntStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField bedCountTxt;
    private javax.swing.JTable bedJTable;
    private javax.swing.JComboBox bedStatusCmb;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnViewApptntStatus;
    private javax.swing.JButton btnViewGraph;
    private javax.swing.JTextField currentBedCountTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
