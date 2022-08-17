/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Libro;
import modelo.LibroDAO;

/**
 *
 * @author Yeya
 */
public class LibroController {
    LibroDAO lb = new LibroDAO();
    CategoriaDAO ca =  new CategoriaDAO();
    public int crear(int cod, String nombre, int code, String codc){
        
        Libro l = lb.buscar(cod);
        int r = 0;
        if( l == null){
            Libro lc = new Libro();
            lc.setCod(cod);
            lc.setNombre(nombre);
            lc.setCod_e(code);
            lc.setCod_c(codc);
            lc.setEstado("disponible");
            r = lb.crear(lc);
        }
        return r;
        
    }
    
    
    public int actualizarEstado(int cod, String estado){
        Libro l = new Libro();
        l.setCod(cod);
        l.setEstado(estado);
        
        return lb.actualizarEstado(l);
    }
    public String[][] ListarLibro(){
        ArrayList<Libro> ls = lb.listar();
        String m[][] = new String[ls.size()][5];
        Categoria c = new Categoria();
        
        for(int i = 0; i < m.length; i++){
            m[i][0] = ""+ls.get(i).getCod();
            m[i][1] = ls.get(i).getNombre();
            m[i][2] = ""+ls.get(i).getCod_e();
            c = ca.buscarC(ls.get(i).getCod_c());
            m[i][3] = c.getNombre();
   
        }

        return m;
    }
    
    public String EliminarLibro(int cod){
        String result;
        int r = lb.eliminar(cod);
        if(r > 0){
            result = "Libro eliminado";
        }else{
            result = "No fue posible eliminar";
        }
        return result;
    }
    
    public ArrayList<String> BuscarLibro(int cod){
        Libro l = lb.buscar(cod);
        ArrayList<String> ls = new ArrayList();
        if(l !=null){
            ls.add(""+l.getCod());
            ls.add(l.getNombre());
            ls.add(""+l.getCod_e());
            Categoria c = ca.buscarC(l.getCod_c());
            ls.add(c.getNombre());
            ls.add(c.getCod());
        }
   
        return ls;
    }
    
    public String[][] BuscarLibro1(int cod){
        Libro l = lb.buscar(cod);
        String m[][] = new String[1][5];
        
        if(l !=null){
            m[0][0] = ""+l.getCod();
            m[0][1] = l.getNombre();
            m[0][2] = ""+l.getCod_e();
            Categoria c = ca.buscarC(l.getCod_c());
            m[0][3] = c.getNombre();
                  
        }
   
        return m;
    }
    
    public String[][] BuscarLibro11(int cod){
        Libro l = lb.buscar(cod);
        String m[][] = new String[1][5];
        
        if(l !=null){
            if(l.getEstado().equals("disponible")){
               m[0][0] = ""+l.getCod();
                m[0][1] = l.getNombre();
                m[0][2] = ""+l.getCod_e();
                Categoria c = ca.buscarC(l.getCod_c());
                m[0][3] = c.getNombre(); 
            }
            
                  
        }
   
        return m;
    }
    public String[][] BuscarLibro2(String cod){
        ArrayList<Libro> l = lb.buscar1(cod);
        String m[][] = new String[l.size()][5];
        if(!l.isEmpty()){
            
            for(int i = 0; i < m.length; i++){
                m[i][0] = ""+l.get(i).getCod();
                m[i][1] = l.get(i).getNombre();
                m[i][2] = ""+l.get(i).getCod_e();
                Categoria c = ca.buscarC(l.get(i).getCod_c());
                m[i][3] = c.getNombre();
            }
            
                  
        }
   
        return m;
    }
    public String[][] BuscarLibro22(String cod){
        ArrayList<Libro> l = lb.buscar1(cod);
        String m[][] = new String[l.size()][5];
        
        if(!l.isEmpty()){
            int j =0;
            for(int i = 0; i < l.size(); i++){
                if(l.get(i).getEstado().equals("disponible")){
                    j++;
                }
            }
            m = new String[j][5];
            int  k  = 0;
            for(int i = 0; i < l.size(); i++){
                if(l.get(i).getEstado().equals("disponible")){
                    m[k][0] = ""+l.get(i).getCod();
                    m[k][1] = l.get(i).getNombre();
                    m[k][2] = ""+l.get(i).getCod_e();
                    Categoria c = ca.buscarC(l.get(i).getCod_c());
                    m[k][3] = c.getNombre();
                    k++;
                }
                
            }
            
                  
        }
   
        return m;
    }
    public String[][] listar1(){
        ArrayList<Libro> l = lb.listar();
        String m[][] = new String[l.size()][5];
        int j = 0;
        if(!l.isEmpty()){
            
            for(int i = 0; i < l.size(); i++){
                if(l.get(i).getEstado().equals("disponible")){
                    j++;
                }
            }
            m = new String[j][5];
            int  k  = 0;
            for(int i = 0; i < l.size(); i++){
                if(l.get(i).getEstado().equals("disponible")){
                    m[k][0] = ""+l.get(i).getCod();
                    m[k][1] = l.get(i).getNombre();
                    m[k][2] = ""+l.get(i).getCod_e();
                    Categoria c = ca.buscarC(l.get(i).getCod_c());
                    m[k][3] = c.getNombre();
                    k++;
                }
                
            }
            
                  
        }
   
        return m;
    }
  
    public int ModificarLibro(int cod, String nombre, int code, String codc){
        
        Libro l = new Libro();
        l.setCod(cod);
        l.setNombre(nombre);
        l.setCod_e(code);
        l.setCod_c(codc);
 
        return lb.modificar(l);
    }
   
}
