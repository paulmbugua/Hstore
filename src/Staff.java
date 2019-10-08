
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
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Staff extends javax.swing.JFrame {
 public String u="root";
    public String p="";
      public String conn="jdbc:mysql://127.0.0.1:3306/hstore";
      String id;
    public Staff() {
        initComponents();
    }
    public void update(){
     try{Connection co=null;
      co=DriverManager.getConnection(conn,u,p);
        Statement stmt=(Statement)co.createStatement();        
           
            String sql5="select * from received where receivedby='"+id+"'";
            ResultSet rs5 =stmt.executeQuery(sql5); 
            receivetable.setModel(DbUtils.resultSetToTableModel(rs5));
            System.out.println("1");
            String sql6="select * from stock ";
            ResultSet rs6 =stmt.executeQuery(sql6); 
            stocktable2.setModel(DbUtils.resultSetToTableModel(rs6));
             System.out.println("2");
            String sql8="select * from sales where servedby='"+id+"'";
            ResultSet rs8 =stmt.executeQuery(sql8); 
            salestable.setModel(DbUtils.resultSetToTableModel(rs8));
             System.out.println("3");
            String sql9="select itemname,quantity from stock where quantity < 10 ";
            ResultSet rs9=stmt.executeQuery(sql9);
            stockouttable.setModel(DbUtils.resultSetToTableModel(rs9));
             System.out.println("3");
             String sql11="select itemname quantity from stock where quantity < 10 ";
            ResultSet rs11 =stmt.executeQuery(sql11);
            int count=0;
            while(rs11.next()){
                count++;
                notificationmenu.setText(count+"   NOTIFICATION");
            }
           
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
                    String sql7="select itemname from stock";
                    ResultSet rs7=stmt.executeQuery(sql7);
                    while(rs7.next())
                    {
                   salecombo.addItem(rs7.getString(1));
                    }
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
public Staff (String x){
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        profilepanel = new javax.swing.JPanel();
        imagelabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        useremaillabel = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tabbedpanel2 = new javax.swing.JTabbedPane();
        stockpanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        stocktable2 = new javax.swing.JTable();
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
        jLabel7 = new javax.swing.JLabel();
        salebasic = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        reportpanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        itemlist2 = new javax.swing.JButton();
        currentprice = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        stockreport = new javax.swing.JButton();
        notificationpanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        stockouttable = new javax.swing.JTable();
        emailpamel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        emailtextarea = new javax.swing.JTextArea();
        emailbutton = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        toemail = new javax.swing.JTextField();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        filemenu = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        closemenuitem = new javax.swing.JMenuItem();
        salesmenu = new javax.swing.JMenu();
        deliverymenu = new javax.swing.JMenu();
        stockmenu = new javax.swing.JMenu();
        reportmenu = new javax.swing.JMenu();
        notificationmenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

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
                    .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useremaillabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        profilepanelLayout.setVerticalGroup(
            profilepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useremaillabel, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE))
        );

        statuslabel.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N

        jLabel3.setText("START TIME:");

        jLabel4.setText("TODAY DATE:");
        jLabel4.setToolTipText("");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator.png"))); // NOI18N
        jLabel25.setToolTipText("");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notepad.png"))); // NOI18N
        jLabel6.setText("jLabel5");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        tabbedpanel2.setBackground(new java.awt.Color(255, 255, 255));
        tabbedpanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        tabbedpanel2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedpanel2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedpanel2.setToolTipText("");

        stockpanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stocktable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(stocktable2);

        javax.swing.GroupLayout stockpanel2Layout = new javax.swing.GroupLayout(stockpanel2);
        stockpanel2.setLayout(stockpanel2Layout);
        stockpanel2Layout.setHorizontalGroup(
            stockpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        stockpanel2Layout.setVerticalGroup(
            stockpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedpanel2.addTab("STOCK ", stockpanel2);

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

        jLabel7.setText("SALE PRICE:");

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
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel7))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(receipt)
                .addGap(35, 35, 35))
            .addGroup(salepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedpanel2.addTab("SALES", null, salepanel, "");

        reportpanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemlist2.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        itemlist2.setText("LIST OF ITEMS REPORT");
        itemlist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemlist2ActionPerformed(evt);
            }
        });

        currentprice.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        currentprice.setText("ItemsCurrent  Pircing");
        currentprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentpriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemlist2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentprice, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addGap(828, 828, 828))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(itemlist2)
                .addGap(18, 18, 18)
                .addComponent(currentprice)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Item Report", null, jPanel11, "");

        stockreport.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        stockreport.setText("AVAILABLE Stock Report");
        stockreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockreportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(stockreport, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(826, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(stockreport)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Stock Report", null, jPanel12, "");

        javax.swing.GroupLayout reportpanel2Layout = new javax.swing.GroupLayout(reportpanel2);
        reportpanel2.setLayout(reportpanel2Layout);
        reportpanel2Layout.setHorizontalGroup(
            reportpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        reportpanel2Layout.setVerticalGroup(
            reportpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportpanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        tabbedpanel2.addTab("REPORT", null, reportpanel2, "");

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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedpanel2.addTab("NOTIFICATIONS", null, notificationpanel, "");

        emailpamel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        emailtextarea.setColumns(20);
        emailtextarea.setRows(5);
        jScrollPane8.setViewportView(emailtextarea);

        emailbutton.setFont(new java.awt.Font("Trajan Pro", 1, 11)); // NOI18N
        emailbutton.setText("SEND");
        emailbutton.setToolTipText("");
        emailbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailbuttonActionPerformed(evt);
            }
        });

        jLabel29.setText("RECEPIENT:");

        javax.swing.GroupLayout emailpamelLayout = new javax.swing.GroupLayout(emailpamel);
        emailpamel.setLayout(emailpamelLayout);
        emailpamelLayout.setHorizontalGroup(
            emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailpamelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailbutton)
                    .addGroup(emailpamelLayout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toemail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(604, Short.MAX_VALUE))
        );
        emailpamelLayout.setVerticalGroup(
            emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailpamelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(emailpamelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(toemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailbutton)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        tabbedpanel2.addTab("EMAIL", emailpamel);

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
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(receivepanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabbedpanel2.addTab("RECEIVE ORDER", null, receivepanel, "");

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

        salesmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sales_32.png"))); // NOI18N
        salesmenu.setText("SALES");
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
        notificationmenu.setText("Notification");
        notificationmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationmenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(notificationmenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel25)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(profilepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedpanel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(today, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addGap(18, 18, 18)
                .addComponent(tabbedpanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void salesmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesmenuMouseClicked
        tabbedpanel2.setSelectedComponent(salepanel);
    }//GEN-LAST:event_salesmenuMouseClicked

    private void deliverymenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliverymenuMouseClicked
        tabbedpanel2.setSelectedComponent(receivepanel);
    }//GEN-LAST:event_deliverymenuMouseClicked

    private void stockmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockmenuMouseClicked
        tabbedpanel2.setSelectedComponent(stockpanel2);
    }//GEN-LAST:event_stockmenuMouseClicked

    private void reportmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportmenuMouseClicked
        tabbedpanel2.setSelectedComponent(reportpanel2);
    }//GEN-LAST:event_reportmenuMouseClicked

    private void notificationmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationmenuMouseClicked
        tabbedpanel2.setSelectedComponent(notificationpanel);
    }//GEN-LAST:event_notificationmenuMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        Runtime rs=Runtime.getRuntime();
        try {
            rs.exec("calc");
        } catch (IOException ex) {
            Logger.getLogger(Administrative.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Runtime rs=Runtime.getRuntime();
        try {
            rs.exec("notepad");
        } catch (IOException ex) {
            Logger.getLogger(Administrative.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

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

    private void itemlist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemlist2ActionPerformed

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
    }//GEN-LAST:event_itemlist2ActionPerformed

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancledelivery;
    private javax.swing.JButton canclesalebutton;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton clearsale;
    private javax.swing.JMenuItem closemenuitem;
    private javax.swing.JButton currentprice;
    private javax.swing.JTextField customername;
    private javax.swing.JMenu deliverymenu;
    private javax.swing.JButton emailbutton;
    private javax.swing.JPanel emailpamel;
    private javax.swing.JTextArea emailtextarea;
    private javax.swing.JMenu filemenu;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JButton itemlist2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu notificationmenu;
    private javax.swing.JPanel notificationpanel;
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
    private javax.swing.JPanel reportpanel2;
    private javax.swing.JLabel salebasic;
    private javax.swing.JButton salebutton;
    private javax.swing.JComboBox salecombo;
    private com.toedter.calendar.JDateChooser saledate;
    private javax.swing.JPanel salepanel;
    private javax.swing.JTextField saleprice;
    private javax.swing.JTextField salequantity;
    private javax.swing.JMenu salesmenu;
    private javax.swing.JTable salestable;
    private javax.swing.JLabel statuslabel;
    private javax.swing.JLabel stocklevels;
    private javax.swing.JMenu stockmenu;
    private javax.swing.JTable stockouttable;
    private javax.swing.JPanel stockpanel2;
    private javax.swing.JButton stockreport;
    private javax.swing.JTable stocktable2;
    private javax.swing.JTabbedPane tabbedpanel2;
    private javax.swing.JLabel time;
    private javax.swing.JLabel today;
    private javax.swing.JTextField toemail;
    private javax.swing.JButton updatesale;
    private javax.swing.JLabel useremaillabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
