
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Redowan
 */
public class ResultSt extends JFrame{
    private Container c;
    private String courseCode,choice,Name;
    private JTable table;
    private JScrollPane scroll;
    private JPanel panel1,panel2;
    private JTextField fieldNew,fieldUpdate;
    private JButton btnNew,btnRefresh,btnBack,btnSave,btnUpdate;
    private Font f,f1;
    private Cursor cursor;
    private int ID;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    ResultSt(int ID,String Name,String courseCode,String className,String session,String section) throws ClassNotFoundException, SQLException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100,50,1000,500);
        
        this.ID = ID;
        this.Name = Name;
        this.courseCode = courseCode;
        conn = Connector.ConnectDatabase();
        f = new Font("Tahoma",Font.BOLD,14);
        f1 = new Font("Tahoma",Font.PLAIN,14);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        panel1 = new JPanel();
        panel1.setBounds(2,2,990,350);
        panel1.setLayout(null);
        Vector<Vector<String> > data = new Vector<>();
        Vector<String> coloumn = new Vector<>();
        
        choice = courseCode + "_result_coloumns";
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM "+choice);
        
        while(rs.next()){
            coloumn.add(rs.getString("Coloumns"));
        }
        
        stmt.close();
        
        choice = courseCode + "_result";
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM "+choice);
        
        while(rs.next()){
            Vector<String> temp = new Vector<>();
            
            for(String s : coloumn){
                temp.add(rs.getString(s));
            }
            
            data.add(temp);
        }
        
        stmt.close();
        
 
        
        DefaultTableModel model = new DefaultTableModel(data,coloumn){
            @Override
            public void setValueAt(Object aValue, int row, int column) {
                if(column!=0 && column!=1)
                    super.setValueAt(aValue, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        };
        
        table = new JTable(model){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                
                Color color1 = new Color(255, 255, 165);
                Color color2 = new Color(255, 255, 205);
                
                if(row%2==0)
                    comp.setBackground(color2);
                else
                    comp.setBackground(color1);
                
                return comp;
            }
            
            
            
        };
        
        table.setEnabled(false);
        table.setSelectionForeground(Color.red);
        table.setSelectionBackground(Color.BLACK);
        
        
        scroll = new JScrollPane(table);
        scroll.setBounds(5,5,1000,1000);
        
        panel1.add(scroll);
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(2,360,1000,100);
        panel2.setBackground(Color.LIGHT_GRAY);
       
        
        
        btnBack = new JButton("Back");
        btnBack.setFont(f);
        btnBack.setCursor(cursor);
        btnBack.setBounds(370,30,90,30);
        panel2.add(btnBack);
        
        btnBack.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                
                ClassElement ce = new ClassElement("Student",ID,Name,courseCode,className,session,section);
                ce.setLocationRelativeTo(null);
                ce.setVisible(true);
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
        
        
        btnRefresh = new JButton("Refresh");
        btnRefresh.setFont(f);
        btnRefresh.setCursor(cursor);
        btnRefresh.setBounds(490,30,90,30);
        panel2.add(btnRefresh);
        
        btnRefresh.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                
                try {
                    ResultSt rst = new ResultSt(ID,Name,courseCode,className,session,section);
                    rst.setLocationRelativeTo(null);
                    rst.setVisible(true);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
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
        
        c.add(panel1);
        c.add(panel2);
        
        validate();
    }
}
