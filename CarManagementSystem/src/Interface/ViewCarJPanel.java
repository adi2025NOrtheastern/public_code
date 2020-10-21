/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Car;
import Business.Uber;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author aditi
 */
public class ViewCarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewCarJPanel
     */
    Uber uobj;
    Car car;
    JSplitPane splitpane;
    JPanel previousFrame;
    public ViewCarJPanel(Car car,Uber uobj,JSplitPane splitpane, JPanel previousFrame) {//for update view normal
        initComponents();
        this.uobj=uobj;
        this.car=car;
        this.splitpane=splitpane;
        this.previousFrame=previousFrame;
        populate(car);
        
    }
    
    
    public ViewCarJPanel(Uber uobj,JSplitPane splitpane,JPanel previousFrame) {//for seat count
        initComponents();
        //populateForSeat(car);
        this.uobj=uobj;
        this.splitpane=splitpane;
        //this.car=car;
        this.previousFrame=previousFrame;
        txtCarName.setEnabled(false);        
        txtManufactureYear.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtCity.setEnabled(false);
        txtCarTypr.setEnabled(false);
        txtCertiDate.setEnabled(false);
        txtSeat.setEnabled(false);
        txtSerialNo.setEnabled(false);
        txtManufacturer.setEnabled(false);
        chckAvailable.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(false);
        txtGetSeat2.setVisible(true);
        txtGetSeat1.setVisible(true);
        lblSeat.setVisible(true);
        btnSearch.setVisible(true);
        comboCarType.setEnabled(false);
        //this.car=car;
        
    }

    public ViewCarJPanel(Uber uobj, Car car, JSplitPane splitpane,JPanel previousFrame) {//for serial number
        initComponents();
        this.uobj=uobj;
        this.car=car;
        this.splitpane=splitpane;
        this.previousFrame=previousFrame;
        populate(this.car);
    }

    public ViewCarJPanel(Uber obj, JSplitPane splitpane, String city,JPanel previousFrame) {
        initComponents();
        this.uobj=uobj;
        this.splitpane=splitpane;
        this.previousFrame=previousFrame;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   private void populateForSeat(Car car)
    {
        txtCarName.setText(car.getCarName());
        txtManufactureYear.setText(car.getManufactureYear());
        txtModelNumber.setText(car.getModelNumber());
        txtCity.setText(car.getCity());
        txtCarTypr.setText(car.getCarType());
        txtCertiDate.setText(car.getMaintenanceCertiDate());
        txtSeat.setText(String.valueOf(car.getSeatCount()));
        txtSerialNo.setText(car.getSerialNumber());
        txtManufacturer.setText(car.getManufacturer());
        lblUniqueId.setText(car.getUniqueId());
        /*if(uobj.getAvailableCarList().contains(car)){
        chckAvailable.setSelected(true);
        }*/
        if(car.getAvailable().equals("A")){
        chckAvailable.setSelected(true);
        }
        else{
            chckAvailable.setSelected(false);
        }
        //disable
        txtCarName.setEnabled(false);        
        txtManufactureYear.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtCity.setEnabled(false);
        txtCarTypr.setEnabled(false);
        txtCertiDate.setEnabled(false);
        txtSeat.setEnabled(false);
        txtSerialNo.setEnabled(false);
        txtManufacturer.setEnabled(false);
        chckAvailable.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        txtGetSeat2.setVisible(true);
        txtGetSeat1.setVisible(true);
        lblSeat.setVisible(true);
        btnSearch.setVisible(true);
        comboCarType.setEnabled(false);
        this.car=car;
    }

    private void populate(Car car)
    {
        if(this.car==null)
        {
            JOptionPane.showMessageDialog(null, "No Car");
            return;
        }
        txtCarName.setText(car.getCarName());
        txtManufactureYear.setText(car.getManufactureYear());
        txtModelNumber.setText(car.getModelNumber());
        txtCity.setText(car.getCity());
        txtCarTypr.setText(car.getCarType());
        txtCertiDate.setText(car.getMaintenanceCertiDate());
        txtSeat.setText(String.valueOf(car.getSeatCount()));
        txtSerialNo.setText(car.getSerialNumber());
        txtManufacturer.setText(car.getManufacturer());
        lblUniqueId.setText(car.getUniqueId());
        if(car.getAvailable().equals("A")){
        chckAvailable.setSelected(true);
        }
        else{
            chckAvailable.setSelected(false);
        }
        //disable
        txtCarName.setEnabled(false);        
        txtManufactureYear.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtCity.setEnabled(false);
        txtCarTypr.setEnabled(false);
        txtCertiDate.setEnabled(false);
        txtSeat.setEnabled(false);
        txtSerialNo.setEnabled(false);
        txtManufacturer.setEnabled(false);
        chckAvailable.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        txtGetSeat2.setVisible(false);
        lblSeat.setVisible(false);
        btnSearch.setVisible(false);
        txtGetSeat1.setVisible(false);
        comboCarType.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtModelNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSerialNo = new javax.swing.JTextField();
        txtManufactureYear = new javax.swing.JTextField();
        txtCarName = new javax.swing.JTextField();
        txtSeat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCertiDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        txtCarTypr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        chckAvailable = new javax.swing.JCheckBox();
        btnDelete = new javax.swing.JButton();
        lblSeat = new javax.swing.JLabel();
        txtGetSeat2 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtGetSeat1 = new javax.swing.JTextField();
        lblUniqueId = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        comboCarType = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Car Type");

        txtModelNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtModelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelNumberActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Model Number ");

        txtSerialNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSerialNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerialNoActionPerformed(evt);
            }
        });

        txtManufactureYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtManufactureYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufactureYearActionPerformed(evt);
            }
        });

        txtCarName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCarName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarNameActionPerformed(evt);
            }
        });

        txtSeat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeatActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Serial Number");

        txtCertiDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCertiDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCertiDateActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Manufacture Year");

        txtCity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("City");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Number of Seats");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Expiry date Certificate");

        txtManufacturer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufacturerActionPerformed(evt);
            }
        });

        txtCarTypr.setEditable(false);
        txtCarTypr.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCarTypr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarTyprActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Car Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Manufacturer");

        btnUpdate.setBackground(new java.awt.Color(153, 255, 204));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(153, 255, 153));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        chckAvailable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chckAvailable.setText("Check if Available");

        btnDelete.setBackground(new java.awt.Color(204, 204, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblSeat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSeat.setText("Enter Seat Range");

        txtGetSeat2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGetSeat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGetSeat2ActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 204, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtGetSeat1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGetSeat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGetSeat1ActionPerformed(evt);
            }
        });

        lblUniqueId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Unique ID");

        btnBack.setBackground(new java.awt.Color(0, 204, 204));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        comboCarType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboCarType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Passenger", "Transport", "Other" }));
        comboCarType.setEnabled(false);
        comboCarType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCarTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(375, 375, 375)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtManufactureYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerialNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(293, 293, 293))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(237, 237, 237)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCertiDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(158, 158, 158)
                        .addComponent(txtCarTypr, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(comboCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chckAvailable)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblSeat, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(237, 237, 237)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtGetSeat1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(txtGetSeat2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnSearch)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(148, 148, 148)
                            .addComponent(txtCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(145, 145, 145)
                        .addComponent(lblUniqueId, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(584, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(29, 29, 29)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGetSeat1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGetSeat2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUniqueId, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCarTypr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManufactureYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCertiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(chckAvailable)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtModelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelNumberActionPerformed

    private void txtSerialNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerialNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerialNoActionPerformed

    private void txtManufactureYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufactureYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufactureYearActionPerformed

    private void txtCarNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarNameActionPerformed

    private void txtSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeatActionPerformed

    private void txtCertiDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCertiDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCertiDateActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void txtManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufacturerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufacturerActionPerformed

    private void txtCarTyprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarTyprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarTyprActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtCarName.setEnabled(true);        
        txtManufactureYear.setEnabled(true);
        txtModelNumber.setEnabled(true);
        txtCity.setEnabled(true);
        txtCarTypr.setEnabled(true);
        txtCertiDate.setEnabled(true);
        txtSeat.setEnabled(true);
        txtSerialNo.setEnabled(true);
        txtManufacturer.setEnabled(true);
        chckAvailable.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        comboCarType.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        //validations
        try{
        if(txtCarName.getText()==null || "".equals(txtCarName.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Car Name");
            return;
        }
        
        if(txtManufacturer.getText()==null || "".equals(txtManufacturer.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Manufacturer");
            return;
        }
        
        if(txtCarTypr.getText()==null || "".equals(txtCarTypr.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Car type");
            return;
        }
        
        if(txtModelNumber.getText()==null || "".equals(txtModelNumber.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Model Number");
            return;
        }
        
        if(txtSerialNo.getText()==null || "".equals(txtSerialNo.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Serial Number");
            return;
        }
        
        if(txtManufactureYear.getText()==null || "".equals(txtManufactureYear.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Manufacture Year");
            return;
        }
        
        if(txtSeat.getText()==null || "".equals(txtSeat.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Seat number");
            return;
        }
        
        if(txtCertiDate.getText()==null || "".equals(txtCertiDate.getText())){
            JOptionPane.showMessageDialog(null, "Please enter expiry date of certificate");
            return;
        }
        
        if(txtCity.getText()==null || "".equals(txtCity.getText())){
            JOptionPane.showMessageDialog(null, "Please enter City Name");
            return;
        }

        boolean match = txtCarName.getText().matches("[a-zA-Z0-9\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Car Name correctly");
            return;
        }

        match = txtManufacturer.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Manufacturer correctly");
            return;
        }
        
        match = txtCarTypr.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Car Type correctly");
            return;
        }
        
        match = txtModelNumber.getText().matches("[a-zA-Z0-9\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Model Number correctly");
            return;
        }
        
        match = txtSerialNo.getText().matches("[a-zA-Z0-9\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Serail Number correctly");
            return;
        }
        
        match = txtManufactureYear.getText().matches("[0-9][0-9][0-9][0-9]");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Manufacture year correctly");
            return;
        }
        
        /*match = txtCertiDate.getText().matches("[0-9]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Certificate Expiry Date correctly");
            return;
        }*/
        
        SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
	    sdfrmt.setLenient(false);
            Date javaDate = sdfrmt.parse(txtCertiDate.getText()); 
        ///*  to do *****////////////////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////////
        //////////////////////////////////////////////////
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        //formatter.parse(txtCertiDate.getText());
        
        match = txtCity.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter City correctly");
            return;
        }
        
        match = txtSeat.getText().matches("[0-9]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Seat number correctly");
            return;
        }
        Car car1 = null;
        ArrayList<Car> newCarList=(ArrayList)uobj.getAvailableCarList();
        for(Car c: newCarList) {
            if(c.equals(this.car)) {
                car1 = c;
            }
        }
        newCarList=(ArrayList)uobj.getBookedCarList();
        for(Car c: newCarList) {
            if(c.equals(this.car)) {
                car1 = c;
            }
        }
        car1.setCarName(txtCarName.getText());
        car1.setCarType(txtCarTypr.getText());
        car1.setCity(txtCity.getText());
        car1.setMaintenanceCertiDate(txtCertiDate.getText());
        car1.setManufactureYear(txtManufactureYear.getText());
        car1.setManufacturer(txtManufacturer.getText());
        car1.setModelNumber(txtModelNumber.getText());
        car1.setSerialNumber(txtSerialNo.getText());
        car1.setSeatCount(Integer.parseInt(txtSeat.getText()));
        car1.setUniqueId(car.getUniqueId());
        


/*        if(newCarList.contains(this.car))
        {
            newCarList.remove(this.car);
            uobj.setAvailableCarList(newCarList);
            System.out.println("Removed from Available list");
        }
        else 
        {
            newCarList=(ArrayList)uobj.getBookedCarList();
            newCarList.remove(this.car);
            uobj.setBookedCarList(newCarList);
            System.out.println("Removed from booked list");
        }
        */
        if(chckAvailable.isSelected()){
            car1.setAvailable("A");
            if(! uobj.getAvailableCarList().contains(car1)) {
            //uobj.getBookedCarList().remove(car1);
            uobj.getAvailableCarList().add(car1);
                uobj.getBookedCarList().remove(car1);
            }
            
            System.out.println("Added in available list");
        }
        else{
            car1.setAvailable("U");
            
            if(! uobj.getBookedCarList().contains(car1)) {
              //  uobj.getAvailableCarList().remove(car1);
                 uobj.getBookedCarList().add(car1);
                    uobj.getAvailableCarList().remove(car1);
                }
                
                System.out.println("Added in available list");
            System.out.println("Added in booked list");
        }
        
        
        
        
        //after saving
        txtCarName.setEnabled(false);        
        txtManufactureYear.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtCity.setEnabled(false);
        txtCarTypr.setEnabled(false);
        txtCertiDate.setEnabled(false);
        txtSeat.setEnabled(false);
        txtSerialNo.setEnabled(false);
        txtManufacturer.setEnabled(false);
        chckAvailable.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
        comboCarType.setEnabled(false);
        uobj.setModifiedDate(new Date().toString());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Date is wrong");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        Car car=this.car;
        
        int dialogButton= JOptionPane.YES_NO_CANCEL_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the details?", "Warning",dialogButton);
        if( dialogResult!=JOptionPane.YES_OPTION){
                return;
                
            }
        
        
        if(uobj.getAvailableCarList().contains(car))
        {
            uobj.getAvailableCarList().remove(car);
        }
        else if(uobj.getBookedCarList().contains(car))
        {
            uobj.getBookedCarList().remove(car);
        }
        
        
        
        
        
        JOptionPane.showMessageDialog(null, "Deleted successfully!");
        
        txtCarName.setText("");        
        txtManufactureYear.setText("");
        txtModelNumber.setText("");
        txtCity.setText("");;
        txtCarTypr.setText("");
        txtCertiDate.setText("");
        txtSeat.setText("");
        txtSerialNo.setText("");
        txtManufacturer.setText("");
        chckAvailable.setSelected(false);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        comboCarType.setEnabled(false);
        uobj.setModifiedDate(new Date().toString());
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtGetSeat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGetSeat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGetSeat2ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(txtGetSeat1.getText()==null || txtGetSeat2.getText()==null
                || "".equals(txtGetSeat1.getText()) || "".equals(txtGetSeat2.getText()) ){
            JOptionPane.showMessageDialog(null,"Enter proper values");
            return;
        }
        int x=Integer.parseInt(txtGetSeat1.getText());
        int y=Integer.parseInt(txtGetSeat2.getText());
        if(x<0 || y<0){
            JOptionPane.showMessageDialog(null,"Enter proper values");
            return;
        }
        Car c=uobj.getCarBySeatRange(x,y);
        if(c==null)
        {
            JOptionPane.showMessageDialog(null, "No car found!");
            return;
        }
        populateForSeat(c);
        
        //disable
        txtCarName.setEnabled(false);        
        txtManufactureYear.setEnabled(false);
        txtModelNumber.setEnabled(false);
        txtCity.setEnabled(false);
        txtCarTypr.setEnabled(false);
        txtCertiDate.setEnabled(false);
        txtSeat.setEnabled(false);
        txtSerialNo.setEnabled(false);
        txtManufacturer.setEnabled(false);
        chckAvailable.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        txtGetSeat2.setVisible(true);
        lblSeat.setVisible(true);
        btnSearch.setVisible(true);
        txtGetSeat1.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtGetSeat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGetSeat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGetSeat1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        /*Method[] methods = previousFrame.getClass().getMethods();
        for(Method method: methods){
            if(method.toString().equals("refreshTable"))
            {
                previousFrame.method.toString();
            }
        }*/
        previousFrame.toString();
        splitpane.setRightComponent(previousFrame);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboCarTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCarTypeActionPerformed
        // TODO add your handling code here:
        int select = comboCarType.getSelectedIndex();
        if(select ==0){
            txtCarTypr.setText("");
            return;
        }
        txtCarTypr.setText(comboCarType.getItemAt(comboCarType.getSelectedIndex()));
    }//GEN-LAST:event_comboCarTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chckAvailable;
    private javax.swing.JComboBox<String> comboCarType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSeat;
    private javax.swing.JLabel lblUniqueId;
    private javax.swing.JTextField txtCarName;
    private javax.swing.JTextField txtCarTypr;
    private javax.swing.JTextField txtCertiDate;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtGetSeat1;
    private javax.swing.JTextField txtGetSeat2;
    private javax.swing.JTextField txtManufactureYear;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtModelNumber;
    private javax.swing.JTextField txtSeat;
    private javax.swing.JTextField txtSerialNo;
    // End of variables declaration//GEN-END:variables
}
