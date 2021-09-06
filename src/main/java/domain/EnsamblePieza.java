/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author douglas2021
 */
public class EnsamblePieza {
    private Mueble mueble;
    private Pieza pieza;

    public EnsamblePieza(Mueble mueble, Pieza pieza) {
        this.mueble = mueble;
        this.pieza = pieza;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
}
