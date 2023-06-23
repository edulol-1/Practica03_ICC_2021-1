/**
 * @author Eduardo Montaño Gomez
 * @version 1.0 Noviembre 2020
 * @since ICC laboratorio 2021-1 
 */

package src;
import java.util.regex.Pattern;

public class Analizador implements AnalizadorDeCadenas {
	
    /**
     * @param cadena la cadena a analizaar.
     * @param caracter el caracter a buscar.
     * @return la posicion de la primera aparcicion del caraccter en la cadena, -1 en otro caso.
     */
    @Override public int encuentraPosicion(String cadena, char caracter) {
        return cadena.indexOf(caracter);
    }

    /**
     * @param cadena la cadena a analizar.
     * @return true si la cadena es un número, false en otro caso.
     */
    @Override
    public boolean esNumero(String cadena) {
        boolean es_numero;
        if (cadena == null)
            es_numero = false;

        es_numero = Pattern.matches("-?\\d+(\\.\\d+)?", cadena);
        return es_numero;
    }

    /**
     * @param cadena la cadena a analizar.
     * @param reemplazado, el caracter reemplazado.
     * @param reemplazador el caracter que reemplazara a reemplazado.
     * @return El string resultante luego de realizar el reemplazamiento.
     */
    @Override
    public String reemplazaCaracter(String cadena, char reemplazado, char reemplazador) {
        return cadena.replace(reemplazado, reemplazador);
    }

    /**
     * @param cadena la cadena a analizar.
     * @return true si la cadena es palíndroma, false en otro caso.
     */
    @Override
    public boolean esPalindromo(String cadena) {
        var lowerCaseCadena = cadena.toLowerCase();
        var cadenaSinEspacios = lowerCaseCadena.replace(" ", "");
        var i = 0;
        var j = cadenaSinEspacios.length() - 1;
        while (i <= j) {
            if (cadenaSinEspacios.charAt(j--) != cadenaSinEspacios.charAt(i++))
                return false;
        }
        return true;
    }

    /**
     * @param cadena la cadena a revisar.
     * @param la cadena a revisar si está contenida.
     */
    @Override
    public boolean contiene(String cadena, String buscada) {
        return cadena.contains(buscada);
    }
}
