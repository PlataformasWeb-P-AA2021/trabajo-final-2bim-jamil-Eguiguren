/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritura_lectura_archivo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import planes.PlanCelular;

/**
 *
 * @author josef
 */
public class Lectura {

    private ObjectInputStream entrada;
    private ArrayList<PlanCelular> planes;
    private String nombreArchivo;

    public Lectura(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPlanes() {
        // 
        planes = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());

        while (true) {
            try {

                Object registro = entrada.readObject();
                planes.add((PlanCelular) registro);
            } catch (EOFException endOfFileException) {
                return; // se llegó al fin del archivo

            } catch (IOException ex) {
                System.err.println("Error al leer el archivo: " + ex);
            } catch (ClassNotFoundException ex) {
                System.err.println("No se pudo crear el objeto: " + ex);
            } catch (Exception ex) {
                // System.err.println("No hay datos en el archivo: " + ex);
                break;
            }
        }

    }

    public ArrayList<PlanCelular> obtenerListaPlanes() {
        return planes;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Planes\n";
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            cadena = String.format("%sPLAN # %d\n%s\n", cadena, i + 1, p);
        }
        return cadena;
    }

    public String leerPlanPostPagoMegas() {
        String cadena = "Lista de Planes de Megas:\n";
        int cont = 1;
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            if (p.getClass().getName().equals("planes.PlanPostPagoMegas")) {
                cadena = String.format("%sPLAN # %d\n%s\n", cadena, cont, p);
                cont++;
            }
        }
        return cadena;
    }

    public String leerPlanPostPagoMinutos() {
        String cadena = "Lista de Minutos:\n";
        int cont = 1;
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            if (p.getClass().getName().equals("planes.PlanPostPagoMinutos")) {
                cadena = String.format("%sPLAN # %d\n%s\n", cadena, cont, p);
                cont++;
            }
        }
        return cadena;
    }

    public String leerPlanPostPagoMinutosMegas() {
        String cadena = "Lista de Minutos y Megas\n";
        int cont = 1;
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            if (p.getClass().getName().equals(
                    "planes.PlanPostPagoMinutosMegas")) {
                cadena = String.format("%sPLAN # %d\n%s\n", cadena, cont, p);
                cont++;
            }
        }
        return cadena;
    }

    public String leerPlanPostPagoMinutosMegasEconomico() {
        String cadena = "Lista de Pasajes\n";
        int cont = 1;
        for (int i = 0; i < obtenerListaPlanes().size(); i++) {
            PlanCelular p = obtenerListaPlanes().get(i);
            if (p.getClass().getName().equals(
                    "planes.PlanPostPagoMinutosMegasEconomico")) {
                cadena = String.format("%sPLAN # %d\n%s\n", cadena, cont, p);
                cont++;
            }
        }
        return cadena;
    }

    public String leerUltimoPlanIngresado() {
        String cadena = "RESUMEN:\n";
        int cont = obtenerListaPlanes().size() - 1;
        PlanCelular p = obtenerListaPlanes().get(cont);
        cadena = String.format("%s%s", cadena, p);
        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            //System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo

}
