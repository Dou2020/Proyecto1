package domain;

import java.io.Serializable;

/**
 *
 * @author douglas2021
 */
public class Usuario implements Serializable{
    private String nombre;
    private String password;
    private int tipo;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(String nombre, String password, int tipo,boolean estado) {
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", password=" + password + ", tipo=" + tipo + '}';
    }
    
    
    
}
