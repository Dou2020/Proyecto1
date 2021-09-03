package datos;

import static datos.conexion.close;
import domain.Mueble;
import domain.Pieza;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author douglas2021
 */
public class CrearMuebleDAO {

    private static final String SQL_SELECT_ENMUEBLE = "SELECT * FROM ensamble_pieza WHERE nombre_mueble = ?";
    private static final String SQL_SELECT_ENMUEBLE_PIEZA = "SELECT * FROM emsable_pieza WHERE nombre_pieza = ? && nombre_mueble = ?";
    private static final String SQL_SELECT_MUEBLE = "SELECT * FROM Mueble";
    private static final String SQL_SELECT_MUEBLE_ID = "SELECT * FROM Mueble WHERE nombre = ?";
    private static final String SQL_INSERT_ENMUEBLE = "INSERT INTO ensamble_pieza(nombre_mueble,nombre_pieza,cantidad)VALUES (?,?,?)";
    private static final String SQL_INSERT_MUEBLE = "INSERT INTO Mueble(nombre,precio)VALUE(?,?)";
    
    private static final String SQL_UPDATE_ENMUEBLE = "UPDATE ensamble_pieza SET nombre_pieza = ? cantidad = ? WHERE nombre_mueble = ?";
    private static final String SQL_UPDATE_MUEBLE = "UPDATE Mueble SET precio = ? WHERE nombre = ?";
    private static final String SQL_DELETE_ENMUEBLE_PIEZA = "DELETE FROM ensamble_pieza WHERE nombre_pieza = ?";
    private static final String SQL_DELETE_ENMUEBLE = "DELETE FROM ensamble_pieza WHERE nombre_mueble = ? ";
    private static final String SQL_DELETE_MUEBLE = "DELETE FROM Mueble WHERE nombre = ?";
    
    // listar toda la base de datos 
    public List<Pieza> listaEnMueble(String nombreMueble) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pieza> piezas = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ENMUEBLE);
            stmt.setString(1, nombreMueble);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre_pieza");
                int cantidad = rs.getInt("cantidad");

                Pieza pieza = new Pieza(nombre, cantidad);
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
    public List<Mueble> listaMueble(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Mueble> muebles = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MUEBLE);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                Mueble mueble = new Mueble(nombre, precio);
                muebles.add(mueble);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return muebles;
    }
    public int InsertarMueble(Mueble mueble){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_MUEBLE);
            stmt.setString(1, mueble.getNombre());
            stmt.setDouble(2, mueble.getPrecio());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    
    public int InsertarEnPieza(Pieza pieza,Mueble mueble){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            if (!this.encontrarMueble(mueble.getNombre())) {
                this.InsertarMueble(mueble);
            }
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_ENMUEBLE);
            stmt.setString(1, mueble.getNombre());
            stmt.setString(2, pieza.getNombre());
            stmt.setInt(3, pieza.getCantidad());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
   
    public boolean encontrarMueble(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MUEBLE_ID);
            System.out.println("nombre_id: " + nombre);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreM = rs.getString("nombre");
                if (nombreM != null && nombreM.equalsIgnoreCase(nombre)) {
                    return true;
                }
                
                System.out.println(rs.getRow()+" "+nombreM);
            }
            return false;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.print("hay un error en encontrar ");
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return false;
    }
    public Mueble seleccionarMueble(String nombre){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MUEBLE_ID);
            System.out.println("nombre_id: " + nombre);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreM = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                if (nombreM != null && nombreM.equalsIgnoreCase(nombre)) {
                    return new Mueble(nombreM,precio);
                }
                
                System.out.println(rs.getRow()+" "+nombreM);
            }
            return null;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.print("hay un error en encontrar ");
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return null;
    }
    public int actualizarPieza(Pieza pieza) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_ENMUEBLE);
            stmt.setInt(1,pieza.getCantidad());
            stmt.setString(2, pieza.getNombre());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }

    public int actualizarMueble(Mueble mueble) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_MUEBLE);
            stmt.setDouble(1,mueble.getPrecio());
            stmt.setString(2, mueble.getNombre());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public int eliminarEnMueble(String nombreMueble){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_ENMUEBLE);
            stmt.setString(1, nombreMueble);

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public int eliminarMueble(String nombreMueble) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_MUEBLE);
            stmt.setString(1, nombreMueble);

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public void alerta(HttpServletRequest request, HttpServletResponse response,String nombre,String link) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('"+nombre+ "')");
            out.println("location='"+link+"'");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            out.close();
    }
    
    

}
