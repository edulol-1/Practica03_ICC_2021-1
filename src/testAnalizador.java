/**
 * Some basics test. This are not formal unit tests.
*/
package src;
import src.Analizador;

public class testAnalizador {
    public static void main(String[] args) {
	Analizador analizador = new Analizador();

	////////// ACTIVIDAD 1//////////////////
	System.out.println("Posicion: " + analizador.encuentraPosicion("Esta es una palabra de prueba”,",'e'));
	System.out.println("Posicion: " + analizador.encuentraPosicion("Esta es una palabra de prueba”,",'E'));
	System.out.println("Posicion: " + analizador.encuentraPosicion("Esta es una palabra de prueba”,",'z'));
	System.out.println("Posicion: " + analizador.encuentraPosicion("Esta es una palabra de prueba”,",'u'));
	////////////////////////////////////////
	////////// ACTIVIDAD 2//////////////////
	System.out.println("------------------------------------------");
	System.out.println(analizador.esNumero("Texto"));
	System.out.println(analizador.esNumero("133"));
	System.out.println(analizador.esNumero("12.44"));
	System.out.println(analizador.esNumero("12.44.3.2"));
	System.out.println(analizador.esNumero("1233texto42"));
	System.out.println("------------------------------------------");
	////////////////////////////////////////
	///////// ACTIVIDAD 3//////////////////
	System.out.println(analizador.reemplazaCaracter("Hola Mundo",'o', 'i'));
	System.out.println(analizador.reemplazaCaracter("Palabra de prueba",'a', 'o'));
	System.out.println(analizador.reemplazaCaracter("Palabra de prueba",'P', 'H'));
	System.out.println(analizador.reemplazaCaracter("Palabra de prueba",'p', 'w'));
	System.out.println(analizador.reemplazaCaracter("Palabra de prueba",' ', '_'));
	System.out.println(analizador.reemplazaCaracter("Palabra de prueba",' ', '\0'));
	System.out.println("------------------------------------------");
	///////////////////////////////////////
	///////// ACTIVIDAD 4//////////////////
	System.out.println(analizador.esPalindromo("Anital avalatIna"));
	System.out.println(analizador.esPalindromo("oso baboso"));
	System.out.println(analizador.esPalindromo("o"));
	System.out.println(analizador.esPalindromo("Anita lava la tina"));
	System.out.println(analizador.esPalindromo("Oso baboso"));
	System.out.println(analizador.esPalindromo("Hola mundo"));
	System.out.println(analizador.esPalindromo(" "));
	System.out.println("------------------------------------------");
	///////////////////////////////////////
	///////// ACTIVIDAD 5//////////////////
	System.out.println(analizador.contiene("Hola mundo", "mundo"));
	System.out.println(analizador.contiene("Hola mundo", "oso"));
	System.out.println(analizador.contiene("Hola", "Hola mundo"));
	System.out.println(analizador.contiene("Hola mundo", "und"));
	System.out.println("------------------------------------------");
	///////////////////////////////////////
    }
}
