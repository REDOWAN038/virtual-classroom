
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


public class Login extends JFrame{
    
    private Container c;
    private JLabel lblID,lblPassword,lblType;
    private JTextField fieldID;
    private JPasswordField filedPassword;
    private JPanel panel;
    private Font f;
    private JComboBox comboBox;
    private JButton btnLogin,btnSignUp;
    
    Login(){
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setBounds(500, 100, 500, 500);
        c.setBackground(Color.WHITE);
        
        panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Login", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 24), new Color(0, 153, 255)));
	panel.setBounds(10, 11, 469, 440);
        c.add(panel);
	panel.setLayout(null);
        
        f = new Font("Tahoma", Font.PLAIN, 20);
        
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
        
        filedPassword = new JPasswordField();
        filedPassword.setBounds(148, 187, 234, 22);
	panel.add(filedPassword);
        
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
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
        
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(100, 320, 100,30);
        panel.add(btnSignUp);
        
        btnSignUp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
    }
    
    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }
}
