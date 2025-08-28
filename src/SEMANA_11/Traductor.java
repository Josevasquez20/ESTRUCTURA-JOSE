/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_11;
import java.util.*;
import java.util.Scanner; 
/**
 *
 * @author User
 */
import java.util.*; // Importa utilidades como Scanner y HashMap

public class Traductor { // Clase principal del programa

    // Diccionario que almacena pares español-inglés
    private static Map<String, String> diccionario = new HashMap<>();

    // Scanner para leer datos del usuario
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Carga palabras iniciales al diccionario
        inicializarDiccionario();

        int opcion; // Variable para almacenar la opción del menú

        // Bucle principal del menú
        do {
            mostrarMenu(); // Muestra las opciones disponibles
            opcion = leerEntero("Seleccione una opción: "); // Lee la opción elegida

            // Limpia el buffer para evitar que se salte la entrada de texto
            scanner.nextLine();

            // Ejecuta la acción según la opción seleccionada
            switch (opcion) {
                case 1 -> traducirFrase(); // Traduce una frase
                case 2 -> agregarPalabra(); // Permite agregar una nueva palabra
                case 0 -> System.out.println("¡Hasta pronto!"); // Finaliza el programa
                default -> System.out.println("Opción inválida. Intente de nuevo."); // Maneja errores de entrada
            }
        } while (opcion != 0); // Repite el menú hasta que el usuario elija salir
    }

    // Carga palabras base al diccionario
    private static void inicializarDiccionario() {
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

    // Muestra el menú principal
    private static void mostrarMenu() {
        System.out.println("\n==================== MENU ====================");
        System.out.println("1. Traducir una frase");
        System.out.println("2. Agregar palabras al diccionario");
        System.out.println("0. Salir");
    }

    // Traduce una frase ingresada por el usuario
    private static void traducirFrase() {
        System.out.print("Ingrese una frase en espaNol: ");
        String frase = scanner.nextLine().toLowerCase(); // Convierte la frase a minúsculas

        String[] palabras = frase.split("\\s+"); // Divide la frase en palabras

        StringBuilder traduccion = new StringBuilder(); // Construye la frase traducida

        for (String palabra : palabras) {
            // Elimina signos de puntuación para facilitar la búsqueda
            String limpia = palabra.replaceAll("[^a-záéíóúñ]", "");

            // Busca la traducción en el diccionario; si no existe, usa la palabra original
            String traduccionPalabra = diccionario.getOrDefault(limpia, palabra);

            // Añade la palabra traducida (o original) a la frase final
            traduccion.append(traduccionPalabra).append(" ");
        }

        // Muestra la frase traducida
        System.out.println("TraducciOn : " + traduccion.toString().trim());
    }

    // Permite al usuario agregar nuevas palabras al diccionario
    private static void agregarPalabra() {
        System.out.print("Ingrese la palabra en espaNol: ");
        String esp = scanner.nextLine().toLowerCase(); // Lee la palabra en español

        System.out.print("Ingrese su traducción al ingles: ");
        String ing = scanner.nextLine().toLowerCase(); // Lee la traducción al inglés

        diccionario.put(esp, ing); // Añade la nueva palabra al diccionario
        System.out.println("Palabra agregada exitosamente.");
    }

    // Método para leer números enteros con validación
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next(); // Descarta entrada inválida
        }
        return scanner.nextInt(); // Devuelve el número ingresado
    }
}