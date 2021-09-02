
package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import datos.UsuarioDAO;
import datos.Utilidades;
import domain.Usuario;
import java.util.List;


@WebServlet("/servlet-Financiero")
public class servlet_financiero extends HttpServlet {
    private static boolean estado = false;
    UsuarioDAO usu = new UsuarioDAO();
    Utilidades util = new Utilidades();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession sesion = request.getSession();
        String keys = (String) sesion.getAttribute("keys");
        
        if (keys != null && keys.equals("1111"))
            estado = true;
        
        System.out.println(keys+" "+estado);
        if (estado) {
            String accion = (String) request.getParameter("accion");
            if (accion != null) {
                switch(accion){
                    case "editarUsuario":
                        
                        break;
                    case "eliminarUsuario":
                        this.eliminarUsuario(request, response);
                        break;
                    case "modificarUser":
                        this.modificarUsuario(request, response);
                        break;
                    case "salir":
                        estado = util.accionDefault(request,response);
                        break;
                    default:
                        accionDefaul(request,response,true);
                        break;
                }
            }else{
                accionDefaul(request,response,true);
            }
        }else{
            estado = util.accionDefault(request, response);
        }
    }
        
    private void accionDefaul(HttpServletRequest request, HttpServletResponse response, boolean esta) throws IOException, ServletException{
        List<Usuario>  usuarios = usu.lista();
        HttpSession session = request.getSession();
        session.setAttribute("usuarios", usuarios);
        if (esta) {
            System.out.println("ingreso al accion defaul");
                response.sendRedirect("financiero.jsp");
        }
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
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String usuario = request.getParameter("nombreUsuario");
        if (evaluar(usuario)) {
            int esta = usu.eliminar(new Usuario(usuario));
            System.out.print("eliminado "+esta);
            this.accionDefaul(request, response,true);
        }else{
            System.out.print("error");
            this.accionDefaul(request, response, true);   
        }
    }
    private void editarUsuario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }
    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String usuario = request.getParameter("idUser");
        String estado = request.getParameter("estado");
        boolean estados = false;
        if (evaluar(estado)) {
            if (estado.equals("true")) {estados = true;}
            System.out.println("usuario: "+usuario+" estatus: "+ estado);
            usu.actualizarEstado(new Usuario(usuario,!estados));
        }
       
        this.accionDefaul(request, response, true);
    }
    private void ingresarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String estad = request.getParameter("estado");
        String tipo = request.getParameter("tipo");
        boolean estado = false;
        if (estad != null && estad.equals("true")) {
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
                        util.alerta(request, response, "se ingreso el usuario: "+usuarios.getNombre(),"financiero.jsp");
                        }else{
                            System.out.println("ya hay un usuario");
                            util.alerta(request, response, "Ya existe el usuario", "financiero.jsp");
                        }
                    }
                }
            }else{
                System.out.println("contraseña incorrecta");
                util.alerta(request, response, "contraseña no valida", "financiero.jsp");
            }
               
        }else{
            System.out.println("no se ingreso");
            util.alerta(request, response, "No se ingreso el usuario", "financiero.jsp");
        }
        accionDefaul(request,response,false);
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
