
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * @author red2724
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile(String type,int ID,String Name) throws ClassNotFoundException, SQLException{
        this.type = type;
        this.ID = ID;
        this.Name = Name;
        
        initComponents();
        conn = Connector.ConnectDatabase();
        setElements();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblDept = new javax.swing.JLabel();
        fieldID = new javax.swing.JTextField();
        fieldName = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldPhone = new javax.swing.JTextField();
        fieldDept = new javax.swing.JTextField();
        lblSession = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblReligion = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        lblCPassword = new javax.swing.JLabel();
        fieldSession = new javax.swing.JTextField();
        fieldGender = new javax.swing.JTextField();
        fieldReligion = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        fieldNewPassword = new javax.swing.JPasswordField();
        fieldCPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profileandsignup.png"))); // NOI18N
        lblImage.setPreferredSize(new java.awt.Dimension(945, 610));
        jPanel2.add(lblImage);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setPreferredSize(new java.awt.Dimension(945, 610));
        getContentPane().setLayout(null);

        lblProfile.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblProfile.setText("Your Profile");
        getContentPane().add(lblProfile);
        lblProfile.setBounds(410, 30, 102, 23);

        lblID.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblID.setText("ID");
        getContentPane().add(lblID);
        lblID.setBounds(52, 115, 18, 23);

        lblName.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblName.setText("Name");
        getContentPane().add(lblName);
        lblName.setBounds(52, 181, 49, 23);

        lblEmail.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblEmail.setText("Email");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(52, 253, 48, 23);

        lblPhone.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblPhone.setText("Phone");
        getContentPane().add(lblPhone);
        lblPhone.setBounds(52, 343, 55, 23);

        lblDept.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblDept.setText("Department");
        getContentPane().add(lblDept);
        lblDept.setBounds(52, 431, 100, 23);

        fieldID.setEditable(false);
        fieldID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldID);
        fieldID.setBounds(197, 116, 193, 30);

        fieldName.setEditable(false);
        fieldName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldName);
        fieldName.setBounds(197, 181, 193, 30);

        fieldEmail.setEditable(false);
        fieldEmail.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldEmail);
        fieldEmail.setBounds(197, 254, 193, 30);

        fieldPhone.setEditable(false);
        fieldPhone.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldPhone);
        fieldPhone.setBounds(197, 344, 193, 30);

        fieldDept.setEditable(false);
        fieldDept.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldDept);
        fieldDept.setBounds(197, 432, 193, 30);

        lblSession.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblSession.setText("Session");
        getContentPane().add(lblSession);
        lblSession.setBounds(533, 115, 160, 23);

        lblGender.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblGender.setText("Gender");
        getContentPane().add(lblGender);
        lblGender.setBounds(533, 181, 160, 23);

        lblReligion.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblReligion.setText("Religion");
        getContentPane().add(lblReligion);
        lblReligion.setBounds(533, 253, 72, 23);

        lblNewPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblNewPassword.setText("New Password");
        getContentPane().add(lblNewPassword);
        lblNewPassword.setBounds(533, 343, 129, 23);

        lblCPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblCPassword.setText("Confirm Password");
        getContentPane().add(lblCPassword);
        lblCPassword.setBounds(533, 431, 160, 23);

        fieldSession.setEditable(false);
        fieldSession.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldSession);
        fieldSession.setBounds(728, 116, 192, 30);

        fieldGender.setEditable(false);
        fieldGender.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldGender);
        fieldGender.setBounds(728, 181, 192, 30);

        fieldReligion.setEditable(false);
        fieldReligion.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldReligion);
        fieldReligion.setBounds(728, 254, 192, 30);

        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(258, 518, 93, 38);

        btnEdit.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(457, 518, 87, 38);

        btnSave.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(651, 518, 87, 38);

        fieldNewPassword.setEditable(false);
        fieldNewPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldNewPassword);
        fieldNewPassword.setBounds(728, 344, 192, 30);

        fieldCPassword.setEditable(false);
        fieldCPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        getContentPane().add(fieldCPassword);
        fieldCPassword.setBounds(728, 432, 192, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profileandsignup.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(948, 615));
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 960, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
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
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
                fieldEmail.setEditable(true);
                fieldPhone.setEditable(true);
                fieldNewPassword.setEditable(true);
                fieldCPassword.setEditable(true);
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
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
                
                
                
                else{
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);    
                    JOptionPane.showMessageDialog(dialog, "Error" , null , JOptionPane.PLAIN_MESSAGE );
                }
    }//GEN-LAST:event_btnSaveMouseClicked

    void setElements() throws SQLException{
        fieldID.setText(Integer.toString(ID));
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
                String gender = rs.getString("Gender");
                String religion = rs.getString("Religion");
                
                fieldName.setText(fName+" "+lName);
                fieldEmail.setText(email);
                fieldPhone.setText(phone);
                fieldDept.setText(dept);
                fieldSession.setText(session);
                fieldGender.setText(gender);
                fieldReligion.setText(religion);
                
                
                
                break;
            }
        }
        
        stmt.close();
        rs.close();
    }
    
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Profile("a",0,"a").setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JPasswordField fieldCPassword;
    private javax.swing.JTextField fieldDept;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldGender;
    private javax.swing.JTextField fieldID;
    private javax.swing.JTextField fieldName;
    private javax.swing.JPasswordField fieldNewPassword;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JTextField fieldReligion;
    private javax.swing.JTextField fieldSession;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCPassword;
    private javax.swing.JLabel lblDept;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblReligion;
    private javax.swing.JLabel lblSession;
    // End of variables declaration//GEN-END:variables
    
    private int ID;
    private String type,Name;
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;
    ResultSet rs = null;

}
