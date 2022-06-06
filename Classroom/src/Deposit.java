
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Deposit extends JFrame{
    private Container c;
    private JPanel panel;
    private JLabel lblID,lblAmount,lblTotal,lblCur,lblName;
    private JTextField fieldID,fieldName,fieldCur,fieldAmount,fieldTotal;
    private Font f;
    private Cursor cursor;
    private JButton btnBack,btnDeposit;
    private JMenuBar menuBar;
    private JMenu menuHome,menuSignOut;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    Deposit() throws ClassNotFoundException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Deposit");
        setResizable(false);
        setBounds(550, 300, 500, 500);
        
        conn = Connector.ConnectDatabase();
        f = new Font("Tahoma", Font.PLAIN, 18);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        menuBar = new JMenuBar();
        
        menuHome = new JMenu("Home");
        menuHome.setCursor(cursor);
        menuBar.add(menuHome);
        menuHome.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    Administrator admin = new Administrator();
                    admin.setLocationRelativeTo(null);
                    admin.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        
        menuSignOut = new JMenu("Sign Out");
        menuSignOut.setCursor(cursor);
        menuBar.add(menuSignOut);
        menuSignOut.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    LoginPage login = new LoginPage();
                    login.setLocationRelativeTo(null);
                    login.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        
        this.setJMenuBar(menuBar);
        
        panel = new JPanel();
        panel.setBounds(5,10,490,490);
        panel.setLayout(null);
        
        lblID = new JLabel("ID");
        lblID.setBounds(50,100,100,20);
        lblID.setFont(f);
        panel.add(lblID);
        
        lblName = new JLabel("Name");
        lblName.setBounds(50,150,100,20);
        lblName.setFont(f);
        panel.add(lblName);
        
        lblCur = new JLabel("Current");
        lblCur.setBounds(50,200,100,20);
        lblCur.setFont(f);
        panel.add(lblCur);
        
        lblAmount = new JLabel("Amount");
        lblAmount.setBounds(50,250,100,20);
        lblAmount.setFont(f);
        panel.add(lblAmount);
        
        lblTotal = new JLabel("Total");
        lblTotal.setBounds(50,300,100,20);
        lblTotal.setFont(f);
        panel.add(lblTotal);
        
        fieldID = new JTextField();
        fieldID.setBounds(150,100,200,20);
        fieldID.setFont(f);
        panel.add(fieldID);
        
        fieldName = new JTextField();
        System.out.println();
        fieldName.setEditable(false);
        fieldName.setBounds(150,150,200,20);
        fieldName.setFont(f);
        panel.add(fieldName);
        
        fieldCur = new JTextField();
        fieldCur.setBounds(150,200,200,20);
        fieldCur.setEditable(false);
        fieldCur.setFont(f);
        panel.add(fieldCur);
        
        fieldAmount = new JTextField();
        fieldAmount.setBounds(150,250,200,20);
        fieldAmount.setFont(f);
        panel.add(fieldAmount);
        
//        amount = Float.parseFloat(fieldAmount.getText());
//        total = balance+amount;
        
        fieldTotal = new JTextField();
        fieldTotal.setBounds(150,300,200,20);
        fieldTotal.setEditable(false);
        fieldTotal.setFont(f);
        panel.add(fieldTotal);
        
        fieldID.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    boolean found = false;
                    try {
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM Student");
                        int userID = Integer.parseInt(fieldID.getText());
                        
                        while(rs.next()){
                            int databaseID = rs.getInt("ID");
                            String name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                            float balance = rs.getFloat("Balance");
                            
                            if(userID==databaseID){
                                fieldName.setText(name);
                                fieldCur.setText(Float.toString(balance));
                                found = true;
                                break;
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!found){
                        JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);    
                        JOptionPane.showMessageDialog(dialog, "Not Found Such ID" , null , JOptionPane.PLAIN_MESSAGE );
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        
        fieldAmount.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    float amount = Float.parseFloat(fieldAmount.getText());
                    float cur = Float.parseFloat(fieldCur.getText());
                    float total = amount+cur;
                    fieldTotal.setText(Float.toString(total));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        
        
        btnBack = new JButton("Back");
        btnBack.setBounds(100,360,100,20);
        btnBack.setCursor(cursor);
        btnBack.setFont(f);
        panel.add(btnBack);
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    Administrator admin = new Administrator();
                    admin.setLocationRelativeTo(null);
                    admin.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(230,360,100,20);
        btnDeposit.setCursor(cursor);
        btnDeposit.setFont(f);
        panel.add(btnDeposit);
        
        btnDeposit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                float chkBalance = Float.parseFloat(fieldTotal.getText());
                if(chkBalance<0.0f){
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Balance Can not be Negative" , null , JOptionPane.PLAIN_MESSAGE );
                }
                
                else{
                    String op = "UPDATE STUDENT SET BALANCE=? WHERE ID=?";
                    try {
                        pStmt = conn.prepareStatement(op);
                        pStmt.setFloat(1,Float.parseFloat(fieldTotal.getText()));
                        pStmt.setInt(2,Integer.parseInt(fieldID.getText()));
                        pStmt.executeUpdate();
                        pStmt.close();

                        JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);    
                        JOptionPane.showMessageDialog(dialog, "Successfully Deposit" , null , JOptionPane.PLAIN_MESSAGE );

                        setVisible(false);
                        Deposit deposit = new Deposit();
                        deposit.setLocationRelativeTo(null);
                        deposit.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        
        
        c.add(panel);
    }
}
