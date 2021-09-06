package datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class conexion {
     //connectar a la base de datos y antes del ? ingresa la base de datos (nombre_base_datos?)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Proyect1?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //ingresa el usuario de la base de datos
    private static final String JDBC_USER = "UserProyecto1";
    //ingresa la contraseña de la base de datos
    private static final String JDBC_PASSWORD = "12345678";
    
    private static BasicDataSource dataSourse;
    
    
    public static DataSource getDataSource(){
        if (dataSourse == null) {
            dataSourse = new BasicDataSource();
            dataSourse.setUrl(JDBC_URL);
            dataSourse.setUsername(JDBC_USER);
            dataSourse.setPassword(JDBC_PASSWORD);
            dataSourse.setInitialSize(400);
        }
        return dataSourse;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement smtm){
        try {
            smtm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    //public static void close(Statement smtm) throws SQLException{
      //  smtm.close();
    //}
    public static void close(Connection smtm){
        try {
            smtm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
