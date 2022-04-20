
import java.awt.Container;
import java.awt.Cursor;
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
import javax.swing.JTextField;


public class Payment extends JFrame{
    
    private Container c;
    private JPanel panel;
    private JLabel lblID,lblName,lblSession,lblSemister,lblTheory,lblLab,lblTAmount,lblLAmount,lblTotal;
    private JLabel lblPayment,lblCur,lblDept,lblAft;
    private JTextField fieldID,fieldName,fieldDept,fieldSession,fieldTheory,fieldTAmount,fieldLab;
    private JTextField fieldLAmount,fieldTotal,fieldCur,fieldAft;
    private JComboBox comboSemister;
    private Font f;
    private Cursor cursor;
    private JButton btnBack,btnConfirm;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    Payment(int ID) throws ClassNotFoundException, SQLException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Payment");
        setResizable(false);
        setBounds(400, 100, 900, 600);
        
        panel = new JPanel();
        panel.setBounds(10, 11, 888, 488);
        panel.setLayout(null);
        
        f = new Font("Tahoma", Font.PLAIN, 18);
        conn = Connector.ConnectDatabase();
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        lblPayment = new JLabel("Payment Page");
        lblPayment.setBounds(350,10,200,20);
        lblPayment.setFont(f);
        panel.add(lblPayment);
        
        lblID = new JLabel("ID");
        lblID.setBounds(12,90,40,20);
        lblID.setFont(f);
        panel.add(lblID);
        
        lblName = new JLabel("Name");
        lblName.setBounds(12,140,100,20);
        lblName.setFont(f);
        panel.add(lblName);
        
        lblDept = new JLabel("Department");
        lblDept.setBounds(12,190,100,20);
        lblDept.setFont(f);
        panel.add(lblDept);
        
        lblSession = new JLabel("Session");
        lblSession.setBounds(12,240,100,20);
        lblSession.setFont(f);
        panel.add(lblSession);
        
        lblSemister = new JLabel("Semister");
        lblSemister.setBounds(12,290,100,20);
        lblSemister.setFont(f);
        panel.add(lblSemister);
        
        lblTheory = new JLabel("Theory Credit");
        lblTheory.setBounds(12,340,150,20);
        lblTheory.setFont(f);
        panel.add(lblTheory);
        
        lblTAmount = new JLabel("Theory Amount");
        lblTAmount.setBounds(450,90,150,20);
        lblTAmount.setFont(f);
        panel.add(lblTAmount);
        
        lblLab = new JLabel("Lab Credit");
        lblLab.setBounds(450,140,100,20);
        lblLab.setFont(f);
        panel.add(lblLab);
        
        lblLAmount = new JLabel("Lab Amount");
        lblLAmount.setBounds(450,190,100,20);
        lblLAmount.setFont(f);
        panel.add(lblLAmount);
        
        lblTotal = new JLabel("Total Amount");
        lblTotal.setBounds(450,240,150,20);
        lblTotal.setFont(f);
        panel.add(lblTotal);
        
        lblCur = new JLabel("Current Balance");
        lblCur.setBounds(450,290,180,20);
        lblCur.setFont(f);
        panel.add(lblCur);
        
        lblAft = new JLabel("After Payment");
        lblAft.setBounds(450,340,180,20);
        lblAft.setFont(f);
        panel.add(lblAft);
        
        
        fieldID = new JTextField(Integer.toString(ID));
        fieldID.setEditable(false);
        fieldID.setBounds(140,90,200,30);
        fieldID.setFont(f);
        panel.add(fieldID);
        
        fieldName = new JTextField();
        fieldName.setEditable(false);
        fieldName.setBounds(140,140,200,30);
        fieldName.setFont(f);
        panel.add(fieldName);
        
        fieldDept = new JTextField();
        fieldDept.setEditable(false);
        fieldDept.setBounds(140,190,200,30);
        fieldDept.setFont(f);
        panel.add(fieldDept);

        fieldSession = new JTextField();
        fieldSession.setEditable(false);
        fieldSession.setBounds(140,240,200,30);
        fieldSession.setFont(f);
        panel.add(fieldSession);
        
        String[] sem = {"1/1","1/2","2/1","2/2"};
        comboSemister = new JComboBox(sem);
        comboSemister.setBounds(140,290,200,30);
        panel.add(comboSemister);
        
        fieldTheory = new JTextField();
        fieldTheory.setEditable(false);
        fieldTheory.setBounds(140,340,200,30);
        fieldTheory.setFont(f);
        panel.add(fieldTheory);
        
        fieldTAmount = new JTextField(ID);
        fieldTAmount.setEditable(false);
        fieldTAmount.setBounds(610,90,200,30);
        fieldTAmount.setFont(f);
        panel.add(fieldTAmount);
        
