package ejecutorgestionbecas;

import modelo.TablaBeca;
import Vista.BecaVista;

public class EjecutorGestionBecas {

    public static void main(String[] args) {

        TablaBeca.crearTabla();

        BecaVista vista = new BecaVista();
        vista.mostrarMenu();
    }
}
