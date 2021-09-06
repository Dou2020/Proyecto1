/*
 * Objeto de cliente
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author douglas2021
 */
public class Cliente implements Serializable {
    private String nombre;
    private String nit;
    private String direccion;
    private String municipio;
    private String departamento;

    public Cliente(String nombre, String nit, String direccion, String municipio, String departamento) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public Cliente(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", nit=" + nit + ", direccion=" + direccion + ", municipio=" + municipio + ", departamento=" + departamento + '}';
    }
    
}
