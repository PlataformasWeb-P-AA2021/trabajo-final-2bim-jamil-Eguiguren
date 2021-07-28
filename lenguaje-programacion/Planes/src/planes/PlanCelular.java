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
public abstract class PlanCelular implements Serializable {

    protected Persona propietario;
    protected String ciudadPropietario;
    protected String marcaCelular;
    protected String numeroCelular;
    protected double pagoMensual;

    public PlanCelular(Persona prop, String ciudad, String marca, String num) {
        propietario = prop;
        ciudadPropietario = ciudad;
        marcaCelular = marca;
        numeroCelular = num;
    }

    public void establecerPropietario(Persona prop) {
        propietario = prop;
    }

    public void establecerCiudadPropietario(String ciudad) {
        ciudadPropietario = ciudad;
    }

    public void establecerMarcaCelular(String marca) {
        marcaCelular = marca;
    }

    public void establecerNumeroCelular(String num) {
        numeroCelular = num;
    }

    public abstract void establecerPagoMensual();

    public Persona obtenerPropietario() {
        return propietario;
    }

    public String obtenerCiudadPropietario() {
        return ciudadPropietario;
    }

    public String obtenerMarcaCelular() {
        return marcaCelular;
    }

    public String obtenerNumeroCelular() {
        return numeroCelular;
    }

    public double obtenerPagoMensual() {
        return pagoMensual;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("- Propietario:\n%s- Ciudad: %s\n"
                + "- Marca del celular: %s\n- Número de celular: %s\n",
                obtenerPropietario(), obtenerCiudadPropietario(),
                obtenerMarcaCelular(), obtenerNumeroCelular());
        return cadena;
    }

}
