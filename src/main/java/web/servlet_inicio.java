package web;

import datos.UsuarioDAO;
import domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author douglas2021
 */
@WebServlet("/servletInicio")
public class servlet_inicio extends HttpServlet {
    UsuarioDAO usuarioInteraccion = new UsuarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {

        } else {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("retorna");
            response.sendRedirect("inicio.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("usuario");
        String password = request.getParameter("password");
        if ((nombre != null) && (password != null)) {
            int a = validar(nombre,password); 
            switch (a) {
                case 1:
                    usuarioInteraccion.alerta(request,response,"Bienvenido al area Fincanciera: "+nombre,"financiero.jsp");
                    Puestos(request,response,nombre,"1111");
                    break;
                case 2:
                    usuarioInteraccion.alerta(request,response,"Bienvenido al area Ventas: "+nombre,"ventas.jsp");
                    Puestos(request,response,nombre,"3333");
                    break;
                case 3:
                    usuarioInteraccion.alerta(request,response,"Bienvenido al area Fabrica: "+nombre,"/proyecto1/servlet-Fabrica");
                    Puestos(request,response,nombre,"2222");
                    break;
                default:
                    System.out.println(" Error");
                    accionDefault(request,response,a);
                    break;
            }
        }else{
            response.sendRedirect("inicio.jsp");
        }
           

    }
    private void Puestos(HttpServletRequest request, HttpServletResponse response,String nombre,String key) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        sesion.setAttribute("nombre", nombre);
        sesion.setAttribute("keys",key);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response,int a) throws ServletException, IOException {
        // realiza el llamado de clientes de la base de datos 
        HttpSession sesion = request.getSession();
        sesion.setAttribute("retorna", "false");
        switch(a){
            case 0:
                usuarioInteraccion.alerta(request,response,"Usuario y password no encontrado","inicio.jsp");
                
                break;
            case 6:
                usuarioInteraccion.alerta(request,response,"password no encontrado","inicio.jsp");
                
                break;
            default:
                usuarioInteraccion.alerta(request,response,"error servlet","inicio.jsp");
                break;
        }
        
        response.sendRedirect("inicio.jsp");
        //este metodo es estatico y solo redireccioa a la pagina no cambi la url
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }

    private int validar(String nom, String pass) {
        List<Usuario> usuarios = usuarioInteraccion.lista();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre()+" "+usuario.getPassword());
            if (usuario.getNombre().equals(nom)) {
                if (usuario.getPassword().equals(pass) && usuario.isEstado()) {
                    return usuario.getTipo();
                }else{
                    return 6;
                }
            }
        }
        return 0;
    }

}
