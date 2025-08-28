/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_11;
import java.util.*;
/**
 *
 * @author User
 */
public class Traductor { // Clase principal del programa
      private static Map<String, String> diccionario = new HashMap<>(); // Diccionario español-inglés usando HashMap
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) { // Método principal donde inicia el programa
        inicializarDiccionario(); // Carga las palabras base al diccionario

        int opcion;
        do {
            mostrarMenu(); // Muestra el menú interactivo
            opcion = leerEntero("Seleccione una opcion: "); 

            switch (opcion) { // Evalúa la opción seleccionada
                case 1 -> traducirFrase(); //  traduce una frase
                case 2 -> agregarPalabra(); // permite agregar una palabra al diccionario
                case 0 -> System.out.println("¡Hasta pronto!"); // Si elige 0, finaliza el programa
                default -> System.out.println("Opción inválida. Intente de nuevo."); // Para opciones no válidas
            }
        } while (opcion != 0); // Repite el menú hasta que el usuario elija salir
    }

    private static void inicializarDiccionario() { // Método para cargar palabras iniciales
        diccionario.put("día", "day"); 
        diccionario.put("tiempo", "time");
        diccionario.put("persona", "person");
        diccionario.put("año", "year");
        diccionario.put("camino", "way");
        diccionario.put("forma", "way");
        diccionario.put("cosa", "thing");
        diccionario.put("hombre", "man");
        diccionario.put("mundo", "world");
        diccionario.put("vida", "life");
        diccionario.put("mano", "hand");
        diccionario.put("parte", "part");
        diccionario.put("niño", "child");
        diccionario.put("niña", "child");
        diccionario.put("ojo", "eye");
        diccionario.put("mujer", "woman");
        diccionario.put("lugar", "place");
        diccionario.put("trabajo", "work");
        diccionario.put("semana", "week");
        diccionario.put("caso", "case");
        diccionario.put("punto", "point");
        diccionario.put("tema", "point");
        diccionario.put("gobierno", "government");
        diccionario.put("empresa", "company");
        diccionario.put("compañía", "company");
    }

    private static void mostrarMenu() { // Muestra el menú principal
        System.out.println("\n==================== MENU ====================");
        System.out.println("1. Traducir una frase");
        System.out.println("2. Agregar palabras al diccionario");
        System.out.println("0. Salir");
    }

    private static void traducirFrase() { // Traduce una frase ingresada por el usuario
        System.out.print("Ingrese una frase en español: ");
        String frase = scanner.nextLine().toLowerCase(); // Convierte la frase a minúsculas
        String[] palabras = frase.split("\\s+"); // Divide la frase en palabras usando espacios

        StringBuilder traduccion = new StringBuilder(); // Construye la frase traducida
        for (String palabra : palabras) {
            String limpia = palabra.replaceAll("[^a-záéíóúñ]", ""); // Elimina signos de puntuación
            String traduccionPalabra = diccionario.getOrDefault(limpia, palabra); // Traduce si existe en el diccionario
            traduccion.append(traduccionPalabra).append(" "); // Añade la palabra traducida (o original) a la frase
        }

        System.out.println("Traducción parcial: " + traduccion.toString().trim()); // Muestra la frase traducida
    }

    private static void agregarPalabra() { // Permite al usuario añadir nuevas palabras al diccionario
        System.out.print("Ingrese la palabra en español: ");
        String esp = scanner.nextLine().toLowerCase(); // Lee la palabra en español
        System.out.print("Ingrese su traducción al inglés: ");
        String ing = scanner.nextLine().toLowerCase(); // Lee la traducción en inglés

        diccionario.put(esp, ing); // Añade la nueva palabra al diccionario
        System.out.println("Palabra agregada exitosamente."); // Confirma al usuario
    }

    private static int leerEntero(String mensaje) { // Método para leer números enteros con validación
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) { // Verifica si la entrada es un número
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next(); // Descarta la entrada inválida
        }
        return scanner.nextInt(); // Devuelve el número ingresado
    } 
}
