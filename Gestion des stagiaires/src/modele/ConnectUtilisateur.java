
package modele;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectUtilisateur {
    
    Connecte co = new Connecte();
    PreparedStatement ps;
    public ResultSet rs;
    

    public ConnectUtilisateur() {
        
        String req = " select * from utilisateurs";
        try {
            ps = co.connectbd().prepareStatement(req);
            rs = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
