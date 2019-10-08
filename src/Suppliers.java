
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Suppliers extends javax.swing.JFrame {
public String u="root";
    public String p="";
      public String conn="jdbc:mysql://127.0.0.1:3306/hstore";
    public Suppliers() {
        
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        update();
    }
public void update(){
     Connection co=null;
        try{
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from suppliers";
            ResultSet rs =stmt.executeQuery(sql);
             suppliertable.setModel(DbUtils.resultSetToTableModel(rs));
             supplyproduct.removeAllItems();
          String sql2="select itemname from items";
          ResultSet rs2=stmt.executeQuery(sql2);
          while(rs2.next()){
              supplyproduct.addItem(rs2.getString(1));
          }
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
      
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        supplierid = new javax.swing.JTextField();
        suppliername = new javax.swing.JTextField();
        suppliercontact = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliertable = new javax.swing.JTable();
        searchsupp = new javax.swing.JButton();
        addsupp = new javax.swing.JButton();
        updatesupp = new javax.swing.JButton();
        deletesupp = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        supplyproduct = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setToolTipText("");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        jLabel1.setText("SUPPLIER ID:");

        jLabel4.setText("SUPPLIER NAME:");

        jLabel5.setText("EMAIL/CONTACT:");

        jLabel6.setText("SUPPLY PRODUCT:");

        suppliertable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(suppliertable);

        searchsupp.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        searchsupp.setText("Search supplier");
        searchsupp.setToolTipText("");
        searchsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsuppActionPerformed(evt);
            }
        });

        addsupp.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        addsupp.setText("Add supplier");
        addsupp.setToolTipText("");
        addsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsuppActionPerformed(evt);
            }
        });

        updatesupp.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        updatesupp.setText("Update supplier");
        updatesupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesuppActionPerformed(evt);
            }
        });

        deletesupp.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        deletesupp.setText("Delete supplier");
        deletesupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletesuppActionPerformed(evt);
            }
        });

        clearbutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        clearbutton.setText("Clear");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        supplyproduct.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
            .addComponent(statuslabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(suppliercontact, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(suppliername)
                                    .addComponent(supplierid)
                                    .addComponent(supplyproduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(deletesupp)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addsupp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchsupp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(updatesupp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(supplierid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(suppliername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(suppliercontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(supplyproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(addsupp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchsupp)
                        .addGap(18, 18, 18)
                        .addComponent(updatesupp)
                        .addGap(18, 18, 18)
                        .addComponent(deletesupp)
                        .addGap(18, 18, 18)
                        .addComponent(clearbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
     supplierid.setText("");
     suppliername.setText("");
     suppliercontact.setText("");
     supplyproduct.setSelectedIndex(-1);
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void searchsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchsuppActionPerformed
      String orderid;
       orderid= JOptionPane.showInputDialog("Enter supplier id");
        Connection co=null;
        try{
       
           co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from suppliers where supplierid='"+orderid+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
            if (!rs.next())            {
            statuslabel.setText("supplier does not exist");
            statuslabel.setForeground(Color.red);
           
            }   
            else
            {
        supplierid.setText(rs.getString(1));
         suppliername.setText(rs.getString(2));
             suppliercontact.setText(rs.getString(3));
                 supplyproduct.setSelectedItem(rs.getString(4));
            statuslabel.setText("supplier exists "); 
               statuslabel.setForeground(Color.green);
            
            }
             
        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_searchsuppActionPerformed

    private void addsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsuppActionPerformed
       Connection co=null;
        try{
       String a=supplierid.getText();
          String b=suppliername.getText();
          String c=suppliercontact.getText();
          String d=supplyproduct.getSelectedItem().toString();
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="insert into suppliers(supplierid,suppliername,emailcontact,supplyproduct) values('"+a+"','"+b+"','"+c+"','"+d+"')";
            if (b.isEmpty()||c.isEmpty()||a.isEmpty()||d.isEmpty())
            {
            statuslabel.setText("Missing details");
            statuslabel.setForeground(Color.red);
            }   
           
            else
            {
               stmt.executeUpdate(sql);
                statuslabel.setText("Supplier added"); 
               statuslabel.setForeground(Color.green);
              update();
            }          
        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_addsuppActionPerformed

    private void deletesuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletesuppActionPerformed
       String orderid;
       orderid= JOptionPane.showInputDialog("Enter supplier id");
        Connection co=null;
        try{
       
           co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from suppliers where supplierid='"+orderid+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
            if (!rs.next())            {
            statuslabel.setText("supplier does not exist");
            statuslabel.setForeground(Color.red);
           
            }   
            else
            {
            String sql1="DELETE FROM suppliers where supplierid='"+orderid+"'";
            stmt.executeUpdate(sql1);
            update();
            statuslabel.setText("supplier deleted "); 
               statuslabel.setForeground(Color.green);
            
            }
             
        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_deletesuppActionPerformed

    private void updatesuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesuppActionPerformed
       String orderid;
       orderid= JOptionPane.showInputDialog("Enter Supplier ID"); 
        Connection co=null;
        try{
        String a=supplierid.getText();
          String b=suppliername.getText();
          String c=suppliercontact.getText();
          String d=supplyproduct.getSelectedItem().toString();
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
           String sql="update suppliers set supplierid='"+a+"',suppliername='"+b+"',emailcontact='"+c+"',supplyproduct='"+d+"' where supplierid='"+orderid+"'";
             if (a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty())
            {
            statuslabel.setText("Missing details");
            statuslabel.setForeground(Color.red);
            }   
            else
            {
               stmt.executeUpdate(sql);
            statuslabel.setText("successful updated"); 
               statuslabel.setForeground(Color.green);
               update();
              
            }
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_updatesuppActionPerformed

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
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addsupp;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletesupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchsupp;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JTextField suppliercontact;
    private javax.swing.JTextField supplierid;
    private javax.swing.JTextField suppliername;
    private javax.swing.JTable suppliertable;
    private javax.swing.JComboBox supplyproduct;
    private javax.swing.JButton updatesupp;
    // End of variables declaration//GEN-END:variables
}
