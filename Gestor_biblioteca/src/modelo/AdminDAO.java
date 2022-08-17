/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import help.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yeya
 */
public class AdminDAO {
    Connection con;
    public AdminDAO() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/biblioteca",
                                        "root",
                                        "");
        this.con = conectar.getConexion();
    }
    
    public Admin login(String nombre, String password){
        Admin ad = new Admin();
        try{
            String query = "SELECT * FROM administracion WHERE nombre = ? and password = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, nombre);
                ps.setString(2, password);
                ResultSet rest = ps.executeQuery();
                if(rest.next()){
                    ad.setNombre(rest.getString("nombre"));
                    ad.setPassword(rest.getString("password"));
                    
                }else{
                    ad= null;
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        return ad;
    }
    
    
}
