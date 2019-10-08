
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Guest extends javax.swing.JFrame {
 public String u="root";
    public String p="";
      public String conn="jdbc:mysql://127.0.0.1:3306/hstore";
      String id;
    public Guest() {
        initComponents();
    }
     public void update(){
     try{Connection co=null;
      co=DriverManager.getConnection(conn,u,p);
        Statement stmt=(Statement)co.createStatement();        
           
       
            String sql6="select * from stock ";
            ResultSet rs6 =stmt.executeQuery(sql6); 
            stocktable.setModel(DbUtils.resultSetToTableModel(rs6));
       
              }
    catch (Exception e){
                statuslabel.setText(e.getMessage());
                statuslabel.setForeground(Color.red);               
        } 
    }
     public void open(){
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
Calendar cal = Calendar.getInstance();
DateFormat dateFormat1 = new SimpleDateFormat("hh:mm:ss");
 Calendar cal1 = Calendar.getInstance();
today.setText(dateFormat.format(cal.getTime()));
time.setText(dateFormat1.format(cal1.getTime()));
    }
public Guest (String x){
 initComponents();
         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        id=x;
    try{Connection co=null;
      co=DriverManager.getConnection(conn,u,p);
        Statement stmt=(Statement)co.createStatement();        
            String sql="select * from employee where IDNO='"+id+"'";
            ResultSet rs =stmt.executeQuery(sql);
              while(rs.next()){
                 useremaillabel.setText(rs.getString(2));
                 usernamelabel.setText(rs.getString(5));
                 byte[] img= rs.getBytes(7);
                  ImageIcon image=new ImageIcon(img);
                  Image im=image.getImage();
                  Image myImg=im.getScaledInstance(imagelabel.getWidth(),imagelabel.getHeight(), Image.SCALE_SMOOTH);
                  ImageIcon newImage= new ImageIcon(myImg);
                  imagelabel.setIcon(newImage);                 
  statuslabel.setText("welcome to the system");
                statuslabel.setForeground(Color.green);
             } }
              catch (Exception e){
                statuslabel.setText(e.getMessage());
                statuslabel.setForeground(Color.red);               
        }  
    open();
    update();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        profilepanel = new javax.swing.JPanel();
        imagelabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        useremaillabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        tabbedpanel = new javax.swing.JTabbedPane();
        stockpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stocktable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        stockValue = new javax.swing.JLabel();
        reportpanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        itemlist = new javax.swing.JButton();
        currentprice = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        stockreport = new javax.swing.JButton();
        emailpamel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        emailtextarea = new javax.swing.JTextArea();
        emailbutton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        toemail = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        closemenuitem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

        profilepanel.setBackground(new java.awt.Color(255, 255, 255));
        profilepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        usernamelabel.setToolTipText("");

        useremaillabel.setToolTipText("");

        javax.swing.GroupLayout profilepanelLayout = new javax.swing.GroupLayout(profilepanel);
        profilepanel.setLayout(profilepanelLayout);
        profilepanelLayout.setHorizontalGroup(
            profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useremaillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        profilepanelLayout.setVerticalGroup(
            profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useremaillabel, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);

        statuslabel.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N

        jLabel3.setText("START TIME:");

        jLabel4.setText("TODAYS DATE:");
        jLabel4.setToolTipText("");

        tabbedpanel.setBackground(new java.awt.Color(255, 255, 255));
        tabbedpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        tabbedpanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedpanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedpanel.setToolTipText("");

        stockpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stocktable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(stocktable);

        jLabel10.setText("Stock Value:");

        javax.swing.GroupLayout stockpanelLayout = new javax.swing.GroupLayout(stockpanel);
        stockpanel.setLayout(stockpanelLayout);
        stockpanelLayout.setHorizontalGroup(
            stockpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockpanelLayout.createSequentialGroup()
                .addGroup(stockpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stockpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stockpanelLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockValue, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        stockpanelLayout.setVerticalGroup(
            stockpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedpanel.addTab("STOCK ", stockpanel);

        reportpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemlist.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        itemlist.setText("LIST OF ITEMS REPORT");
        itemlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemlistActionPerformed(evt);
            }
        });

        currentprice.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        currentprice.setText("ItemsCurrent  Pircing");
        currentprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentpriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemlist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentprice, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addGap(828, 828, 828))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(itemlist)
                .addGap(28, 28, 28)
                .addComponent(currentprice)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Item Report", null, jPanel7, "");

        stockreport.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        stockreport.setText("AVAILABLE Stock Report");
        stockreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockreportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(stockreport, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(826, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(stockreport)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock Report", null, jPanel10, "");

        javax.swing.GroupLayout reportpanelLayout = new javax.swing.GroupLayout(reportpanel);
        reportpanel.setLayout(reportpanelLayout);
        reportpanelLayout.setHorizontalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        reportpanelLayout.setVerticalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        tabbedpanel.addTab("REPORT", null, reportpanel, "");

        emailpamel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        emailtextarea.setColumns(20);
        emailtextarea.setRows(5);
        jScrollPane6.setViewportView(emailtextarea);

        emailbutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        emailbutton.setText("SEND");
        emailbutton.setToolTipText("");
        emailbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailbuttonActionPerformed(evt);
            }
        });

        jLabel26.setText("RECEPIENT:");

        javax.swing.GroupLayout emailpamelLayout = new javax.swing.GroupLayout(emailpamel);
        emailpamel.setLayout(emailpamelLayout);
        emailpamelLayout.setHorizontalGroup(
            emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailpamelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailbutton)
                    .addGroup(emailpamelLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toemail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(675, Short.MAX_VALUE))
        );
        emailpamelLayout.setVerticalGroup(
            emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailpamelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(toemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailbutton)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        tabbedpanel.addTab("EMAIL", emailpamel);

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setOpaque(false);

        filemenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Folder_32.png"))); // NOI18N
        filemenu.setText("FILE");

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logout_16.png"))); // NOI18N
        logout.setText("Logout");
        logout.setToolTipText("");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        filemenu.add(logout);

        closemenuitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_16.png"))); // NOI18N
        closemenuitem.setText("Exit");
        closemenuitem.setToolTipText("");
        closemenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closemenuitemActionPerformed(evt);
            }
        });
        filemenu.add(closemenuitem);

        jMenuBar1.add(filemenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profilepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profilepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tabbedpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oncloseorlogout();
    }//GEN-LAST:event_formWindowClosing

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        oncloseorlogout();
        StartUp startUp = new StartUp();
        startUp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void closemenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closemenuitemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closemenuitemActionPerformed

    private void itemlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemlistActionPerformed

        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Item.jrxml");
            String sql="select * from items";
            JRDesignQuery jq= new JRDesignQuery();
            jq.setText(sql);
            jd.setQuery(jq);
            JasperReport jr =JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,co);
            JasperViewer.viewReport(jp,false);
        }
        catch (Exception e){
            statuslabel.setText(e.getMessage());

        }
    }//GEN-LAST:event_itemlistActionPerformed

    private void currentpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentpriceActionPerformed

        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\currentprice.jrxml");
            String sql=" select m.itemname,p.itemprice from pricehistory p inner join items m on p.ItemID=m.ItemID where p.enddate is null";
            JRDesignQuery jq= new JRDesignQuery();
            jq.setText(sql);
            jd.setQuery(jq);
            JasperReport jr =JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,co);
            JasperViewer.viewReport(jp,false);
        }
        catch (Exception e){
            statuslabel.setText(e.getMessage());

        }
    }//GEN-LAST:event_currentpriceActionPerformed

    private void stockreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockreportActionPerformed
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\stock.jrxml");
            String sql="select * from stock";
            JRDesignQuery jq= new JRDesignQuery();
            jq.setText(sql);
            jd.setQuery(jq);
            JasperReport jr =JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,co);
            JasperViewer.viewReport(jp,false);
        }
        catch (Exception e){
            statuslabel.setText(e.getMessage());

        }
    }//GEN-LAST:event_stockreportActionPerformed

    private void emailbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailbuttonActionPerformed
        Properties props= new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
        Session s=Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("paulwainaina36@gmail.com", "forbs2017change");}
            });
            try{
                Message m= new MimeMessage(s);
                m.setFrom(new InternetAddress("paulwainaina36@gmail.com"));
                m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toemail.getText()));
                m.setSubject("Hstore");
                m.setText(emailtextarea.getText());
                Transport.send(m);
                JOptionPane.showMessageDialog(null, "Email sent");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_emailbuttonActionPerformed

   public void oncloseorlogout()
    {Connection co=null;
        try{
         String u="root";
         String p="";
         String conn="jdbc:mysql://localhost:3306/hstore";
              DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
Calendar cal = Calendar.getInstance();
DateFormat dateFormat1 = new SimpleDateFormat("hh:mm:ss");
Calendar cal1 = Calendar.getInstance();


  
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="insert into audittrail values('"+id+"','"+time.getText()+"','"+(dateFormat1.format(cal1.getTime())) +"','"+(dateFormat.format(cal.getTime()))+"')";
         stmt.executeUpdate(sql);
            }
            catch (Exception e){
          System.out.println(e.getMessage());
    
        }}
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
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closemenuitem;
    private javax.swing.JButton currentprice;
    private javax.swing.JButton emailbutton;
    private javax.swing.JPanel emailpamel;
    private javax.swing.JTextArea emailtextarea;
    private javax.swing.JMenu filemenu;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JButton itemlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JPanel profilepanel;
    private javax.swing.JPanel reportpanel;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JLabel stockValue;
    private javax.swing.JPanel stockpanel;
    private javax.swing.JButton stockreport;
    private javax.swing.JTable stocktable;
    private javax.swing.JTabbedPane tabbedpanel;
    private javax.swing.JLabel time;
    private javax.swing.JLabel today;
    private javax.swing.JTextField toemail;
    private javax.swing.JLabel useremaillabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
