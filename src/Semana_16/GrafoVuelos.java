/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana_16;

/**
 *
 * @author User
*/
import java.util.*;
// Importo las clases necesarias para manejar listas, mapas y colas de prioridad.

public class GrafoVuelos {
    // Declaro la clase principal que representa el grafo de vuelos entre ciudades.

    Map<String, List<Vuelo>> mapa = new HashMap<>();
    // Creo un mapa donde cada ciudad de origen se asocia con una lista de vuelos que salen desde ella.

    public void agregarVuelo(Vuelo vuelo) {
        // Este método me permite agregar un vuelo al grafo.

        mapa.putIfAbsent(vuelo.origen, new ArrayList<>());
        // Si la ciudad de origen no está en el mapa, la agrego con una lista vacía.

        mapa.get(vuelo.origen).add(vuelo);
        // Luego añado el vuelo a la lista correspondiente a esa ciudad.
    }

    public List<Vuelo> obtenerVuelosDesde(String ciudad) {
        // Este método devuelve la lista de vuelos que salen desde una ciudad específica.

        return mapa.getOrDefault(ciudad, new ArrayList<>());
        // Si no hay vuelos registrados desde esa ciudad, devuelvo una lista vacía.
    }

    // Clase interna para representar nodos en la búsqueda
    static class Nodo implements Comparable<Nodo> {
        // Defino una clase interna que representa cada ciudad como un nodo en el algoritmo de búsqueda.

        String ciudad;
        double costo;

        public Nodo(String ciudad, double costo) {
            // Constructor que inicializa el nombre de la ciudad y el costo acumulado para llegar a ella.
            this.ciudad = ciudad;
            this.costo = costo;
        }

        public int compareTo(Nodo otro) {
            // Comparo dos nodos según su costo, para que la cola de prioridad ordene por el más barato.
            return Double.compare(this.costo, otro.costo);
        }
    }

    // Algoritmo de Dijkstra para encontrar el vuelo más barato
    public double buscarVueloMasBarato(String origen, String destino) {
        // Este método implementa el algoritmo de Dijkstra para encontrar el costo mínimo entre dos ciudades.

        PriorityQueue<Nodo> cola = new PriorityQueue<>();
        // Uso una cola de prioridad para procesar primero los caminos más baratos.

        Map<String, Double> costos = new HashMap<>();
        // Creo un mapa para guardar el costo mínimo conocido para llegar a cada ciudad.

        cola.add(new Nodo(origen, 0.0));
        // Comienzo desde la ciudad de origen con costo cero.

        costos.put(origen, 0.0);
        // Registro que el costo para llegar al origen es cero.

        while (!cola.isEmpty()) {
            // Mientras haya ciudades por procesar en la cola…

            Nodo actual = cola.poll();
            // Tomo el nodo con menor costo acumulado.

            if (actual.ciudad.equals(destino)) return actual.costo;
            // Si ya llegué a la ciudad destino, devuelvo el costo total.

            for (Vuelo vuelo : obtenerVuelosDesde(actual.ciudad)) {
                // Recorro todos los vuelos que salen desde la ciudad actual.

                double nuevoCosto = actual.costo + vuelo.precio;
                // Calculo el nuevo costo acumulado si tomo ese vuelo.

                if (nuevoCosto < costos.getOrDefault(vuelo.destino, Double.MAX_VALUE)) {
                    // Si ese nuevo costo es menor al que tenía registrado para esa ciudad destino…

                    costos.put(vuelo.destino, nuevoCosto);
                    // Actualizo el costo mínimo para llegar a esa ciudad.

                    cola.add(new Nodo(vuelo.destino, nuevoCosto));
                    // Agrego esa ciudad a la cola para seguir explorando desde allí.
                }
            }
        }

        return -1; // No hay ruta disponible
        // Si no encuentro ninguna ruta hacia el destino, devuelvo -1 como indicador.
    }
}