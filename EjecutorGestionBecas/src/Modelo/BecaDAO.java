package Modelo;

import util.ConexionSQLite;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BecaDAO {

    public void insertar(Beca beca) {
        String sql = "INSERT INTO beca (cedula, nombres, apellidos, carrera, tipo_beca, semestre, monto_mensual, ingreso_familiar, promedio_academico) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, beca.getCedula());
            pstmt.setString(2, beca.getNombres());
            pstmt.setString(3, beca.getApellidos());
            pstmt.setString(4, beca.getCarrera());
            pstmt.setString(5, beca.getTipoBeca());
            pstmt.setInt(6, beca.getSemestre());
            pstmt.setDouble(7, beca.getMontoMensual());

            if (beca.getIngresoFamiliar() != null) {
                pstmt.setDouble(8, beca.getIngresoFamiliar());
            } else {
                pstmt.setNull(8, Types.DOUBLE);
            }

            if (beca.getPromedioAcademico() != null) {
                pstmt.setDouble(9, beca.getPromedioAcademico());
            } else {
                pstmt.setNull(9, Types.DOUBLE);
            }

            pstmt.executeUpdate();
            System.out.println("Beca insertada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar beca: " + e.getMessage());
        }
    }

    public boolean actualizar(Beca beca) {
        String sql = "UPDATE beca SET nombres = ?, apellidos = ?, carrera = ?, tipo_beca = ?, semestre = ?, monto_mensual = ?, ingreso_familiar = ?, promedio_academico = ? WHERE cedula = ?";

        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, beca.getNombres());
            pstmt.setString(2, beca.getApellidos());
            pstmt.setString(3, beca.getCarrera());
            pstmt.setString(4, beca.getTipoBeca());
            pstmt.setInt(5, beca.getSemestre());
            pstmt.setDouble(6, beca.getMontoMensual());

            if (beca.getIngresoFamiliar() != null) {
                pstmt.setDouble(7, beca.getIngresoFamiliar());
            } else {
                pstmt.setNull(7, Types.DOUBLE);
            }

            if (beca.getPromedioAcademico() != null) {
                pstmt.setDouble(8, beca.getPromedioAcademico());
            } else {
                pstmt.setNull(8, Types.DOUBLE);
            }

            pstmt.setString(9, beca.getCedula());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar beca: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String cedula) {
        String sql = "DELETE FROM beca WHERE cedula = ?";

        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedula);
            int filasEliminadas = pstmt.executeUpdate();
            return filasEliminadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar beca: " + e.getMessage());
            return false;
        }
    }
    public Beca buscarPorCedula(String cedula) {
        String sql = "SELECT * FROM beca WHERE cedula = ?";
        Beca beca = null;

        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                beca = new Beca();
                beca.setCedula(rs.getString("cedula"));
                beca.setNombres(rs.getString("nombres"));
                beca.setApellidos(rs.getString("apellidos"));
                beca.setCarrera(rs.getString("carrera"));
                beca.setTipoBeca(rs.getString("tipo_beca"));
                beca.setSemestre(rs.getInt("semestre"));
                beca.setMontoMensual(rs.getDouble("monto_mensual"));

                double ingreso = rs.getDouble("ingreso_familiar");
                beca.setIngresoFamiliar(rs.wasNull() ? null : ingreso);

                double promedio = rs.getDouble("promedio_academico");
                beca.setPromedioAcademico(rs.wasNull() ? null : promedio);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar beca: " + e.getMessage());
        }

        return beca;
    }

    public List<Beca> listarTodos() {
        List<Beca> lista = new ArrayList<>();
        String sql = "SELECT * FROM beca";

        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Beca beca = new Beca();
                beca.setCedula(rs.getString("cedula"));
                beca.setNombres(rs.getString("nombres"));
                beca.setApellidos(rs.getString("apellidos"));
                beca.setCarrera(rs.getString("carrera"));
                beca.setTipoBeca(rs.getString("tipo_beca"));
                beca.setSemestre(rs.getInt("semestre"));
                beca.setMontoMensual(rs.getDouble("monto_mensual"));

                double ingreso = rs.getDouble("ingreso_familiar");
                beca.setIngresoFamiliar(rs.wasNull() ? null : ingreso);

                double promedio = rs.getDouble("promedio_academico");
                beca.setPromedioAcademico(rs.wasNull() ? null : promedio);

                lista.add(beca);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar becas: " + e.getMessage());
        }

        return lista;
    }
}
