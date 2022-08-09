
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
    public ClassElement(){
        
    }
    
    public ClassElement(String type,int ID,String Name,String classCode,String className,String session, String section) {
        this.type = type;
        this.ID = ID;
        this.Name = Name;
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblInfo = new javax.swing.JLabel();
        btnStream = new com.k33ptoo.components.KButton();
        btnAttendance = new com.k33ptoo.components.KButton();
        btnResult = new com.k33ptoo.components.KButton();
        btnChat = new com.k33ptoo.components.KButton();
        btnWhiteboard = new com.k33ptoo.components.KButton();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 200));
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 153, 153));
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("CSE 233(OOP),2019-20,both");
        getContentPane().add(lblInfo);
        lblInfo.setBounds(260, 30, 323, 22);

        btnStream.setText("STREAM");
        btnStream.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnStream.setkBackGroundColor(new java.awt.Color(255, 255, 102));
        btnStream.setkEndColor(new java.awt.Color(255, 255, 102));
        btnStream.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnStream.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnStream.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnStream.setkStartColor(new java.awt.Color(255, 51, 204));
        btnStream.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStreamMouseClicked(evt);
            }
        });
        getContentPane().add(btnStream);
        btnStream.setBounds(38, 119, 185, 118);

        btnAttendance.setText("ATTENDENCE");
        btnAttendance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAttendance.setkEndColor(new java.awt.Color(255, 153, 153));
        btnAttendance.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnAttendance.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnAttendance.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnAttendance.setkStartColor(new java.awt.Color(255, 51, 51));
        btnAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAttendanceMouseClicked(evt);
            }
        });
        getContentPane().add(btnAttendance);
        btnAttendance.setBounds(308, 119, 185, 118);

        btnResult.setText("RESULT");
        btnResult.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResult.setkEndColor(new java.awt.Color(255, 51, 255));
        btnResult.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnResult.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnResult.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnResult.setkStartColor(new java.awt.Color(0, 0, 204));
        btnResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResultMouseClicked(evt);
            }
        });
        getContentPane().add(btnResult);
        btnResult.setBounds(572, 119, 185, 118);

        btnChat.setText("CHAT");
        btnChat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChat.setkEndColor(new java.awt.Color(255, 0, 255));
        btnChat.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnChat.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnChat.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnChat.setkStartColor(new java.awt.Color(255, 255, 0));
        btnChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChatMouseClicked(evt);
            }
        });
        getContentPane().add(btnChat);
        btnChat.setBounds(38, 297, 185, 118);

        btnWhiteboard.setText("WhiteBoard");
        btnWhiteboard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnWhiteboard.setkBackGroundColor(new java.awt.Color(51, 0, 204));
        btnWhiteboard.setkEndColor(new java.awt.Color(51, 51, 255));
        btnWhiteboard.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnWhiteboard.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnWhiteboard.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnWhiteboard.setkStartColor(new java.awt.Color(51, 255, 204));
        btnWhiteboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWhiteboardMouseClicked(evt);
            }
        });
        getContentPane().add(btnWhiteboard);
        btnWhiteboard.setBounds(308, 297, 185, 118);

        btnBack.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(40, 30, 72, 23);

        jPanel1.setLayout(null);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/greenboard.png"))); // NOI18N
        jPanel1.add(lblImage);
        lblImage.setBounds(0, 0, 800, 500);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 810, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttendanceMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        
        if(type.equals("Teacher")){
            try {
            Attendance atndnc = new Attendance(ID,Name,classCode,className,session,section);
            atndnc.setLocationRelativeTo(null);
            atndnc.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(type.equals("Student")){
            try {
            AttendanceSt ast = new AttendanceSt(ID,Name,classCode,className,session,section);
            ast.setLocationRelativeTo(null);
            ast.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAttendanceMouseClicked

    private void btnResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResultMouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        
        if(type.equals("Teacher")){
            try {
            Result result = new Result(ID,Name,classCode,className,session,section);
            result.setLocationRelativeTo(null);
            result.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(type.equals("Student")){
            try {
            ResultSt rst = new ResultSt(ID,Name,classCode,className,session,section);
            rst.setLocationRelativeTo(null);
            rst.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnResultMouseClicked

    private void btnChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChatMouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        
        
        try {
            Chat chat = new Chat(type,ID,Name,classCode,className,session,section);
            chat.setLocationRelativeTo(null);
            chat.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnChatMouseClicked

    private void btnWhiteboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWhiteboardMouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        WhiteBoard board = new WhiteBoard(type,ID,Name,classCode,className,session,section);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
    }//GEN-LAST:event_btnWhiteboardMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        
        if(type.equals("Student")){
            try {
                Student st = new Student(ID,Name);
                st.setLocationRelativeTo(null);
                st.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else{
            try {
                Teacher tc = new Teacher(ID,Name);
                tc.setLocationRelativeTo(null);
                tc.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClassElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnStreamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStreamMouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        
        if(type.equals("Teacher")){
            TeacherStream ts = new TeacherStream(type,ID,Name,classCode,className,session,section);
            ts.setLocationRelativeTo(null);
            ts.setVisible(true);
        }
    }//GEN-LAST:event_btnStreamMouseClicked
    
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
                new ClassElement("a",0,"a","a","a","a","a").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAttendance;
    private javax.swing.JButton btnBack;
    private com.k33ptoo.components.KButton btnChat;
    private com.k33ptoo.components.KButton btnResult;
    private com.k33ptoo.components.KButton btnStream;
    private com.k33ptoo.components.KButton btnWhiteboard;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
    
    private String classCode,className,session,section,type;
    private String Name;
    private int ID;

}
///Applications/NetBeans/Apache NetBeans 13.app/Contents/Resources/NetBeans/netbeans/java/modules/ext/AbsoluteLayout.jar
//jar:nbinst://org.netbeans.modules.form/modules/ext/AbsoluteLayout.jar!/