package Vista;

import java.util.Scanner;
import Modelo.Beca;
import controlador.BecaControlador;

public class BecaVista {

    private Scanner sc = new Scanner(System.in);
    private BecaControlador controlador = new BecaControlador();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Sistema de Gestion de Becas ---");
            System.out.println("1. Registrar beca");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 2);
    }

    public void registrar() {
        Scanner sc = new Scanner(System.in);
        Beca beca = new Beca();

        System.out.print("Ingrese cedula: ");
        beca.setCedula(sc.nextLine());

        System.out.print("Ingrese nombres: ");
        beca.setNombres(sc.nextLine());

        System.out.print("Ingrese apellidos: ");
        beca.setApellidos(sc.nextLine());

        System.out.print("Ingrese carrera: ");
        beca.setCarrera(sc.nextLine());

        System.out.print("Ingrese tipo de beca (economica o academica): ");
        String tipo = sc.nextLine().toLowerCase();
        beca.setTipoBeca(tipo);

        System.out.print("Ingrese semestre: ");
        beca.setSemestre(sc.nextInt());

        System.out.print("Ingrese monto mensual: ");
        beca.setMontoMensual(sc.nextDouble());

        if (tipo.equals("economica")) {
            System.out.print("Ingrese ingreso familiar: ");
            beca.setIngresoFamiliar(sc.nextDouble());
            beca.setPromedioAcademico(null);
        } else if (tipo.equals("academica")) {
            System.out.print("Ingrese promedio academico: ");
            beca.setPromedioAcademico(sc.nextDouble());
            beca.setIngresoFamiliar(null);
        } else {
            System.out.println("Tipo de beca no valido. Se cancelara el registro.");
            return;
        }

        sc.nextLine(); 
        controlador.registrarBeca(beca);
    }

}
