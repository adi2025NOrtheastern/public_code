/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;
////
import Business.Appointment.Appointment;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise.Hospital;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
//import Business.WorkQueue.ReportingAdminSceneRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
////
/////**
//// *
//// * @author aditi
//// */
public class AppointmentStatusGraphInEnterprise extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    EcoSystem system;
    JFreeChart barChart;
     Enterprise enterprise;
    /**
     * Creates new form AppointmentTypeGraph
     */
    public AppointmentStatusGraphInEnterprise(JPanel userProcessContainer, EcoSystem system, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise=enterprise;
        populateBarGraph();
    }
    
    public void populateBarGraph() {
        Map<String, Integer> workReqMap = new HashMap<>();
        ArrayList<Appointment> workReqList = new ArrayList<>();
        
       // for(Network network:system.getNetworkList()) {
            
          //  for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()) {
                
                            if(enterprise instanceof Hospital)
                            {
                                for(Patient p: enterprise.getPatientDirectory().getPatientList())
                                {
                                    
                                    workReqList.addAll(p.getAppointmentDirectory().getAppointmentList());
                                }
                            }
          //  }
       // }
                                
                  for(Appointment app : workReqList)      
                  {//--Select--, In-Person, Online
                      if(app.getStatus().equals(Appointment.AppointmentStatus.New.getValue()))
                                   {
                                       workReqMap.put("New", workReqMap.getOrDefault("New", 0) +1);
                                       
                                   }
                      else  if(app.getStatus().equals(Appointment.AppointmentStatus.Close.getValue()))
                                   {
                                       workReqMap.put("Close", workReqMap.getOrDefault("Close", 0) +1);
                                       
                                   }
                      
                      else if(app.getStatus().equals(Appointment.AppointmentStatus.ApprovedInsurance.getValue()))
                                   {
                                       workReqMap.put("ApprovedInsurance", workReqMap.getOrDefault("ApprovedInsurance", 0) +1);
                                       
                                   }
                      else if(app.getStatus().equals(Appointment.AppointmentStatus.MarkForInsurance.getValue()))
                                   {
                                       workReqMap.put("MarkForInsurance", workReqMap.getOrDefault("MarkForInsurance", 0) +1);
                                       
                                   }
                      
                      else if(app.getStatus().equals(Appointment.AppointmentStatus.BedAssigned.getValue()))
                                   {
                                       workReqMap.put("BedAssigned", workReqMap.getOrDefault("BedAssigned", 0) +1);
                                       
                                   }
                      
                      else if(app.getStatus().equals(Appointment.AppointmentStatus.GeneratedReport.getValue()))
                                   {
                                       workReqMap.put("GeneratedReport", workReqMap.getOrDefault("GeneratedReport", 0) +1);
                                       
                                   }
                             else if(app.getStatus().equals(Appointment.AppointmentStatus.Markforbilling.getValue()))
                                   {
                                       workReqMap.put("Markforbilling", workReqMap.getOrDefault("Markforbilling", 0) +1);
                                       
                                   }  
                        }
                
            
        
      
        barChart = ChartFactory.createPieChart(
         "Appointment Status Report",            
         createDataset(workReqMap),          
                 
         true, true, false);
         
        ChartPanel chartPanel = new ChartPanel( barChart );   
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
        /*chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
        setContentPane( chartPanel );*/ 
        
    }
    
    private PieDataset createDataset(Map<String, Integer>  workReqMap) {
        final DefaultPieDataset dataset = new DefaultPieDataset();  

        for(String r : workReqMap.keySet()) {
            dataset.setValue(r, workReqMap.get(r));
        }               

        return dataset; 
//    final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
//      int size= workReqList.size();
//    for(String r : workReqList.keySet()) {
//        dataset.addValue(Integer.parseInt( workReqList.get(r)), size,"#Type");
//        //dataset.addValue(r.getNoOfVictims(), r.getSceneName(), "# of Victims");
    
   }
    
////    /**
////     * This method is called from within the constructor to initialize the form.
////     * WARNING: Do NOT modify this code. The content of this method is always
////     * regenerated by the Form Editor.
////     */
////    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 860, 600));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 56, 82));
        jButton1.setText("Download Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APPOINTMENT STATUS GRAPH");
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 11, 498, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

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

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int width = 640;    /* Width of the image */
            int height = 480;   /* Height of the image */
            File BarChart = new File( "Appointment.jpeg" );
            ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
            JOptionPane.showMessageDialog(null, "A JPEG image file named Appointment.jpeg is downloaded in your current directory.");
        } 
        catch (IOException ex) {
            Logger.getLogger(AppointmentStatusGraphInEnterprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    // End of variables declaration//GEN-END:variables
}
