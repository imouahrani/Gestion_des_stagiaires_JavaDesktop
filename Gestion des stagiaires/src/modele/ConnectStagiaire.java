/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class ConnectStagiaire {
   public  Connecte c = new Connecte();
        public PreparedStatement ps;
        public ResultSet rs;

    public ConnectStagiaire() {
        
        try {
            ps =c.connectbd().prepareStatement("select * from stagiaire");
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
         
         
    
    }
    
}
