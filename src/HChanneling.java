/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class HChanneling extends javax.swing.JFrame {

    
    Connection con1;
    PreparedStatement insert;
    String schedd;
    String docid;
    String docapp;
    String schedt;
    int appCount;
  
    /**
     * Creates new form HChanneling
     */
    public HChanneling() {
        initComponents();
        setImg();
        getAllSpeciality();
        appCount = 0;
         
        
    }

    private void setImg(){
	
        ImageIcon imageicon = new ImageIcon("C:\\Users\\user\\Documents\\SLIIT\\2nd Year Semester 02\\IT Project\\Hospital Management System\\Hospital Management System\\src\\images\\icon.png");
        Image img = imageicon.getImage();
        Image imgScale = img.getScaledInstance(backg.getWidth(),backg.getHeight(),Image.SCALE_FAST);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        backg.setIcon(scaledIcon);
    }
    
    private void getAllSpeciality(){
        
        Speciality.addItem("Select");
         try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            
            insert = con1.prepareStatement("SELECT Speciality FROM doctor group by Speciality");
            
          ResultSet rs = insert.executeQuery();
           
           while(rs.next()){
                          
               Speciality.addItem(rs.getString("Speciality"));
          
           }
           
         
           } catch (SQLException ex) {

            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        private void getDoctor(){
 
            DefaultTableModel df2 = (DefaultTableModel) jTable1.getModel();
            df2.setRowCount(0);
            if(docDate.getDate() != null){
            int c;
            SimpleDateFormat dfm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d1 = dfm2.format(docDate.getDate());
            String d2 = java.time.LocalDate.now().toString();

            if(d1.compareTo(d2)<0){
            
                JOptionPane.showMessageDialog(this, "Invalid date");
            }
            
            else{
            try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            
            insert = con1.prepareStatement("SELECT * FROM doctor where Speciality = ? and cast(DateTime as date) = ? and DateTime >= NOW() and DoctorName LIKE concat('%',?,'%') and DocAvailability = 'Yes'");
            
            insert.setString(1, Speciality.getSelectedItem().toString());
            DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");

            String cdte = dfm.format(docDate.getDate());
            insert.setString(2, cdte);
            insert.setString(3, docName.getText());
            
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData res = rs.getMetaData();
            

            c = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {

                    v2.add(rs.getString("DoctorId"));
                    v2.add(rs.getString("DoctorName"));
                    v2.add(rs.getString("Speciality"));
                    v2.add(rs.getDate("DateTime"));
                    v2.add(rs.getTime("DateTime"));
                    v2.add(rs.getString("ChannelingRange"));
                    v2.add(rs.getString("RoomNo"));
                }

               
                df.addRow(v2);
            }
           
         
            if(jTable1.getRowCount()==0)
             JOptionPane.showMessageDialog(this, "No Channelings for the search");
           } catch (SQLException ex) {

            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        } 
            
            
            else{
                SimpleDateFormat dfm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d1;
            String d2 = java.time.LocalDate.now().toString();
                int c;
                
                try {

                    Class.forName("com.mysql.jdbc.Driver");

                    con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

                    insert = con1.prepareStatement("SELECT * FROM doctor where Speciality = ? and DoctorName LIKE concat('%',?,'%') and DocAvailability = 'Yes' and DateTime >= NOW()");

                    insert.setString(1, Speciality.getSelectedItem().toString());
                    insert.setString(2, docName.getText());

                    ResultSet rs = insert.executeQuery();
                    ResultSetMetaData res = rs.getMetaData();

                    c = res.getColumnCount();

                    DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
                    df.setRowCount(0);

                    while (rs.next()) {

                        Vector v2 = new Vector();

                        for (int a = 1; a <= c; a++) {

                     
                            v2.add(rs.getString("DoctorId"));
                            v2.add(rs.getString("DoctorName"));
                            v2.add(rs.getString("Speciality"));
                            v2.add(rs.getDate("DateTime"));
                            v2.add(rs.getTime("DateTime"));
                            v2.add(rs.getString("ChannelingRange"));
                            v2.add(rs.getString("RoomNo"));
                        }

                        d1 = dfm2.format(rs.getDate("DateTime"));
                        
                        if(d1.compareTo(d2)<0){
            
                           
                        }
                        
                        else
                         df.addRow(v2);
                    }
                    
                     if(jTable1.getRowCount()==0)
                         JOptionPane.showMessageDialog(this, "No Channelings for the search");

                } catch (SQLException ex) {

                     Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);

                } catch (ClassNotFoundException ex) {
                     
                    Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
                   
                }  
        
      }
             
    }
    
    private void getAllDocSpeciality(){
        
        int c;
             try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            
            insert = con1.prepareStatement("SELECT * FROM doctor where Speciality = ? and DocAvailability = 'Yes' and DateTime >= NOW()");
            insert.setString(1, Speciality.getSelectedItem().toString());

            ResultSet rs = insert.executeQuery();
            ResultSetMetaData res = rs.getMetaData();

            c = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {

                    v2.add(rs.getString("DoctorId"));
                    v2.add(rs.getString("DoctorName"));
                    v2.add(rs.getString("Speciality"));
                    v2.add(rs.getDate("DateTime"));
                    v2.add(rs.getTime("DateTime"));
                    v2.add(rs.getString("ChannelingRange"));
                    v2.add(rs.getString("RoomNo"));
                    
                  
                }
                
                  
                df.addRow(v2);
            }
            if(jTable1.getRowCount()==0)
             JOptionPane.showMessageDialog(this, "No Channelings for the search");
           
           } catch (SQLException ex) {

            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
        
    private void specialityList(){
        
        SimpleDateFormat dfm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d1 = dfm2.format(docDate.getDate());
        String d2 = java.time.LocalDate.now().toString();
        
       if(d1.compareTo(d2)<0){
            
                    JOptionPane.showMessageDialog(this, "Invalid date");
               }
              else{
            int c;
             try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            
            insert = con1.prepareStatement("SELECT * FROM doctor where Speciality = ? and cast(DateTime as date) = ? and DateTime >= NOW() and DocAvailability = 'Yes'");
            insert.setString(1, Speciality.getSelectedItem().toString());
            
            DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
            String cdte = dfm.format(docDate.getDate());
            insert.setString(2, cdte);
            
            System.out.println(cdte);
            ResultSet rs = insert.executeQuery();
            ResultSetMetaData res = rs.getMetaData();

            c = res.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int a = 1; a <= c; a++) {

                    v2.add(rs.getString("DoctorId"));
                    v2.add(rs.getString("DoctorName"));
                    v2.add(rs.getString("Speciality"));
                    v2.add(rs.getDate("DateTime"));
                    v2.add(rs.getTime("DateTime"));
                    v2.add(rs.getString("ChannelingRange"));
                    v2.add(rs.getString("RoomNo"));
                    
                  
                }
                
                  
                df.addRow(v2);
            }
            if(jTable1.getRowCount()==0)
             JOptionPane.showMessageDialog(this, "No Channelings for the search");
           
           } catch (SQLException ex) {

            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){

                ImageIcon im = new ImageIcon("C:\\Users\\user\\Documents\\SLIIT\\2nd Year Semester 02\\IT Project\\Hospital Management System\\Hospital Management System\\src\\images\\backg1.jpg");
                Image i =im.getImage();

                g.drawImage(i,0,0,this.getSize().width,this.getSize().height,this);

            }

        };
        backg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Speciality = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        docName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        consName = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        dName = new javax.swing.JLabel();
        consName1 = new javax.swing.JLabel();
        sName = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        docDate = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select Specialization:");

        Speciality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecialityActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Doctor:");

        docName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Date:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Id", "Consultant", "Specialization", "Date", "Time", "Appointments", "Room Number"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 25, 112));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Channelings");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        consName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        consName.setText("Consultant:");

        jButton4.setBackground(new java.awt.Color(204, 0, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancel channeling");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 25, 112));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Add Appointment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        dName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        consName1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        consName1.setText("Speciality:");

        sName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View Appointments");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(consName)
                            .addComponent(consName1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(27, 27, 27)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton6))
                        .addGap(94, 94, 94))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(consName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consName1)
                    .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton7.setBackground(new java.awt.Color(153, 153, 153));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setText("Log out");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Speciality, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(docName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(docDate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(18, 18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backg, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286)
                .addComponent(jButton10)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(424, 424, 424))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10)
                            .addComponent(backg, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Speciality, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(docDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        docid = df.getValueAt(selectedIndex, 0).toString();
        dName.setText(df.getValueAt(selectedIndex, 1).toString());
       sName.setText(df.getValueAt(selectedIndex, 2).toString());
        schedd = df.getValueAt(selectedIndex, 3).toString();
       schedt = df.getValueAt(selectedIndex, 4).toString();
       docapp = df.getValueAt(selectedIndex, 5).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
 
         if(dName.getText().equals("") && sName.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Please select a consultant");
        
         else{
         try {

            Class.forName("com.mysql.jdbc.Driver");

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
       
            insert = con1.prepareStatement("select count(User_Id) as count\n" +
                                            "from appointment,doctor\n" + "where appointment.DoctorId = doctor.DoctorId "
                                            + "and doctor.DoctorId = ? and appointment.Status = 'Active' and appointment.Date = ?"
                                            + " and appointment.Time = ?");
           
            insert.setString(1,docid);
            insert.setString(2,schedd);
            insert.setString(3,schedt);
            ResultSet rs = insert.executeQuery();
           
           while(rs.next()){
                          
               appCount = (rs.getInt("count"));
             
          
           }
           
              
         if(Integer.parseInt(docapp) == appCount)
         {
             JOptionPane.showMessageDialog(this, "No more appointments available. Channneling is full");
         }
         
         else{
             insert = con1.prepareStatement("select appointment.Status\n" +
                                            "from appointment,doctor\n" + "where appointment.DoctorId = doctor.DoctorId "
                                            + "and doctor.DoctorId = ? and appointment.Date = ?"
                                            + " and appointment.Time = ?");
            insert.setString(1,docid);
            insert.setString(2,schedd);
            insert.setString(3,schedt);
            String status = "Active";
            
            ResultSet rs2 = insert.executeQuery();
           
           while(rs2.next()){
                          
               status = (rs2.getString("appointment.Status"));
             
          
           }
           
           if(status.equals("Channeling Cancelled"))
               JOptionPane.showMessageDialog(this, "Cannot add appointment. This channeling is cancelled");
         
           
         else{
             
             appCount+=1;
             String appCounts ="";
             appCounts+=appCount;
             System.out.println(appCounts);
             
         
            HChannelApp happ = new HChannelApp(dName.getText(),docid,schedd,schedt,appCounts);
            happ.setVisible(true);
        
        
         }
          
         }
         
           } catch (SQLException ex) {

            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HIpd.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         
         }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dm = new Date();
        String n = df.format(dm);
        
        if(dName.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please select a consultant");
        }
        else{
             
            if(schedd.equals(n)){

                JOptionPane.showMessageDialog(this, "Cannot cancel channeling");
            }
             
            else{
            
                int dialogresult = JOptionPane.showConfirmDialog(null, "Cancel Channeling?", "Warning", JOptionPane.YES_NO_OPTION);

                if (dialogresult == JOptionPane.YES_OPTION) {

                    try {

                        Class.forName("com.mysql.jdbc.Driver");

                        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");

                        insert = con1.prepareStatement("select appointment.Status\n" +
                                            "from appointment,doctor\n" + "where appointment.DoctorId = doctor.DoctorId "
                                            + "and doctor.DoctorId = ? and appointment.Date = ?"
                                            + " and appointment.Time = ?");
                insert.setString(1,docid);
                insert.setString(2,schedd);
                insert.setString(3,schedt);
                String status = "Active";

                ResultSet rs2 = insert.executeQuery();

               while(rs2.next()){

                   status = (rs2.getString("appointment.Status"));


               }

               if(status.equals("Channeling Cancelled"))
                   JOptionPane.showMessageDialog(this, "This channeling is already cancelled");

               else{
                        insert = con1.prepareStatement("update appointment set Status = 'Channeling Cancelled' where DoctorId = ? and Date = ?");

                        insert.setString(1, docid);
                        insert.setString(2, schedd);

                        int i= insert.executeUpdate();


                        JOptionPane.showMessageDialog(this, "Channeling Cancelled");
                        jTable1.clearSelection();

               }
                } catch (SQLException ex) {

                    Logger.getLogger(HChanneling.class.getName()).log(Level.SEVERE, null, ex);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HChanneling.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                        
            }
            }
        }
            
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: 
       dName.setText("");
       sName.setText("");
        if(Speciality.getSelectedItem().equals("Select")){
            
            JOptionPane.showMessageDialog(this, "Please select a specialisation");  
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
          
            
        }

        else{
  
            if(docName.getText().equals("") && docDate.getDate() == null)
                getAllDocSpeciality();
            
            else{
            if(docName.getText().equals("")){
                   specialityList();
            }
            
            else
                    
                getDoctor();          
            
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SpecialityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecialityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecialityActionPerformed

    private void docNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_docNameActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Happointments hap = new Happointments();
        hap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
 
        if(dName.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Please select a consultant");
        
        else{
            
            try {
                HChannelApp2 hap2 = new HChannelApp2(dName.getText(),docid,schedd,schedt);
                hap2.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(HChanneling.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         
  
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        docName.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        MainUI nd = new MainUI();
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(HChanneling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HChanneling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HChanneling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HChanneling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HChanneling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Speciality;
    private javax.swing.JLabel backg;
    private javax.swing.JLabel consName;
    private javax.swing.JLabel consName1;
    private javax.swing.JLabel dName;
    private com.toedter.calendar.JDateChooser docDate;
    private javax.swing.JTextField docName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel sName;
    // End of variables declaration//GEN-END:variables
}
