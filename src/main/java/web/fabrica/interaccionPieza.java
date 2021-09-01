package web.fabrica;

import domain.Pieza;
import java.util.List;

public class interaccionPieza {

    public List<Pieza> contarPieza(List<Pieza> pieza, List<Pieza> piezas) {
        for (int i = 0; i < pieza.size(); i++) {
            int contador = 0;
            for (int j = 0; j < piezas.size(); j++) {
                if (pieza.get(i).getNombre().equalsIgnoreCase(piezas.get(j).getNombre())) {
                    contador++;
                }
            }
            pieza.set(i, new Pieza(pieza.get(i).getNombre(), contador, evaluarEstado(contador)));
        }
        return pieza;
    }

    public List<Pieza> ordenarPieza(List<Pieza> pieza, boolean esta) {

        Pieza mayor;
        int numMayor;
        for (int i = 0; i < pieza.size(); i++) {
            for (int j = 0; j < pieza.size(); j++) {
                numMayor = j + 1;
                if (numMayor < pieza.size()) {
                    if (esta) {
                        if (pieza.get(j).getCantidad() < pieza.get(numMayor).getCantidad()) {
                            mayor = pieza.get(j);
                            pieza.set(j, pieza.get(numMayor));
                            pieza.set(numMayor, mayor);
                        }
                    } else {
                        if (pieza.get(j).getCantidad() > pieza.get(numMayor).getCantidad()) {
                            mayor = pieza.get(j);
                            pieza.set(j, pieza.get(numMayor));
                            pieza.set(numMayor, mayor);
                        }
                    }
                }
            }
        }
        return pieza;
    }

    private String evaluarEstado(int contador) {
        if (contador == 0) {
            return "Agotado";
        }
        if (contador < 4) {
            return "Agotarse";
        }
        return "---------";
    }

    public static boolean isNumeric(String str) {//expresiones regulares
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }

    public boolean evaluar(String palabra) {

        if (palabra != null && !palabra.equals("")) {
            return true;
        }
        return false;
    }
}
