/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.Admin;
import modelo.AdminDAO;

/**
 *
 * @author Yeya
 */
public class AdminController {
    
    private final AdminDAO adDAO = new AdminDAO();
    
    public boolean login(String nombre, String password){
        boolean sw = false;
        Admin ad = adDAO.login(nombre, password);
        if( ad != null){
          sw = true;   
        }
        return sw;
    }
    
}
