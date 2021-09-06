package datos;
import datos.conexion;
import static datos.conexion.close;
import domain.Cliente;
import domain.Pieza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas2021
 */
public class ClienteDAO {
    private static final String SQL_INSERT_CLIENTE1 = "INSERT INTO Cliente(nit,nombre,direccion,municipio,departamento)VALUES (?,?,?,?,?)";
    private static final String SQL_INSERT_CLIENTE2 = "INSERT INTO Cliente(nit,nombre,direccion)VALUES (?,?,?)";
    private static final String SQL_SELECT_CLIENTE = "SELECT * FROM Cliente WHERE nit = ?";
    
    public boolean encontrar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CLIENTE);
            stmt.setString(1, cliente.getNit());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nit = rs.getString("nit");
                if (nit.equals(cliente.getNit())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return false;
    }
    public int insertarCliente1(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CLIENTE1);
            stmt.setString(1,cliente.getNit());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3,cliente.getDireccion());
            stmt.setString(4, cliente.getMunicipio());
            stmt.setString(5, cliente.getDepartamento());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
    public int insertarCliente2(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CLIENTE1);
            stmt.setString(1,cliente.getNit());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3,cliente.getDireccion());
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
