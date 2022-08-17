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

/**
 *
 * @author Yeya
 */
public class CategoriaDAO {
    Connection con;
    public CategoriaDAO() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/biblioteca",
                                        "root",
                                        "");
        this.con = conectar.getConexion();
    }
    
    public int crear(Categoria c){
        int rest = 0;
        
        try{
            String query ="INSERT INTO categoria (cod_categoria, nombre_c) VALUES (?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, c.getCod());
                ps.setString(2, c.getNombre());
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return rest;
    }
    
   public Categoria buscarC(String cod){
        Categoria c = new Categoria();
         try{
            String query = "SELECT * FROM categoria WHERE cod_categoria = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, cod);
                ResultSet rest = ps.executeQuery();
                if(rest.next()){
                    c.setCod(rest.getString("cod_categoria"));
                    c.setNombre(rest.getString("nombre_c"));
                }else{
                    c= null;
                }
            }
        }catch(SQLException e){
             System.out.println(e.toString());
        }
         return c;
    }
   public Categoria buscarN(String cod){
        Categoria c = new Categoria();
         try{
            String query = "SELECT * FROM categoria WHERE nombre_c = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, cod);
                ResultSet rest = ps.executeQuery();
                if(rest.next()){
                    c.setCod(rest.getString("cod_categoria"));
                    c.setNombre(rest.getString("nombre_c"));
                }else{
                    c= null;
                }
            }
        }catch(SQLException e){
             System.out.println(e.toString());
        }
         return c;
    }
   
   public ArrayList<Categoria> listar(){
        ArrayList<Categoria> c = new ArrayList();
        try{
            String query = "SELECT * FROM categoria";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ResultSet rest = ps.executeQuery();
                while(rest.next()){
                    Categoria ca = new Categoria();
                    ca.setCod(rest.getString("cod_categoria"));
                    ca.setNombre(rest.getString("nombre_c"));
                    c.add(ca);
                    
                }
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return c;
    }
    
}
