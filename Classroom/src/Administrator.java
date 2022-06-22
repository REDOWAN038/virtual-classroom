
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Administrator extends JFrame{
    
    private Container c;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu menuHome,menuDeposit,menuSignOut;
    private Cursor cursor;
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    Administrator() throws ClassNotFoundException{
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Administrator");
        setResizable(false);
        setBounds(500, 200, 500, 500);
        
        conn = Connector.ConnectDatabase();
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(450,450));;
        panel.setLayout(null);
        
        menuBar = new JMenuBar();
        
        menuHome = new JMenu("Home");     
        menuHome.setCursor(cursor);
        menuBar.add(menuHome);
        
        menuDeposit = new JMenu("Deposit");     
        menuDeposit.setCursor(cursor);
        menuBar.add(menuDeposit);
        
//        menuDeposit.addMouseListener(new MouseListener(){
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                try {
//                    Deposit deposit = new Deposit();
//                    deposit.setLocationRelativeTo(null);
//                    deposit.setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//            
//        });
        
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
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
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
        
        c.add(panel);
        
        setVisible(true);
    }
    
}
