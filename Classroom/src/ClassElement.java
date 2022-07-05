
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Redowan
 */
public class ClassElement extends javax.swing.JFrame {

    /**
     * Creates new form ClassName
     */
    public ClassElement(String classCode,String className,String session, String section) {
        this.classCode = classCode;
        this.className = className;
        this.session = session;
        this.section = section;
        
        initComponents();
        setLabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfo = new javax.swing.JLabel();
        btnKG1 = new com.k33ptoo.components.KButton();
        btnAttendance = new com.k33ptoo.components.KButton();
        btnResult = new com.k33ptoo.components.KButton();
        btnKG4 = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 200));
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("CSE 233(OOP),2019-20,both");
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 61, 323, -1));

        btnKG1.setText("STREAM");
        btnKG1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(btnKG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 119, -1, 118));

        btnAttendance.setText("ATTENDENCE");
        btnAttendance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseClicked(evt);
            }
        });
        getContentPane().add(btnAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 119, -1, 118));

        btnResult.setText("RESULT");
        btnResult.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResultMouseClicked(evt);
            }
        });
        getContentPane().add(btnResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 119, -1, 118));

        btnKG4.setText("CHAT");
        btnKG4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(btnKG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 297, -1, 118));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        
        try {
            Attendance atndnc = new Attendance(classCode,className,session,section);
            atndnc.setLocationRelativeTo(null);
            atndnc.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAttendanceMouseClicked

    private void btnResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResultMouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        
        try {
            Result result = new Result(classCode,className,session,section);
            result.setLocationRelativeTo(null);
            result.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResultMouseClicked
    
    void setLabel(){
        String lbl = className + "," + session + "," + section;
        lblInfo.setText(lbl);
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
            java.util.logging.Logger.getLogger(ClassElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassElement("a","a","a","a").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAttendance;
    private com.k33ptoo.components.KButton btnKG1;
    private com.k33ptoo.components.KButton btnKG4;
    private com.k33ptoo.components.KButton btnResult;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
    
    private String classCode,className,session,section;

}
///Applications/NetBeans/Apache NetBeans 13.app/Contents/Resources/NetBeans/netbeans/java/modules/ext/AbsoluteLayout.jar
//jar:nbinst://org.netbeans.modules.form/modules/ext/AbsoluteLayout.jar!/