/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Categoria;
import modelo.CategoriaDAO;

/**
 *
 * @author Yeya
 */
public class CategoriaController {
    
    CategoriaDAO cat =  new CategoriaDAO();
    
    public int crear(String cod, String nombre){
        Categoria  ca = cat.buscarC(cod);
        int r = 0;
        if(ca == null){
            Categoria c = new Categoria();
            c.setCod(cod);
            c.setNombre(nombre);
            r = cat.crear(c);
        }
        
        return r; 
    }
    
    public ArrayList<String> listar(){
        ArrayList<String> c = new ArrayList();
        ArrayList<Categoria> ca = cat.listar();
        if(!ca.isEmpty()){
            for(int i = 0; i < ca.size(); i++){
                c.add(ca.get(i).getNombre());
            }
            
        }
        
        return c;
    }
    
    public ArrayList<String> BuscarCategoria(String c){
        Categoria ca = cat.buscarN(c);
        ArrayList<String> ls = new ArrayList();
        if(ca !=null){
            ls.add(""+ca.getCod());
            ls.add(ca.getNombre());
        }
   
        return ls;
    }
}
