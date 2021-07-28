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
public class PlanPostPagoMinutosMegas extends PlanCelular implements
        Serializable {

    private int minutos;
    private double costoMinutos;
    private int gigas;
    private double costoGigas;

    public PlanPostPagoMinutosMegas(Persona prop, String ciudad,
            String marca, String num, int m, double cosM, int g,
            double cosG) {
        super(prop, ciudad, marca, num);
        minutos = m;
        costoMinutos = cosM;
        gigas = g;
        costoGigas = cosG;
    }

    public void establecerMinutos(int m) {
        minutos = m;
    }

    public void establecerCostoMinutos(double c) {
        costoMinutos = c;
    }

    public void establecerGigas(int g) {
        gigas = g;
    }

    public void establecerCostoGigas(double c) {
        costoGigas = c;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (minutos * costoMinutos) + (gigas * costoMinutos);
    }

    public int obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMinutos() {
        return costoMinutos;
    }

    public int obtenerGigas() {
        return gigas;
    }

    public double obtenerCostoGigas() {
        return costoGigas;
    }
    
    @Override
    public String toString(){
        String cadena = String.format(">PlanPostPagoMinutosMegasEconómico<\n%s"
                + "- Número de Minutos: %d\n- Costo por Minuto: $%.2f\n"
                + "- Número de Gigas: %d\n- Costo por Giga: $%.2f\n"
                + "- Pago Mensual: $%.2f\n",
                super.toString(), obtenerMinutos(), obtenerCostoMinutos(),
                obtenerGigas(), obtenerCostoGigas(),obtenerPagoMensual());
        return cadena;
    }

}
