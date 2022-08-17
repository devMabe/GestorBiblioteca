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
public class UsuarioDAO {
    Connection con;
    public UsuarioDAO() {
        Conectar conectar = new Conectar("jdbc:mysql://localhost/biblioteca",
                                        "root",
                                        "");
        this.con = conectar.getConexion();
    }
    
    public int addUsuario(Usuario us){
        int rest = 0;
        
        try{
            String query ="INSERT INTO usuario (cedula, nombre, fecha_nac, sexo, tipo) VALUES (?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, us.getCedula());
                ps.setString(2, us.getNombre());
                ps.setString(3, us.getFecha());
                ps.setString(4, us.getSexo());
                ps.setInt(5, us.getTipo());
                rest = ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return rest;
    }
    
     public Usuario buscar(int cedula){
        Usuario usu = new Usuario();
         try{
            String query = "SELECT * FROM usuario WHERE cedula = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, cedula);
                ResultSet rest = ps.executeQuery();
                if(rest.next()){
                    usu.setNombre(rest.getString("nombre"));
                    usu.setCedula(rest.getInt("cedula"));
                    usu.setFecha(rest.getString("fecha_nac"));
                    usu.setSexo(rest.getString("sexo"));
                    usu.setTipo(rest.getInt("tipo"));
                }else{
                    usu = null;
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
         return usu;
    }
     
    public int eliminar(int cedula){
        int rest = 0;
            try{    
                String query = "DELETE FROM usuario WHERE cedula = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, cedula);
                rest = ps.executeUpdate();
            }
    
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.toString());
            } 
          return rest;
    }

    public int modificar( Usuario usu){
     
         int rest = 0;
            try{
                
                String query = "UPDATE usuario SET nombre = ?, fecha_nac = ?, sexo = ? , tipo = ?  WHERE cedula = ?";
             try (PreparedStatement ps = con.prepareStatement(query)) {
                 ps.setString(1,usu.getNombre());
                 ps.setString(2, usu.getFecha());
                 ps.setString(3, usu.getSexo());
                 ps.setInt(4, usu.getTipo());
                 ps.setInt(5, usu.getCedula());
                 rest = ps.executeUpdate();
             }

            }catch(SQLException e){
                System.out.println(e.toString());
            } 
            System.out.println("rest: "+rest);
          return rest;
    }
     
    public ArrayList<Usuario> listUsuario(){
        ArrayList<Usuario> usuarios = new ArrayList();
        try{
            String query = "SELECT * FROM usuario";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ResultSet rest = ps.executeQuery();
                while(rest.next()){
                    Usuario usu = new Usuario();
                    usu.setCedula(rest.getInt("cedula"));
                    usu.setNombre(rest.getString("nombre"));
                    usu.setFecha(rest.getString("fecha_nac"));
                    usu.setSexo(rest.getString("sexo"));
                    usu.setTipo(rest.getInt("tipo"));
                    usuarios.add(usu);
                    
                }
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return usuarios;
    }
    
    public ArrayList<Usuario> listUsuario1(int c){
        ArrayList<Usuario> usuarios = new ArrayList();
        try{
            String query = "SELECT * FROM usuario WHERE tipo = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, c);
                ResultSet rest = ps.executeQuery();
                while(rest.next()){
                    Usuario usu = new Usuario();
                    usu.setCedula(rest.getInt("cedula"));
                    usu.setNombre(rest.getString("nombre"));
                    usu.setFecha(rest.getString("fecha_nac"));
                    usu.setSexo(rest.getString("sexo"));
                    usu.setTipo(rest.getInt("tipo"));
                    usuarios.add(usu);
                    
                }
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
        return usuarios;
    }
    
    
}
