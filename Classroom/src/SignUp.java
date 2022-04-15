
import java.awt.Container;
import javax.swing.JFrame;


public class SignUp extends JFrame{
    
    private Container c;
    
    SignUp(){
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SignUp");
        setResizable(false);
        setBounds(400, 100, 800, 500);
    }
    
}
