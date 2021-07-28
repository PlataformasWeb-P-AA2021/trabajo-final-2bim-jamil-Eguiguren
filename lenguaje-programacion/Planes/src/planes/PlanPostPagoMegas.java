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
public class PlanPostPagoMegas extends PlanCelular implements
        Serializable {

    protected int gigas;
    protected double costoGigas;
    protected double tarifaBase;

    public PlanPostPagoMegas(Persona prop, String ciudad, String marca,
            String num, int g, double cosG, double tBase) {
        super(prop, ciudad, marca, num);
        gigas = g;
        costoGigas = cosG;
        tarifaBase = tBase;
    }

    public void establecerGigas(int g) {
        gigas = g;
    }

    public void establecerCostoGigas(double c) {
        costoGigas = c;
    }

    public void establecerTarifaBase(double t) {
        tarifaBase = t;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (gigas * costoGigas) + tarifaBase;
    }

    public int obtenerGigas() {
        return gigas;
    }

    public double obtenerCostoGigas() {
        return costoGigas;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }
    
    @Override
    public String toString(){
        String cadena = String.format(">PlanPostPagoMegas<\n%s"
                + "- Numero de Gigas: %d\n- Costo por Giga: $%.2f\n"
                + "- Tarifa base: $%.2f\n- Pago Mensual: $%.2f\n",
                super.toString(), obtenerGigas(), obtenerCostoGigas(),
                obtenerTarifaBase(), obtenerPagoMensual());
        return cadena;
    }

}
