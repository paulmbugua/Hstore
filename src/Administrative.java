import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Administrative extends javax.swing.JFrame {
 public String u="root";
    public String p="";
      public String conn="jdbc:mysql://127.0.0.1:3306/hstore";
      String id;
    public Administrative() {
        initComponents();
    }
    public void open(){
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
Calendar cal = Calendar.getInstance();
DateFormat dateFormat1 = new SimpleDateFormat("hh:mm:ss");
 Calendar cal1 = Calendar.getInstance();
today.setText(dateFormat.format(cal.getTime()));
time.setText(dateFormat1.format(cal1.getTime()));
    }
    public void update(){
     try{Connection co;
      co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement(); 
              AutoCompleteDecorator.decorate(receiveitemname);
           AutoCompleteDecorator.decorate(salecombo);
                receiveitemname.removeAllItems();
                    String sql4="select itemname from items ";
                        ResultSet rs4=stmt.executeQuery(sql4);                
                    while(rs4.next())
                    {
                   receiveitemname.addItem(rs4.getString(1));
                    }  
                  
                salecombo.removeAllItems();
                    String sql7="select ItemName from stock";
                    ResultSet rs7=stmt.executeQuery(sql7);
                    while(rs7.next())
                    {
                   salecombo.addItem(rs7.getString(1));
                    }
                   
                    class stock{
                        public String names;
                        public int quantity;

             private stock(String string, int quantity) {
             names=string;
             this.quantity=quantity;
             }
                    }
                    String count1="select count(*) from stock";
                    ResultSet countrs=stmt.executeQuery(count1);
                    countrs.first();
                    stock[] s=new stock[Integer.parseInt(countrs.getString(1))];
                  
                    ArrayList<stock> stockvalue=new ArrayList<stock>();
                    String sql20="select * from stock";
                    int value=0;
                   
                    ResultSet rs20=stmt.executeQuery(sql20); rs20.first();
                    while(rs20.next()){
                        int quantity=Integer.parseInt(rs20.getString(2));
                   stockvalue.add(new stock(rs20.getString(1),quantity));                  
                    }
                    int x=0;
                 while(x<stockvalue.size()){
                     int q= stockvalue.get(x).quantity;
                     String n=stockvalue.get(x).names;
                     String sql="select itemprice from pricehistory where itemid=(select itemid from items where items.itemname='"+n+"') and enddate is null and "
                    + "startdate=(select distinct t.startdate from pricehistory t inner join(select distinct max(startdate) x, itemid from pricehistory group by itemid)s on s.itemid=( select distinct f.ItemID from pricehistory f where f.ItemID=(select itemid from items where itemname='"+n+"')) and t.startdate=s.x)";
            ResultSet rs=stmt.executeQuery(sql);
       
            rs.first();
            value=value+(q*(Integer.parseInt(rs.getString(1))));
                     x++;
                 }
                    
                   stockValue.setText("Total value :"+value);
            String sql5="select * from received";
            ResultSet rs5 =stmt.executeQuery(sql5); 
            receivetable.setModel(DbUtils.resultSetToTableModel(rs5));
            String sql6="select * from stock";
            ResultSet rs6 =stmt.executeQuery(sql6); 
            stocktable.setModel(DbUtils.resultSetToTableModel(rs6));
            String sql16="select * from audittrail";
            ResultSet rs16=stmt.executeQuery(sql16);
            audittable.setModel(DbUtils.resultSetToTableModel(rs16));
            String sql8="select * from sales";
            ResultSet rs8 =stmt.executeQuery(sql8); 
            salestable.setModel(DbUtils.resultSetToTableModel(rs8));
            String sql9="select ItemName,Quantity from stock where quantity < 10 ";
            ResultSet rs9 =stmt.executeQuery(sql9); 
            stockouttable.setModel(DbUtils.resultSetToTableModel(rs9));
                         String sql11="select ItemName Quantity from stock where quantity < 10 ";
            ResultSet rs11 =stmt.executeQuery(sql11);
            int count=0;
            while(rs11.next()){
                count++;
                notificationmenu.setText(count+"   NOTIFICATION");
            }
           
                    
              }
    catch (Exception e){
                statuslabel.setText(e.getMessage());
                statuslabel.setForeground(Color.red);               
        } 
    }
    public Administrative (String x){
        initComponents();
          AutoCompleteDecorator.decorate(receiveitemname);
           AutoCompleteDecorator.decorate(salecombo);
         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("mainlogo.png")));
        id=x;
        this.setTitle("Administrative panel :..ID Number "+id);
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
             }
        
    }
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
        jLabel2 = new javax.swing.JLabel();
        profilepanel = new javax.swing.JPanel();
        imagelabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        useremaillabel = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tabbedpanel = new javax.swing.JTabbedPane();
        receivepanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        receivedate = new com.toedter.calendar.JDateChooser();
        receiveorder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receivetable = new javax.swing.JTable();
        clearbutton = new javax.swing.JButton();
        cancledelivery = new javax.swing.JButton();
        receiveunitprice = new javax.swing.JLabel();
        receivequantity = new javax.swing.JTextField();
        receiveitemname = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        stockpanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stocktable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        stockValue = new javax.swing.JLabel();
        salepanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        salestable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        salecombo = new javax.swing.JComboBox();
        stocklevels = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        salequantity = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        saleprice = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        saledate = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        customername = new javax.swing.JTextField();
        salebutton = new javax.swing.JButton();
        clearsale = new javax.swing.JButton();
        updatesale = new javax.swing.JButton();
        canclesalebutton = new javax.swing.JButton();
        receipt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        salebasic = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        reportpanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        employeedetails = new javax.swing.JButton();
        employeelist = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dsale = new com.toedter.calendar.JDateChooser();
        empsalereport = new javax.swing.JButton();
        Sales = new javax.swing.JPanel();
        allsales = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        startdatechooser = new com.toedter.calendar.JDateChooser();
        closedatechooser = new com.toedter.calendar.JDateChooser();
        salereport = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        supplierlist = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        itemlist = new javax.swing.JButton();
        itemsalesummary = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pricehistory = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        sp = new com.toedter.calendar.JDateChooser();
        currentprice = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        stockreport = new javax.swing.JButton();
        notificationpanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        stockouttable = new javax.swing.JTable();
        emailpamel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        emailtextarea = new javax.swing.JTextArea();
        emailbutton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        toemail = new javax.swing.JTextField();
        audit = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        audittable = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        closemenuitem = new javax.swing.JMenuItem();
        suppliermenu = new javax.swing.JMenu();
        employeemenu = new javax.swing.JMenu();
        salesmenu = new javax.swing.JMenu();
        deliverymenu = new javax.swing.JMenu();
        stockmenu = new javax.swing.JMenu();
        reportmenu = new javax.swing.JMenu();
        notificationmenu = new javax.swing.JMenu();
        itemsmenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);

        profilepanel.setBackground(new java.awt.Color(102, 102, 102));
        profilepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        imagelabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        usernamelabel.setToolTipText("");

        useremaillabel.setToolTipText("");

        javax.swing.GroupLayout profilepanelLayout = new javax.swing.GroupLayout(profilepanel);
        profilepanel.setLayout(profilepanelLayout);
        profilepanelLayout.setHorizontalGroup(
            profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useremaillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        profilepanelLayout.setVerticalGroup(
            profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useremaillabel, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
        );

        statuslabel.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        statuslabel.setToolTipText("");

        jLabel3.setText("START TIME:");

        jLabel4.setText("TODAYS DATE:");
        jLabel4.setToolTipText("");

        tabbedpanel.setBackground(new java.awt.Color(255, 255, 255));
        tabbedpanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        tabbedpanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedpanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedpanel.setToolTipText("");

        receivepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("ITEM PRICE:");

        jLabel14.setText("ITEM NAME:");

        jLabel15.setText("ORDER QUANTITY:");

        jLabel16.setText("RECEIVED DATE:");

        receiveorder.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        receiveorder.setText("Receive Order");
        receiveorder.setToolTipText("");
        receiveorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveorderActionPerformed(evt);
            }
        });

        receivetable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(receivetable);

        clearbutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        clearbutton.setText("Clear");
        clearbutton.setToolTipText("");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        cancledelivery.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        cancledelivery.setText("Cancle delivery");
        cancledelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancledeliveryActionPerformed(evt);
            }
        });

        receiveunitprice.setToolTipText("");

        receivequantity.setToolTipText("");

        receiveitemname.setToolTipText("");

        jButton1.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jButton1.setText("GET PRICE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receivepanelLayout = new javax.swing.GroupLayout(receivepanel);
        receivepanel.setLayout(receivepanelLayout);
        receivepanelLayout.setHorizontalGroup(
            receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivepanelLayout.createSequentialGroup()
                .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receivepanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancledelivery)
                            .addComponent(clearbutton)
                            .addComponent(receiveorder)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(receivepanelLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receiveitemname, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivepanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivepanelLayout.createSequentialGroup()
                                .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(receiveunitprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(receivequantity)
                                    .addComponent(receivedate, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivepanelLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(46, 46, 46)))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        receivepanelLayout.setVerticalGroup(
            receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receivepanelLayout.createSequentialGroup()
                .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receivepanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(receiveitemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(receiveunitprice, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(receivequantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(receivepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(receivedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(clearbutton)
                        .addGap(18, 18, 18)
                        .addComponent(receiveorder)
                        .addGap(18, 18, 18)
                        .addComponent(cancledelivery)
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(receivepanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabbedpanel.addTab("RECEIVE ORDER", null, receivepanel, "");

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
                .addContainerGap(133, Short.MAX_VALUE))
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

        salepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        salestable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(salestable);

        jLabel17.setText("ITEM NAME:");

        jLabel18.setText("AVAILABLE QUANTITY: ");

        jLabel19.setText("SALE QUANTITY:");

        jLabel20.setText("SALE PRICE:");

        saleprice.setToolTipText("");

        jLabel21.setText("DATE OF SALE:");

        jLabel22.setText("CUSTOMER NAME:");

        salebutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        salebutton.setText("SELL");
        salebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salebuttonActionPerformed(evt);
            }
        });

        clearsale.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        clearsale.setText("CLEAR");
        clearsale.setToolTipText("");
        clearsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearsaleActionPerformed(evt);
            }
        });

        updatesale.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        updatesale.setText("UPDATE SALE");
        updatesale.setToolTipText("");
        updatesale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesaleActionPerformed(evt);
            }
        });

        canclesalebutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        canclesalebutton.setText("CANCLE SALE");
        canclesalebutton.setToolTipText("");
        canclesalebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canclesalebuttonActionPerformed(evt);
            }
        });

        receipt.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        receipt.setText("Print Receipt");
        receipt.setToolTipText("");
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });

        jLabel6.setText("SALE PRICE:");

        jButton2.setText("FIND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salepanelLayout = new javax.swing.GroupLayout(salepanel);
        salepanel.setLayout(salepanelLayout);
        salepanelLayout.setHorizontalGroup(
            salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receipt)
                    .addGroup(salepanelLayout.createSequentialGroup()
                        .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salebutton, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(updatesale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(canclesalebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearsale, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(salepanelLayout.createSequentialGroup()
                        .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salequantity)
                            .addComponent(saleprice)
                            .addComponent(saledate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customername, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                    .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, salepanelLayout.createSequentialGroup()
                            .addComponent(salecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, salepanelLayout.createSequentialGroup()
                            .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stocklevels, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(salepanelLayout.createSequentialGroup()
                                    .addComponent(salebasic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(16, 16, 16))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        salepanelLayout.setVerticalGroup(
            salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salepanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(5, 5, 5)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salebasic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stocklevels, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salequantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(23, 23, 23)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(saleprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(saledate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salebutton)
                    .addComponent(clearsale))
                .addGap(18, 18, 18)
                .addGroup(salepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatesale)
                    .addComponent(canclesalebutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(receipt)
                .addGap(35, 35, 35))
            .addGroup(salepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedpanel.addTab("SALES", null, salepanel, "");

        reportpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        employeedetails.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        employeedetails.setText("Employee Details REPORT");
        employeedetails.setToolTipText("");
        employeedetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeedetailsActionPerformed(evt);
            }
        });

        employeelist.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        employeelist.setText("Employee List Report");
        employeelist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeelistActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jLabel7.setText("Employee Sales");

        jLabel8.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jLabel8.setText("Sale Date:");

        empsalereport.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        empsalereport.setText("Employee Sale Report");
        empsalereport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empsalereportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(empsalereport, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(97, 97, 97)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(dsale, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(dsale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(empsalereport)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeedetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeelist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(163, 163, 163)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(employeedetails)
                        .addGap(18, 18, 18)
                        .addComponent(employeelist)))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employee Reports", jPanel3);

        allsales.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        allsales.setText("All Sales Report");
        allsales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allsalesActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel23.setText("START DATE:");

        jLabel24.setText("END DATE:");

        salereport.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        salereport.setText("Sale Report");
        salereport.setToolTipText("");
        salereport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salereportActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jLabel13.setText("SALES REPORT BETWEEN DATES:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salereport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(closedatechooser, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addComponent(startdatechooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(startdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(closedatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(salereport)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SalesLayout = new javax.swing.GroupLayout(Sales);
        Sales.setLayout(SalesLayout);
        SalesLayout.setHorizontalGroup(
            SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(allsales, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        SalesLayout.setVerticalGroup(
            SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesLayout.createSequentialGroup()
                .addGroup(SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(allsales))))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sales Report", Sales);

        supplierlist.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        supplierlist.setText("LIST OF SUPPLIERS REPORT");
        supplierlist.setToolTipText("");
        supplierlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierlistActionPerformed(evt);
            }
        });

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("All Supply Summary", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Supply Over A Period", null, jPanel6, "");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(supplierlist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierlist)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supplier Report", null, jPanel4, "");

        itemlist.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        itemlist.setText("LIST OF ITEMS REPORT");
        itemlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemlistActionPerformed(evt);
            }
        });

        itemsalesummary.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        itemsalesummary.setText("Items Sale Summary Report");
        itemsalesummary.setToolTipText("");
        itemsalesummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsalesummaryActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        pricehistory.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        pricehistory.setText("Price history");
        pricehistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricehistoryActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        jLabel27.setText("Price History");

        jLabel28.setText("START DATE:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricehistory, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(pricehistory)
                .addGap(32, 32, 32))
        );

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
                    .addComponent(itemsalesummary, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(itemlist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(131, 131, 131)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(itemlist)
                        .addGap(18, 18, 18)
                        .addComponent(itemsalesummary)
                        .addGap(30, 30, 30)
                        .addComponent(currentprice)))
                .addContainerGap(197, Short.MAX_VALUE))
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
                .addContainerGap(136, Short.MAX_VALUE))
        );
        reportpanelLayout.setVerticalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        tabbedpanel.addTab("REPORT", null, reportpanel, "");

        notificationpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stockouttable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(stockouttable);

        javax.swing.GroupLayout notificationpanelLayout = new javax.swing.GroupLayout(notificationpanel);
        notificationpanel.setLayout(notificationpanelLayout);
        notificationpanelLayout.setHorizontalGroup(
            notificationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        notificationpanelLayout.setVerticalGroup(
            notificationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedpanel.addTab("NOTIFICATIONS", null, notificationpanel, "");

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
                .addContainerGap(604, Short.MAX_VALUE))
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
                .addContainerGap(124, Short.MAX_VALUE))
        );

        tabbedpanel.addTab("EMAIL", emailpamel);

        audit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        audittable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(audittable);

        javax.swing.GroupLayout auditLayout = new javax.swing.GroupLayout(audit);
        audit.setLayout(auditLayout);
        auditLayout.setHorizontalGroup(
            auditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(auditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        auditLayout.setVerticalGroup(
            auditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(auditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedpanel.addTab("AUDIT TRAIL", null, audit, "");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator.png"))); // NOI18N
        jLabel25.setToolTipText("");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notepad.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

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

        suppliermenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Supplier_32.png"))); // NOI18N
        suppliermenu.setText("SUPPLIERS");
        suppliermenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliermenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(suppliermenu);

        employeemenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee_32.png"))); // NOI18N
        employeemenu.setText("EMPLOYEE");
        employeemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeemenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(employeemenu);

        salesmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sales_32.png"))); // NOI18N
        salesmenu.setText("SALE");
        salesmenu.setToolTipText("");
        salesmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(salesmenu);

        deliverymenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delivery_32.png"))); // NOI18N
        deliverymenu.setText("DELIVERY");
        deliverymenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliverymenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(deliverymenu);

        stockmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stock_32.png"))); // NOI18N
        stockmenu.setText("STOCK");
        stockmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(stockmenu);

        reportmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/report_32.png"))); // NOI18N
        reportmenu.setText("REPORT");
        reportmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(reportmenu);

        notificationmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notification_32.png"))); // NOI18N
        notificationmenu.setText("NOTIFICATION");
        notificationmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(notificationmenu);

        itemsmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/items_32.png"))); // NOI18N
        itemsmenu.setText("ITEMS");
        itemsmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(itemsmenu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh_32.png"))); // NOI18N
        jMenu1.setText("REFRESH");
        jMenu1.setToolTipText("");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedpanel)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statuslabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(profilepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)))
                            .addComponent(jLabel25)
                            .addComponent(jLabel4)))
                    .addComponent(profilepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        oncloseorlogout();
        StartUp startUp = new StartUp();
         startUp.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        oncloseorlogout();
    }//GEN-LAST:event_formWindowClosing

    private void receiveorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveorderActionPerformed
         Connection co=null;
        try{
          
          String b=receivequantity.getText();
          String c=receiveunitprice.getText();
          String d=receiveitemname.getSelectedItem().toString();
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date de=receivedate.getDate();
          java.sql.Date date=new java.sql.Date(de.getTime());
         
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="insert into received(itemname,quantity,unitprice,dateofreceive,receivedby) values('"+d+"','"+b+"','"+c+"','"+date+"','"+id+"')";
           
            if (b.isEmpty()||c.isEmpty()||d.isEmpty())
            {
            statuslabel.setText("Missing details");
            statuslabel.setForeground(Color.red);
            }   
            else
            {String sqln="select itemid from items where itemname='"+d+"'";
           ResultSet rsn=stmt.executeQuery(sqln);
           rsn.first();
           int x=Integer.parseInt(rsn.getString(1));
               stmt.executeUpdate(sql);
               statuslabel.setText("Successfully added");
            statuslabel.setForeground(Color.green);
                String sql3="select * from stock where itemid='"+x+"'";
                ResultSet rs1=stmt.executeQuery(sql3);
                if (!rs1.next()){
                String sql2="insert into stock(itemname,quantity,itemid)  values('"+d+"','"+b+"','"+x+"')";
                stmt.executeUpdate(sql2);}
                else{
                    int totalquantity=0;
                    totalquantity=Integer.parseInt(rs1.getString(2))+ Integer.parseInt(b);
                     String sql4="update stock set quantity='"+totalquantity+"' where itemname='"+d+"'";
                stmt.executeUpdate(sql4); 
                }
        update();
            }
            
            
            
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_receiveorderActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
       receivedate.setDate(null);
       receivequantity.setText("");
       receiveunitprice.setText("");
      
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void cancledeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancledeliveryActionPerformed
     String orderid;
       orderid= JOptionPane.showInputDialog("Enter Delivery number");
       try{
          Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from received where DeliveryNumber='"+orderid+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
             
            if (!rs.next())            {
            statuslabel.setText("Received not exist");
            statuslabel.setForeground(Color.red);
           
            }   
            else
            {
               
            statuslabel.setText("Received  exists"); 
               statuslabel.setForeground(Color.green);               
             receiveitemname.setSelectedItem(rs.getString(2));
              receivequantity.setText(rs.getString(3));
              receiveunitprice.setText(rs.getString(4));
             receivedate.setDate(rs.getDate(5));
             String xes=rs.getString(2);
             int quantity= Integer.parseInt(rs.getString(3)) ;
             Statement stmt1=(Statement)co.createStatement();
             String sqln="select itemid from items where itemname='"+xes+"'";
           ResultSet rsn=stmt.executeQuery(sqln);
           rsn.first();
           int x=Integer.parseInt(rsn.getString(1));
             String sql3="select quantity from stock where itemid='"+x+"'";
            
             ResultSet rs1=stmt1.executeQuery(sql3);
     
              if(rs1.next()){
              rs1.first();
             int removed=Integer.parseInt(rs1.getString(1));
              
             int total=removed - quantity;
                      
             String sql4="update stock set quantity='"+total+"' where itemid='"+x+"'";
             stmt.executeUpdate(sql4);}
            String sql1="DELETE FROM received where DeliveryNumber='"+orderid+"'";
            stmt.executeUpdate(sql1);
           update();
            statuslabel.setText("Order  deleted "); 
               statuslabel.setForeground(Color.green);
                             
            }
             
                        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
    
        }
      
    }//GEN-LAST:event_cancledeliveryActionPerformed

    private void salebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salebuttonActionPerformed
         Connection co=null;
        try{
          String a=salecombo.getSelectedItem().toString();
          String b=salequantity.getText();
          String c=saleprice.getText();
          String d=customername.getText();
          String e=stocklevels.getText();
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date de=saledate.getDate();
          java.sql.Date date=new java.sql.Date(de.getTime());
         int received=1;
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="insert into sales(itemname,quantity,saleprice,customername,dateofsale,servedby) values('"+a+"','"+b+"','"+c+"','"+d+"','"+date+"','"+id+"')";
            if (a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty())
            {
            statuslabel.setText("Missing details");
            statuslabel.setForeground(Color.red);
            }   
            else if(Integer.parseInt(b)>Integer.parseInt(e)){
                  statuslabel.setText("Such an amount do not exist");
            statuslabel.setForeground(Color.red);
            }
            else if(Integer.parseInt(c)<Integer.parseInt(salebasic.getText())){
                 statuslabel.setText("The selling price does not reach the minimum amount");
            statuslabel.setForeground(Color.red); 
            }
            else
            {
               stmt.executeUpdate(sql);
               int totalquantity=Integer.parseInt(e)- Integer.parseInt(b);
                     String sql4="update stock set quantity='"+totalquantity+"' where itemname='"+a+"'";
                stmt.executeUpdate(sql4); 
              
            statuslabel.setText("successful sale"); 
               statuslabel.setForeground(Color.green);
              update();}
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
          
        }
    }//GEN-LAST:event_salebuttonActionPerformed

    private void clearsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearsaleActionPerformed
        salecombo.setSelectedIndex(-1);
        stocklevels.setText("");
        saledate.setDate(null);
        salequantity.setText("");
        saleprice.setText("");
        customername.setText("");
    }//GEN-LAST:event_clearsaleActionPerformed

    private void updatesaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesaleActionPerformed
       String orderid;
       orderid= JOptionPane.showInputDialog("Enter sale number you want to update"); 
        Connection co=null;
        try{
     
          String b=salequantity.getText();
          String c=saleprice.getText();
          String d=customername.getText();
          SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date de=saledate.getDate();
          java.sql.Date date=new java.sql.Date(de.getTime());
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
           String sql="update sales set saleprice='"+c+"',quantity='"+b+"',dateofsale='"+date+"',customername='"+d+"',servedby='"+id+"' where salenumber='"+orderid+"'";
             if (b.isEmpty()||c.isEmpty()||d.isEmpty())
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
    }//GEN-LAST:event_updatesaleActionPerformed

    private void canclesalebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canclesalebuttonActionPerformed
         String orderid;
       orderid= JOptionPane.showInputDialog("Enter sale number");
       try{
          Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select * from sales where salenumber='"+orderid+"'";
             ResultSet rs =stmt.executeQuery(sql);
             
             
            if (!rs.next())            {
            statuslabel.setText("sale does not exist");
            statuslabel.setForeground(Color.red);
           
            }   
            else
            {
               
            statuslabel.setText("sale exists"); 
               statuslabel.setForeground(Color.green);
               
             customername.setText(rs.getString(5));
             salequantity.setText(rs.getString(3));
              saleprice.setText(rs.getString(4));
             saledate.setDate(rs.getDate(6));
             String xes=rs.getString(2);           
          
             int quantity= Integer.parseInt(rs.getString(3)) ;
             
             String sqln="select itemid from items where itemname='"+xes+"'";
           ResultSet rsn=stmt.executeQuery(sqln);
           rsn.first();
           int x=Integer.parseInt(rsn.getString(1));
           
             Statement stmt1=(Statement)co.createStatement();
             String sql3="select quantity from stock where itemname='"+xes+"'";
             ResultSet rs1=stmt1.executeQuery(sql3);
             if(rs1.next()){
              rs1.first();
             int removed=Integer.parseInt(rs1.getString(1));
             int total=removed + quantity;
             String sql4="update stock set quantity='"+total+"' where itemname='"+xes+"'";
             stmt.executeUpdate(sql4);}
             else{
                 String sql5="insert into stock (itemname,quantity,itemid) values ('"+xes+"','"+quantity+"','"+x+"')";
                 stmt.executeUpdate(sql5);
             }
            String sql1="DELETE FROM sales where salenumber='"+orderid+"'";
            stmt.executeUpdate(sql1);
            update();
            statuslabel.setText("sale  deleted "); 
               statuslabel.setForeground(Color.green);
                              
            }
             
                        
        }catch (Exception e){
           statuslabel.setText(e.getMessage());
    
        }
    }//GEN-LAST:event_canclesalebuttonActionPerformed

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

    private void employeedetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeedetailsActionPerformed
       String orderid;
       orderid= JOptionPane.showInputDialog("Enter ID number"); 
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Employeeindividualdetail.jrxml");
            String sql="select * from employee where IDNO='"+orderid+"'";
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
    }//GEN-LAST:event_employeedetailsActionPerformed

    private void salereportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salereportActionPerformed
       java.util.Date de=startdatechooser.getDate();
          java.sql.Date date=new java.sql.Date(de.getTime());
          java.util.Date de1=closedatechooser.getDate();
          java.sql.Date date1=new java.sql.Date(de1.getTime());
       
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Sale.jrxml");
            String sql="select itemname,dateofsale,sum(quantity) as totalsales from sales where dateofsale between '"+date+"' and '"+date1+"' GROUP BY itemname,dateofsale";
            JRDesignQuery jq= new JRDesignQuery();
            jq.setText(sql);
            jd.setQuery(jq);
            JasperReport jr =JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,co);
            JasperViewer.viewReport(jp,false);
        }
         catch (Exception e){
           statuslabel.setText(e.getMessage());
           statuslabel.setText("Select the dates");
                  statuslabel.setForeground(Color.red);
    
        }
    }//GEN-LAST:event_salereportActionPerformed

    private void closemenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closemenuitemActionPerformed
       System.exit(0);
    }//GEN-LAST:event_closemenuitemActionPerformed

    private void suppliermenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliermenuMouseClicked
        Suppliers sp = new Suppliers();
        sp.setVisible(true);
        
        
    }//GEN-LAST:event_suppliermenuMouseClicked

    private void employeemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeemenuMouseClicked
        Employee emp=new Employee();
        emp.setVisible(true);
    }//GEN-LAST:event_employeemenuMouseClicked

    private void salesmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesmenuMouseClicked
   tabbedpanel.setSelectedComponent(salepanel);
    }//GEN-LAST:event_salesmenuMouseClicked

    private void deliverymenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliverymenuMouseClicked
      tabbedpanel.setSelectedComponent(receivepanel);
    }//GEN-LAST:event_deliverymenuMouseClicked

    private void stockmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockmenuMouseClicked
       tabbedpanel.setSelectedComponent(stockpanel);
    }//GEN-LAST:event_stockmenuMouseClicked

    private void reportmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportmenuMouseClicked
       tabbedpanel.setSelectedComponent(reportpanel);
    }//GEN-LAST:event_reportmenuMouseClicked

    private void notificationmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationmenuMouseClicked
        tabbedpanel.setSelectedComponent(notificationpanel);
    }//GEN-LAST:event_notificationmenuMouseClicked

    private void itemsmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsmenuMouseClicked
        Supplyitems sp = new Supplyitems();
        sp.setVisible(true);
    }//GEN-LAST:event_itemsmenuMouseClicked

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
       String orderid;
       orderid= JOptionPane.showInputDialog("Enter Sale number"); 
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Receipt.jrxml");
            String sql="select * from sales where salenumber='"+orderid+"'";
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
    }//GEN-LAST:event_receiptActionPerformed

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

    private void supplierlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierlistActionPerformed
      
                 try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Supplierdetail.jrxml");
            String sql="select * from suppliers";
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
    }//GEN-LAST:event_supplierlistActionPerformed

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      Runtime rs=Runtime.getRuntime();
     try {
         rs.exec("notepad");
     } catch (IOException ex) {
         Logger.getLogger(Administrative.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
      Runtime rs=Runtime.getRuntime();
     try {
         rs.exec("calc");
     } catch (IOException ex) {
         Logger.getLogger(Administrative.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
update();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void pricehistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricehistoryActionPerformed
        String orderid;
       orderid= JOptionPane.showInputDialog("Enter Item number"); 
      java.util.Date de=sp.getDate();
          java.sql.Date orderid1=new java.sql.Date(de.getTime());
         
       
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\ItemPricehistory.jrxml");
            String sql="select * from pricehistory where StartDate >= '"+orderid1+"'and ItemID='"+Integer.parseInt(orderid)+"'  ";
            JRDesignQuery jq= new JRDesignQuery();
            jq.setText(sql);
            jd.setQuery(jq);
            JasperReport jr =JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,co);
            JasperViewer.viewReport(jp,false);
        }
         catch (Exception e){
     System.out.println(e.getMessage());
           statuslabel.setText("Select the dates");
                  statuslabel.setForeground(Color.red);
    
        }
    }//GEN-LAST:event_pricehistoryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String x= receiveitemname.getSelectedItem().toString();
       String n="null";
        if(x.isEmpty()){
        statuslabel.setText("No Item is selected");
            statuslabel.setForeground(Color.red);}
        else{
            try {
             Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select itemprice from pricehistory where itemid=(select itemid from items where items.itemname='"+x+"') and enddate is null and "
                    + "startdate=(select distinct t.startdate from pricehistory t inner join(select distinct max(startdate) x, itemid from pricehistory group by itemid)s on s.itemid=( select distinct f.ItemID from pricehistory f where f.ItemID=(select itemid from items where itemname='"+x+"')) and t.startdate=s.x)";
            ResultSet rs=stmt.executeQuery(sql);
            rs.first();
            receiveunitprice.setText(rs.getString(1));
            }
            catch(Exception e){
           statuslabel.setText(e.getMessage());
                  statuslabel.setForeground(Color.red);
    
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String x= salecombo.getSelectedItem().toString();
        if(x.isEmpty()){
          statuslabel.setText("No Item is selected");
            statuslabel.setForeground(Color.red);}
        else{
            try {
             Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            Statement stmt=(Statement)co.createStatement();
            String sql="select itemprice from pricehistory where itemid=(select itemid from items where items.itemname='"+x+"') and enddate is null and "
                    + "startdate=(select distinct t.startdate from pricehistory t inner join(select distinct max(startdate) x, itemid from pricehistory group by itemid)s on s.itemid=( select distinct f.ItemID from pricehistory f where f.ItemID=(select itemid from items where itemname='"+x+"')) and t.startdate=s.x)";
            ResultSet rs=stmt.executeQuery(sql);
            rs.first();
            salebasic.setText(rs.getString(1));
            String f="select quantity from stock where itemname='"+x+"'";
            ResultSet g=stmt.executeQuery(f);
            g.first();
            stocklevels.setText(g.getString(1));
            }
            catch(Exception e){
           statuslabel.setText(e.getMessage());
                  statuslabel.setForeground(Color.red);
    
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemsalesummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsalesummaryActionPerformed
        String x;
       x= JOptionPane.showInputDialog("Enter Item number");  
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Itemsummary.jrxml");
            String sql="select * from sales where ItemName=(select ItemName from items where ItemID='"+Integer.parseInt(x)+"')";
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
    }//GEN-LAST:event_itemsalesummaryActionPerformed

    private void employeelistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeelistActionPerformed
           try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Employeelist.jrxml");
            String sql="select * from employee";
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
    }//GEN-LAST:event_employeelistActionPerformed

    private void empsalereportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empsalereportActionPerformed
        String x;
       x= JOptionPane.showInputDialog("Enter Employee IDNO");  
              java.util.Date de=dsale.getDate();
          java.sql.Date date=new java.sql.Date(de.getTime());
        try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\Employeesales.jrxml");
            String sql="select * from sales where Servedby='"+Integer.parseInt(x)+"' and DateOfSale='"+date+"'";
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
    }//GEN-LAST:event_empsalereportActionPerformed

    private void allsalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allsalesActionPerformed
          try{Connection co=null;
            co=DriverManager.getConnection(conn,u,p);
            JasperDesign jd =JRXmlLoader.load("C:\\Users\\PAUL\\Documents\\NetBeansProjects\\HSTORE\\src\\SalesReport.jrxml");
            String sql="select * from sales";
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
    }//GEN-LAST:event_allsalesActionPerformed

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
            java.util.logging.Logger.getLogger(Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sales;
    private javax.swing.JButton allsales;
    private javax.swing.JPanel audit;
    private javax.swing.JTable audittable;
    private javax.swing.JButton cancledelivery;
    private javax.swing.JButton canclesalebutton;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton clearsale;
    private com.toedter.calendar.JDateChooser closedatechooser;
    private javax.swing.JMenuItem closemenuitem;
    private javax.swing.JButton currentprice;
    private javax.swing.JTextField customername;
    private javax.swing.JMenu deliverymenu;
    private com.toedter.calendar.JDateChooser dsale;
    private javax.swing.JButton emailbutton;
    private javax.swing.JPanel emailpamel;
    private javax.swing.JTextArea emailtextarea;
    private javax.swing.JButton employeedetails;
    private javax.swing.JButton employeelist;
    private javax.swing.JMenu employeemenu;
    private javax.swing.JButton empsalereport;
    private javax.swing.JMenu filemenu;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JButton itemlist;
    private javax.swing.JButton itemsalesummary;
    private javax.swing.JMenu itemsmenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu notificationmenu;
    private javax.swing.JPanel notificationpanel;
    private javax.swing.JButton pricehistory;
    private javax.swing.JPanel profilepanel;
    private javax.swing.JButton receipt;
    private com.toedter.calendar.JDateChooser receivedate;
    private javax.swing.JComboBox receiveitemname;
    private javax.swing.JButton receiveorder;
    private javax.swing.JPanel receivepanel;
    private javax.swing.JTextField receivequantity;
    private javax.swing.JTable receivetable;
    private javax.swing.JLabel receiveunitprice;
    private javax.swing.JMenu reportmenu;
    private javax.swing.JPanel reportpanel;
    private javax.swing.JLabel salebasic;
    private javax.swing.JButton salebutton;
    private javax.swing.JComboBox salecombo;
    private com.toedter.calendar.JDateChooser saledate;
    private javax.swing.JPanel salepanel;
    private javax.swing.JTextField saleprice;
    private javax.swing.JTextField salequantity;
    private javax.swing.JButton salereport;
    private javax.swing.JMenu salesmenu;
    private javax.swing.JTable salestable;
    private com.toedter.calendar.JDateChooser sp;
    private com.toedter.calendar.JDateChooser startdatechooser;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JLabel stockValue;
    private javax.swing.JLabel stocklevels;
    private javax.swing.JMenu stockmenu;
    private javax.swing.JTable stockouttable;
    private javax.swing.JPanel stockpanel;
    private javax.swing.JButton stockreport;
    private javax.swing.JTable stocktable;
    private javax.swing.JButton supplierlist;
    private javax.swing.JMenu suppliermenu;
    private javax.swing.JTabbedPane tabbedpanel;
    private javax.swing.JLabel time;
    private javax.swing.JLabel today;
    private javax.swing.JTextField toemail;
    private javax.swing.JButton updatesale;
    private javax.swing.JLabel useremaillabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
