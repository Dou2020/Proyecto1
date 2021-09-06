package datos;

import domain.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/lectura-archivo")
@MultipartConfig(location = "/tmp")// localizacion del archivo que se va a guardar temporalmente
public class LecturaArchivo extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        int longitud = (int) filePart.getSize();
        System.out.println(fileName + " tamaño de archivo: " + longitud + " " + filePart.getSubmittedFileName());
        InputStream fileContent = filePart.getInputStream();
        System.out.println("-----------------lectura-------------------");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(fileContent))) {
            String line = in.readLine();
            int total = 0;
            while (line != null) {
                lectura(line);
                line = in.readLine();
                total++;
            }
            System.out.println("------------------<" + total + ">-----------------------------");
            //String filePath = PATH + "/" + "archivo";
            //filePart.write(filePath);
            //request.getRequestDispatcher("result.jsp?path=" + filePath).forward(request, response);
        } catch (Exception ex) {
            System.out.println("error " + ex);
            // manejo de error
        }
        /*
        byte[] total = new byte[longitud + 1];

        int leidos = 0;
        while (leidos < longitud) {
            int n = fileContent.read(total, leidos, longitud + 1);
            System.out.println(n);
            if (n < 0) {
                break;
            }

            leidos += n;
        }
        fileContent.close();
        System.out.println(total.toString());
        String cadena = new String(total, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println(cadena);
         */
       insertarBaseDatos();
        HttpSession session = request.getSession();
        session.setAttribute("piezasR", piezas);
        session.setAttribute("mueblesR", muebles);
        session.setAttribute("usuariosR", usuarios);
        session.setAttribute("clientesR", clientes);
        session.setAttribute("error", error);
        response.sendRedirect("financiero.jsp");

    }
    private List<Cliente> clientes = new ArrayList<>();
    private List<Mueble> muebles = new ArrayList<>();
    private List<Pieza> piezas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<EnsamblePieza> enPieza = new ArrayList<>();
    private List<EnsambleMueble> enMueble = new ArrayList<>();
    private List<String> error = new ArrayList<>();
    private void insertarBaseDatos(){
        for (Cliente cliente: clientes) {
            if (!this.ingresarCliente(cliente)) {
                clientes.remove(cliente);
            }
        }
        for(Mueble mueble: muebles){
            if (!this.ingresarMueble(mueble)) {
                clientes.remove(mueble);
            }
        }
        for (Pieza pieza: piezas) {
            if (!this.ingresarPieza(pieza)) {
                piezas.remove(pieza);
            }
        }
        for (Usuario usuario: usuarios) {
            if (!this.ingresarUsuario(usuario)) {
                usuarios.remove(usuario);
            }
        }
        for (EnsamblePieza ensambleP: enPieza) {
            if (!this.ingresarEnPieza(ensambleP)) {
                enPieza.remove(ensambleP);
            }
        }
        for(EnsambleMueble ensambleMueble: enMueble){
            if (!this.ingresarEnMueble(ensambleMueble)) {
                enMueble.remove(ensambleMueble);
            }
        }
    }
    private void lectura(String cadena) {
        boolean estado = true;
        //expresiones regulares
        Pattern ENPIEZA = Pattern.compile("ENSAMBLE_PIEZAS\\([\"|“|”]([A-Za-z]+\\s?)+[\"|“|”]\\s?,\\s?[\"|“|”]([A-Za-z]+\\s?)+[\"|“|”]\\s?,\\s?\\d+\\)\\s?$");
        Pattern ENMUEBLE = Pattern.compile("ENSAMBLAR_MUEBLE\\([\"|“|”]([A-Za-z]+\\s*)+[\"|“|”]\\s?,\\s?[\"|“|”]([A-Za-z]+\\s*)+[\"|“|”]\\s?,\\s?[\"|“|”]\\d{2,2}/\\d{2,2}/\\d{4,4}[\"|“|”]\\)\\s?$");
        Pattern MUEBLE = Pattern.compile("MUEBLE\\([\"|“|”]([A-Za-z]+\\s?)+[\"|“|”],\\s?\\d*\\.?\\d+\\)\\s?$");
        Pattern PIEZA = Pattern.compile("PIEZA\\([\"|“|”]([A-Za-z]+\\s?)+[\"|“|”],\\d*\\.?\\d+\\)\\s?$");
        Pattern USUARIO = Pattern.compile("USUARIO\\([\"|“|”](\\w+\\s?)+[\"|“|”]\\s?,\\s?[\"|“|”]\\w{6,}[\"|“|”],\\d\\)\\s?$");
        Pattern CLIENTE = Pattern.compile("CLIENTE\\([\"|“|”]([A-Za-z]+\\s?)+[\"|“|”]\\s?,\\s?[\"|“|”]\\w+[\"|“|”]\\s?,\\s?[\"|“|”]\\w+\\s\\d+\\-\\d+\\szona\\s\\d[\"|“|”]\\s?,\\s?[\"|“|”][A-Za-z]+[\"|“|”]\\s?,\\s?[\"|“|”][A-Za-z]+[\"|“|”]\\s?\\)\\s?$");
        Pattern CLIENTE2 = Pattern.compile("CLIENTE\\([\"|“|”]([A-Za-z]+\\s?)+[\"|“|”]\\s?,\\s?[\"|“|”]\\w+[\"|“|”]\\s?,\\s?[\"|“|”][A-Za-z]+[\"|“|”]\\)\\s?$");
        //agrego las expreciones regulares al metodo que retornara un boolean
        Matcher cliente = CLIENTE.matcher(cadena);
        Matcher cliente2 = CLIENTE2.matcher(cadena);
        Matcher usuario = USUARIO.matcher(cadena);
        Matcher mueble = MUEBLE.matcher(cadena);
        Matcher pieza = PIEZA.matcher(cadena);
        Matcher enMueble = ENMUEBLE.matcher(cadena);
        Matcher enPieza = ENPIEZA.matcher(cadena);
        //evaluar
        if (cliente.matches()) {
            System.out.println(cadena);
            Cliente(partes(cadena));
            estado = false;
        }
        if (cliente2.matches()) {
            System.out.println(cadena);
            Cliente(partes(cadena));
            estado = false;
        }
        if (usuario.matches()) {
            System.out.println(cadena);
            Usuario(partes(cadena));
            estado = false;
        }
        if (mueble.matches()) {
            System.out.println(cadena);
            Mueble(partes(cadena));
            estado = false;
        }
        if (pieza.matches()) {
            System.out.println(cadena);
            Pieza(partes(cadena));
            estado = false;
        }
        if (enMueble.matches()) {
            System.out.println(cadena);
            enMueble(partes(cadena));
            estado = false;
        }
        if (enPieza.matches()) {
            System.out.println(cadena);
            enPieza(partes(cadena));
            estado = false;
        }
        if (estado) {
            error.add(cadena);
            System.out.println("No se acepto la cadena:  " + cadena);
        }
    }
    FabricaDAO f = new FabricaDAO();
    CrearMuebleDAO cm = new CrearMuebleDAO();
    UsuarioDAO usu = new UsuarioDAO();
    ClienteDAO cl = new ClienteDAO();

    private boolean ingresarMueble(Mueble mueble) {
        if (cm.encontrarMueble(mueble.getNombre())) {
            cm.InsertarMueble(mueble);
            return true;
        }
        return false;
    }

    private boolean ingresarPieza(Pieza pieza) {
        if (f.encontrarPieza(pieza.getNombre()) == null) {
            f.insertarPieza(pieza.getNombre());
            String nombre = f.encontrarPieza(pieza.getNombre());
            Pieza p = new Pieza(nombre, pieza.getCosto());
            f.insertarPrecio(p);
            return true;
        }
        return false;
    }

    private boolean ingresarUsuario(Usuario usuario) {
        if (!usu.encontrar(usuario)) {
            usu.Insertar(usuario);
            return true;
        }
        return false;
    }

    private boolean ingresarCliente(Cliente cliente) {
        if (!cl.encontrar(cliente)) {
            if (cliente.getDepartamento() != null) {
                cl.insertarCliente1(cliente);
            } else {
                cl.insertarCliente2(cliente);
            }
            return true;
        }
        return false;
    }

    private boolean ingresarEnPieza(EnsamblePieza pieza) {
        if (cm.encontrarMueble(pieza.getMueble().getNombre())) {
            if (f.encontrarPieza(pieza.getPieza().getNombre()) == null) {
                cm.InsertarEnPieza(pieza.getPieza(), pieza.getMueble());
                return true;
            }
        }
        return false;
    }

    private boolean ingresarEnMueble(EnsambleMueble mueble) {
        if (usu.encontrar(mueble.getUsuario())) {
            if (cm.encontrarMueble(mueble.getMueble())) {
                return true;
            }
        }
        return false;
    }

    private void enPieza(List<String> obj) {
        if (3 == obj.size()) {
            int cantidad = Integer.parseInt(obj.get(2));
            enPieza.add(new EnsamblePieza(new Mueble(obj.get(0)), new Pieza(obj.get(1), cantidad)));
        }

    }

    private void enMueble(List< String> obj) {
        if (3 == obj.size()) {
            enMueble.add(new EnsambleMueble(new Usuario(obj.get(1)), obj.get(0), obj.get(2)));
        }
    }

    private void Cliente(List<String> obj) {
        if (3 < obj.size()) {
            clientes.add(new Cliente(obj.get(0), obj.get(1), obj.get(2), obj.get(3), obj.get(4)));
        }
        if (3 == obj.size()) {
            clientes.add(new Cliente(obj.get(0), obj.get(1), obj.get(2)));
        }
    }

    private void Usuario(List<String> obj) {
        if (3 == obj.size()) {
            int tipo = Integer.parseInt(obj.get(2));
            usuarios.add(new Usuario(obj.get(0), obj.get(1), tipo));
        }
    }

    private void Pieza(List<String> obj) {
        if (2 == obj.size()) {
            double costo = Double.parseDouble(obj.get(1));
            piezas.add(new Pieza(obj.get(0), costo));
        }
    }

    private void Mueble(List<String> obj) {
        if (2 == obj.size()) {
            double costo = Double.parseDouble(obj.get(1));
            muebles.add(new Mueble(obj.get(0), costo));
        }
    }

    public List<String> partes(String cadena) {
        String a[] = cadena.split("\\(");
        String b[] = a[1].split("\\)");
        String c[] = b[0].split(",");
        List<String> datos = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
        for (String part : c) {
            String d = evaluar(part);
            System.out.println(d);
            if (part != null) {
                datos.add(d);
            } else {
                System.out.println("error en la cadena: " + cadena);
                return null;
            }
        }
        return datos;
    }

    public String evaluar(String part) {
        String d[] = part.split("\"");
        if (2 <= d.length) {
            return d[1];
        }
        d = part.split("”");
        if (3 == d.length) {

            return d[1];
        }
        if (2 == d.length) {
            System.out.println("evaluar letra cadena 1 " + d[0] + " largo de cadena " + d.length);
            String e[] = d[0].split("“");
            if (e.length == 2) {
                return e[1];
            }
            if (e.length == 1) {
                String f[] = d[1].split("“");
                return f[0];
            }
        }
        d = part.split("“");
        if (3 == d.length) {
            return d[1];

        }
        if (2 == d.length) {
            System.out.println("evaluar letra cadena 1 " + d[0] + " largo de cadena " + d.length);
            String e[] = d[0].split("”");
            if (e.length == 2) {
                return e[1];
            }
            if (e.length == 1) {
                String f[] = d[1].split("”");
                return f[0];
            }
        }
        String cd = "";
        for (int i = 0; i < part.length(); i++) {
            String parte = part.substring(i, i + 1);
            if (!parte.equals(" ")) {
                cd += parte;
            }
        }
        if (isNumeric(cd)) {
            return cd;
        }
        return null;
    }

    public static boolean isNumeric(String str) {//expresiones regulares
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
