/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_7;

/**
 *
 * @author User
 */
import java.util.Stack; // Importamos Stack para usar pilas
import java.util.Scanner; // Importamos Scanner para leer del teclado

public class TorresHanoi {
    
    // Creamos 3 pilas que representan las 3 torres
    static Stack<Integer> torreA = new Stack<>(); // Torre origen (izquierda)
    static Stack<Integer> torreB = new Stack<>(); // Torre auxiliar (centro)
    static Stack<Integer> torreC = new Stack<>(); // Torre destino (derecha)
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos scanner para leer del teclado
        
        System.out.print("¿Cuantos discos quiere usar? "); // Preguntamos cuántos discos
        int numDiscos = scanner.nextInt(); // Leemos el número de discos
        
        // Inicializamos la torre A con los discos (el más grande abajo)
        for (int i = numDiscos; i >= 1; i--) {
            torreA.push(i); // Agregamos discos del más grande al más pequeño
        }
        
        System.out.println("\nEstado inicial:"); // Mostramos el estado inicial
        mostrarTorres(); // Llamamos método para mostrar las torres
        
        System.out.println("\nResolviendo Torres de Hanoi...\n"); // Mensaje de inicio
        
        // Llamamos al método recursivo para resolver el problema
        hanoi(numDiscos, torreA, torreC, torreB); // Mover n discos de A a C usando B
        
        System.out.println("\n¡Problema resuelto!"); // Mensaje final
        scanner.close(); // Cerramos el scanner
    }
    
    // Método recursivo que resuelve las Torres de Hanoi
    public static void hanoi(int n, Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar) {
        
        if (n == 1) { // Caso base: si solo hay 1 disco
            int disco = origen.pop(); // Sacamos el disco de la torre origen
            destino.push(disco); // Lo ponemos en la torre destino
            System.out.println("Mover disco " + disco + " de " + nombreTorre(origen) + " a " + nombreTorre(destino)); // Mostramos el movimiento
            mostrarTorres(); // Mostramos el estado actual de las torres
            System.out.println(); // Línea en blanco para separar
        } else {
            // Paso 1: Mover n-1 discos de origen a auxiliar
            hanoi(n-1, origen, auxiliar, destino);
            
            // Paso 2: Mover el disco más grande de origen a destino
            int disco = origen.pop(); // Sacamos el disco más grande
            destino.push(disco); // Lo ponemos en destino
            System.out.println("Mover disco " + disco + " de " + nombreTorre(origen) + " a " + nombreTorre(destino)); // Mostramos el movimiento
            mostrarTorres(); // Mostramos el estado actual
            System.out.println(); // Línea en blanco
            
            // Paso 3: Mover n-1 discos de auxiliar a destino
            hanoi(n-1, auxiliar, destino, origen);
        }
    }
    
    // Método que devuelve el nombre de la torre
    public static String nombreTorre(Stack<Integer> torre) {
        if (torre == torreA) return "Torre A"; // Si es la torre A
        if (torre == torreB) return "Torre B"; // Si es la torre B
        return "Torre C"; // Si es la torre C
    }
    
    // Método que muestra el estado actual de las 3 torres
    public static void mostrarTorres() {
        System.out.println("Torre A: " + torreA); // Mostramos contenido de torre A
        System.out.println("Torre B: " + torreB); // Mostramos contenido de torre B
        System.out.println("Torre C: " + torreC); // Mostramos contenido de torre C
    }
}