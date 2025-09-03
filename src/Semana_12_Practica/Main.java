/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana_12_Practica;
import java.util.*;
/**
 *
 * @author User
 */
// Finalmente, en la clase principal probé toda la funcionalidad.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TorneoFutbol torneo = new TorneoFutbol();
        int opcion;   // Declaré una variable para controlar la opción seleccionada

        // Usé un bucle para mostrar el menú hasta que el usuario decida salir.
        do {
            // Mostré las opciones disponibles en el menú.
            System.out.println("\n MENU DEL TORNEO DE FÚTBOL");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Agregar jugador a equipo");
            System.out.println("3. Mostrar equipos y jugadores");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            // Leí la opción ingresada por el usuario.
            opcion = scanner.nextInt();
            scanner.nextLine(); 
 // Usé un switch para ejecutar la acción correspondiente según la opción seleccionada.
            switch (opcion) {
                case 1:
                    /// Si el usuario elige registrar un equipo, le pido el nombre y lo registro.
                    System.out.print("Nombre del equipo: ");
                    String nombreEquipo = scanner.nextLine();
                    torneo.registrarEquipo(nombreEquipo);
                    break;

                case 2:
                    // Si elige agregar un jugador, solicito el nombre del equipo, del jugador y su edad.
                    System.out.print("Nombre del equipo: ");
                    String equipo = scanner.nextLine();
                    System.out.print("Nombre del jugador: ");
                    String nombreJugador = scanner.nextLine();
                    System.out.print("Edad del jugador: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // Limpio el buffer
                    torneo.agregarJugador(equipo, new Jugador(nombreJugador, edad));
                    break;

                case 3:
                     // Si elige mostrar los equipos y jugadores, llamo al método correspondiente.
                    torneo.mostrarEquiposYJugadores();
                    break;

                case 4:
                    // Si elige salir, muestro un mensaje de despedida.
                    System.out.println(" Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    // Si el usuario ingresa una opción inválida, muestro una advertencia.
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 4);
    }
}

