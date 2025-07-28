package Vista;

import Modelo.Beca;
import java.util.Scanner;

public class BecaVista {

    private Scanner scanner = new Scanner(System.in);

    public Beca leerDatos() {
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

    public void mostrarBeca(Beca b) {
        System.out.printf("Cedula: %s\nNombres: %s\nApellidos: %s\nCarrera: %s\nTipo: %s\nSemestre: %d\nMonto mensual: %.2f\nIngreso familiar: %.2f\nPromedio academico: %.2f\n",
                b.getCedula(), b.getNombres(), b.getApellidos(), b.getCarrera(), b.getTipoBeca(),
                b.getSemestre(), b.getMontoMensual(),
                b.getIngresoFamiliar() != null ? b.getIngresoFamiliar() : 0.0,
                b.getPromedioAcademico() != null ? b.getPromedioAcademico() : 0.0);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
