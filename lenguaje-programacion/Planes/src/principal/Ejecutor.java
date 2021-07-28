/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import escritura_lectura_archivo.*;
import java.util.Scanner;
import planes.*;

/**
 *
 * @author josef
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String identificacion;
        String ciudadPropie;
        String marcaCelu;
        String numeroCelu;
        boolean bandera = true;
        int op;
        int op2;
        int op3;
        String nombreArchivo = "planes.data";
        String nombreArchivo2 = "propietarios.data";

        do {
            System.out.println("Digite la opción para realizar una accion:\n"
                    + "-1 para Ingresar un plan celular.\n"
                    + "-2 para Mostrar los planes ingresados.\n"
                    + "-3 para Ingresar un Propietario.\n"
                    + "-4 para NO realizar más acciones: ");
            op = sc.nextInt();
            if ((op >= 1) && (op <= 4)) {
                switch (op) {
                    case 1:
                        System.out.println("Digite el plan que desa "
                                + "ingresar:\n"
                                + "(1) Plan Post Pago Megas.\n"
                                + "(2) Plan Post Pago Minutos.\n"
                                + "(3) Plan Post Pago Minutos Megas.\n"
                                + "(4) Plan Post Pago Minutos Megas "
                                + "Economico.: ");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        if ((op2 >= 1) && (op2 <= 4)) {
                            System.out.println("Ingrese la idetificacion del "
                                    + "Propietario: ");
                            identificacion = sc.nextLine();
                            Persona p = extraerIngresarPersona(identificacion,
                                    nombreArchivo2);
                            System.out.println("Ingrese el nombre de la "
                                    + "ciudad: ");
                            ciudadPropie = sc.nextLine();
                            System.out.println("Ingrese la marca del "
                                    + "Celular: ");
                            marcaCelu = sc.nextLine();
                            System.out.println("Ingrese el numero Celular: ");
                            numeroCelu = sc.nextLine();
                            switch (op2) {
                                case 1:
                                    ingresarPlanPostPagoMegas(p, ciudadPropie,
                                            marcaCelu, numeroCelu,
                                            nombreArchivo);
                                    break;
                                case 2:
                                    ingresarPlanPostPagoMinutos(p,
                                            ciudadPropie, marcaCelu,
                                            numeroCelu, nombreArchivo);
                                    break;
                                case 3:
                                    ingresarPlanPostPagoMinutosMegas(p,
                                            ciudadPropie, marcaCelu,
                                            numeroCelu, nombreArchivo);
                                    break;
                                case 4:
                                    ingresarPlanPostPagoMinutosMegasEconomico(
                                            p, ciudadPropie, marcaCelu,
                                            numeroCelu, nombreArchivo);
                                    break;
                            }
                        } else {
                            System.out.println("Opción incorrecta-Intente "
                                    + "de nuevo");
                        }
                        break;
                    case 2:
                        System.out.println("Digite el plan que desa "
                                + "ingresar:\n"
                                + "(1) para mostrar los Planes Post Pago"
                                + " Megas.\n"
                                + "(2) para mostrar los Planes Plan Post Pago"
                                + " Minutos.\n"
                                + "(3) para mostrar los Planes Plan Post Pago"
                                + " Minutos Megas.\n"
                                + "(4) para mostrar los Planes Plan Post Pago"
                                + " Minutos Megas "
                                + "Economico.\n(5) para mostrar todos los"
                                + " Planes: ");
                        op3 = sc.nextInt();
                        if ((op3 >= 1) && (op3 <= 5)) {
                            switch (op3) {
                                case 1:
                                    Lectura le = new Lectura(nombreArchivo);
                                    le.establecerListaPlanes();
                                    System.out.println(le.leerPlanPostPagoMegas());
                                    le.cerrarArchivo();
                                    break;
                                case 2:
                                    Lectura le2 = new Lectura(nombreArchivo);
                                    le2.establecerListaPlanes();
                                    System.out.println(
                                            le2.leerPlanPostPagoMinutos());
                                    le2.cerrarArchivo();
                                    break;
                                case 3:
                                    Lectura le3 = new Lectura(nombreArchivo);
                                    le3.establecerListaPlanes();
                                    System.out.println(le3.
                                            leerPlanPostPagoMinutosMegas());
                                    le3.cerrarArchivo();
                                    break;
                                case 4:
                                    Lectura le4 = new Lectura(nombreArchivo);
                                    le4.establecerListaPlanes();
                                    System.out.println(le4.
                                            leerPlanPostPagoMinutosMegasEconomico());
                                    le4.cerrarArchivo();
                                    break;
                                case 5:
                                    Lectura le5 = new Lectura(nombreArchivo);
                                    le5.establecerListaPlanes();
                                    System.out.println(le5);
                                    le5.cerrarArchivo();
                                    break;
                            }
                        } else {
                            System.out.println("Opción incorrecta-"
                                    + "Intente de nuevo");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese la idetificacion del "
                                + "Propietario: ");
                        identificacion = sc.nextLine();
                        extraerIngresarPersona(identificacion, nombreArchivo2);
                        break;
                    case 4:
                        bandera = false;
                        break;
                }

            } else {
                System.out.println("Opción incorrecta-Intente de nuevo");
            }
            System.out.println("" + bandera);
        } while (bandera);
    }

    public static Persona extraerIngresarPersona(String id, String nombreA2) {
        Scanner sc = new Scanner(System.in);
        Persona p;
        String nombre;
        String apellido;
        LeerPropietario lp = new LeerPropietario(nombreA2);
        lp.establecerListaPersona();
        p = lp.extraerPropietario(id);
        if (p == null) {
            System.out.println("Ingrese el nombre del Propietario: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese el apellido del Propietario: ");
            apellido = sc.nextLine();
            p = new Persona(nombre, apellido, id);
            escribirPersona(p, nombreA2);
            mostrarResumenPersona(nombreA2);
        }
        lp.cerrarArchivo();
        return p;
    }

    public static void escribirPersona(Persona p, String nombreArc2) {
        EscribirPropietario ep = new EscribirPropietario(nombreArc2);
        ep.establecerRegistro(p);
        ep.establecerSalida();
        ep.cerrarArchivo();
    }

    public static void mostrarResumenPersona(String nombreArc2) {
        LeerPropietario le = new LeerPropietario(nombreArc2);
        le.establecerListaPersona();
        System.out.println(le.leerUltimoPropietario());
        le.cerrarArchivo();
    }

    public static void ingresarPlanPostPagoMegas(Persona prop, String ciudad,
            String marca, String num, String nombreA) {
        Scanner sc = new Scanner(System.in);
        int g;
        double cosG;
        double tBase;
        System.out.println("Ingrese el numero de gigas: ");
        g = sc.nextInt();
        System.out.println("Ingrese el costo por giga: ");
        cosG = sc.nextDouble();
        System.out.println("Ingrese la tarifa Base: ");
        tBase = sc.nextDouble();
        PlanPostPagoMegas plan = new PlanPostPagoMegas(prop, ciudad, marca,
                num, g, cosG, tBase);
        plan.establecerPagoMensual();
        escribirArchivo(nombreA, plan);
        mostrarResumen(nombreA);
    }

    public static void ingresarPlanPostPagoMinutos(Persona prop, String ciudad,
            String marca, String num, String nombreA) {
        Scanner sc = new Scanner(System.in);
        int minutosNacionales;
        double costoMinutoNacional;
        int minutosInternacionales;
        double costoMinutoInternacional;
        System.out.println("Ingresar el numero de minutos nacionales: ");
        minutosNacionales = sc.nextInt();
        System.out.println("Ingresar el costo por minutos nacionales: ");
        costoMinutoNacional = sc.nextDouble();
        System.out.println("Ingresar el numero de minutos internacionales: ");
        minutosInternacionales = sc.nextInt();
        System.out.println("Ingresar el numero de minutos internacionales: ");
        costoMinutoInternacional = sc.nextDouble();
        PlanPostPagoMinutos plan = new PlanPostPagoMinutos(prop, ciudad,
                marca, num, minutosNacionales, costoMinutoNacional,
                minutosInternacionales, costoMinutoInternacional);
        plan.establecerPagoMensual();
        escribirArchivo(nombreA, plan);
        mostrarResumen(nombreA);
    }

    public static void ingresarPlanPostPagoMinutosMegas(Persona prop,
            String ciudad, String marca, String num, String nombreA) {
        Scanner sc = new Scanner(System.in);
        int minutos;
        double costoMinutos;
        int gigas;
        double costoGigas;
        System.out.println("Ingresar el numero de minutos nacionales: ");
        minutos = sc.nextInt();
        System.out.println("Ingresar el costo por minutos nacionales: ");
        costoMinutos = sc.nextDouble();
        System.out.println("Ingresar el numero de minutos nacionales: ");
        gigas = sc.nextInt();
        System.out.println("Ingresar el numero de minutos nacionales: ");
        costoGigas = sc.nextDouble();
        PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(prop,
                ciudad, marca, num, minutos, costoMinutos, gigas, costoGigas);
        plan.establecerPagoMensual();
        escribirArchivo(nombreA, plan);
        mostrarResumen(nombreA);
    }

    public static void ingresarPlanPostPagoMinutosMegasEconomico(Persona prop,
            String ciudad, String marca, String num, String nombreA) {
        Scanner sc = new Scanner(System.in);
        int minutos;
        double costoMinutos;
        int gigas;
        double costoGigas;
        System.out.println("Ingresar el numero de minutos nacionales: ");
        minutos = sc.nextInt();
        System.out.println("Ingresar el costo por minutos nacionales: ");
        costoMinutos = sc.nextDouble();
        System.out.println("Ingresar el numero de minutos nacionales: ");
        gigas = sc.nextInt();
        System.out.println("Ingresar el numero de minutos nacionales: ");
        costoGigas = sc.nextDouble();
        PlanPostPagoMinutosMegasEconomico plan
                = new PlanPostPagoMinutosMegasEconomico(prop, ciudad, marca,
                        num, minutos, costoMinutos, gigas, costoGigas, 15);
        plan.establecerPagoMensual();
        escribirArchivo(nombreA, plan);
        mostrarResumen(nombreA);
    }

    public static void escribirArchivo(String nombreArc, PlanCelular p) {
        Escritura ec = new Escritura(nombreArc);
        ec.establecerRegistro(p);
        ec.establecerSalida();
        ec.cerrarArchivo();
    }

    public static void mostrarResumen(String nombreArc) {
        Lectura le = new Lectura(nombreArc);
        le.establecerListaPlanes();
        System.out.println(le.leerUltimoPlanIngresado());
        le.cerrarArchivo();
    }

}
