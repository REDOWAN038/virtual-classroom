
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Login extends JFrame{
    
    private Container c;
    private JLabel lblID,lblPassword,lblType;
    private JTextField fieldID;
    private JPasswordField fieldPassword;
    private JPanel panel;
    private Font f;
    private JComboBox comboBox;
    private JButton btnLogin,btnSignUp;
    String choice;
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    Login() throws ClassNotFoundException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setBounds(500, 100, 500, 500);
        //c.setBackground(Color.LIGHT_GRAY);
        
        panel = new JPanel();
	//panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Login", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 24), new Color(0, 153, 255)));
	panel.setBounds(10, 11, 469, 440);
	panel.setLayout(null);
        
        f = new Font("Tahoma", Font.PLAIN, 20);
        conn = Connector.ConnectDatabase();
        
        lblID = new JLabel("ID");
	lblID.setBounds(10, 130, 89, 20);
	panel.add(lblID);
        lblID.setFont(f);
        lblID.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblPassword = new JLabel("Password");
	lblPassword.setBounds(38, 187, 89, 20);
	panel.add(lblPassword);
	lblPassword.setFont(f);
	lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
	fieldID = new JTextField();
	fieldID.setBounds(148, 130, 234, 22);
	panel.add(fieldID);
        
        fieldPassword = new JPasswordField();
        fieldPassword.setBounds(148, 187, 234, 22);
	panel.add(fieldPassword);
        
        lblType = new JLabel("Type");
	lblType.setBounds(38, 244, 89, 20);
	panel.add(lblType);
        lblType.setFont(f);
        
        String[] choices = {"Teacher","Student"};
        comboBox = new JComboBox(choices);
        comboBox.setBounds(148,244,234,22);
        panel.add(comboBox);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(250, 320, 100,30);
        panel.add(btnLogin);
        
        comboBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            choice = comboBox.getSelectedItem().toString();
            }

        });
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM "+choice);
                    int userID = Integer.parseInt(fieldID.getText());
                    String userPassword = fieldPassword.getText();
                    
                    while(rs.next()){
                        int dataBaseID = rs.getInt("ID");
                        String dataBasePassword = rs.getString("Password");
                        
                        if(userID==dataBaseID && userPassword.equals(dataBasePassword)){
                            found = true;
                            if(choice.equals("Student")){
                                setVisible(false);
                                Student student = new Student(userID);
                                student.setLocationRelativeTo(null);
                                student.setVisible(true);
                            }
                            
                            else{
                                setVisible(false);
                                Teacher teacher = new Teacher(userID);
                                teacher.setLocationRelativeTo(null);
                                teacher.setVisible(true);
                            }
                        }
                    }
                    
                    if(!found){
                        JDialog dialog = new JDialog();
                        dialog.setAlwaysOnTop(true);    
                        JOptionPane.showMessageDialog(dialog, "UserID or Password is incorrect" , null , JOptionPane.PLAIN_MESSAGE );
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(100, 320, 100,30);
        panel.add(btnSignUp);
        
        btnSignUp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignUp sign = new SignUp();
                sign.setLocationRelativeTo(null);
                sign.setVisible(true);
            }
            
        });
        
        c.add(panel);
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        Login frame = new Login();
        frame.setVisible(true);
    }
}
