package Controlador;

import Modelo.Beca;
import Modelo.BecaDAO;
import java.util.*;

public class BecaControlador {

    private BecaDAO dao;
    private Scanner scanner;

    public BecaControlador() {
        dao = new BecaDAO();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion;

        do {
            System.out.println("\n--- GESTION DE BECAS UNIVERSITARIAS ---");
            System.out.println("1. Insertar beca");
            System.out.println("2. Listar becas");
            System.out.println("3. Actualizar beca");
            System.out.println("4. Eliminar beca");
            System.out.println("5. Buscar beca por cedula");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> insertar();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 5 -> buscar();
            }

        } while (opcion != 6);
    }

    private void insertar() {
        Beca beca = leerDatos();
        dao.insertar(beca);
        System.out.println("Beca ingresada correctamente.");
    }

    private void listar() {
        List<Beca> lista = dao.listarTodos();
        for (Beca b : lista) {
            System.out.printf("%s | %s %s | Carrera: %s | Tipo: %s | Semestre: %d | Monto: %.2f | Ingreso fam.: %.2f | Promedio: %.2f%n",
                    b.getCedula(), b.getNombres(), b.getApellidos(), b.getCarrera(), b.getTipoBeca(),
                    b.getSemestre(), b.getMontoMensual(),
                    b.getIngresoFamiliar() != null ? b.getIngresoFamiliar() : 0.0,
                    b.getPromedioAcademico() != null ? b.getPromedioAcademico() : 0.0);
        }
    }

    private void actualizar() {
        System.out.print("Ingrese la cedula de la beca a actualizar: ");
        String cedula = scanner.nextLine();
        Beca beca = leerDatos();
        beca.setCedula(cedula);
        if (dao.actualizar(beca)) {
            System.out.println("Beca actualizada.");
        } else {
            System.out.println("No se encontro una beca con esa cedula.");
        }
    }

    private void eliminar() {
        System.out.print("Ingrese la cedula de la beca a eliminar: ");
        String cedula = scanner.nextLine();
        if (dao.eliminar(cedula)) {
            System.out.println("Beca eliminada.");
        } else {
            System.out.println("No se encontro una beca con esa cedula.");
        }
    }

    private void buscar() {
        System.out.print("Ingrese la cedula de la beca a buscar: ");
        String cedula = scanner.nextLine();
        Beca b = dao.buscarPorCedula(cedula);
        if (b != null) {
            System.out.printf("Cedula: %s\nNombre: %s %s\nCarrera: %s\nTipo: %s\nSemestre: %d\nMonto: %.2f\nIngreso fam.: %.2f\nPromedio: %.2f\n",
                    b.getCedula(), b.getNombres(), b.getApellidos(), b.getCarrera(), b.getTipoBeca(),
                    b.getSemestre(), b.getMontoMensual(),
                    b.getIngresoFamiliar() != null ? b.getIngresoFamiliar() : 0.0,
                    b.getPromedioAcademico() != null ? b.getPromedioAcademico() : 0.0);
        } else {
            System.out.println("No se encontro ninguna beca con esa cedula.");
        }
    }

    private Beca leerDatos() {
        Beca beca = new Beca();

        System.out.print("Cedula: ");
        beca.setCedula(scanner.nextLine());

        System.out.print("Nombres: ");
        beca.setNombres(scanner.nextLine());

        System.out.print("Apellidos: ");
        beca.setApellidos(scanner.nextLine());

        System.out.print("Carrera: ");
        beca.setCarrera(scanner.nextLine());

        System.out.print("Tipo de beca (economica / academica): ");
        beca.setTipoBeca(scanner.nextLine());

        System.out.print("Semestre: ");
        beca.setSemestre(Integer.parseInt(scanner.nextLine()));

        System.out.print("Monto mensual: ");
        beca.setMontoMensual(Double.parseDouble(scanner.nextLine()));

        // Campos opcionales
        System.out.print("Ingreso familiar (si aplica): ");
        String ingreso = scanner.nextLine();
        beca.setIngresoFamiliar(ingreso.isEmpty() ? null : Double.parseDouble(ingreso));

        System.out.print("Promedio academico (si aplica): ");
        String promedio = scanner.nextLine();
        beca.setPromedioAcademico(promedio.isEmpty() ? null : Double.parseDouble(promedio));

        return beca;
    }
    
}
