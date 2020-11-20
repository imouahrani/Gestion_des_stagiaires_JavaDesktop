package modele;

import javax.swing.JOptionPane;
import java.sql.*;

public class Connecte {

    Connection c;

    public Connecte() {

        /*1. Connexion au serveur de BDD */
        try {

            Class.forName("com.mysql.jdbc.Driver");
            //JOptionPane.showMessageDialog(null, "Connexion au serveur MySQL réussie !");

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Echec de connexion au serveur MySQL" + e.getMessage());
        }
        /*2. Connexion à la BDD */

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstagiaire", "root", "");
            //JOptionPane.showMessageDialog(null, "Connexion réussie!");
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, "Echec de connexion au serveur MySQL" + e.getMessage());*/

        }

    }
/*methode de connexion a la BDD */
    
    public Connection connectbd(){
    
    
    return c;}
    
    
    
}
