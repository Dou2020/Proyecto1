package datos;

import static datos.conexion.close;
import domain.Pieza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabricaDAO {
    private static final String SQL_SELECT_PIEZA = "SELECT * FROM Pieza";
    private static final String SQL_SELECT_PRECIO = "SELECT * FROM Precio";
    private static final String SQL_SELECT_MUEBLE = "SELECT * FROM Mueble";
    private static final String SQL_SELECT_PRECIO_ID = "SELECT * FROM Precio WHERE id = ?";
    private static final String SQL_INSERT_PIEZA = "INSERT INTO Pieza(nombre)VALUES (?)";
    private static final String SQL_INSERT_PRECIO = "INSERT INTO Precio(costo,nombre_pieza)VALUES (?,?)";
    
    private static final String SQL_UPDATE_PRECIO = "UPDATE Precio SET costo = ?, nombre_pieza = ? WHERE id = ?";
    private static final String SQL_UPDATE_PIEZA = "UPDATE Pieza SET nombre = ? WHERE nombre = ?";
    private static final String SQL_DELETE_PRECIO = "DELETE FROM Precio WHERE id = ?";
    
    public List<Pieza> listaPrecio() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pieza> piezas = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PRECIO);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre_pieza");
                double costo = rs.getDouble("costo");
                int id = rs.getInt("id");

                Pieza pieza = new Pieza(nombre, costo, id);
                piezas.add(pieza);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return piezas;
    }
    public List<Pieza> listaPieza() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pieza> piezas = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PIEZA);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                
                Pieza pieza = new Pieza(nombre);
                piezas.add(pieza);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return piezas;
    }
    public String encontrarPieza(String nom) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PIEZA);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                
                if (nombre.equalsIgnoreCase(nom)) {
                    return nombre;
                }
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return null;
    }
    public Pieza encontrarPrecio(int id_) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pieza pieza;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PRECIO_ID);
            stmt.setInt(1,id_);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre_pieza");
                double costo = rs.getDouble("costo");
                int id = rs.getInt("id");
                pieza = new Pieza(nombre, costo, id);
                return pieza;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return null;
    }
    public int insertarPieza(String pieza){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PIEZA);
            stmt.setString(1, pieza);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public int insertarPrecio(Pieza pieza){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PRECIO);
            stmt.setString(2, pieza.getNombre());
            stmt.setDouble(1, pieza.getCosto());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public int modificarPrecio(Pieza pieza){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, pieza.getCosto());
            stmt.setString(2, pieza.getNombre());
            stmt.setInt(3, pieza.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public int eliminarPrecio(int id){
        int rows =0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_PRECIO);
            stmt.setInt(1, id);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    
    
}
