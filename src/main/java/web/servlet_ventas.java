
package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import datos.UsuarioDAO;
import datos.Utilidades;
import domain.Usuario;

@WebServlet("/servletVentas")
public class servlet_ventas extends HttpServlet {
    private static boolean estado = false;
    UsuarioDAO usu = new UsuarioDAO();
    Utilidades util = new Utilidades();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession sesion = request.getSession();
        String keys = (String) sesion.getAttribute("keys");
        
        if (keys != null && keys.equals("2222"))
            estado = true;
        
        System.out.println(keys+" "+estado);
        if (estado) {
            String accion = (String) request.getParameter("accion");
            if (accion != null) {
                switch(accion){
                    case "salir":
                        estado = util.accionDefault(request,response);
                        break;
                    default:
                        accionDefaul(request,response);
                        break;
                }
            }else{
                accionDefaul(request,response);
            }
        }else{
            estado = util.accionDefault(request,response);
        }
    }
        
    private void accionDefaul(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.sendRedirect("ventas.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = (String) request.getParameter("accion");
        if (accion != null && estado) {
            switch(accion){
                case"buscar":
                    break;
                case "ingresar":
                    ingresarUsuario(request,response);
                    break;
                default:
                    estado = util.accionDefault(request,response);
                    break;
            }
        }else{
            estado = util.accionDefault(request,response);
        }
    }
    private void ingresarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String estad = request.getParameter("estado");
        String tipo = request.getParameter("tipo");
        boolean estado = false;
        if (estad.equals("true")) {
            estado = true;
        }
        if (evaluar(usuario) && evaluar(password) && evaluar(password2) && evaluar(tipo)) {
            if (password.equals(password2) && (5 < password.length()) ) {
                if (isNumeric(tipo)) {
                    int tip = Integer.parseInt(tipo);
                    if ((0<tip)&&(tip<4)) {
                       Usuario usuarios = new Usuario(usuario,password,tip,estado);
                        if (!usu.encontrar(usuarios)) {
                            int rows = usu.Insertar(usuarios);
                        System.out.println("ingresados: "+rows+" "+usuarios);
                        usu.alerta(request, response, "se ingreso el usuario: "+usuarios.getNombre(),"financiero.jsp");
                        }else{
                            System.out.println("ya hay un usuario");
                            usu.alerta(request, response, "Ya existe el usuario", "financiero.jsp");
                        }
                    }
                }
            }else{
                System.out.println("contrase??a incorrecta");
                usu.alerta(request, response, "contrase??a no valida", "financiero.jsp");
            }
               
        }else{
            System.out.println("no se ingreso");
            usu.alerta(request, response, "No se ingreso el usuario", "financiero.jsp");
        }
        accionDefaul(request,response);
    }
    public static boolean isNumeric(String str) {//expresiones regulares
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
    private boolean evaluar(String palabra){
        
        if (palabra != null && !palabra.equals("")) {
            return true;
        }
        return false;
    }
}
