/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author Yeya
 */
public class UsuarioController {
    private final UsuarioDAO usuDAO = new UsuarioDAO(); 
    
    public int CrearUsuario(int cedula, String nombre, String fecha, String sexo, int tipo){
        
        Usuario as = usuDAO.buscar(cedula);
        int r = 0;
        if( as == null){
            Usuario us = new Usuario();
            us.setCedula(cedula);
            us.setNombre(nombre);
            us.setFecha(fecha);
            us.setSexo(sexo);
            us.setTipo(tipo);
            r = usuDAO.addUsuario(us);
        }
        return r;
        
    }
    
    public String[][] ListarUsuario(){
        ArrayList<Usuario> usuarios = usuDAO.listUsuario();
        String m[][] = new String[usuarios.size()][5];
        
        for(int i = 0; i < m.length; i++){
            m[i][0] = ""+usuarios.get(i).getCedula();
            m[i][1] = usuarios.get(i).getNombre();
            m[i][2] = usuarios.get(i).getFecha();
            m[i][3] = usuarios.get(i).getSexo();
            if(usuarios.get(i).getTipo() == 0){
                m[i][4] = "Estudiante";
            }else{
                m[i][4] = "Docente";
            }
            
        }
        
        
        return m;
    }
    public String[][] ListarUsuario1(int c){
        ArrayList<Usuario> usuarios = usuDAO.listUsuario1(c);
        String m[][] = new String[usuarios.size()][5];
        
        for(int i = 0; i < m.length; i++){
            m[i][0] = ""+usuarios.get(i).getCedula();
            m[i][1] = usuarios.get(i).getNombre();
            m[i][2] = usuarios.get(i).getFecha();
            m[i][3] = usuarios.get(i).getSexo();
            if(usuarios.get(i).getTipo() == 0){
                m[i][4] = "Estudiante";
            }else{
                m[i][4] = "Docente";
            }
            
        }
        
        
        return m;
    }
    
    public String EliminarUsuario(int ced){
        String result;
        int r = usuDAO.eliminar(ced);
        if(r > 0){
            result = "Usuario eliminado";
        }else{
            result = "No fue posible eliminar";
        }
        return result;
    }
    
    public ArrayList<String> BuscarUsuario(int ced){
        Usuario usu = usuDAO.buscar(ced);
        ArrayList<String> usuario = new ArrayList();
        if(usu !=null){
            usuario.add(""+usu.getCedula());
            usuario.add(usu.getNombre());
            usuario.add(usu.getFecha());
            usuario.add(usu.getSexo());
            usuario.add(""+usu.getTipo());
        }
   
        return usuario;
    }
    
    public String[][] BuscarUsuario1(int ced){
        Usuario usu = usuDAO.buscar(ced);
        String m[][] = new String[1][5];
        
        if(usu !=null){
            m[0][0] = ""+usu.getCedula();
            m[0][1] = usu.getNombre();
            m[0][2] = usu.getFecha();
            m[0][3] = usu.getSexo();
            
            if(usu.getTipo() == 0){
                m[0][4] = "Estudiante";
            }else{
                m[0][4] = "Docente";
            }
            
        }
   
        return m;
    }
  
    public int ModificarUsuario(int cedula, String nombre, String fecha, String Sexo, int tipo){
        
        Usuario us = new Usuario();
      
            us.setCedula(cedula);
            us.setNombre(nombre);
            us.setFecha(fecha);
            us.setSexo(Sexo);
            us.setTipo(tipo);
 
        return usuDAO.modificar(us);
    }
    
}
