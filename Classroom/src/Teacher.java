
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


public class Teacher extends JFrame implements Template{
    
    private Container c;
    private JPanel panel;
    private JLabel showCourse,lblTemp;
    private JMenu menu;
    private Font f;
    private ArrayList<String> courseList = new ArrayList<>();
    private ArrayList<String> courseListCode = new ArrayList<>();
    private int ID,numberofCourses;
    private String tableName;
    private JScrollPane scroll;
    private JMenuBar menuBar;
    private JMenu menuHome,menuNew,menuPayment,menuProfile,menuSignOut;
    private Cursor cursor;
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    Teacher(int ID) throws ClassNotFoundException{
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setBounds(500, 100, 635, 550);
        
        f = new Font("Tahoma", Font.PLAIN, 20);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        conn = Connector.ConnectDatabase();
        this.ID = ID;
        
        getClasses();
                
        numberofCourses = courseList.size();
        panel = new JPanel();
        int sz = 500;
        
        if((numberofCourses*50)>600)
            sz = numberofCourses*50;
        
        panel.setPreferredSize(new Dimension(600,sz));
        panel.setLayout(null);
        
        menuBar = new JMenuBar();
        
        bodyofClassButton();
        bodyofHome();
        bodyofNew();
        bodyofPayment();
        bodyofProfile();
        bodyofSignOut();
        
        
        this.setJMenuBar(menuBar);
        
        showCourse = new JLabel("Your Classes");
        showCourse.setBounds(260,80,200,30);
        showCourse.setFont(f);
        panel.add(showCourse);
        
        
        scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(500,500));
       
       
        c.add(scroll);
        
        setVisible(true);
    }
    
    void getClasses(){
        tableName = Integer.toString(this.ID);
        tableName = "_" + tableName;
        
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+tableName);
           
            
            while(rs.next()){
                String courseCode = rs.getString("Course_Code");
                String courseName = rs.getString("Course_Name");
                courseListCode.add(courseCode);
                courseList.add(courseName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void bodyofClassButton() {
        int cnt = 120;
        int idx = 0;
        
        JButton[] courseListName = new JButton[numberofCourses];
        
        for(String s : courseList){
            courseListName[idx] = new JButton(s);
            courseListName[idx].setBounds(230,cnt,200,30);
            courseListName[idx].setFont(f);
            panel.add(courseListName[idx]);
            
            courseListName[idx].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                
            });
            
            cnt+=40;
            idx+=1;
        }
    }

    @Override
    public void bodyofHome() {
        menuHome = new JMenu("Home");
        menuBar.add(menuHome);
        menuHome.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                
            });
    }

    @Override
    public void bodyofNew() {
        menuNew = new JMenu("New");
        menuBar.add(menuNew);
        menuNew.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                
            });
    }

    @Override
    public void bodyofPayment() {
        menuPayment = new JMenu("Payment");
        menuBar.add(menuPayment);
        menuPayment.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                
            });
    }

    @Override
    public void bodyofProfile() {
        menuProfile = new JMenu("Profile");
        menuBar.add(menuProfile);
        menuProfile.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                }
                
        });
    }
    
    @Override
    public void bodyofSignOut() {
        menuSignOut = new JMenu("Sign Out");
        menuSignOut.setCursor(cursor);
        menuBar.add(menuSignOut);
        menuSignOut.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    Login login = new Login();
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
    }
}