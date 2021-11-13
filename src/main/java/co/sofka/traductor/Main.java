package co.sofka.traductor;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Diccionario diccionario = new Diccionario();

        int opcion = 0;
        boolean deseaSalir = false;

        System.out.println("Bienvenido a la APP diccionario! ¿Qué deseas hacer?");

        while (!deseaSalir) {
            System.out.println("1. Mostrar todas las palabras registradas en el diccionario");
            System.out.println("2. Buscar el significado en inglés de una palabra en castellano");
            System.out.println("3. Ingresar una nueva palabra y su significado");
            System.out.println("4. Salir");

            System.out.println("Selecciona lo que deseas hacer");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Estan son las palabras registradas");
                    diccionario.mostarPalabrasRegistradas();
                    break;
                case 2:
                    System.out.println("Ingresa la palabra a buscar");
                    String palabraBuscar = scanner.next();
                    diccionario.mostrarPalabraSignificadoIngles(palabraBuscar);
                    break;
                case 3:
                    System.out.println("ingresa la palabra en castellano");
                    String palabraCastellano = scanner.next();
                    System.out.println("ingresa la palabra en inglés");
                    String palabraIngles = scanner.next();
                    diccionario.insertarNuevaPalabra(palabraCastellano, palabraIngles);
                    break;
                case 4:
                    System.out.println("Gracias por utilizar este programa, nos vemos luego");
                    deseaSalir = true;
                    break;
                default:
                    System.out.println("Ingresa una opción valida");
            }
        }

        scanner.close();
    }
}
