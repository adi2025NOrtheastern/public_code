/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryMan;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.EcoSystem;
import Business.Menu.MenuDirectory;
import Business.Order.Order;
import Business.Order.OrderDirectory;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cnakhare
 */
public class ManageOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrderJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business;
    //private CustomerDirectory customerDirectory;
    private RestaurantDirectory restaurantDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    private MenuDirectory menuDirectory;
    private OrderDirectory orderDirectory;
    
    public ManageOrderJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business, RestaurantDirectory restaurantDirectory, DeliveryManDirectory deliveryManDirectory, MenuDirectory menuDirectory, OrderDirectory orderDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        //this.customerDirectory = customerDirectory;
        this.restaurantDirectory = restaurantDirectory;
        this.deliveryManDirectory = deliveryManDirectory;
        this.menuDirectory = menuDirectory;
        this.orderDirectory = orderDirectory;
        populate();
        populateDeliveryManTable();
    }
    
    public void populate() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);
        Restaurant rs = business.getRestaurantDirectory().getRestaurantByManagerID(account.getEmployee().getId());
        for (Order order : business.getOrderDirectory().getOrderDirectory()) {
            if (order.getRestaurant().getId()== rs.getId()) {
                Object[] row = new Object[10];
                row[0] = order.getMessage();
                row[1] = order.getReceiver();
                row[2] = order.getStatus();
                row[3] = (order.getResult() == null ? "Waiting" : order.getResult());
                row[4] = order.getRestaurant().getName();
                row[5] = order.getFoodItem().getItemName();
                row[6] = order.getQuantity();
                row[7] = order.getQuantity() * order.getFoodItem().getPrice();
                row[8] = (order.getDeliveryMan() == null) ? "Not Assigned" : order.getDeliveryMan().getName();
                row[9] = order;//.getOrderId();
                model.addRow(row);
            }
        }
    }
    
    public void populateDeliveryManTable(){
        DefaultTableModel model = (DefaultTableModel) deliveryTable.getModel();
        model.setRowCount(0);
        for (DeliveryMan deliveryMan : business.getDeliveryManDirectory().getDeliveryManList()) {
                Object[] row = new Object[3];
                row[0] = deliveryMan.getName();
                row[1] = deliveryMan.getPhoneNum();
                //row[2] = deliveryMan.getAddress();
                row[2] = deliveryMan;//.getId();
                model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        deliveryTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel9.setText("Orders");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result", "Restaurant Name", "Food Item", "Quantity", "Total Cost", "Delivery Man", "Order Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderTable);

        jButton1.setText("Confirm Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Assign Delivery Man");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Delivery Man Name", "Contact No", "Delivery Man Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(deliveryTable);

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Decline Order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(46, 46, 46)
                                        .addComponent(jButton4)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(335, 335, 335)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row = orderTable.getSelectedRow();
        if (row >= 0) {
            //String id = (String)orderTable.getValueAt(row, 9);
            Order order = (Order)orderTable.getValueAt(row, 9);//business.getOrderDirectory().getOrderByOrderId(id);//orderDirectory.getOrderDirectory().get(row);
            
            if(order.getStatus().equals("Declined"))
            {
                JOptionPane.showMessageDialog(null, "Order is declined cannot change!");
                return;
            }
            order.setStatus("Confirmed");
            JOptionPane.showMessageDialog(null, "Order Confirmed!");
            populate();
        } else {
            JOptionPane.showMessageDialog(null, "Select a order!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = orderTable.getSelectedRow();
        if (row >= 0) {
           // String orderID=
            Order order = (Order)orderTable.getValueAt(row, 9);//business.getOrderDirectory().getOrderByOrderId(row,9);
            System.out.println(order.getStatus().trim());
            if (order.getStatus().trim().equalsIgnoreCase("Confirmed")) {
                int deliveryRow = deliveryTable.getSelectedRow();
                if (deliveryRow >= 0) {
                    DeliveryMan dm1=(DeliveryMan)deliveryTable.getValueAt(deliveryRow, 2);
                    order.setDeliveryMan(dm1);
                    String empId = String.valueOf( dm1.getId());
                    UserAccount user = business.getUserAccountDirectory().getUserByEmployeeId(empId);
                    order.setReceiver(user);
                    order.setSender(account);
                    //order.setCustomer(customer);
                    order.setStatus("Prepared Order");
                    JOptionPane.showMessageDialog(null, "Delivery Man Assigned!");
                    populate();
                } else {
                    JOptionPane.showMessageDialog(null, "Select a delivery man to assign from dm table!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Order has not been confirmed! Please confirm the order before assigning!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a order!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = orderTable.getSelectedRow();
        if (row >= 0) {
            //String id = (String)orderTable.getValueAt(row, 9);
            Order order = (Order)orderTable.getValueAt(row, 9);//business.getOrderDirectory().getOrderByOrderId(id);//orderDirectory.getOrderDirectory().get(row);
            order.setStatus("Declined");
            order.setResult("Declined");
            //DeliveryMan dm1 = new DeliveryMan();
            //dm1.setName("Declined");
      
            //order.setDeliveryMan(dm1);
            JOptionPane.showMessageDialog(null, "Order Declined!");
            populate();
        } else {
            JOptionPane.showMessageDialog(null, "Select a order!");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable deliveryTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable orderTable;
    // End of variables declaration//GEN-END:variables
}