        fieldLab = new JTextField();
        fieldLab.setEditable(false);
        fieldLab.setBounds(610,140,200,30);
        fieldLab.setFont(f);
        panel.add(fieldLab);
        
        fieldLAmount = new JTextField();
        fieldLAmount.setEditable(false);
        fieldLAmount.setBounds(610,190,200,30);
        fieldLAmount.setFont(f);
        panel.add(fieldLAmount);

        fieldTotal = new JTextField();
        fieldTotal.setEditable(false);
        fieldTotal.setBounds(610,240,200,30);
        fieldTotal.setFont(f);
        panel.add(fieldTotal);
        
        fieldCur = new JTextField();
        fieldCur.setEditable(false);
        fieldCur.setBounds(610,290,200,30);
        fieldCur.setFont(f);
        panel.add(fieldCur);
        
        fieldAft = new JTextField();
        fieldAft.setEditable(false);
        fieldAft.setBounds(610,340,200,30);
        fieldAft.setFont(f);
        panel.add(fieldAft);
        
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM STUDENT");
        
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
            String session = rs.getString("Session");
            String dept = rs.getString("Dept_Name");
            float blnc = rs.getFloat("Balance");
            
            if(id==ID){
                fieldName.setText(name);
                fieldSession.setText(session);
                fieldDept.setText(dept);
                fieldCur.setText(Float.toString(blnc));
                break;
            }
        }
        
        comboSemister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String choiceSemister = comboSemister.getSelectedItem().toString();
                getCredit(choiceSemister);
            }
            
        });
        
        btnBack = new JButton("Back");
        btnBack.setBounds(250,430,100,30);
        btnBack.setCursor(cursor);
        btnBack.setFont(f);
        panel.add(btnBack);
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    Student student = new Student(ID);
                    student.setLocationRelativeTo(null);
                    student.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(500,430,100,30);
        btnConfirm.setCursor(cursor);
        btnConfirm.setFont(f);
        panel.add(btnConfirm);
        
        
        btnConfirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String choiceSemister = comboSemister.getSelectedItem().toString();
                String newSemister = "_" + Character.toString(choiceSemister.charAt(0)) + "_" + Character.toString(choiceSemister.charAt(2));
                
                String op = "UPDATE PAYMENT SET "+newSemister+"=? WHERE ID=?";
                try {
                    pStmt = conn.prepareStatement(op);
                    pStmt.setString(1,"paid");
                    pStmt.setInt(2,ID);
                    pStmt.executeUpdate();
                    pStmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                op = "UPDATE STUDENT SET BALANCE=? WHERE ID=?";
                try {
                    pStmt = conn.prepareStatement(op);
                    pStmt.setFloat(1,Float.parseFloat(fieldAft.getText()));
                    pStmt.setInt(2,ID);
                    pStmt.executeUpdate();
                    pStmt.close();
                    
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Successfully Payment Complete" , null , JOptionPane.PLAIN_MESSAGE );
                   
                } catch (SQLException ex) {
                    Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
        });
        
        c.add(panel);
    }
    
    void getCredit(String Sem){
        if(Sem.equals("1/1")){
            
            fieldTheory.setText("12");
            fieldTAmount.setText("1248");
            fieldLab.setText("8");
            fieldLAmount.setText("1200");
            fieldTotal.setText("2448");
            float blnc = Float.parseFloat(fieldCur.getText());
            blnc-=2448;
            fieldAft.setText(Float.toString(blnc));
            
        }
        
        else if(Sem.equals("1/2")){
            fieldTheory.setText("12");
            fieldTAmount.setText("1248");
            fieldLab.setText("8");
            fieldLAmount.setText("1200");
            fieldTotal.setText("2448");
            float blnc = Float.parseFloat(fieldCur.getText());
            blnc-=2448;
            fieldAft.setText(Float.toString(blnc));
        }
        
        else if(Sem.equals("2/1")){
            fieldTheory.setText("12");
            fieldTAmount.setText("1248");
            fieldLab.setText("8");
            fieldLAmount.setText("1200");
            fieldTotal.setText("2448");
            float blnc = Float.parseFloat(fieldCur.getText());
            blnc-=2448;
            fieldAft.setText(Float.toString(blnc));
        }
        
        else if(Sem.equals("2/2")){
            fieldTheory.setText("12");
            fieldTAmount.setText("1248");
            fieldLab.setText("8");
            fieldLAmount.setText("1200");
            fieldTotal.setText("2448");
            float blnc = Float.parseFloat(fieldCur.getText());
            blnc-=2448;
            fieldAft.setText(Float.toString(blnc));
        }
        
        return;
    }
    
}
