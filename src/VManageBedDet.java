/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VManageBedDet extends javax.swing.JFrame {
    Connection con1;
    PreparedStatement insert;
   
    public VManageBedDet() {
        initComponents();
        table_update();
        setimg();
        
    }
    
    public void setimg(){
        ImageIcon imageicon = new ImageIcon("C:\\Users\\user\\Documents\\SLIIT\\2nd Year Semester 02\\IT Project\\Hospital Management System\\Hospital Management System\\src\\images\\icon.png");
        Image img = imageicon.getImage();
        Image imgScale = img.getScaledInstance(backg.getWidth(),backg.getHeight(),Image.SCALE_FAST);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        backg.setIcon(scaledIcon);
    };
    
    
    private void table_update(){
    int c;
        
        try {
            
             Class.forName("com.mysql.jdbc.Driver");
            
            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            
            insert= (PreparedStatement) con1.prepareStatement("select * from Bed ");
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            
            c = res.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            
            while (rs.next()){
                
            Vector v2 = new Vector();
            
            for(int a=1; a<=c ; a++){
            
                v2.add(rs.getString("bed_Id"));
                v2.add(rs.getString("bed_type"));
                v2.add(rs.getString("Room_No"));
               
            
            }
                  df.addRow(v2);
              }
            
            
       } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        } 
        
        catch(SQLException ex){
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        }
    
    
    
    
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){

                ImageIcon im = new ImageIcon("C:\\Users\\user\\Documents\\SLIIT\\2nd Year Semester 02\\IT Project\\Hospital Management System\\Hospital Management System\\src\\images\\backg1.jpg");
                Image i =im.getImage();

                g.drawImage(i,0,0,this.getSize().width,this.getSize().height,this);

            }

        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        droplistBedT = new javax.swing.JComboBox<>();
        txt_rno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        lval = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bno = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblbype = new javax.swing.JLabel();
        lbl01 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btypec = new javax.swing.JComboBox<>();
        backg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bed Number", "Bed Type", "Room Number"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Bed Type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Room Number");

        droplistBedT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        droplistBedT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Electric", "Semi Electric", "Manual" }));
        droplistBedT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                droplistBedTActionPerformed(evt);
            }
        });

        txt_rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rnoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(102, 102, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.setMaximumSize(new java.awt.Dimension(61, 25));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(102, 102, 255));
        Delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        lval.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lval.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_rno, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(droplistBedT, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lval, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 262, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(droplistBedT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lval, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        bno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnoActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Enter Bed Number");

        jLabel6.setText("Select Bed Type");

        btypec.setForeground(new java.awt.Color(204, 204, 255));
        btypec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Bed Type", "Full Electric", "Semi Electric", "Manual" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblbype)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(btypec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addComponent(lbl01, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel6)
                    .addComponent(btypec, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblbype))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Bed Details");

        jButton4.setText("Log Out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(439, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(backg, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(395, 395, 395)
                        .addComponent(jButton4)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(327, 327, 327))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton4)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(backg, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton5)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MainUI mu = new MainUI();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String btype = btypec.getSelectedItem().toString();
        bno.setText(null);

        /*if(txt_btype.getText().trim().isEmpty()){
            lbl02.setText(" Bed Type  Field is  Empty");

        }

        else{
            lbl02.hide();

        }
        */

        int c;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

            //insert = (PreparedStatement) con1.prepareStatement("select 1 from Bed where Bed_type = ?");
            //    insert.setString(1,txt_btype.getText());
            //   ResultSet rs = insert.executeQuery();

            //  int val = 0;
            // while(rs.next()){

                //    val = rs.getInt("1");
                //   System.out.println(val);

                // }

            //String btype = txt_btype.getText();

            //if( (val != 1) ){
                // JOptionPane.showMessageDialog(this, "invalid Bed Type");
                // }

            // else{

                insert =  (PreparedStatement) con1.prepareStatement("select * from Bed where Bed_type = ?");
                insert.setString(1, btype);
                // insert.setString(1,txt_btype.getText());
                ResultSet rs2 =  insert.executeQuery();

                ResultSetMetaData res = rs2.getMetaData();

                c = res.getColumnCount();

                DefaultTableModel df =(DefaultTableModel) jTable1.getModel();
                df.setRowCount(0);

                while(rs2.next()){

                    Vector v2 = new Vector();

                    for(int a=1; a<=c ; a++){

                        v2.add(rs2.getString("Bed_Id"));
                        v2.add(rs2.getString("Bed_type"));
                        v2.add(rs2.getString("Room_No"));

                    }

                    df.addRow(v2);

                }
                // }
        } catch (SQLException e) {
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,e);
        }

        catch(ClassNotFoundException e){
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        btypec.setSelectedItem("Select Bed Type");
        
        if(bno.getText().trim().isEmpty()){
            lbl01.setText(" Bed  Number Field is  empty");

        }

        else{
            lbl01.hide();

        }

        int c;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

            insert = (PreparedStatement) con1.prepareStatement("select 1 from Bed where Bed_Id = ?");
            insert.setString(1,bno.getText());
            ResultSet rs = insert.executeQuery();

            int val =0;
            while(rs.next()){

                val =   rs.getInt("1");

            }

            if(val != 1){
                JOptionPane.showMessageDialog(this, "invalid Bed Number");
            }

            else{

                insert =  (PreparedStatement) con1.prepareStatement("select * from Bed where Bed_Id = ?");
                insert.setString(1,bno.getText());
                ResultSet rs2 =  insert.executeQuery();

                ResultSetMetaData res = rs2.getMetaData();

                c = res.getColumnCount();

                DefaultTableModel df =(DefaultTableModel) jTable1.getModel();
                df.setRowCount(0);

                while(rs2.next()){

                    Vector v2 = new Vector();

                    for(int a=1; a<=c ; a++){

                        v2.add(rs2.getString("bed_Id"));
                        v2.add(rs2.getString("bed_type"));
                        v2.add(rs2.getString("Room_No"));

                    }
                    df.addRow(v2);

                }
            }

        } catch (SQLException e) {
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,e);
        }

        catch(ClassNotFoundException e){
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void bnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bnoActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
             if(txt_rno.getText().matches("\\d+") == false){
            JOptionPane.showMessageDialog(this,"Invalid Room number");
        }
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();

        try {

            int id = Integer.parseInt(df.getValueAt(selectedIndex,0).toString());

            int dialogrsult = JOptionPane.showConfirmDialog(null,"Do you want to delete the record ?","warning",JOptionPane.YES_NO_OPTION);

            if(dialogrsult == JOptionPane.YES_OPTION){

                Class.forName("com.mysql.jdbc.Driver");

                con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

                insert =  (PreparedStatement) con1.prepareStatement("delete from Bed  where Bed_Id = ?");

                insert.setInt(1, id);
                insert.executeUpdate();

                JOptionPane.showMessageDialog(this,"Bed is deleted");
                table_update();

                txt_rno.setText("");

                txt_rno.requestFocus();
            }

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

          if(txt_rno.getText().matches("\\d+") == false){
            JOptionPane.showMessageDialog(this,"Invalid Room number");
        }
        
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt(df.getValueAt(selectedIndex,0).toString());

        String bedType = droplistBedT.getSelectedItem().toString();
        String rno = txt_rno.getText();
        
         if(txt_rno.getText().matches("\\d+") == false){
            JOptionPane.showMessageDialog(this,"Invalid Room number");
        }

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            
            insert = (PreparedStatement) con1.prepareStatement("select 1 from Bed  where  Room_No = ? || Bed_type = ?");
          
            insert.setString(1,txt_rno.getText());
              insert.setString(2,bedType);
            ResultSet rs = insert.executeQuery();

            int val =0;
            while(rs.next()){

                val =   rs.getInt("1");

            }

            if(val != 1){
                JOptionPane.showMessageDialog(this, "Room Already has a Bed");
            }
            
            
            else{ 

            insert =  (PreparedStatement) con1.prepareStatement("update Bed set Bed_type = ?,Room_No = ? where Bed_Id = ?");

            insert.setString(1,bedType);
            insert.setString(2,rno);
            insert.setInt(3,id);

            insert.executeUpdate();
            table_update();

            txt_rno .setText("");
            txt_rno.requestFocus();
            JOptionPane.showMessageDialog(this, "Bed Detail is Updated");
            table_update();
            }
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        
        }
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String btype = droplistBedT.getSelectedItem().toString();
        String rno = txt_rno.getText();

        // if (txt_rno.getText().trim().isEmpty() &&  droplistBedT.getSelectedItem().toString().trim().isEmpty() ){
            //lval.setText("Fields are empty");
            // }

        if(txt_rno.getText().trim().isEmpty()){
            lval.setText(" Room Number Field is  empty");
        }

        else{
            lval.hide();
        }

        if(txt_rno.getText().matches("\\d+") == false){
            JOptionPane.showMessageDialog(this,"Invalid Room number");
        }

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

            insert = (PreparedStatement) con1.prepareStatement("select 1 from Bed where Room_No = ?");
            insert.setString(1,txt_rno.getText());
            ResultSet rs = insert.executeQuery();

            int val =0;
            while(rs.next()){

                val =   rs.getInt("1");

            }

            if(val == 1){
                JOptionPane.showMessageDialog(this, "Room Already has a Bed");
            }

            else{

                insert =  (PreparedStatement) con1.prepareStatement("insert into Bed (Bed_type,Room_No) values(?,?)");
                insert.setString(1,btype);
                insert.setString(2,rno);

                insert.executeUpdate();

                JOptionPane.showMessageDialog(this, " Bed is Added to the Room");
                table_update();
                txt_rno.setText("");
            }

        } catch (ClassNotFoundException ex) {

            Logger.getLogger( VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        }

        catch(SQLException ex){
            Logger.getLogger(VManageBedDet.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_rnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rnoActionPerformed

    private void droplistBedTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_droplistBedTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_droplistBedTActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();

        droplistBedT.setSelectedItem(jTable1.getValueAt(selectedIndex,1).toString());
        txt_rno.setText(df.getValueAt(selectedIndex,2).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MSVMainUI ms = new MSVMainUI();
        ms.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VManageBedDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VManageBedDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VManageBedDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VManageBedDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VManageBedDet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JLabel backg;
    private javax.swing.JTextField bno;
    private javax.swing.JComboBox<String> btypec;
    private javax.swing.JComboBox<String> droplistBedT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl01;
    private javax.swing.JLabel lblbype;
    private javax.swing.JLabel lval;
    private javax.swing.JTextField txt_rno;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
