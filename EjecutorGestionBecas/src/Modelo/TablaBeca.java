package modelo;

import java.sql.Connection;
import java.sql.Statement;
import util.ConexionSQLite;

public class TablaBeca {
    public static void crearTabla() {
        String sql = """
            CREATE TABLE IF NOT EXISTS beca (
                cedula TEXT PRIMARY KEY,
                nombres TEXT NOT NULL,
                apellidos TEXT NOT NULL,
                carrera TEXT NOT NULL,
                tipo_beca TEXT NOT NULL CHECK(tipo_beca IN ('económica', 'académica')),
                semestre INTEGER NOT NULL,
                monto_mensual REAL NOT NULL,
                ingreso_familiar REAL,
                promedio_academico REAL
            );
            """;

        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'beca' creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
