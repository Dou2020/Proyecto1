
package web;

import datos.FabricaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import datos.Utilidades;
import domain.Pieza;
import java.util.List;

@WebServlet("/servlet-Fabrica")
public class servlet_fabrica extends HttpServlet {
    private static boolean estado = false;
    Utilidades util = new Utilidades();
    FabricaDAO usu = new FabricaDAO();
    
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
                    case "editar":
                        this.pestanaEditarPieza(request, response);
                        break;
                    default:
                        accionDefaul(request,response,true);
                        break;
                }
            }else{
                accionDefaul(request,response,true);
            }
        }else{
            estado = util.accionDefault(request,response);
        }
    }
        
    private void accionDefaul(HttpServletRequest request, HttpServletResponse response, boolean esta) throws IOException, ServletException{
        List<Pieza> piezas = usu.listaPrecio();
        System.out.println("piezas= "+piezas);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("piezas", piezas);
        if (esta) {
            System.out.println("ingreso a fabrica "+ esta);
            response.sendRedirect("fabrica.jsp");
        }
        System.out.println("ingreso aqui accionDefaul");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = (String) request.getParameter("accion");
        boolean esta = false;
        if (accion != null && estado) {
            switch(accion){
                case"buscar":
                    break;
                case "ingresar":
                    this.ingresarPieza(request,response,esta);
                    break;
                case "modificar":
                    this.editarPieza(request, response);
                    break;
                default:
                    estado = util.accionDefault(request,response);
                    break;
            }
        }else{
            estado = util.accionDefault(request,response);
        }
    }
    private void editarPieza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idPieza = request.getParameter("idPieza");
        String nombre = request.getParameter("nombre");
        String costo = request.getParameter("saldo");
        if (this.evaluar(nombre) && this.evaluar(idPieza) && this.evaluar(costo)) {
            if (isNumeric(costo)) {
                double cost = Double.parseDouble(costo);
                if (usu.encontrarPieza(nombre) == null) {
                    usu.insertarPieza(nombre);
                }else{
                    nombre = usu.encontrarPieza(nombre);
                }
                Pieza pieza = new Pieza(nombre,cost);
                int rows = usu.modificarPrecio(pieza);
                this.accionDefaul(request, response,false);
                util.alerta(request, response,"Se Modifico la pieza "+rows+" "+pieza.getNombre(),"fabrica.jsp?opcion=2");
            }
        }
    }
    private void pestanaEditarPieza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idPieza = request.getParameter("idPieza");
        if (isNumeric(idPieza)) {
            int id = Integer.parseInt(idPieza);
            Pieza pieza = usu.encontrarPrecio(id);
            HttpSession session = request.getSession();
            session.setAttribute("pieza", pieza);
            String url = "/WEB-INF/paginas/Fabrica/editarPieza.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }else{
            this.accionDefaul(request, response,true);
        }
        
    }
    private void ingresarPieza(HttpServletRequest request, HttpServletResponse response,boolean esta) throws ServletException, IOException{
        String pieza = request.getParameter("pieza");
        String precio = request.getParameter("precio");
        String tipo = request.getParameter("cantidad");
        
        if (evaluar(pieza) && evaluar(precio) && evaluar(tipo)) {
                if (isNumeric(tipo)) {
                    int tip = Integer.parseInt(tipo);
                    if (0<tip) {
                        boolean es = false;
                        for (int i = 0; i < tip; i++) {
                            if(usu.encontrarPieza(pieza) == null) {
                                usu.insertarPieza(pieza);
                            }else{
                                pieza = usu.encontrarPieza(pieza);
                            }
                            if (isNumeric(precio)) {
                                double precioo = Double.parseDouble(precio);
                                Pieza piez = new Pieza(pieza,precioo);
                                usu.insertarPrecio(piez);
                                es = true;
                            }else{
                                util.alerta(request, response, "Precio incorrecto no es un numero", "fabrica.jsp");
                            }
                                
                        }
                        if (es) {
                            System.out.println("Ingreso la pieza "+pieza);
                            accionDefaul(request,response, esta);
                            util.alerta(request, response, "Ingreso la pieza"+pieza+" "+tipo, "fabrica.jsp");
                            
                        }
                    }else{
                        System.out.println("no se ingreso cantidad menor a 0");
                        util.alerta(request, response, "No se ingreso cantidad menor a 0", "fabrica.jsp");
                    }
                }
        }else{
            System.out.println("no se ingreso");
            util.alerta(request, response, "No se ingreso el usuario", "fabrica.jsp");
        }
        accionDefaul(request,response,esta);
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
