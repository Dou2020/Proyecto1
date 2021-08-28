package datos;

import static datos.conexion.close;
import domain.Usuario;
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
public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM Usuario";
    private static final String SQL_SELECT_BY_ID = "SELECT nombre,passwordd,tipo,estado "
            +"FROM Usuario WHERE estado = ?";
    private static final String SQL_INSERT = "INSERT INTO Usuario(nombre,passwordd,tipo,estado)VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET passwordd = ?, tipo = ? estado = ? WHERE nombre = ?";
    private static final String SQL_UPDATE_ESTADO = "UPDATE Usuario SET estado = ? WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuario WHERE nombre = ?";
    
    // listar toda la base de datos 
    public List<Usuario> lista() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String password = rs.getString("passwordd");
                int tipo = rs.getInt("tipo");
                boolean estado = rs.getBoolean("estado");

                Usuario usuario = new Usuario(nombre, password, tipo,estado);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return usuarios;
    }
    public int Insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getTipo());
            stmt.setBoolean(4, usuario.isEstado());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }
   
    public boolean encontrar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            System.out.println("nombre_id: " + usuario.getNombre());
            stmt.setString(1, usuario.getNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                if (nombre.equalsIgnoreCase(usuario.getNombre())) {
                    return true;
                }
                
                System.out.println(rs.getRow()+" "+usuario);
            }
            return false;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.print("hay un error en encontrar ");
            System.out.println(usuario);
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return false;
    }
    public int actualizarEstado(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_ESTADO);
            stmt.setBoolean(1, usuario.isEstado());
            stmt.setString(2, usuario.getNombre());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }

    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getPassword());
            stmt.setInt(2, usuario.getTipo());
            stmt.setBoolean(3, usuario.isEstado());
            stmt.setString(4, usuario.getNombre());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return rows;
    }

    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getNombre());

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
