package controlador;

import Modelo.Beca;
import Modelo.BecaDAO;

import java.util.List;

public class BecaControlador {
    private BecaDAO dao;

    public BecaControlador() {
        dao = new BecaDAO();
    }

    public boolean registrarBeca(Beca beca) {
        return dao.insertar(beca);
    }

    public List<Beca> obtenerTodas() {
        return dao.listar();
    }

    public Beca buscarPorCedula(String cedula) {
        return dao.buscarPorCedula(cedula);
    }

    public boolean actualizarBeca(Beca beca) {
        return dao.actualizar(beca);
    }

    public boolean eliminarBeca(String cedula) {
        return dao.eliminar(cedula);
    }
}
