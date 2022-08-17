/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Libro {
    private int cod;
    private String nombre;
    private int cod_e;
    private String cod_c;
    private String estado;
    public Libro() {
    }

    public Libro(int cod, String nombre, int cod_e, String cod_c, String estado) {
        this.cod = cod;
        this.nombre = nombre;
        this.cod_e = cod_e;
        this.cod_c = cod_c;
        this.estado = estado;
    }

    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCod_e() {
        return cod_e;
    }

    public String getCod_c() {
        return cod_c;
    }

    public String getEstado() {
        return estado;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCod_e(int cod_e) {
        this.cod_e = cod_e;
    }

    public void setCod_c(String cod_c) {
        this.cod_c = cod_c;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
