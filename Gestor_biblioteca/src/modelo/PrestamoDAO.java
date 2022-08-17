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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yeya
 */
public class PrestamoDAO {
    Connection con;
    public PrestamoDAO() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/biblioteca",
                                        "root",
                                        "");
        this.con = conectar.getConexion();
    }
    
    public int crear(Prestamo p){
        int rest = 0;
        
        try{
            String query ="INSERT INTO prestamo(cod_libro_p, cod_usu_p, fecha_entrega_p, fecha_p) VALUES (?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, p.getCod_libro());
                ps.setInt(2, p.getCod_usuario());
                ps.setString(3, p.getFecha_entrega());
                ps.setString(4, p.getFecha_prestamo());
                
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return rest;
    }
    
    public ArrayList<Prestamo> listar(){
        ArrayList<Prestamo> p =  new ArrayList();
        try{
            String query = "SELECT * FROM prestamo";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ResultSet rest = ps.executeQuery();
                while(rest.next()){
                    Prestamo pr = new Prestamo();
                    pr.setCod(rest.getInt("Id"));
                    pr.setCod_libro(rest.getInt("cod_libro_p"));
                    pr.setCod_usuario(rest.getInt("cod_usu_p"));
                    pr.setFecha_entrega(rest.getString("fecha_entrega_p"));
                    pr.setFecha_prestamo(rest.getString("fecha_p"));
                    
                    p.add(pr);
                }
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return p;
    }
    
    public ArrayList<Prestamo> buscar1(int cod){
         ArrayList<Prestamo> ls =  new ArrayList();
         try{
            String query = "SELECT * FROM prestamo, usuario WHERE cedula= ? and  cedula = cod_usu_p";
             try (PreparedStatement ps = con.prepareStatement(query)) {
                 ps.setInt(1, cod);
                 ResultSet rest = ps.executeQuery();
                 while(rest.next()){
                     Prestamo p = new Prestamo();
                     p.setCod(rest.getInt("Id"));
                     p.setCod_libro(rest.getInt("cod_libro_p"));
                     p.setCod_usuario(rest.getInt("cod_usu_p"));
                     p.setFecha_entrega(rest.getString("fecha_entrega_p"));
                     p.setFecha_prestamo(rest.getString("fecha_p"));
                     ls.add(p);
                     
                 }}
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
      
         return ls;
    }
    public int modificar( Prestamo p){
     
         int rest = 0;
            try{
                
                String query = "UPDATE prestamo SET fecha_entrega_p = ?  WHERE id= ?";
             try (PreparedStatement ps = con.prepareStatement(query)) {
                 ps.setString(1,p.getFecha_entrega());
                 ps.setInt(2, p.getCod());
                 
                 rest = ps.executeUpdate();
             }

            }catch(SQLException e){
                System.out.println(e.toString());
            } 
            
          return rest;
    }
}
