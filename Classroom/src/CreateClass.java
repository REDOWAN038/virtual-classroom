
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Redowan
 */
public class CreateClass extends javax.swing.JFrame {

    /**
     * Creates new form CreateClass
     */
    public CreateClass(int ID,String Name) throws ClassNotFoundException, SQLException{
        this.ID = ID;
        this.Name = Name;
        conn = Connector.ConnectDatabase();
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSession = new javax.swing.JLabel();
        lblSection = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        fieldName = new javax.swing.JTextField();
        fieldSession = new javax.swing.JTextField();
        fieldSection = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnConfim = new javax.swing.JButton();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCode.setText("Class Code");
        getContentPane().add(lblCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 120, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblName.setText("Class Name");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        lblSession.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSession.setText("Session");
        getContentPane().add(lblSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        lblSection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSection.setText("Section");
        getContentPane().add(lblSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        fieldCode.setEditable(false);
        fieldCode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(fieldCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 230, -1));

        fieldName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(fieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 230, -1));

        fieldSession.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(fieldSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 230, -1));

        fieldSection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(fieldSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 230, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.setActionCommand("JButton");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 110, 30));

        btnConfim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConfim.setText("Confirm");
        btnConfim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfimMouseClicked(evt);
            }
        });
        getContentPane().add(btnConfim, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 110, 30));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 102, 255));
        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void init() throws ClassNotFoundException, SQLException{
        String code = Code.getCode();
        fieldCode.setText(code);
    }
    
    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        
        try {
            Teacher teacher = new Teacher(ID,Name);
            teacher.setLocationRelativeTo(null);
            teacher.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnConfimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfimMouseClicked
        // TODO add your handling code here:
        
        String tableName = "_" + Integer.toString(ID);
        
        try {
            pStmt = conn.prepareStatement("INSERT INTO "+ tableName +" VALUES(?,?,?,?)");
            pStmt.setString(1,fieldCode.getText());
            pStmt.setString(2,fieldName.getText());
            pStmt.setString(3,fieldSession.getText());
            pStmt.setString(4,fieldSection.getText());
            pStmt.execute();
            pStmt.close();
            
            pStmt = conn.prepareStatement("INSERT INTO COURSE VALUES(?,?,?,?)");
            pStmt.setString(1,fieldCode.getText());
            pStmt.setString(2,fieldName.getText());
            pStmt.setString(3,fieldSession.getText());
            pStmt.setString(4,fieldSection.getText());
            pStmt.execute();
            pStmt.close();
            
            tableName = fieldCode.getText() + "_" + "Attendance";
        
            String op = "CREATE TABLE " + tableName + " ("
                            + " ID INTEGER NOT NULL, "
                            + " Name VARCHAR(100) NOT NULL, "
                            + " PRIMARY KEY (`ID`))";

            pStmt = conn.prepareStatement(op);
            pStmt.execute();
            pStmt.close();
            
            tableName = fieldCode.getText() + "_" + "Result";
        
            op = "CREATE TABLE " + tableName + " ("
                            + " ID INTEGER NOT NULL, "
                            + " Name VARCHAR(100) NOT NULL, "
                            + " PRIMARY KEY (`ID`))";

            pStmt = conn.prepareStatement(op);
            pStmt.execute();
            pStmt.close();
            
            tableName = fieldCode.getText() + "_" + "Attendance" + "_" + "Coloumns";
        
            op = "CREATE TABLE " + tableName + " ("
                            + " SI INTEGER NOT NULL, "
                            + " COLOUMNS VARCHAR(100) NOT NULL, "
                            + " PRIMARY KEY (`SI`))";

            pStmt = conn.prepareStatement(op);
            pStmt.execute();
            pStmt.close();
            
            pStmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)");
            pStmt.setInt(1, 1);
            pStmt.setString(2, "ID");
            pStmt.execute();
            pStmt.close();
            
            pStmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)");
            pStmt.setInt(1, 2);
            pStmt.setString(2, "Name");
            pStmt.execute();
            pStmt.close();
            
            tableName = fieldCode.getText() + "_" + "Result" + "_" + "Coloumns";
        
            op = "CREATE TABLE " + tableName + " ("
                            + " SI INTEGER NOT NULL, "
                            + " COLOUMNS VARCHAR(100) NOT NULL, "
                            + " PRIMARY KEY (`SI`))";

            pStmt = conn.prepareStatement(op);
            pStmt.execute();
            pStmt.close();
            
            pStmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)");
            pStmt.setInt(1, 1);
            pStmt.setString(2, "ID");
            pStmt.execute();
            pStmt.close();
            
            pStmt = conn.prepareStatement("INSERT INTO " + tableName + " VALUES(?,?)");
            pStmt.setInt(1, 2);
            pStmt.setString(2, "Name");
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
            Teacher teacher = new Teacher(ID,Name);
            teacher.setLocationRelativeTo(null);
            teacher.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfimMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CreateClass(0,"a").setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfim;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldSection;
    private javax.swing.JTextField fieldSession;
    private javax.swing.JLabel jLabel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSection;
    private javax.swing.JLabel lblSession;
    // End of variables declaration//GEN-END:variables
    
    private int ID;
    private String Name;
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
}
