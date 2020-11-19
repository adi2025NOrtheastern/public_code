/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.EcoSystem;

import Business.Organization;
import Business.Restaurant.Restaurant;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=ecosystem;
        populateTree();
    }
    
    public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree.getModel();
       // Add the code for draw your system structure shown by JTree
       ArrayList<Restaurant> restroList=ecosystem.getRestaurantDirectory().getRestaurantList();
        ArrayList<Customer> customerList =ecosystem.getCustomerDirectory().getCustomerList() ;
        ArrayList<DeliveryMan> deliveryManlist = ecosystem.getDeliveryManDirectory().getDeliveryManList();
        
        Restaurant network;
        Customer enterprise;
        DeliveryMan organization;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Restaurants");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i=0;i<restroList.size();i++){
            network=restroList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
        }  
        DefaultMutableTreeNode enterprises=new DefaultMutableTreeNode("Customers");
        root.insert(enterprises, 1);
            //customerList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<customerList.size();j++){
                enterprise=customerList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                enterprises.insert(enterpriseNode, j);
            }
            DefaultMutableTreeNode organizastions=new DefaultMutableTreeNode("DeliveryMan");
        root.insert(organizastions, 2);
               // organizationList=enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0;k<deliveryManlist.size();k++){
                    organization=deliveryManlist.get(k);
                    organizationNode=new DefaultMutableTreeNode(organization.getName());
                    organizastions.insert(organizationNode, k);
                }
            
        
        model.reload();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSelectedNode = new javax.swing.JLabel();
        btnManageCustomer = new javax.swing.JButton();
        btnManageRestaunt = new javax.swing.JButton();
        btnManageDelivery = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 118, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        jLabel1.setText("Selected Node:");

        lblSelectedNode.setText("<View_selected_node>");

        btnManageCustomer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnManageCustomer.setText("Manage All Customers");
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });

        btnManageRestaunt.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnManageRestaunt.setText("Manage Restaurants");
        btnManageRestaunt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRestauntActionPerformed(evt);
            }
        });

        btnManageDelivery.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnManageDelivery.setText("Manage Deliveryman");
        btnManageDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblSelectedNode))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageDelivery)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnManageRestaunt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnManageCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSelectedNode))
                .addGap(54, 54, 54)
                .addComponent(btnManageCustomer)
                .addGap(18, 18, 18)
                .addComponent(btnManageRestaunt)
                .addGap(18, 18, 18)
                .addComponent(btnManageDelivery)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        ManageCustomerJPanel manageCustomersJPanel=new ManageCustomerJPanel(userProcessContainer, ecosystem, ecosystem.getCustomerDirectory());
        userProcessContainer.add("manageCustomersJPanel",manageCustomersJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }                                                  

    private void bnPerformed(java.awt.event.ActionEvent evt) {                                                     
        
    }                                                    

    private void btnPerformed(java.awt.event.ActionEvent evt) {                                                  
      
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnManageRestauntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRestauntActionPerformed
        ManageRestaurantJPanel manageRestaurantJPanel=new ManageRestaurantJPanel(userProcessContainer, ecosystem, ecosystem.getRestaurantDirectory());
        userProcessContainer.add("manageRestaurantJPanel",manageRestaurantJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageRestauntActionPerformed

    private void btnManageDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDeliveryActionPerformed
        ManageDeliveryJPanel manageDeliveryJPanel=new ManageDeliveryJPanel(userProcessContainer, ecosystem, ecosystem.getDeliveryManDirectory());
        userProcessContainer.add("manageDeliveryJPanel",manageDeliveryJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageDeliveryActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        
        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageDelivery;
    private javax.swing.JButton btnManageRestaunt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblSelectedNode;
    // End of variables declaration//GEN-END:variables
}
