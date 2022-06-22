import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Profile extends JFrame{
    
    private Container c;
    private JLabel lblSignUp,lblID,lblName,lblBalance,lblEmail,lblPhone,lblNewPassword;
    private JLabel lblPassword,lblCPassword,lblGender,lblReligion,lblDept,lblSession;
    private JTextField fieldID,fieldName,fieldBalance,fieldEmail,fieldPhone;
    private JTextField fieldGender,fieldReligion,fieldDept,fieldSession,fieldPassword;
    private JPasswordField fieldCPassword,fieldNewPassword;
    private JPanel panel;
    private Font f;
    private JButton btnEdit,btnSave;
    private Cursor cursor;
    private JMenuBar menuBar;
    private JMenu menuHome,menuSignOut;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    Profile(String type,int ID,String Name) throws ClassNotFoundException, SQLException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Profile");
        setResizable(false);
        setBounds(400, 100, 900, 600);
        
        f = new Font("Tahoma", Font.PLAIN, 18);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        conn = Connector.ConnectDatabase();
        
        menuBar = new JMenuBar();
        
        menuHome = new JMenu("Home");
        menuHome.setCursor(cursor);
        menuBar.add(menuHome);
        menuHome.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                try {
                    if(type.equals("Student")){
                        Student st = new Student(ID,Name);
                        st.setLocationRelativeTo(null);
                        st.setVisible(true);
                    }
                    
                    else{
                        Teacher tch = new Teacher(ID,Name);
                        tch.setLocationRelativeTo(null);
                        tch.setVisible(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
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
        panel.setBounds(10, 20, 888, 488);
        panel.setLayout(null);
     
        
        lblSignUp = new JLabel("Your Profile");
        lblSignUp.setBounds(350,20,100,20);
        lblSignUp.setFont(f);
        panel.add(lblSignUp);
        
        lblID = new JLabel("ID");
        lblID.setBounds(12,100,40,20);
        lblID.setFont(f);
        panel.add(lblID);
        
        lblName = new JLabel("Name");
        lblName.setBounds(12,150,100,20);
        lblName.setFont(f);
        panel.add(lblName);
        
        lblBalance = new JLabel("Balance");
        lblBalance.setBounds(12,200,100,20);
        lblBalance.setFont(f);
        panel.add(lblBalance);
        
        lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(12,250,100,20);
        lblEmail.setFont(f);
        panel.add(lblEmail);
        
        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(12,300,100,20);
        lblPhone.setFont(f);
        panel.add(lblPhone);
        
        lblDept = new JLabel("Department");
        lblDept.setBounds(12,350,100,20);
        lblDept.setFont(f);
        panel.add(lblDept);
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(450,100,150,20);
        lblPassword.setFont(f);
        panel.add(lblPassword);
        
        lblNewPassword = new JLabel("New Password");
        lblNewPassword.setBounds(450,150,150,20);
        lblNewPassword.setFont(f);
        panel.add(lblNewPassword);
        
        lblCPassword = new JLabel("Confirm Password");
        lblCPassword.setBounds(450,200,150,20);
        lblCPassword.setFont(f);
        panel.add(lblCPassword);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(450,250,100,20);
        lblGender.setFont(f);
        panel.add(lblGender);
        
        lblReligion = new JLabel("Religion");
        lblReligion.setBounds(450,300,100,20);
        lblReligion.setFont(f);
        panel.add(lblReligion);
        
        lblSession = new JLabel("Session");
        lblSession.setBounds(450,350,100,20);
        lblSession.setFont(f);
        panel.add(lblSession);
        
        
        fieldID = new JTextField(Integer.toString(ID));
        fieldID.setEditable(false);
        fieldID.setBounds(140,100,200,30);
        fieldID.setFont(f);
        panel.add(fieldID);
        
        fieldName = new JTextField();
        fieldName.setEditable(false);
        fieldName.setBounds(140,150,200,30);
        fieldName.setFont(f);
        panel.add(fieldName);
        
        fieldBalance = new JTextField();
        fieldBalance.setEditable(false);
        fieldBalance.setBounds(140,200,200,30);
        fieldBalance.setFont(f);
        panel.add(fieldBalance);
        
        fieldEmail = new JTextField();
        fieldEmail.setEditable(false);
        fieldEmail.setBounds(140,250,200,30);
        fieldEmail.setFont(f);
        panel.add(fieldEmail);
        
        fieldPhone = new JTextField();
        fieldPhone.setEditable(false);
        fieldPhone.setBounds(140,300,200,30);
        fieldPhone.setFont(f);
        panel.add(fieldPhone);
        
        fieldPassword =  new JTextField();
        fieldPassword.setEditable(false);
        fieldPassword.setBounds(650,100,200,30);
        fieldPassword.setFont(f);
        panel.add(fieldPassword);
        
        fieldNewPassword = new JPasswordField();
        fieldNewPassword.setEditable(false);
        fieldNewPassword.setBounds(650,150,200,30);
        fieldNewPassword.setFont(f);
        panel.add(fieldNewPassword);
        
        fieldCPassword = new JPasswordField();
        fieldCPassword.setEditable(false);
        fieldCPassword.setBounds(650,200,200,30);
        fieldCPassword.setFont(f);
        panel.add(fieldCPassword);
      
        
        fieldGender = new JTextField();
        fieldGender.setEditable(false);
        fieldGender.setBounds(650,250,200,30);
        fieldGender.setFont(f);
        panel.add(fieldGender);
        
        fieldReligion = new JTextField();
        fieldReligion.setEditable(false);
        fieldReligion.setBounds(650,300,200,30);
        fieldReligion.setFont(f);
        panel.add(fieldReligion);
        
        
        fieldDept = new JTextField();
        fieldDept.setEditable(false);
        fieldDept.setBounds(140,350,200,30);
        fieldDept.setFont(f);
        panel.add(fieldDept);
        
        fieldSession = new JTextField();
        fieldSession.setEditable(false);
        fieldSession.setBounds(650,350,200,30);
        fieldSession.setFont(f);
        panel.add(fieldSession);
        
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM "+type);
        
        while(rs.next()){
            int dataBaseID = rs.getInt("ID");
            
            if(ID==dataBaseID){
                String fName = rs.getString("First_Name");
                String lName = rs.getString("Last_Name");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String dept = rs.getString("Dept_Name");
                String session = rs.getString("Session");
                String password = rs.getString("Password");
                String gender = rs.getString("Gender");
                String religion = rs.getString("Religion");
                
                fieldName.setText(fName+" "+lName);
                fieldEmail.setText(email);
                fieldPhone.setText(phone);
                fieldDept.setText(dept);
                fieldSession.setText(session);
                fieldPassword.setText(password);
                fieldGender.setText(gender);
                fieldReligion.setText(religion);
                
                if(type.equals("Student")){
                    float blnc = rs.getFloat("Balance");
                    fieldBalance.setText(Float.toString(blnc));
                }
                
                break;
            }
        }
        
        stmt.close();
        
        
        btnEdit = new JButton("Edit");
        btnEdit.setCursor(cursor);
        btnEdit.setBounds(320,440,100,40);
        btnEdit.setFont(f);
        panel.add(btnEdit);
        
        btnEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldEmail.setEditable(true);
                fieldPhone.setEditable(true);
                fieldNewPassword.setEditable(true);
                fieldCPassword.setEditable(true);
            }
            
        });
        
        btnSave = new JButton("Save");
        btnSave.setCursor(cursor);
        btnSave.setBounds(470,440,100,40);
        btnSave.setFont(f);
        panel.add(btnSave);
        
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPass = fieldNewPassword.getText();
                String confirmPass = fieldCPassword.getText();
                
                
                if(newPass.length()>0 && newPass.equals(confirmPass)){
                    String op = "UPDATE "+ type + " SET EMAIL=?,PHONE=?,PASSWORD=? WHERE ID=?";
                    try {
                        pStmt = conn.prepareStatement(op);
                        pStmt.setString(1, fieldEmail.getText());
                        pStmt.setString(2, fieldPhone.getText());
                        pStmt.setString(3, fieldNewPassword.getText());
                        pStmt.setInt(4, ID);
                        pStmt.executeUpdate();
                        pStmt.close();
                        
                        JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);    
                        JOptionPane.showMessageDialog(dialog, "Saved" , null , JOptionPane.PLAIN_MESSAGE );
                        
                        setVisible(false);
                        Profile profile = new Profile(type,ID,Name);
                        profile.setLocationRelativeTo(null);
                        profile.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else if(newPass.length()==0){
                    String op = "UPDATE "+ type + " SET EMAIL=?,PHONE=?,PASSWORD=? WHERE ID=?";
                    try {
                        pStmt = conn.prepareStatement(op);
                        pStmt.setString(1, fieldEmail.getText());
                        pStmt.setString(2, fieldPhone.getText());
                        pStmt.setString(3, fieldPassword.getText());
                        pStmt.setInt(4, ID);
                        pStmt.executeUpdate();
                        pStmt.close();
                        
                        JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);    
                        JOptionPane.showMessageDialog(dialog, "Saved" , null , JOptionPane.PLAIN_MESSAGE );
                        
                        setVisible(false);
                        Profile profile = new Profile(type,ID,Name);
                        profile.setLocationRelativeTo(null);
                        profile.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else{
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Error" , null , JOptionPane.PLAIN_MESSAGE );
                }
            }
            
        });
        
        c.add(panel);
    }
}