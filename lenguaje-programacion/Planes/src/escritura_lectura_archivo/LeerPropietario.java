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
import planes.Persona;

/**
 *
 * @author josef
 */
public class LeerPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Persona> planes;
    private String nombreArchivo;

    public LeerPropietario(String n) {
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

    public void establecerListaPersona() {
        // 
        planes = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());

        while (true) {
            try {

                Object registro = entrada.readObject();
                planes.add((Persona) registro);
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

    public ArrayList<Persona> obtenerListaPersona() {
        return planes;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Persona extraerPropietario(String id) {
        Persona p = null;
        for (int i = 0; i < obtenerListaPersona().size(); i++) {
            if (obtenerListaPersona().get(i).obtenerIdentificacion().
                    equals(id)) {
                p = obtenerListaPersona().get(i);
                System.out.printf("El propietario de identificacion: %s "
                        + "ya existe.\n %s",
                        id, obtenerListaPersona().get(i));
            }
        }
        return p;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Planes\n";
        for (int i = 0; i < obtenerListaPersona().size(); i++) {
            Persona p = obtenerListaPersona().get(i);
            cadena = String.format("%sPERSONA # %d\n%s\n", cadena, i + 1, p);
        }
        return cadena;
    }

    public String leerUltimoPropietario() {
        String cadena = "RESUMEN:\n";
        int cont = obtenerListaPersona().size() - 1;
        Persona p = obtenerListaPersona().get(cont);
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
