
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


public class CreateClass extends JFrame{
    private Container c;
    private JPanel panel;
    private JLabel lblCode,lblName;
    private JTextField fieldCode,fieldName;
    private JButton btnBack,btnConfirm;
    private Font f;
    private Cursor cursor;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    
    CreateClass(int ID) throws ClassNotFoundException, SQLException{
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
        
        String code = Code.getCode();
        
        lblCode = new JLabel("Class Code");
        lblCode.setBounds(80,70,100,50);
        lblCode.setFont(f);
        panel.add(lblCode);
        
        lblName = new JLabel("Class Name");
        lblName.setBounds(80,130,100,50);
        lblName.setFont(f);
        panel.add(lblName);
        
        fieldCode = new JTextField(code);
        fieldCode.setBounds(190,80,200,30);
        fieldCode.setFont(f);
        fieldCode.setEditable(false);
        panel.add(fieldCode);
        
        fieldName = new JTextField("");
        fieldName.setBounds(190,140,200,30);
        fieldName.setFont(f);
        panel.add(fieldName);
        
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
                    Teacher teacher = new Teacher(ID);
                    teacher.setLocationRelativeTo(null);
                    teacher.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
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
                try {
                    pStmt = conn.prepareStatement("INSERT INTO "+ tableName +" VALUES(?,?)");
                    pStmt.setString(1,fieldCode.getText());
                    pStmt.setString(2,fieldName.getText());
                    pStmt.execute();
                    pStmt.close();
                    
                    pStmt = conn.prepareStatement("INSERT INTO COURSE VALUES(?,?)");
                    pStmt.setString(1,fieldCode.getText());
                    pStmt.setString(2,fieldName.getText());
                    pStmt.execute();
                    pStmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);    
                JOptionPane.showMessageDialog(dialog, "Congratulations!!! New Class Created" , null , JOptionPane.PLAIN_MESSAGE );
                
                setVisible(false);
                try {
                    Teacher teacher = new Teacher(ID);
                    teacher.setLocationRelativeTo(null);
                    teacher.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        c.add(panel);
        setVisible(true);
    }
}
