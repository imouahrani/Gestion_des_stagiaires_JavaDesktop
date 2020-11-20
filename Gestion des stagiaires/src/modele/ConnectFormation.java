
package modele;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectFormation {
    Connecte c = new Connecte();
    PreparedStatement ps;
    public ResultSet rs;

    public ConnectFormation() {
        try {
            ps = c.connectbd().prepareStatement(" select * from formatio");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
