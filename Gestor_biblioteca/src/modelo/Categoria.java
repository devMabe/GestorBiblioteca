/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Yeya
 */
public class Categoria {
    private String cod;
    private String nombre;

    public Categoria() {
    }

    public Categoria(String cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
