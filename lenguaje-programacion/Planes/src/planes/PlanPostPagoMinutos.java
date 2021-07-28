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
public class PlanPostPagoMinutos extends PlanCelular implements Serializable {

    protected int minutosNacionales;
    protected double costoMinutoNacional;
    protected int minutosInternacionales;
    protected double costoMinutoInternacional;

    public PlanPostPagoMinutos(Persona prop, String ciudad, String marca,
            String num, int mNacional, double costoMinutoNaci,
            int mInternacional, double costoMinutoInter) {
        super(prop, ciudad, marca, num);
        minutosNacionales = mNacional;
        costoMinutoNacional = costoMinutoNaci;
        minutosInternacionales = mInternacional;
        costoMinutoInternacional = costoMinutoInter;
    }

    public void establecerMinutosNacionales(int m) {
        minutosNacionales = m;
    }

    public void establecerCostoMinutoNacional(double c) {
        costoMinutoNacional = c;
    }

    public void establecerMinutosInternacionales(int m) {
        minutosInternacionales = m;
    }

    public void estableceracostoMinutoInternacional(double c) {
        costoMinutoInternacional = c;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (minutosNacionales * costoMinutoNacional)
                + (minutosInternacionales * costoMinutoInternacional);
    }

    public int obtenerMinutosNacionales() {
        return minutosNacionales;
    }

    public double obtenerCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public int obtenerMinutosInternacionales() {
        return minutosInternacionales;
    }

    public double obtenerCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }
    
    @Override
    public String toString(){
        String cadena = String.format(">PlanPostPagoMegas<\n%s"
                + "- Numero de Minutos Nacionales: %d\n"
                + "- Costo por Minuto Nacional: $%.2f\n"
                + "- Numero de Minutos Internacionales: %d\n"
                + "- Costo por Minuto Internacional: $%.2f\n"
                + "- Pago Mensual: $%.2f\n",
                super.toString(), obtenerMinutosNacionales(),
                obtenerCostoMinutoNacional(),
                obtenerMinutosInternacionales(),
                obtenerCostoMinutoInternacional(),
                obtenerPagoMensual());
        return cadena;
    }

}
