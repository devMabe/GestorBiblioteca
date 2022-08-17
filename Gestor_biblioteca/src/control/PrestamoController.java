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
import modelo.Prestamo;
import modelo.PrestamoDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author Yeya
 */
public class PrestamoController {
        LibroDAO lb = new LibroDAO();
        UsuarioDAO us = new UsuarioDAO();
        PrestamoDAO pr = new PrestamoDAO();
        CategoriaDAO ca = new CategoriaDAO();
        
    public int crear(int cod, int codu, String f , String f1 ){
        Libro l = lb.buscar(cod);
        Usuario u = us.buscar(codu);
        
        int r = 0;
        if( l != null  && u != null ){
            Prestamo p = new Prestamo();
            p.setCod_libro(cod);
            p.setCod_usuario(codu);
            p.setFecha_entrega(f);
            p.setFecha_prestamo(f1);
            
            r = pr.crear(p);
            
            if(r >0){
                l.setEstado("prestado");
                int h = lb.actualizarEstado(l);
            }
        }
        return r;
    }
    
    public String[][] ListarLibro(){
        ArrayList<Prestamo> p = pr.listar();
        String m[][] = new String[p.size()][8];
        Categoria c = new Categoria();
        
        for(int i = 0; i < m.length; i++){
            Libro l = lb.buscar(p.get(i).getCod_libro());
            m[i][0] = ""+p.get(i).getCod();
            m[i][1] = ""+p.get(i).getCod_libro();   
            m[i][2] = ""+p.get(i).getCod_usuario();
            m[i][3] = l.getNombre(); 
            c = ca.buscarC(l.getCod_c());
            m[i][4] = c.getNombre();
            m[i][5] = ""+p.get(i).getFecha_entrega();
            m[i][6] = p.get(i).getFecha_prestamo();
            if(l.getEstado().equals("disponible")){
                m[i][7] = "entregado";
            }
            else {
                m[i][7] = l.getEstado();
            }
   
        }

        return m;
    }
    
    public String[][] BuscarPrestamo(int ced){
        ArrayList<Prestamo> p = pr.buscar1(ced);
        String m[][] = new String[p.size()][8];
        Categoria c = new Categoria();
        if(!p.isEmpty()){
            
            for(int i = 0; i < m.length; i++){
            Libro l = lb.buscar(p.get(i).getCod_libro());
            m[i][0] = ""+p.get(i).getCod();
            m[i][1] = ""+p.get(i).getCod_libro();   
            m[i][2] = ""+p.get(i).getCod_usuario();
            m[i][3] = l.getNombre(); 
            c = ca.buscarC(l.getCod_c());
            m[i][4] = c.getNombre();
            m[i][5] = ""+p.get(i).getFecha_entrega();
            m[i][6] = p.get(i).getFecha_prestamo();
            if(l.getEstado().equals("disponible")){
                m[i][7] = "entregado";
            }
            else {
                m[i][7] = l.getEstado();
            }
   
        }
            
                  
        }
   
        return m;
    }
    
    public int actualizarEstado(int id,String f ,int cod){
        
        Prestamo p = new Prestamo();
        p.setCod(id);
        p.setFecha_entrega(f);
        int a  = 0;
        if(pr.modificar(p) > 0){
            Libro l = new Libro();
            l.setCod(cod);
            l.setEstado("disponible");
            a  = lb.actualizarEstado(l);
        }
        return a;
    }
}
