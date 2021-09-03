package web;

import datos.CrearMuebleDAO;
import datos.FabricaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import datos.UsuarioDAO;
import datos.Utilidades;
import domain.Mueble;
import domain.Pieza;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet-Financiero")
public class servlet_financiero extends HttpServlet {

    private static boolean estado = false;
    UsuarioDAO usu = new UsuarioDAO();
    FabricaDAO p = new FabricaDAO();
    CrearMuebleDAO cm = new CrearMuebleDAO();
    Utilidades util = new Utilidades();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sesion = request.getSession();
        String keys = (String) sesion.getAttribute("keys");

        if (keys != null && keys.equals("1111")) {
            estado = true;
        }

        System.out.println(keys + " " + estado);
        if (estado) {
            String accion = (String) request.getParameter("accion");
            if (evaluar(accion)) {
                switch (accion) {
                    case "editarMueble":
                        this.editarMuebleRedi(request, response);
                        break;
                    case "eliminarMueble":
                        this.eliminarMueble(request, response);
                        break;
                    case "verPieza":
                        CargarPieza(request, response);
                        break;
                    case "editarUsuario":

                        break;
                    case "eliminarUsuario":
                        this.eliminarUsuario(request, response);
                        break;
                    case "modificarUser":
                        this.modificarUsuario(request, response);
                        break;
                    case "salir":
                        estado = util.accionDefault(request, response);
                        break;
                    default:
                        accionDefaul(request, response, true);
                        break;
                }
            } else {
                accionDefaul(request, response, true);
            }
        } else {
            estado = util.accionDefault(request, response);
        }
    }

    private void CargarPieza(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Pieza> piezas = p.listaPieza();
        System.out.println(piezas);
        HttpSession session = request.getSession();
        session.setAttribute("piezas", piezas);
        String url = "/WEB-INF/paginas/Usuario/contenidoNuevoUsuario.jsp";
        request.getRequestDispatcher(url).forward(request, response);
        System.out.println("ingreso a carga de pieza");
    }

    private void accionDefaul(HttpServletRequest request, HttpServletResponse response, boolean esta) throws IOException, ServletException {
        List<Mueble> muebles = cm.listaMueble();
        System.out.println(muebles);
        List<Usuario> usuarios = usu.lista();
        HttpSession session = request.getSession();
        session.setAttribute("usuarios", usuarios);
        session.setAttribute("muebles", muebles);
        if (esta) {
            System.out.println("ingreso al accion defaul");
            response.sendRedirect("financiero.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = (String) request.getParameter("accion");
        if (accion != null && estado) {
            switch (accion) {
                case "buscar":
                    break;
                case "editarMueble":
                    this.editarMueble(request, response);
                    break;
                case "ingresar":
                    ingresarUsuario(request, response);
                    break;
                case "ingresarMueble":
                    ingresarMueble(request, response);
                    break;
                default:
                    estado = util.accionDefault(request, response);
                    break;
            }
        } else {
            estado = util.accionDefault(request, response);
        }
    }
    private void eliminarMueble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombreMueble");
        System.out.println(nombre);
        if (evaluar(nombre)) {
            if (cm.encontrarMueble(nombre)) {
                cm.eliminarEnMueble(nombre);
                cm.eliminarMueble(nombre);
            }else{
                util.alerta(request, response, "No existe el Mueble "+nombre, "financiero.jsp");
            }
        }else{
            util.alerta(request, response, "No ingreso el Mueble a eliminar "+nombre,"financiero.jsp");
        }
        accionDefaul(request, response, true);
    }
    private List<Pieza> recuperarPiezas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Pieza> piezasMueble = new ArrayList<>();
        String nombre, cantidad;
        int contador = 1;
        do {
            nombre = request.getParameter("pieza" + contador);
            cantidad = request.getParameter("numero" + contador);
            System.out.println(contador + ". " + nombre + "  " + cantidad);
            if (evaluar(nombre) && evaluar(cantidad) && isNumeric(cantidad)) {
                int cantidadd = Integer.parseInt(cantidad);
                piezasMueble.add(new Pieza(nombre, cantidadd));
                contador++;
            }
        } while (nombre != null && cantidad != null);
        return piezasMueble;
    }
    private void ingresarMueble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pieza> piezasMueble = recuperarPiezas(request,response);
        String usuario = request.getParameter("usuario");
        String precio = request.getParameter("precio");
        
        if (evaluar(usuario) && evaluar(precio)) {
            double precioo = Double.parseDouble(precio); 
            if (!cm.encontrarMueble(usuario)) {
                cm.InsertarMueble(new Mueble(usuario,precioo));
                for (Pieza p : piezasMueble) {
                    if (p != null) {
                        cm.InsertarEnPieza(p, new Mueble(usuario, precioo));
                    }
                }
                util.alerta(request, response, "se ingreso el Mueble " + usuario, "financiero.jsp");
            }else{
                util.alerta(request, response, "Mueble ya existente modifiquelo", "financiero.jsp");
            }
        } else {
            util.alerta(request, response, "Error del Mueble mueble invalido o precio", "financiero.jsp");
        }
        accionDefaul(request, response, false);
    }
    private void editarMueble(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Pieza> piezasMueble = recuperarPiezas(request,response);
        String usuario = request.getParameter("nombreMueble");
        String precio = request.getParameter("precio");
        if (evaluar(usuario) && evaluar(precio)) {
            double precioo = Double.parseDouble(precio); 
            if (cm.encontrarMueble(usuario)) {
                cm.actualizarMueble(new Mueble(usuario,precioo));
                cm.eliminarEnMueble(usuario);
                for (Pieza p : piezasMueble) {
                    if (p != null) {
                        cm.InsertarEnPieza(p, new Mueble(usuario, precioo));
                    }
                }
                util.alerta(request, response, "se Modifico el Mueble " + usuario, "financiero.jsp");
            }else{
                util.alerta(request, response, "No existe creelo", "financiero.jsp");
            }
        }else {
            util.alerta(request, response, "Error del Mueble invalido o precio", "financiero.jsp");
        }
        accionDefaul(request, response, false);
    }
    private void editarMuebleRedi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombreMueble");
        if (evaluar(nombre)) {
            if (cm.encontrarMueble(nombre)) {
                Mueble mueble = cm.seleccionarMueble(nombre);
                List<Pieza> piezas = cm.listaEnMueble(nombre);
                List<Pieza> piezass = p.listaPieza();
                
                HttpSession session = request.getSession();
                session.setAttribute("mueble", mueble);
                session.setAttribute("piezass", piezas);
                session.setAttribute("piezas", piezass);
                String url = "/WEB-INF/paginas/Usuario/editarMueble.jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }
        }else{
            this.accionDefaul(request, response, true);
        }
        
    }
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("nombreUsuario");
        if (evaluar(usuario)) {
            int esta = usu.eliminar(new Usuario(usuario));
            util.alerta(request, response,esta+" Se elimino al usuario "+usuario, "financiero.jsp");
        } else {
            util.alerta(request, response,"Error al eliminar", "financiero.jsp");
        }
        this.accionDefaul(request, response, false);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.accionDefaul(request, response, true);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("idUser");
        String estado = request.getParameter("estado");
        boolean estados = false;
        if (evaluar(estado)) {
            if (estado.equals("true")) {
                estados = true;
            }
            System.out.println("usuario: " + usuario + " estatus: " + estado);
            usu.actualizarEstado(new Usuario(usuario, !estados));
        }

        this.accionDefaul(request, response, true);
    }

    private void ingresarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            if (password.equals(password2) && (5 < password.length())) {
                if (isNumeric(tipo)) {
                    int tip = Integer.parseInt(tipo);
                    if ((0 < tip) && (tip < 4)) {
                        Usuario usuarios = new Usuario(usuario, password, tip, estado);
                        if (!usu.encontrar(usuarios)) {
                            int rows = usu.Insertar(usuarios);
                            System.out.println("ingresados: " + rows + " " + usuarios);
                            util.alerta(request, response, "se ingreso el usuario: " + usuarios.getNombre(), "financiero.jsp");
                        } else {
                            System.out.println("ya hay un usuario");
                            util.alerta(request, response, "Ya existe el usuario", "financiero.jsp");
                        }
                    }
                }
            } else {
                System.out.println("contraseña incorrecta");
                util.alerta(request, response, "contraseña no valida tiene que ser mayor de 6", "financiero.jsp");
            }

        } else {
            System.out.println("no se ingreso");
            util.alerta(request, response, "No se ingreso el usuario", "financiero.jsp");
        }
        accionDefaul(request, response, false);
    }

    public static boolean isNumeric(String str) {//expresiones regulares
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    private boolean evaluar(String palabra) {

        if (palabra != null && !palabra.equals("")) {
            return true;
        }
        return false;
    }
}
