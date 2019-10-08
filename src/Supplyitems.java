
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Supplyitems extends javax.swing.JFrame {
public String u="root";
    public String p="";
      public String conn="jdbc:mysql://127.0.0.1:3306/hstore";
    public Supplyitems() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        update();
    }

  public void update(){
      Connection co=null;
        try{
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from items";
            ResultSet rs =stmt.executeQuery(sql);
             itemtable.setModel(DbUtils.resultSetToTableModel(rs));
          
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
      
  } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemdescription = new javax.swing.JTextArea();
        additem = new javax.swing.JButton();
        deleteitem = new javax.swing.JButton();
        searchitem = new javax.swing.JButton();
        statuslabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemtable = new javax.swing.JTable();
        clearbutton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        itemlocation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setToolTipText("");
        jLabel4.setOpaque(true);

        jLabel1.setText("ITEM NAME:");

        jLabel2.setText("DESCRIPTION:");

        itemdescription.setColumns(20);
        itemdescription.setRows(5);
        jScrollPane1.setViewportView(itemdescription);

        additem.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        additem.setText("Add Item");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });

        deleteitem.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        deleteitem.setText("Delete Item");
        deleteitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteitemActionPerformed(evt);
            }
        });

        searchitem.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        searchitem.setText("Search Item");
        searchitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchitemActionPerformed(evt);
            }
        });

        itemtable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(itemtable);

        clearbutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        clearbutton.setText("Clear");
        clearbutton.setToolTipText("");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        jLabel5.setText("LOCATION:");

        jButton1.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jButton1.setText("change pricing ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchitem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(itemlocation, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(deleteitem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(additem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statuslabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemlocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(additem)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearbutton)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(deleteitem)
                        .addGap(18, 18, 18)
                        .addComponent(searchitem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchitemActionPerformed
        String orderid;
       orderid= JOptionPane.showInputDialog("Enter item ID");
        Connection co=null;
        try{
       
           co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from items where itemid='"+orderid+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
            if (!rs.next())            {
            statuslabel.setText("Item does not exist");
            statuslabel.setForeground(Color.red);
           
            }   
            else
            {
          itemname.setText(rs.getString(2));
         
          itemdescription.setText(rs.getString(3));
          itemlocation.setText(rs.getString(4));
            statuslabel.setText("Item found"); 
               statuslabel.setForeground(Color.green);
            
            }
             
        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_searchitemActionPerformed

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
      Connection co=null;
        try{
          
          String b=itemname.getText();
          String c=itemdescription.getText();
          String d=itemlocation.getText();
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="insert into items(itemname,itemdescription,location) values('"+b+"','"+c+"','"+d+"')";
            String sq="select * from items where itemname='"+b+"'";
            ResultSet r=stmt.executeQuery(sq);
            if (r.next()){
                statuslabel.setText("Items cannot have the same name");
            statuslabel.setForeground(Color.red);
            }
            else if (b.isEmpty()||c.isEmpty()||d.isEmpty())
            {
            statuslabel.setText("Missing details");
            statuslabel.setForeground(Color.red);
            }   
           
            else
            {  stmt.executeUpdate(sql);
            String sql4="select itemid from items where itemname='"+b+"' and itemdescription='"+c+"' and location='"+d+"'";
            ResultSet rs4=stmt.executeQuery(sql4);
            if(rs4.next()){
               Date x=Calendar.getInstance().getTime();
                  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            String date=sdf.format(x);
               int px=Integer.parseInt(JOptionPane.showInputDialog("Enter the price of the Item"));
            String sql3="insert into pricehistory (itemid,itemprice,startDate) values('"+rs4.getString(1)+"','"+px+"','"+date+"')"; 
            stmt.executeUpdate(sql3);
            }
                statuslabel.setText("Item successfully added"); 
               statuslabel.setForeground(Color.green);
              update();
            }          
        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_additemActionPerformed

    private void deleteitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteitemActionPerformed
      String orderid;
       orderid= JOptionPane.showInputDialog("Enter item id");
        Connection co=null;
        try{
       
           co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from items where itemid='"+orderid+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
            if (!rs.next())            {
            statuslabel.setText("Item does not exist");
            statuslabel.setForeground(Color.red);
           
            }   
            else
            {
            String sql1="DELETE FROM items where itemid='"+orderid+"'";
            stmt.executeUpdate(sql1);
            update();
            statuslabel.setText("Item deleted successfully"); 
               statuslabel.setForeground(Color.green);
            
            }
             
        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_deleteitemActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
         itemname.setText("");
          itemdescription.setText("");
          itemlocation.setText("");
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Connection co=null;
        try{
           co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
        int x= Integer.parseInt(JOptionPane.showInputDialog("Enter the item id"));
          int y= Integer.parseInt(JOptionPane.showInputDialog("Enter the item new price"));
          Date z=Calendar.getInstance().getTime();
                  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            String date=sdf.format(z);
          String sql1="select itemid from pricehistory";
          ResultSet rs1=stmt.executeQuery(sql1);
          rs1.first();
          if (!rs1.next())
          { 
              String sql2="insert into pricehistory (itemid,itemprice,startdate) values('"+x+"','"+y+"','"+date+"')";
              stmt.executeUpdate(sql2);
               statuslabel.setText("The price of '"+x+"' has been successfully changed to '"+y+"'");  
             statuslabel.setBackground(Color.green);
          }
          else{
                String sql7="select t.startdate from pricehistory t inner join(select distinct max(startdate) x,itemid from pricehistory "
                          + "group by itemid)s on s.itemid=("
                          + "select distinct f.itemid from pricehistory f where f.itemid='"+x+"')"
                          + "and t.startdate=s.x";
                 ResultSet rs7=stmt.executeQuery(sql7);
                rs7.next();
                String f=rs7.getString(1);                   
                
                String sql4="update pricehistory set enddate='"+date+"' where itemid='"+x+"' and startdate='"+f+"'";
                stmt.executeUpdate(sql4);
                 String sql2="insert into pricehistory (itemid,itemprice,startdate) values('"+x+"','"+y+"','"+date+"')";
              stmt.executeUpdate(sql2);
                           
                
          }     
             statuslabel.setText("The price of '"+x+"' has been successfully changed to '"+y+"'");  
             statuslabel.setBackground(Color.green);
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
           statuslabel.setBackground(Color.red);
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Supplyitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplyitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplyitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplyitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplyitems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additem;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deleteitem;
    private javax.swing.JTextArea itemdescription;
    private javax.swing.JTextField itemlocation;
    private javax.swing.JTextField itemname;
    private javax.swing.JTable itemtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton searchitem;
    private javax.swing.JLabel statuslabel;
    // End of variables declaration//GEN-END:variables
}
