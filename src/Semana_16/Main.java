/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Semana_16;

/**
 *
 * @author User
 */
public class Main {
    // Declaro la clase principal del programa, donde se ejecuta el método main.

    public static void main(String[] args) {
        // Este es el punto de entrada del programa. Aquí comienza la ejecución.

        GrafoVuelos grafo = new GrafoVuelos();
        // Creo una instancia del grafo de vuelos, que me permitirá organizar y buscar rutas entre ciudades.

        // Carga manual de vuelos 
        grafo.agregarVuelo(new Vuelo("Quito", "Bogotá", 120.0));
        // Agrego un vuelo desde Quito a Bogotá con un precio de $120.

        grafo.agregarVuelo(new Vuelo("Quito", "Lima", 150.0));
        // Agrego un vuelo directo desde Quito a Lima por $150.

        grafo.agregarVuelo(new Vuelo("Bogotá", "Lima", 100.0));
        // Agrego un vuelo desde Bogotá a Lima por $100, lo que permite una ruta alternativa desde Quito pasando por Bogotá.

        grafo.agregarVuelo(new Vuelo("Lima", "Santiago", 130.0));
        // Agrego un vuelo desde Lima a Santiago por $130, ampliando la red de destinos.

        // Búsqueda de ruta más barata
        String origen = "Quito";
        // Defino la ciudad de origen como Quito.

        String destino = "Argentina";
        // Defino la ciudad de destino como Lima.

        double precio = grafo.buscarVueloMasBarato(origen, destino);
        // Llamo al método del grafo para buscar el precio más barato entre Quito y Lima.

        if (precio != -1) {
            // Si se encontró una ruta válida…

            System.out.println("Precio más barato de " + origen + " a " + destino + ": $" + precio);
            // Imprimo el precio más barato encontrado en consola.
        } else {
            System.out.println("No hay ruta disponible entre " + origen + " y " + destino);
            // Si no se encontró ninguna ruta, informo al usuario.
        }
    }
}