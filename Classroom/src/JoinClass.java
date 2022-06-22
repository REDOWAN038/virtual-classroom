
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JoinClass extends JFrame{
    private Container c;
    private JPanel panel;
    private JLabel lblCode;
    private JTextField fieldCode;
    private JButton btnBack,btnConfirm;
    private Font f;
    private Cursor cursor;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    JoinClass(int ID,String Name) throws ClassNotFoundException, SQLException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Create New Class");
        setResizable(false);
        setBounds(430, 100, 550, 400);
                
        conn = Connector.ConnectDatabase();
        f = new Font("Tahoma", Font.PLAIN, 18);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        panel = new JPanel();
        panel.setBounds(5,10,540,390);
        panel.setLayout(null);
        
        lblCode = new JLabel("Class Code");
        lblCode.setBounds(80,70,100,50);
        lblCode.setFont(f);
        panel.add(lblCode);
       
        
        fieldCode = new JTextField();
        fieldCode.setBounds(190,80,200,30);
        fieldCode.setFont(f);
        panel.add(fieldCode);
       
        
        btnBack = new JButton("Back");
        btnBack.setBounds(180,200,100,20);
        btnBack.setFont(f);
        btnBack.setCursor(cursor);
        panel.add(btnBack);
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    Student student = new Student(ID,Name);
                    student.setLocationRelativeTo(null);
                    student.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JoinClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(320,200,100,20);
        btnConfirm.setFont(f);
        btnConfirm.setCursor(cursor);
        panel.add(btnConfirm);
        
        btnConfirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = "_" + Integer.toString(ID);
                
                String courseName = "";
                String sessionName = "";
                String sectionName = "";
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM COURSE");
                    
                    while(rs.next()){
                        String code = rs.getString("ClassCode");
                        
                        if(code.equals(fieldCode.getText())){
                            courseName = rs.getString("ClassName");
                            sessionName = rs.getString("Session");
                            sectionName = rs.getString("Section");
                            break;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JoinClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    pStmt = conn.prepareStatement("INSERT INTO "+ tableName +" VALUES(?,?,?,?)");
                    pStmt.setString(1,fieldCode.getText());
                    pStmt.setString(2,courseName);
                    pStmt.setString(3,sessionName);
                    pStmt.setString(4,sectionName);
                    pStmt.execute();
                    pStmt.close();
                    
                    tableName = fieldCode.getText() + "_attendance_coloumns";
                    String op = "SELECT * FROM "+tableName;;
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(op);
                    int rowNumbers = 0;
                    
                    while(rs.next()){
                        rowNumbers++;
                    }
                    
                    rs.close();
                    stmt.close();
                    
                    tableName = fieldCode.getText() + "_attendance";
                    op = "INSERT INTO "+ tableName + " VALUES";
                    String op1 = "(";
                    int r = rowNumbers;
                    
                    while(r>1){
                        op1 = op1+"?,";
                        r-=1;
                    }
                    
                    op1 = op1+"?)";
                    
                    op = op+op1;
                    
                    pStmt = conn.prepareStatement(op);
                    pStmt.setInt(1,ID);
                    pStmt.setString(2,Name);
                    
                    for(int i=3;i<=rowNumbers;i++){
                        pStmt.setString(i,"-");
                    }
                    pStmt.executeUpdate();
                    pStmt.close();
                    
                    
                    tableName = fieldCode.getText() + "_result_coloumns";
                    op = "SELECT * FROM "+tableName;;
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(op);
                    rowNumbers = 0;
                    
                    while(rs.next()){
                        rowNumbers++;
                    }
                    
                    rs.close();
                    stmt.close();
                    
                    tableName = fieldCode.getText() + "_result";
                    op = "INSERT INTO "+ tableName + " VALUES";
                    op1 = "(";
                    r = rowNumbers;
                    
                    while(r>1){
                        op1 = op1+"?,";
                        r-=1;
                    }
                    
                    op1 = op1+"?)";
                    
                    op = op+op1;
                    
                    pStmt = conn.prepareStatement(op);
                    pStmt.setInt(1,ID);
                    pStmt.setString(2,Name);
                    
                    for(int i=3;i<=rowNumbers;i++){
                        pStmt.setString(i,"-");
                    }
                    pStmt.executeUpdate();
                    pStmt.close();
                    
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);    
                JOptionPane.showMessageDialog(dialog, "Congratulations!!! Joined New Class" , null , JOptionPane.PLAIN_MESSAGE );
                
                setVisible(false);
                try {
                    Student student = new Student(ID,Name);
                    student.setLocationRelativeTo(null);
                    student.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JoinClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        c.add(panel);
        setVisible(true);
    }
}
