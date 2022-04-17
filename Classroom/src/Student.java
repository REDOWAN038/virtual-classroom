
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


public class Student extends JFrame{
    
    private Container c;
    private JPanel panel;
    private JLabel showCourse,lblTemp;
    private JMenu menu;
    private Font f;
    private ArrayList<String> courseList = new ArrayList<>();
    //private ArrayList<JButton> courseListName = new ArrayList<>();
    private String tableName;
    private JScrollPane scroll;
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    Student(int ID) throws ClassNotFoundException{
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setBounds(500, 100, 550, 550);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600,600));
        panel.setLayout(null);
        f = new Font("Tahoma", Font.PLAIN, 20);
        conn = Connector.ConnectDatabase();
        tableName = Integer.toString(ID);
        tableName = "_" + tableName;
        
        showCourse = new JLabel("Your Classes");
        showCourse.setBounds(210,45,200,30);
        showCourse.setFont(f);
        panel.add(showCourse);
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+tableName);
           
            
            while(rs.next()){
                String courseName = rs.getString("Courses");
                courseList.add(courseName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int cnt = 90;
        int idx = 0;
        
        JButton[] courseListName = new JButton[courseList.size()];
        
        for(String s : courseList){
            courseListName[idx] = new JButton(s);
            courseListName[idx].setBounds(180,cnt,200,30);
            courseListName[idx].setFont(f);
            panel.add(courseListName[idx]);
            cnt+=40;
            idx+=1;
        }
        
       scroll = new JScrollPane(panel);
       scroll.setAutoscrolls(true);
       scroll.setPreferredSize(new Dimension(500,500));
       c.add(scroll);
        
        
        setVisible(true);
    }
    
}
