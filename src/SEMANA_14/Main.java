/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_14;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Utilizo Scanner para leer datos 
        Scanner scanner = new Scanner(System.in);

        // Instancio mi árbol binario
        ArbolBinario arbol = new ArbolBinario();
        int opcion;

        // Uso un ciclo do-while para mostrar el menú hasta que el usuario decida salir.
        do {
            System.out.println("\n--- MENU ARBOL BINARIO ---");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Recorrido Inorden");
            System.out.println("3. Recorrido Preorden");
            System.out.println("4. Recorrido Postorden");
            System.out.println("5. Buscar elemento");
            System.out.println("6. Eliminar nodo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt(); 

            // Utilizo switch para ejecutar la acción correspondiente
            switch (opcion) {
                case 1:
                    // Inserto un nuevo valor en el árbol
                    System.out.print("Ingrese valor a insertar: ");
                    int valorInsertar = scanner.nextInt();
                    arbol.insertar(valorInsertar);
                    break;
                case 2:
                    // Muestro el recorrido inorden (izquierda, raíz, derecha).
                    arbol.inorden();
                    break;
                case 3:
                    // Muestro el recorrido preorden (raíz, izquierda, derecha).
                    arbol.preorden();
                    break;
                case 4:
                    // Muestro el recorrido postorden (izquierda, derecha, raíz).
                    arbol.postorden();
                    break;
                case 5:
                    // Permito buscar un valor en el árbol.
                    System.out.print("Ingrese valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    System.out.println(arbol.buscar(valorBuscar)
                        ? "Elemento encontrado."
                        : "Elemento no encontrado.");
                    break;
                case 6:
                    // Elimino un nodo del árbol si existe.
                    System.out.print("Ingrese valor a eliminar: ");
                    int valorEliminar = scanner.nextInt();
                    arbol.eliminar(valorEliminar);
                    break;
                case 0:
                    // Finalizo el programa.
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    // Manejo opciones inválidas.
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0); // El ciclo continúa hasta que se elija salir.

        scanner.close(); 
    }
}