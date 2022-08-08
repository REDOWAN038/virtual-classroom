
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
public class Attendance extends JFrame{
    private Container c;
    private String courseCode,choice,Name;
    private JTable table;
    private JScrollPane scroll;
    private JPanel panel1,panel2;
    private JTextField fieldNew,fieldUpdate;
    private JButton btnNew,btnEdit,btnBack,btnSave,btnUpdate;
    private Font f,f1;
    private Cursor cursor;
    private int ID;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;
    
    Attendance(int ID,String Name,String courseCode,String className,String session,String section) throws ClassNotFoundException, SQLException{
        c = this.getContentPane();
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100,50,1000,600);
        
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
        
        choice = courseCode + "_attendance_coloumns";
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM "+choice);
        
        while(rs.next()){
            coloumn.add(rs.getString("Coloumns"));
        }
        
        stmt.close();
        
        choice = courseCode + "_attendance";
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
        rs.close();
        
 
        
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
        panel2.setBounds(2,360,1000,190);
        panel2.setBackground(Color.LIGHT_GRAY);
        
        fieldNew = new JTextField("Enter Coloumn Name You Want to Create");
        fieldNew.setFont(f1);
        fieldNew.setBounds(150,15,350,30);
        panel2.add(fieldNew);
        
        fieldUpdate = new JTextField("Enter Coloumn Name You Want to Update");
        fieldUpdate.setFont(f1);
        fieldUpdate.setBounds(150,60,350,30);
        panel2.add(fieldUpdate);
        
        
        btnNew = new JButton("New");
        btnNew.setFont(f);
        btnNew.setCursor(cursor);
        btnNew.setBounds(520,15,90,30);
        panel2.add(btnNew);
        
        btnNew.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String coloumnName = fieldNew.getText();
                String tableName = courseCode + "_attendance";
                
                String op = "ALTER TABLE " + tableName + " ADD " + coloumnName + " VARCHAR(10)";
                
                try {
                    pStmt = conn.prepareStatement(op);
                    pStmt.execute();
                    pStmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    tableName = courseCode + "_attendance_coloumns";
                    pStmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)");
                    pStmt.setInt(1,coloumn.size()+1);
                    pStmt.setString(2,coloumnName);
                    pStmt.execute();
                    pStmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                setVisible(false);
                
                try {
                    Attendance atndnc = new Attendance(ID,Name,courseCode,className,session,section);
                    atndnc.setLocationRelativeTo(null);
                    atndnc.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
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
        
        btnUpdate = new JButton("Update");
        btnUpdate.setFont(f);
        btnUpdate.setCursor(cursor);
        btnUpdate.setBounds(520,60,90,30);
        panel2.add(btnUpdate);
        
        btnUpdate.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String coloumnName = fieldUpdate.getText();
                
                if(coloumnName=="ID" || coloumnName=="Name"){
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "You Can't Edit ID or Name" , null , JOptionPane.PLAIN_MESSAGE );
                }
                
                else{
                    for(int idx=0;idx<table.getRowCount();idx++){
                        int cIdx = getColumnByName(table,coloumnName);
                        String val = (String) table.getValueAt(idx,cIdx );
                        int id = Integer.parseInt((String) table.getValueAt(idx, 0));
                        String tableName = courseCode+"_attendance";
                        
                        String op = "UPDATE " + tableName + " SET " + coloumnName + " = ? WHERE ID = ?";
                        try {
                            pStmt = conn.prepareStatement(op);
                            pStmt.setString(1, val);
                            pStmt.setInt(2, id);
                            pStmt.executeUpdate();
                            pStmt.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try {
                            pStmt = conn.prepareStatement(op);
                            pStmt.execute();
                            pStmt.close();
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                   
                    
                    setVisible(false);
                    
                    try {
                        Attendance atndnc = new Attendance(ID,Name,courseCode,className,session,section);
                        atndnc.setLocationRelativeTo(null);
                        atndnc.setVisible(true);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                    }
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

            private int getColumnByName(JTable table, String coloumnName) {
                for (int i = 0; i < table.getColumnCount(); ++i){
                    if (table.getColumnName(i).equals(coloumnName)){
                        return i;
                    }
                }
                
                return -1;
            }
            
        });
        
        
        btnBack = new JButton("Back");
        btnBack.setFont(f);
        btnBack.setCursor(cursor);
        btnBack.setBounds(380,120,80,30);
        panel2.add(btnBack);
        
        btnBack.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                
                ClassElement ce = new ClassElement("Teacher",ID,Name,courseCode,className,session,section);
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
        
        btnEdit = new JButton("Edit");
        btnEdit.setFont(f);
        btnEdit.setCursor(cursor);
        btnEdit.setBounds(480,120,80,30);
        panel2.add(btnEdit);
        
        btnEdit.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                table.setEnabled(true);
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
