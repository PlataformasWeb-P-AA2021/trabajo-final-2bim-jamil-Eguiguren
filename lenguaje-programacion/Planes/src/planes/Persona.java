/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planes;

import java.io.Serializable;

/**
 *
 * @author josef
 */
public class Persona implements Serializable {

    private String nombres;
    private String apellidos;
    private String identificacion;

    public Persona(String n, String a, String i) {
        nombres = n;
        apellidos = a;
        identificacion = i;
    }

    public void establecerNombres(String n) {
        nombres = n;
    }

    public void establecerApellidos(String a) {
        apellidos = a;
    }

    public void establecerIdentificacion(String i) {
        identificacion = i;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public String obtenerIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        String cadena = String.format(" > Nombres: %s\n > Apellidos: %s\n"
                + " > Identificación: %s\n", obtenerNombres(),
                obtenerApellidos(), obtenerIdentificacion());
        return cadena;
    }

}
