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
public class Usuario {
    private int cedula;
    private String nombre;
    private String sexo;
    private String fecha;
    private int tipo;

    public Usuario() {
    }

    public Usuario(int cedula, String nombre, String sexo, String fecha, int tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    
    
}
