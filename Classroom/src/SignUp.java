
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUp extends JFrame{
    
    private Container c;
    private JLabel lblSignUp,lblID,lblFName,lblLName,lblEmail,lblPhone,lblType,lblPassword,lblCPassword,lblGender,lblReligion;
    private JTextField fieldID,fieldFName,fieldLName,fieldEmail,fieldPhone;
    private JPasswordField fieldPassword,fieldCPassword;
    private JPanel panel;
    private Font f;
    private JComboBox comboType,comboGender,comboReligion;
    private JButton btnClear,btnConfirm;
    private String choiceType,choiceGender,choiceReligion;
    private int id;
    private String fName,lName,password,email,phone,confirmPassword;
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    SignUp() throws ClassNotFoundException, SQLException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SignUp");
        setResizable(false);
        setBounds(400, 100, 900, 500);
        
        panel = new JPanel();
        panel.setBounds(10, 11, 888, 488);
        panel.setLayout(null);
        
        f = new Font("Tahoma", Font.PLAIN, 18);
        conn = Connector.ConnectDatabase();
        
        lblSignUp = new JLabel("SignUp form");
        lblSignUp.setBounds(350,10,100,20);
        lblSignUp.setFont(f);
        panel.add(lblSignUp);
        
        lblID = new JLabel("ID");
        lblID.setBounds(12,90,40,20);
        lblID.setFont(f);
        panel.add(lblID);
        
        lblFName = new JLabel("First Name");
        lblFName.setBounds(12,140,100,20);
        lblFName.setFont(f);
        panel.add(lblFName);
        
        lblLName = new JLabel("Last Name");
        lblLName.setBounds(12,190,100,20);
        lblLName.setFont(f);
        panel.add(lblLName);
        
        lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(12,240,100,20);
        lblEmail.setFont(f);
        panel.add(lblEmail);
        
        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(12,290,100,20);
        lblPhone.setFont(f);
        panel.add(lblPhone);
        
        lblType = new JLabel("Type");
        lblType.setBounds(450,90,40,20);
        lblType.setFont(f);
        panel.add(lblType);
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(450,140,100,20);
        lblPassword.setFont(f);
        panel.add(lblPassword);
        
        lblCPassword = new JLabel("Confirm Password");
        lblCPassword.setBounds(450,190,150,20);
        lblCPassword.setFont(f);
        panel.add(lblCPassword);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(450,240,100,20);
        lblGender.setFont(f);
        panel.add(lblGender);
        
        lblReligion = new JLabel("Religion");
        lblReligion.setBounds(450,290,100,20);
        lblReligion.setFont(f);
        panel.add(lblReligion);
        
        id = ID.getID();
        
        fieldID = new JTextField(Integer.toString(id));
        fieldID.setEditable(false);
        fieldID.setBounds(140,90,200,30);
        fieldID.setFont(f);
        panel.add(fieldID);
        
        fieldFName = new JTextField();
        fieldFName.setBounds(140,140,200,30);
        fieldFName.setFont(f);
        panel.add(fieldFName);
        
        fieldLName = new JTextField();
        fieldLName.setBounds(140,190,200,30);
        fieldLName.setFont(f);
        panel.add(fieldLName);
        
        fieldEmail = new JTextField();
        fieldEmail.setBounds(140,240,200,30);
        fieldEmail.setFont(f);
        panel.add(fieldEmail);
        
        fieldPhone = new JTextField();
        fieldPhone.setBounds(140,290,200,30);
        fieldPhone.setFont(f);
        panel.add(fieldPhone);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(650,140,200,30);
        fieldPassword.setFont(f);
        panel.add(fieldPassword);
        
        fieldCPassword = new JPasswordField();
        fieldCPassword.setBounds(650,190,200,30);
        fieldCPassword.setFont(f);
        panel.add(fieldCPassword);
        
        String[] type = {"Student","Teacher"};
        comboType = new JComboBox(type);
        comboType.setBounds(650,90,100,30);
        panel.add(comboType);
        
        comboType.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            choiceType = comboType.getSelectedItem().toString();
            }

        });
        
        String[] gender = {"Male","Female","Other"};
        comboGender = new JComboBox(gender);
        comboGender.setBounds(650,240,100,30);
        panel.add(comboGender);
        
        comboGender.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            choiceGender = comboGender.getSelectedItem().toString();
            }

        });
        
        String[] religion = {"Muslim","Hindu","Christian","Buddhists","Other"};
        comboReligion = new JComboBox(religion);
        comboReligion.setBounds(650,290,100,30);
        panel.add(comboReligion);
        
        comboReligion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            choiceReligion = comboReligion.getSelectedItem().toString();
            }

        });
        
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(280,380,100,40);
        btnClear.setFont(f);
        panel.add(btnClear);
        
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldFName.setText("");
                fieldLName.setText("");
                fieldEmail.setText("");
                fieldPhone.setText("");
                fieldPassword.setText("");
                fieldCPassword.setText("");
                choiceType = "";
                choiceGender = "";
                choiceReligion = "";
                
            }
            
        });
        
        btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(490,380,100,40);
        btnConfirm.setFont(f);
        panel.add(btnConfirm);
        
        
        btnConfirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fName = fieldFName.getText();
                lName = fieldLName.getText();
                password = fieldPassword.getText();
                confirmPassword = fieldCPassword.getText();
                email = fieldEmail.getText();
                phone = fieldPhone.getText();
                
                if(!(password.equals(confirmPassword))){
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Password and Confirm Password Must be Same" , null , JOptionPane.PLAIN_MESSAGE );
                }
                
                else{
                    try {
                    
                    if(choiceType.equals("Student")){
                        stmt = conn.prepareStatement("INSERT INTO "+ choiceType +" VALUES(?,?,?,?,?,?,?,?,?)");
                        stmt.setInt(1, id);
                        stmt.setString(2, fName);
                        stmt.setString(3, lName);
                        stmt.setString(4, password);
                        stmt.setString(5, email);
                        stmt.setString(6, phone);
                        stmt.setString(7, choiceGender);
                        stmt.setString(8, choiceReligion);
                        stmt.setDouble(9, 0.0);
                        stmt.execute();
                        stmt.close();
                    }
                    
                    else{
                        stmt = conn.prepareStatement("INSERT INTO "+ choiceType +" VALUES(?,?,?,?,?,?,?,?)");
                        stmt.setInt(1, id);
                        stmt.setString(2, fName);
                        stmt.setString(3, lName);
                        stmt.setString(4, password);
                        stmt.setString(5, email);
                        stmt.setString(6, phone);
                        stmt.setString(7, choiceGender);
                        stmt.setString(8, choiceReligion);
                        stmt.execute();
                        stmt.close();
                    }
                    
                    String tableName = "_" + fieldID.getText();
                    String op = "CREATE TABLE "+tableName+" (" +
                    " Courses VARCHAR(100) NOT NULL, " + 
                    " PRIMARY KEY (`Courses`))";
                    
                    stmt = conn.prepareStatement(op);
                    stmt.execute();
                    stmt.close();
                    
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Congratulations!!! Account Created Successfully" , null , JOptionPane.PLAIN_MESSAGE );
                    
                    setVisible(false);
                    Login login = new Login();
                    login.setLocationRelativeTo(null);
                    login.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        
        
        c.add(panel);
    }
    
}
