/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import help.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Yeya
 */
public class LibroDAO {
    Connection con;
    public LibroDAO() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/biblioteca",
                                        "root",
                                        "");
        this.con = conectar.getConexion();
    }
    
    public int crear(Libro l){
        int rest = 0;
        
        try{
            String query ="INSERT INTO libro (cod_libro, nombre_l, cod_ejemplar_l, cod_categoria_l, estado) VALUES (?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, l.getCod());
                ps.setString(2, l.getNombre());
                ps.setInt(3, l.getCod_e());
                ps.setString(4, l.getCod_c());
                ps.setString(5, l.getEstado());
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return rest;
    }
    
     public Libro buscar(int cod){
        Libro l = new Libro();
         try{
            String query = "SELECT * FROM libro WHERE cod_libro = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, cod);
                ResultSet rest = ps.executeQuery();
                if(rest.next()){
                    
                    l.setCod(rest.getInt("cod_libro"));
                    l.setNombre(rest.getString("nombre_l"));
                    l.setCod_e(rest.getInt("cod_ejemplar_l"));
                    l.setCod_c(rest.getString("cod_categoria_l"));
                    l.setEstado(rest.getString("estado"));
                    
                }else{
                    l = null;
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
         return l;
    }
    public ArrayList<Libro> buscar1(String cod){
         ArrayList<Libro> ls =  new ArrayList();
         try{
            String query = "SELECT cod_libro, nombre_l, cod_ejemplar_l, cod_categoria_l, estado  FROM libro, categoria WHERE cod_categoria_l = ? and  cod_categoria = cod_categoria_l";
             try (PreparedStatement ps = con.prepareStatement(query)) {
                 ps.setString(1, cod);
                 ResultSet rest = ps.executeQuery();
                 while(rest.next()){
                     Libro l = new Libro();
                     l.setCod(rest.getInt("cod_libro"));
                     l.setNombre(rest.getString("nombre_l"));
                     l.setCod_e(rest.getInt("cod_ejemplar_l"));
                     l.setCod_c(rest.getString("cod_categoria_l"));
                     l.setEstado(rest.getString("estado"));
                     ls.add(l);
                     
                 }}
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
         System.out.println(ls.get(0).getNombre());
         return ls;
    }
     
    public int eliminar(int cod){
        int rest = 0;
            try{    
                String query = "DELETE FROM libro WHERE cod_libro = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, cod);
                rest = ps.executeUpdate();
            }
    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.toString());
            } 
          return rest;
    }
    public int actualizarEstado( Libro l){
     
         int rest = 0;
            try{
                
                String query = "UPDATE libro SET estado = ? WHERE cod_libro = ?";
             try (PreparedStatement ps = con.prepareStatement(query)) {
                 ps.setString(1,l.getEstado());
                 ps.setInt(2, l.getCod());
                 rest = ps.executeUpdate();
             }

            }catch(SQLException e){
                System.out.println(e.toString());
            } 
            
          return rest;
    }
    public int modificar( Libro l){
     
         int rest = 0;
            try{
                
                String query = "UPDATE libro SET nombre_l = ?, cod_ejemplar_l = ?, cod_categoria_l = ?  WHERE cod_libro = ?";
             try (PreparedStatement ps = con.prepareStatement(query)) {
                 ps.setString(1,l.getNombre());
                 ps.setInt(2, l.getCod_e());
                 ps.setString(3, l.getCod_c());
                 ps.setInt(4, l.getCod());
                 rest = ps.executeUpdate();
             }

            }catch(SQLException e){
                System.out.println(e.toString());
            } 
            
          return rest;
    }
     
    public ArrayList<Libro> listar(){
        ArrayList<Libro> l =  new ArrayList();
        try{
            String query = "SELECT * FROM libro";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ResultSet rest = ps.executeQuery();
                while(rest.next()){
                    Libro lb = new Libro();
                    lb.setCod(rest.getInt("cod_libro"));
                    lb.setNombre(rest.getString("nombre_l"));
                    lb.setCod_e(rest.getInt("cod_ejemplar_l"));
                    lb.setCod_c(rest.getString("Cod_categoria_l"));
                    lb.setEstado(rest.getString("estado"));
                    l.add(lb);
                }
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return l;
    }
    
}
