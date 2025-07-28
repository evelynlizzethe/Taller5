package ejecutorgestionbecas;

import Controlador.BecaControlador;
import modelo.TablaBeca;
import Vista.BecaVista;

public class EjecutorGestionBecas {

    public static void main(String[] args) {

        BecaControlador controlador = new BecaControlador();
        controlador.iniciar(); 
    }
}
