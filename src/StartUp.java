import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
public class StartUp extends javax.swing.JFrame {
       String u="root";
         String p="";
            String conn="jdbc:mysql://localhost:3306/hstore";
    public StartUp() {
        initComponents();
         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        try{      
          Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
             Statement stmt=(Statement)co.createStatement();
             
             usertype.removeAll();
              String sql1="select usertype from users";
                ResultSet rs1=stmt.executeQuery(sql1);
                    while(rs1.next())
                    { 
                        usertype.addItem(rs1.getString(1));
                    }
                    AutoCompleteDecorator.decorate(usertype);
            Statement stmt1=(Statement)co.createStatement();
                       String sql11="select Image,Description from display";           
                      final  ResultSet rs11=stmt1.executeQuery(sql11);
                      rs11.first();
                        byte[] img= rs11.getBytes(1);
                            ImageIcon imges=new ImageIcon(img);
                                Image im=imges.getImage();
                                    Image myImg=im.getScaledInstance(image.getWidth(),image.getHeight(), Image.SCALE_SMOOTH);
                                ImageIcon newImage= new ImageIcon(myImg);                  
                            image.setIcon(newImage);
                        status.setText(rs11.getString(2));  
         Timer display =new Timer(2000,new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                    try {
                      
                      if(!rs11.next()){
                         rs11.first();
                      } else
                      {byte[] img= rs11.getBytes(1);
                  ImageIcon imges=new ImageIcon(img);
                    Image im=imges.getImage();
                        Image myImg=im.getScaledInstance(image.getWidth(),image.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon newImage= new ImageIcon(myImg); 
                            image.setIcon(newImage);
                  status.setText(rs11.getString(2)); 
                      }
                  } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
                  }
             
              }
          } );
         display.start();
            }catch (Exception e){
          systemstatus.setText("Connection to database error ...");
          systemstatus.setForeground(Color.red);
            }  
    }
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resetpassword = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        visiblepassword = new javax.swing.JCheckBox();
        usertype = new javax.swing.JComboBox();
        username = new javax.swing.JTextField();
        userpassword = new javax.swing.JPasswordField();
        systemstatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("H-STORE");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

        status.setBackground(new java.awt.Color(102, 102, 102));
        status.setOpaque(true);

        jLabel2.setText("USER TYPE:");

        jLabel3.setText("USER NAME:");

        jLabel4.setText("PASSWORD:");

        resetpassword.setText("Forgot your password...?");
        resetpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetpasswordMouseClicked(evt);
            }
        });

        login.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        visiblepassword.setText("See password");
        visiblepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visiblepasswordActionPerformed(evt);
            }
        });

        systemstatus.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        systemstatus.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(systemstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(clear)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userpassword)
                                            .addComponent(usertype, 0, 196, Short.MAX_VALUE)
                                            .addComponent(username))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                        .addComponent(visiblepassword))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetpassword)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(systemstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(visiblepassword)
                            .addComponent(userpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login)
                            .addComponent(clear))
                        .addGap(31, 31, 31)
                        .addComponent(resetpassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void visiblepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visiblepasswordActionPerformed
       if(visiblepassword.isSelected()){
        userpassword.setEchoChar((char)0);
       }else{
        userpassword.setEchoChar('*');   
       }
    }//GEN-LAST:event_visiblepasswordActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
         String user,pass,t;
        t=usertype.getSelectedItem().toString();
        user=username.getText();
        pass=userpassword.getText();
       if (t.isEmpty()||user.isEmpty()||pass.isEmpty()){
            systemstatus.setText("Missing Field.Please enter all the required data");
            systemstatus.setForeground(Color.blue);
       }
       else{
        try{
             Connection co =DriverManager.getConnection(conn,u,p);  
          Statement stmt=(Statement)co.createStatement();
        String sql1="select IDNO from employee where Username='"+user+"' and Password='"+pass+"' and Type='"+t+"' ";
      ResultSet rs1 =stmt.executeQuery(sql1);
      if(rs1.next()){
            systemstatus.setText("Welcome");
           systemstatus.setForeground(Color.green);
           if (usertype.getSelectedItem().equals("Administrator")){
        Administrative main =new Administrative(rs1.getString(1));
          main.setVisible(true);
          this.dispose();} 
       if (usertype.getSelectedItem().equals("Guest")){
        Guest guest =new Guest(rs1.getString(1));
         guest.setVisible(true);
          this.dispose();} 
        if (usertype.getSelectedItem().equals("Staff")){
       Staff staff =new Staff(rs1.getString(1));
          staff.setVisible(true);
          this.dispose();} }
      else{
         systemstatus.setText("Wrong UserName or Password");
          systemstatus.setForeground(Color.red);
      }
        }catch (Exception e){
          System.out.println(e.getMessage());
    
        }}
    }//GEN-LAST:event_loginActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       username.setText("");
       userpassword.setText("");
       usertype.setSelectedIndex(0);
    }//GEN-LAST:event_clearActionPerformed

    private void resetpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetpasswordMouseClicked
    Reset reset = new Reset();
    reset.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_resetpasswordMouseClicked
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartUp().setVisible(true);
            }
            });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton login;
    private javax.swing.JLabel resetpassword;
    private javax.swing.JLabel status;
    private javax.swing.JLabel systemstatus;
    private javax.swing.JTextField username;
    private javax.swing.JPasswordField userpassword;
    private javax.swing.JComboBox usertype;
    private javax.swing.JCheckBox visiblepassword;
    // End of variables declaration//GEN-END:variables
}
