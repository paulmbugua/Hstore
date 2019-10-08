
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Employee extends javax.swing.JFrame {

String filename=null;
int s=0;
byte[] personimage=null;
  public String u="root";
    public String p="";
      public String conn="jdbc:mysql://127.0.0.1:3306/hstore";
    public Employee() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        try{
      Connection co =DriverManager.getConnection(conn,u,p);  
          Statement stmt=(Statement)co.createStatement();
            String sql="select usertype from users";
            ResultSet rs =stmt.executeQuery(sql);
             
                    while(rs.next())
                    {
                   usertypecmb.addItem(rs.getString(1));
                    }
                        
        }catch (Exception e){
                statuslbl.setText(e.getMessage());
                statuslbl.setForeground(Color.red);               
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statuslbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Imagelbl = new javax.swing.JLabel();
        Idnotxt = new javax.swing.JTextField();
        Firstnametxt = new javax.swing.JTextField();
        surnametxt = new javax.swing.JTextField();
        Middlenametxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        passwordtxt1 = new javax.swing.JTextField();
        Imagechangebtn = new javax.swing.JButton();
        picpath = new javax.swing.JLabel();
        Savebtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        usertypecmb = new javax.swing.JComboBox();
        searchbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);

        jLabel3.setText("ID Number:");

        jLabel4.setText("Fisrt Name:");

        jLabel5.setText("Middle Name:");

        jLabel6.setText("Suname:");

        jLabel7.setText("UserName:");

        jLabel8.setText("Password:");

        jLabel9.setText("User Type:");

        Imagelbl.setToolTipText("");

        Imagechangebtn.setText("Change Image ...");
        Imagechangebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagechangebtnActionPerformed(evt);
            }
        });

        Savebtn.setText("Register");
        Savebtn.setToolTipText("");
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });

        jLabel10.setText("email:");

        usertypecmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertypecmbActionPerformed(evt);
            }
        });

        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        updatebtn.setText("Update");
        updatebtn.setToolTipText("");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        deletebtn.setText("Deregister");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        clearbtn.setText("Clear");
        clearbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearbtnclicked(evt);
            }
        });
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Idnotxt)
                    .addComponent(Firstnametxt)
                    .addComponent(surnametxt)
                    .addComponent(Middlenametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(usernametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(passwordtxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(emailtxt)
                    .addComponent(usertypecmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(clearbtn)
                .addGap(18, 18, 18)
                .addComponent(Savebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updatebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deletebtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Imagechangebtn)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(picpath, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(statuslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Imagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(statuslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(Idnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Firstnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(Middlenametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Imagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(surnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Imagechangebtn)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(picpath, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(passwordtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(usertypecmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Savebtn)
                        .addComponent(searchbtn)
                        .addComponent(updatebtn)
                        .addComponent(deletebtn)
                        .addComponent(clearbtn))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void display(){
   byte[] img1= personimage;
                  ImageIcon image=new ImageIcon(img1);
                  Image im=image.getImage();
                  Image myImg=im.getScaledInstance(Imagelbl.getWidth(),Imagelbl.getHeight(), Image.SCALE_SMOOTH);
                  ImageIcon newImage= new ImageIcon(myImg);
                  Imagelbl.setIcon(newImage);  
}
    private void ImagechangebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagechangebtnActionPerformed
     JFileChooser chooser= new JFileChooser();
     chooser.showOpenDialog(null);
     File f=chooser.getSelectedFile();
      filename=f.getAbsolutePath();
      picpath.setText(filename);
      try{Connection co=DriverManager.getConnection(conn,u,p);          
            String sql="UPDATE Employee SET Picture=?  where IDNO = ?";
            PreparedStatement pst=co.prepareStatement(sql);           
       File image= new File(filename);
       FileInputStream fis=new FileInputStream(image);
       ByteArrayOutputStream bos =new ByteArrayOutputStream ();
       byte[] buf = new byte[500000];
       for(int readNum;(readNum=fis.read(buf))!=-1;){
           bos.write(buf,0,readNum);
       }
       personimage=bos.toByteArray();
          display();
           pst.setBytes(1, personimage);
            pst.setInt(2,Integer.parseInt( Idnotxt.getText()));
          pst.execute();
          statuslbl.setText("Image changed successfully");
            statuslbl.setForeground(Color.red); 
      }
      catch(Exception e){
         statuslbl.setText(e.getMessage());
            statuslbl.setForeground(Color.red);  
      }
    
    }//GEN-LAST:event_ImagechangebtnActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
      try{
          int a=Integer.parseInt(Idnotxt.getText());
          String b=Firstnametxt.getText();
          String c=Middlenametxt.getText();
          String d=surnametxt.getText();
          String e=usernametxt.getText();
          String g=passwordtxt1.getText();
          String h=usertypecmb.getSelectedItem().toString();
          String s=emailtxt.getText();
            Connection co=DriverManager.getConnection(conn,u,p);          
            String sql="insert into employee(IDNO,FirstName,MiddleName,Surname,Email,Picture,Type,Username,Password) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=co.prepareStatement(sql);
            if (a==0||b.isEmpty()||c.isEmpty()||d.isEmpty()||e.isEmpty()||g.isEmpty()||h.isEmpty()||s.isEmpty())
            {
            statuslbl.setText("Missing details....");
            statuslbl.setForeground(Color.red);
            }   
            else
            {pst.setInt(1, a);
            pst.setString(2,b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, s);
            pst.setString(9, g);
            pst.setString(8, e);
            pst.setString(7, h);
            pst.setBytes(6, personimage);
               pst.execute();
            statuslbl.setText("Operation successfully completed");
            statuslbl.setForeground(Color.green);
            }
                      
            
        
      }
      catch(Exception e){
         statuslbl.setText(e.getMessage());
            statuslbl.setForeground(Color.red);  
      }
    }//GEN-LAST:event_SavebtnActionPerformed
public void clear(){
    
                statuslbl.setText("");                
                Idnotxt.setText("");
                Firstnametxt.setText("");
                Middlenametxt.setText("");
                surnametxt.setText("");
                usernametxt.setText("");
                passwordtxt1.setText("");
                emailtxt.setText("");
                usertypecmb.setSelectedIndex(-1);
                Imagelbl.setIcon(null);
                picpath.setText("");
}
    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        clear();
        String id;
       id= JOptionPane.showInputDialog("Enter ID NUMBER");
       try{         
            Connection co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from employee where IDNO='"+id+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
            if (!rs.next())            {
            statuslbl.setText("Record does not exist ..");
            statuslbl.setForeground(Color.red);
           
            }   
            else
            {
               
            statuslbl.setText("Record has been found..."); 
               statuslbl.setForeground(Color.green);
                Idnotxt.setText(rs.getString(1));
                Firstnametxt.setText(rs.getString(2));
               Middlenametxt.setText(rs.getString(3));
               surnametxt.setText(rs.getString(4));
               usernametxt.setText(rs.getString(9));
               passwordtxt1.setText(rs.getString(10));
               if ("Administrator".equals(rs.getString(8)))
               { usertypecmb.setSelectedIndex(0);}
               if ("Staff".equals(rs.getString(8)))
               { usertypecmb.setSelectedIndex(2);}
                  if ("Guest".equals(rs.getString(8)))
               { usertypecmb.setSelectedIndex(1);}
                 emailtxt.setText(rs.getString(5));
                 byte[] img= rs.getBytes(7);
                 ImageIcon image=new ImageIcon(img);
                  Image im=image.getImage();
                  Image myImg=im.getScaledInstance(Imagelbl.getWidth(),Imagelbl.getHeight(), Image.SCALE_SMOOTH);
                  ImageIcon newImage= new ImageIcon(myImg);
                  Imagelbl.setIcon(newImage);
                
                 
            }
             
            
            
        }catch (Exception e){
           statuslbl.setText(e.getMessage());
    
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
      try{
          int a=Integer.parseInt(Idnotxt.getText());
          String b=Firstnametxt.getText();
          String c=Middlenametxt.getText();
          String d=surnametxt.getText();
          String e=usernametxt.getText();
          String g=passwordtxt1.getText();
          String h=usertypecmb.getSelectedItem().toString();
          String s=emailtxt.getText();
            Connection co=DriverManager.getConnection(conn,u,p);          
            String sql="UPDATE employee SET IDNO = ?, FirstName = ?, MiddleName = ?, Surname = ?, Email = ?,Type = ?, Username= ?, "
                    + "Password = ? where IDNO = ?";
            PreparedStatement pst=co.prepareStatement(sql);
            if (a==0||b.isEmpty()||c.isEmpty()||d.isEmpty()||e.isEmpty()||g.isEmpty()||h.isEmpty()||s.isEmpty())
            {
            statuslbl.setText("Missing details....");
            statuslbl.setForeground(Color.red);
            }   
            else
            {pst.setInt(1, a);
            pst.setString(2,b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, s);
            pst.setString(6, h);
            pst.setString(7, e);
            pst.setString(8, g);
            pst.setInt(9, a);           
            pst.execute();
            statuslbl.setText("Operation successfully completed");
            statuslbl.setForeground(Color.green);
            }     
        
      }
      catch(Exception e){
         statuslbl.setText(e.getMessage());
         statuslbl.setForeground(Color.red);  
      }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
       String id;
       id= JOptionPane.showInputDialog("Enter ID NUMBER");
        try{
            Connection co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
           String sql="select * from employee where IDNO='"+id+"'";
             ResultSet rs =stmt.executeQuery(sql);
             if (!rs.next())            {
            statuslbl.setText("The user  '"+id+"' does not exist");
            statuslbl.setForeground(Color.red);
           
            }   
            else
            {
            String sql1="DELETE FROM employee where IDNO='"+id+"'";
            stmt.executeUpdate(sql1);
              statuslbl.setText("The user  '"+id+"' has been removed from system");
                statuslbl.setForeground(Color.green);
            }
       }
       catch(Exception e){
         statuslbl.setText(e.getMessage());
         statuslbl.setForeground(Color.red);  
       }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbtnclicked
        clear();
    }//GEN-LAST:event_clearbtnclicked

    private void usertypecmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertypecmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypecmbActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
      clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Firstnametxt;
    private javax.swing.JTextField Idnotxt;
    private javax.swing.JButton Imagechangebtn;
    private javax.swing.JLabel Imagelbl;
    private javax.swing.JTextField Middlenametxt;
    private javax.swing.JButton Savebtn;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField passwordtxt1;
    private javax.swing.JLabel picpath;
    private javax.swing.JButton searchbtn;
    private javax.swing.JLabel statuslbl;
    private javax.swing.JTextField surnametxt;
    private javax.swing.JButton updatebtn;
    private javax.swing.JTextField usernametxt;
    private javax.swing.JComboBox usertypecmb;
    // End of variables declaration//GEN-END:variables
}
