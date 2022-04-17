
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ID {
    
    public static int getID() throws ClassNotFoundException, SQLException{
        
        Connection conn = Connector.ConnectDatabase();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
        int maxID = 1000;
        
        while(rs.next()){
            int id = rs.getInt("ID");
            
            if(id>=maxID){
                maxID = id;
            }
        }
        
        rs = stmt.executeQuery("SELECT * FROM Teacher");
        
        while(rs.next()){
            int id = rs.getInt("ID");
            
            if(id>=maxID){
                maxID = id;
            }
        }
        
        return (maxID+1);
        
    }
    
}
