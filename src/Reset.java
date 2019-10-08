
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Reset extends javax.swing.JFrame {
String u="root";
         String p="";
            String conn="jdbc:mysql://localhost:3306/hstore";
                String id;
    public Reset() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        Changebtn.setEnabled(false);
           firstpass.setEnabled(false);
           secondpass.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        validatebtn = new javax.swing.JButton();
        Changebtn = new javax.swing.JButton();
        idnumbertxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        firstpass = new javax.swing.JPasswordField();
        secondpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PASSWORD RESET");
        setResizable(false);

        loginbtn.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        loginbtn.setText("Log in");
        loginbtn.setBorderPainted(false);
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);

        jLabel3.setText("Username :");

        jLabel4.setText("IDNumber :");

        jLabel5.setText("New password :");

        jLabel6.setText("Confirm password :");

        validatebtn.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        validatebtn.setText("Validate");
        validatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validatebtnActionPerformed(evt);
            }
        });

        Changebtn.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        Changebtn.setText("Change");
        Changebtn.setToolTipText("");
        Changebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangebtnActionPerformed(evt);
            }
        });

        usernametxt.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statuslabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstpass, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(secondpass, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Changebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idnumbertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(validatebtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginbtn)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idnumbertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(validatebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(firstpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(secondpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(Changebtn)
                .addGap(37, 37, 37)
                .addComponent(loginbtn)
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
       StartUp startUp =new StartUp();
        startUp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginbtnActionPerformed

    private void ChangebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangebtnActionPerformed
     if(firstpass.getText().isEmpty())
{
    statuslabel.setText("Please enter the new password");
    statuslabel.setForeground(Color.BLUE);
}
else if(secondpass.getText().isEmpty()){
    statuslabel.setText("Please enter the confirmation password");
    statuslabel.setForeground(Color.BLUE);
}else if(firstpass.getText().equals(secondpass.getText())){
    try{      
          Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
             String sql="update employee set Password='"+firstpass.getText()+"' where IDNO='"+id+"'";           
               Statement pst =(Statement)co.createStatement();
                  pst.executeUpdate(sql);
          statuslabel.setText("Password successfully changed");
          statuslabel.setForeground(Color.green);
                       
            }catch (Exception e){
          statuslabel.setText("Password not changed");
          statuslabel.setForeground(Color.red);
        } 
}else{
    statuslabel.setText("Your password does not match");
    statuslabel.setForeground(Color.red);
} 
    }//GEN-LAST:event_ChangebtnActionPerformed

    private void validatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validatebtnActionPerformed
 if(idnumbertxt.getText().isEmpty())
{
    statuslabel.setText("Please enter your idnumber");
    statuslabel.setForeground(Color.BLUE);
}
else if(usernametxt.getText().isEmpty()){
    statuslabel.setText("Please enter your username");
    statuslabel.setForeground(Color.red);
}else{
    try{      
          Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
           Statement stmt=(Statement)co.createStatement();
           String sql="select Username,IDNO from employee where Username='"+usernametxt.getText()+"' and IDNO='"+idnumbertxt.getText()+"'";          
               ResultSet rs= stmt.executeQuery(sql);
           if (rs.next()){        
          statuslabel.setText("Validated successsfully");
          statuslabel.setForeground(Color.green);
           id=idnumbertxt.getText();
           Changebtn.setEnabled(true);
           firstpass.setEnabled(true);
           secondpass.setEnabled(true);
           }
           else{
                statuslabel.setText("Wrong credentials");
          statuslabel.setForeground(Color.red);   
           }
                       
            }catch (Exception e){
          statuslabel.setText("Wrong credentials");
          statuslabel.setForeground(Color.red);
                } 
}
    }//GEN-LAST:event_validatebtnActionPerformed

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
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Changebtn;
    private javax.swing.JPasswordField firstpass;
    private javax.swing.JTextField idnumbertxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField secondpass;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JTextField usernametxt;
    private javax.swing.JButton validatebtn;
    // End of variables declaration//GEN-END:variables
}
