package domain;

import java.io.Serializable;

/**
 *
 * @author douglas2021
 */
public class Pieza implements Serializable {

    private String nombre;
    private int id;
    private double costo;
    private int cantidad;
    private String estado;

    public Pieza() {
    }

    public Pieza(String nombre, int cantidad, String estado) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Pieza(String nombre) {
        this.nombre = nombre;
    }

    public Pieza(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public Pieza(String nombre, double costo, int id) {
        this.nombre = nombre;
        this.id = id;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pieza{" + "nombre=" + nombre + ", id=" + id + ", costo=" + costo + ", cantidad=" + cantidad + ", estado=" + estado + '}';
    }
    
}
