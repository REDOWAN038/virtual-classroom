
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Code {
    
    public static String getCode() throws ClassNotFoundException, SQLException{
        
        Connection conn = Connector.ConnectDatabase();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Course");
        int cnt = 0;
        
        while(rs.next()){
            cnt+=1;
        }
        
        cnt = 1000+cnt;
        
        String temp1 = "abcdefgh";
        String temp2 = "pqrstxyz";
        
        String first = Character.toString(temp1.charAt((cnt%temp1.length())));
        String last = Character.toString(temp2.charAt((cnt%temp2.length())));
        String middle = Integer.toString(cnt);
        
        String code = first + middle + last;
        
        return code;
    }
    
}
