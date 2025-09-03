/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana_12_Practica;

/**
 *
 * @author User
 */
import java.util.*;

// Primero, definí la clase Jugador 
class Jugador {
    String nombre;
    int edad;

    // En el constructor, inicialicé el nombre y la edad del jugador.
    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrescribí el método toString para mostrar el jugador de forma legible.
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

// Luego, creé la clase TorneoFutbol para manejar el registro de equipos y jugadores.
class TorneoFutbol {
    // Usé un conjunto (Set) para almacenar los nombres de los equipos sin duplicados.
    Set<String> equipos = new HashSet<>();

    // Utilicé un mapa  para asociar cada equipo con su conjunto de jugadores.
    Map<String, Set<Jugador>> registro = new HashMap<>();

    // Este método permite registrar un nuevo equipo en el torneo.
    public void registrarEquipo(String nombreEquipo) {
        equipos.add(nombreEquipo); // Agrego el nombre al conjunto de equipos.
        registro.putIfAbsent(nombreEquipo, new HashSet<>()); // Inicializo su lista de jugadores.
    }

    // Este método agrega un jugador a un equipo ya registrado.
    public void agregarJugador(String equipo, Jugador jugador) {
        if (equipos.contains(equipo)) {
            registro.get(equipo).add(jugador); // Si el equipo existe, añado el jugador.
        } else {
            System.out.println("️ El equipo no esta registrado."); // Si no existe, muestro advertencia.
        }
    }

    // Este método imprime todos los equipos y sus respectivos jugadores.
    public void mostrarEquiposYJugadores() {
        for (String equipo : registro.keySet()) {
            System.out.println("Equipo: " + equipo);
            for (Jugador j : registro.get(equipo)) {
                System.out.println("  - " + j); // Muestro cada jugador del equipo.
            }
        }
    }
}

