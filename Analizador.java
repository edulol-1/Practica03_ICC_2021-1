/**
 * @author Eduardo Montaño Gomez
 * @version 1.0 Noviembre 2020
 * @since ICC laboratorio 2021-1 
 */

public class Analizador implements AnalizadorDeCadenas{

    public Analizador(){}//Es un constructor vacio para inicializar los obejtos
	
    //ACTIVIDAD 1
    @Override public int encuentraPosicion(String cadena, char c) {
	// posicion: el contador que se regresa.
	int posicion = 0;
	for (char c1 : cadena.toCharArray()) {
	    // Si el caracter coincide con con el parametro, se regresa esa posicion.
	    if (c1 == c)
		return posicion;
	    posicion++;
	}
	// Si niniguna coincidio, se regresa -1.
	return -1;
    }

    //ACTIVIDAD 2
    @Override
    public boolean esNumero(String cadena) {
	boolean numero = false;
	int numPuntos = 0;

	// Usamos for each, para una implementacion mas elegante.
	for (char caracter : cadena.toCharArray()) {
	    if (caracter == '.')
		numPuntos++;
	}
	
	//Valida si es que se han introducido mas de dos puntos
	if(numPuntos <= 1) {
	    for(char c : cadena.toCharArray()) {
		switch (c) {
		case('0'): numero = true;
		    break;
		case('1'): numero = true;
		    break;
		case('2'): numero = true;
		    break;
		case('3'): numero = true;
		    break;
		case('4'): numero = true;
		    break;
		case('5'): numero = true;
		    break;
		case('6'): numero = true;
		    break;
		case('7'): numero = true;
		    break;
		case('8'): numero = true;
		    break;
		case('9'): numero = true;
		    break;
		case('.'): numero = true;
		    break;
		default: numero = false;
		    break;
		}//Fin del switch

		if (numero == false)
		    break;
	    }
	}else {numero = false;}

	return numero;
    }

    //ACTIVIDAD 3
    @Override
    public String reemplazaCaracter(String cadena, char reemplazado, char reemplazador) {

	int i = 0;
	String cadenaModificada = "";//Declaramos una variable para almacenar la cadena modificada
	for (char caracter : cadena.toCharArray()) {
	    // Comparamos el i-esimo caracter con el remplazado.
	    if (caracter == reemplazado)
		// Si coincide con el parametro, agregamos el reemplazo.
		cadenaModificada += "" + reemplazador;
	    else
		// En otro caso, se agrega el caracter original.
		cadenaModificada += caracter;
	}
	return cadenaModificada;
    }

    //ACTIVIDAD 4
    @Override
    public boolean esPalindromo(String cadena) {
	String cadenaMinusculas = cadena.toLowerCase();
	String cadena2 = "";
	String cadena3 = "";
	boolean sonIguales = false;

	for(int i = 0; i < cadenaMinusculas.length(); i++) {
	    if (cadenaMinusculas.charAt(i) != ' ') {
		cadena2 += ""+cadenaMinusculas.charAt(i);
	    }
	}
		
	int i = 0;
	while(i<cadena2.length()){
	    cadena3 += "" + cadena2.charAt(cadena2.length()-i-1);
	    i++;
	}
	//Para este momento, cadena3 ya tiene lo que tenia cadena 2 pero al reves
	//Verificamos si la longitud de la cadena 2 es 0, si es cero, entonces es palindromo.
	if (cadena2.length() == 0) {
	    sonIguales = true;
	}else {
	    for(int j = 0; j<cadena2.length(); j++) {
			
		if(cadena2.charAt(j) == cadena3.charAt(j)) {
		    sonIguales = true;
		}else { 
		    sonIguales = false;
		    break;
		}
	    }
	}
	return sonIguales;
    }

    //ACTIVIDAD 5
    @Override
    public boolean contiene(String cadena, String buscada) {
	//Variable booleana para saber si lo contiene o no	
	boolean siContiene = false;
	//Preguntamos si es que la cadena buscada es mayor que la cadena contenedora.
	if (cadena.length() < buscada.length()) {
	    //si es mayor, entonces no puede estar contenida en otra mas pequena y por lotanto es falso
	    siContiene = false; 
	    System.out.println("La cadena buscada es mayor!!: ");
	}else {
	    //Hacemos un ciclo con la longitud de caracteres de la cadena contenedora	    
	    for (int i = 0; i<cadena.length(); i+=1) {
		//Verificamos si el caracter i-esimo de la cadena contenedora es igual al primer caracter de la cadena a buscar		
		if(cadena.charAt(i) == buscada.charAt(0)) {
		    if (cadena.substring(i).length() < buscada.length()) {
			siContiene = false;
			break;
		    }else {
			//Caso contrario, declaramos otra variable String local y le asignamos los caracteres de la cadena mayor, desde el caracter que coincidio hasta los que completen la longitud de la cadena buscada.
			String cadena2 = cadena.substring(i, i + buscada.length());
			//Verificamos si todos los caracteres coiniciden
			for(int j = 0; j<buscada.length(); j++){
			    //Si el i-esimo caracter coincide, entonces la variable siContiene se evalua a verdadero.			    
			    if(cadena2.charAt(j) == buscada.charAt(j)){
				siContiene = true;
				// Falso en otro caso.				
			    }else {
				siContiene = false;
				break;
			    }
			}
		    }
		}
	    }
	}
	return siContiene;
    }

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
	//System.out.println(analizador.esPalindromo("Anital avalatIna"));
	System.out.println(analizador.esPalindromo("oso baboso"));
	System.out.println(analizador.esPalindromo("o"));
	System.out.println(analizador.esPalindromo("Anita lava la tina"));
	System.out.println(analizador.esPalindromo("Oso baboso"));
	System.out.println(analizador.esPalindromo("Hola mundo"));
	//System.out.println(analizador.esPalindromo("dsfsdfdsreth"));
	System.out.println(analizador.esPalindromo(" "));
	//System.out.println(analizador.esPalindromo("Palabra de prueba"));
	System.out.println("------------------------------------------");
	///////////////////////////////////////
	///////// ACTIVIDAD 5//////////////////
	System.out.println(analizador.contiene("Hola mundo", "mundo"));
	System.out.println(analizador.contiene("Hola mundo", "oso"));
	System.out.println(analizador.contiene("Hola", "Hola mundo"));
	System.out.println(analizador.contiene("Hola mundo", "und"));
	System.out.println("------------------------------------------");
	///////////////////////////////////////

	//comentarios de ejemplo en la otra verion de mi proyecto con github
	// ESTA VERSION TIENE EL COMENTARIO DE ARRIBA ADICIONAL ADEMAS DE QUE NO TIENE NUMERO DE CUENTA
    }

}//Find de la clase
