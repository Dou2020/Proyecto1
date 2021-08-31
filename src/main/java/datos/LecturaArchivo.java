package datos;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/lectura-archivo")
@MultipartConfig
public class LecturaArchivo extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        //String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        int longitud = (int) filePart.getSize();
        System.out.println(fileName+" tamaño de archivo: "+longitud);
        InputStream fileContent = filePart.getInputStream();
        
        byte[] total = new byte[longitud+1];
        
        int leidos = 0;
        while (leidos < longitud) {
            int n = fileContent.read(total, leidos,longitud+1);
            System.out.println(n);
            if (n < 0)
                break;
            
            leidos += n;
        }
        fileContent.close();
        System.out.println(total.toString());
        String cadena = new String(total, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println(cadena);
    }
    
}
