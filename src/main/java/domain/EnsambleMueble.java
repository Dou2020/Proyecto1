/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author douglas2021
 */
public class EnsambleMueble {
    private Usuario usuario;
    private String fecha;
    private String mueble;

    public EnsambleMueble(Usuario usuario, String mueble, String fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.mueble = mueble;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMueble() {
        return mueble;
    }

    public void setMueble(String mueble) {
        this.mueble = mueble;
    }
    
}
