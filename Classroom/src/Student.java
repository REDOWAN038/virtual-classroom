
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
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


public class Student extends JFrame implements Template{
    
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
    
    Student(int ID) throws ClassNotFoundException{
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setBounds(500, 100, 700, 550);
        
        f = new Font("Tahoma", Font.PLAIN, 20);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        conn = Connector.ConnectDatabase();
        this.ID = ID;
        
        getClasses();
                
        numberofCourses = courseList.size();
        panel = new JPanel();
        int sz = 500;
        
        if((numberofCourses*50)>sz)
            sz = numberofCourses*50;
        
        panel.setPreferredSize(new Dimension(665,sz));
        panel.setLayout(null);
        
        menuBar = new JMenuBar();
        
        bodyofClassButton();
        bodyofHome();
        bodyofNew();
        bodyofPayment();
        bodyofProfile();
        bodyofSignOut();
        
        
        this.setJMenuBar(menuBar);
        
//        showCourse = new JLabel("Your Classes");
//        showCourse.setBounds(260,80,200,30);
//        showCourse.setFont(f);
//        panel.add(showCourse);
        
        
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
    public void bodyofClassButton(){
        JTextArea[] courseListName = new JTextArea[numberofCourses];
        
        Color c1 = new Color(214,113,44);
        Color c2= new Color(76,185,138);
        Color c3 = new Color(36,69,63);
        
        int x = 10;
        int y = 20;
        int cnt = 0;
        int idx = 0;
        
        for(String s : courseList){
            courseListName[idx] = new JTextArea(s);
            courseListName[idx].setEditable(false);
            if(cnt==0)
                courseListName[idx].setBackground(c1);
            else if(cnt==1)
                courseListName[idx].setBackground(c2);
            else if(cnt==2)
                courseListName[idx].setBackground(c3);
            courseListName[idx].setForeground(Color.WHITE);
            courseListName[idx].setCursor(cursor);
            courseListName[idx].setBounds(x,y,200,100);
            courseListName[idx].setFont(f);
            panel.add(courseListName[idx]);
            
            final int cc = cnt;
            
            courseListName[idx].addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    JTextArea area = (JTextArea)e.getSource();
                    area.setBackground(Color.WHITE);
                    area.setForeground(Color.BLACK);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    JTextArea area = (JTextArea)e.getSource();
                    if(cc==0)
                        area.setBackground(c1);
                    else if(cc==1)
                        area.setBackground(c2);
                    else if(cc==2)
                          area.setBackground(c3);
                    area.setForeground(Color.WHITE);
                }
                
            });
            
            cnt = (cnt+1)%3;
            
            if(cnt==1)
                x = 225;
            else if(cnt==2)
                x = 450;
            else{
                x = 10;
                y+=110;
            }
            
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
        menuNew.setCursor(cursor);
        menuBar.add(menuNew);
        menuNew.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    JoinClass joinClass = new JoinClass(ID);
                    joinClass.setLocationRelativeTo(null);
                    joinClass.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void bodyofPayment() {
        menuPayment = new JMenu("Payment");
        menuPayment.setCursor(cursor);
        menuBar.add(menuPayment);
        menuPayment.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    Payment pay = new Payment(ID);
                    pay.setLocationRelativeTo(null);
                    pay.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void bodyofProfile() {
        menuProfile = new JMenu("Profile");
        menuProfile.setCursor(cursor);
        menuBar.add(menuProfile);
        menuProfile.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                    try {
                        Profile profile = new Profile("Student",ID);
                        profile.setLocationRelativeTo(null);
                        profile.setVisible(true);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
