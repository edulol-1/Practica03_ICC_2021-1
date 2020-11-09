/**
* @author Eduardo Montaño Gomez
* @version 1.0 Noviembre 2020
* NUmero de cuenta: 421005183
* @since ICC laboratorio 2021-1 
*/

public class Analizador implements AnalizadorDeCadenas{

	public Analizador(){}//Es un constructor vacio para inicializar los obejtos
	
	//ACTIVIDAD 1
	@Override	
	public int encuentraPosicion(String cadena, char c) {
		int posicion = 0;
		for(int i = 0; i<cadena.length(); i++) {
			char c1 = cadena.charAt(i);//Declaramos una variable local de tipo char en cada iteracion, donde la variable guarda el caracter i-esimo caracter de la cadena
			if (c1 == c) {
				posicion = i;
				break; //Uso break para que no siga iterando
			}else { posicion = -1; }
		}
		System.out.println("Entrada: " + cadena + ", caracter: " + c + ", " + "primer posicion donde se encuentra: " + posicion);
		//System.out.println("caracter a buscar: " + c);
		return posicion;
	}

	//ACTIVIDAD 2
	@Override
	public boolean esNumero(String cadena) {
		boolean numero = false;
		int numPuntos = 0;

		for(int i = 0; i<cadena.length(); i++) {
			if(cadena.charAt(i) == '.')
				numPuntos+= 1;//Va acumulando la cantidad de puntos del String
		}

		if(numPuntos <= 1) {//Valida si es que se han introducido mas de dos puntos
			for(int i = 0; i<cadena.length(); i+=1) {

				switch (cadena.charAt(i)) {
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
		System.out.println("Entrada: " + cadena + ", ¿Es numero?: " + numero);
		return numero;
	}

	//ACTIVIDAD 3
	@Override
	public String reemplazaCaracter(String cadena, char reemplazado, char reemplazador) {

		int i = 0;
		String cadenaModificada = "";//Declaramos una variable para almacenar la cadena modificada
		while (i<cadena.length()) {
			if (cadena.charAt(i) == reemplazado) {//Comparamos el caracter i con el reemplazado
				cadenaModificada += "" + reemplazador; //Si es cierto, a la cadena modificada le concatenamos el caracter reemplazador
			}else {
				cadenaModificada += "" + cadena.charAt(i);//Si no es igual, le concatenamos el caracter i-esimo de la cadena original
			}
			i++;//Sumamos 1 a i
		}
		System.out.println("Entrada: " + cadena + ", caracter a reemplazar: " + reemplazado + ", caracter remplazador: " + reemplazador + ", salida: " + cadenaModificada);
		return cadenaModificada;
	}

	//ACTIVIDAD 4
	@Override
	public boolean esPalindromo(String cadena) {
		String cadenaMinusculas = cadena.toLowerCase();
		String cadena2 = "";
		String cadena3 = "";
		boolean sonIguales = false;

		for(int i = 0; i<cadenaMinusculas.length(); i++) {
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
		System.out.println("Entrada: " + cadena + ", salida: " + sonIguales);
		return sonIguales;
	}

	//ACTIVIDAD 5
	@Override
	public boolean contiene(String cadena, String buscada) {
		//System.out.println(buscada.charAt(0));
		boolean siContiene = false;//Variable booleana para saber si lo contiene o no
		if (cadena.length() < buscada.length()) {//Preguntamos si es que la cadena buscada es mayor que la cadena contenedora
			siContiene = false; //si es mayor, entonces no puede estar contenida en otra mas pequena y por lotanto es falso
			System.out.println("La cadena buscada es mayor!!: ");
		}else { //Si la cadena a buscar no es mas grande, entonces
			for (int i = 0; i<cadena.length(); i+=1) {//Hacemos un ciclo con la longitud de caracteres de la cadena contenedora
				if(cadena.charAt(i) == buscada.charAt(0)) {//Verificamos si el caracter i-esimo de la cadena contenedora es igual al primer caracter de la cadena a buscar
					if (cadena.substring(i).length() < buscada.length()) {
							siContiene = false;
							break;
					}else {
						String cadena2 = cadena.substring(i, i + buscada.length());//Si coincide, declaramos otra vairable String local y le asignamos los caracteres de la cadena mayor, desde el caracter que coincidio hasta los que completen la longitud de la cadena buscada

						for(int j = 0; j<buscada.length(); j++){//Hacemos otro for, en este verificamos si todos los caracteres coiniciden
							if(cadena2.charAt(j) == buscada.charAt(j)){//Si el i-esimo caracter coincide, entonces la variable siContiene se evalua a verdadero.
								siContiene = true;
							}else {//Si no lo contiene, entonces es falso siContiene
								siContiene = false;//Si un caracter no coincide, la variable siContiene es falsa.
								break;//Con que un caracter sea falso basta para que las dos cadenas no sean iguales, y hace un break para salir del for
							}
						}
					}
				}
			}
		}
		System.out.println("Entrada 1: " + cadena + ", entrada 2: " + buscada + ", salida: " + siContiene);
		return siContiene;
	}

	public static void main(String[] args) {
		Analizador analizador = new Analizador();


		////////// ACTIVIDAD 1//////////////////
		System.out.println("\t\tACTIVIDAD 1" + "\n\n");
		System.out.println(analizador.encuentraPosicion("Esta es una palabra de prueba”,",'e'));
		System.out.println(analizador.encuentraPosicion("Esta es una palabra de prueba”,",'E'));
		System.out.println(analizador.encuentraPosicion("Esta es una palabra de prueba”,",'z'));
		System.out.println(analizador.encuentraPosicion("Esta es una palabra de prueba”,",'u'));
		////////////////////////////////////////
		////////// ACTIVIDAD 2//////////////////
		System.out.println("------------------------------------------");
		System.out.println("\t\tACTIVIDAD 2" + "\n\n");
		System.out.println(analizador.esNumero("Texto"));
		System.out.println(analizador.esNumero("133"));
		System.out.println(analizador.esNumero("12.44"));
		System.out.println(analizador.esNumero("12.44.3.2"));
		System.out.println(analizador.esNumero("1233texto42"));
		System.out.println("------------------------------------------");
		////////////////////////////////////////
		///////// ACTIVIDAD 3//////////////////
		System.out.println("\t\tACTIVIDAD 3" + "\n\n");
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
		System.out.println("\t\tACTIVIDAD 4" + "\n\n");
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
		System.out.println("\t\tACTIVIDAD 5" + "\n\n");
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