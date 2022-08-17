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
public class Prestamo {
    private int cod;
    private int cod_libro;
    private int cod_usuario;
    private String fecha_prestamo;
    private String fecha_entrega;
    private int estado;

    public Prestamo() {
    }

    public Prestamo(int cod_libro, int cod_usuario, String fecha_prestamo, String fecha_entrega, int estado) {
        this.cod_libro = cod_libro;
        this.cod_usuario = cod_usuario;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
    }

    public int getCod_libro() {
        return cod_libro;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public int getEstado() {
        return estado;
    }

    public int getCod() {
        return cod;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    
    
}
