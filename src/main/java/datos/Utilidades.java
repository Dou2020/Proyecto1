/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author douglas2021
 */
public class Utilidades {
    
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
    public boolean accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        boolean estado = false;
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("keys");
        sesion.removeAttribute("retorna");
        sesion.removeAttribute("nombre");
        response.sendRedirect("inicio.jsp");
        return estado;
    }
    
}
