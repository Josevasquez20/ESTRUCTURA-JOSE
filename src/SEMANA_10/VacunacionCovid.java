/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;

/**
 *
 * @author User
 */

import java.util.*;

// Clase principal que contiene la lógica del programa
public class VacunacionCovid {

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {

        // Genero un conjunto de 500 ciudadanos únicos
        Set<Ciudadano> todos = generarCiudadanos(500);

        // Selecciono aleatoriamente 75 ciudadanos para recibir la vacuna Pfizer
        Set<Ciudadano> pfizer = seleccionarVacunados(todos, 75);

        // Selecciono aleatoriamente 75 ciudadanos para recibir la vacuna AstraZeneca
        Set<Ciudadano> astraZeneca = seleccionarVacunados(todos, 75);

        // Creo un conjunto con los ciudadanos que recibieron ambas dosis (intersección)
        Set<Ciudadano> ambasDosis = new HashSet<>(pfizer);
        ambasDosis.retainAll(astraZeneca); // Conserva solo los que están en ambos conjuntos

        // Creo un conjunto con los ciudadanos vacunados solo con Pfizer
        Set<Ciudadano> soloPfizer = new HashSet<>(pfizer);
        soloPfizer.removeAll(astraZeneca); // Elimina los que también están en AstraZeneca

        // Creo un conjunto con los ciudadanos vacunados solo con AstraZeneca
        Set<Ciudadano> soloAstraZeneca = new HashSet<>(astraZeneca);
        soloAstraZeneca.removeAll(pfizer); // Elimina los que también están en Pfizer

        // Creo un conjunto con todos los ciudadanos vacunados (unión de ambos)
        Set<Ciudadano> vacunados = new HashSet<>(pfizer);
        vacunados.addAll(astraZeneca); // Agrega los de AstraZeneca al conjunto de Pfizer

        // Creo un conjunto con los ciudadanos que no fueron vacunados
        Set<Ciudadano> noVacunados = new HashSet<>(todos);
        noVacunados.removeAll(vacunados); // Elimina los vacunados del conjunto total


        System.out.println(" Ciudadanos NO vacunados:");
        noVacunados.forEach(System.out::println);


        System.out.println("\n Ciudadanos con ambas dosis:");
        ambasDosis.forEach(System.out::println);


        System.out.println("\n Ciudadanos vacunados SOLO con Pfizer:");
        soloPfizer.forEach(System.out::println);

        System.out.println("\n Ciudadanos vacunados SOLO con AstraZeneca:");
        soloAstraZeneca.forEach(System.out::println);
    }

    // Método que genera una cantidad determinada de ciudadanos con ID y nombre únicos
    public static Set<Ciudadano> generarCiudadanos(int cantidad) {
        Set<Ciudadano> ciudadanos = new HashSet<>();
        for (int i = 1; i <= cantidad; i++) {
            ciudadanos.add(new Ciudadano(i, "Ciudadano_" + i)); // Creo y agrega cada ciudadano
        }
        return ciudadanos; // Devuelvo el conjunto completo
    }

    // Método que selecciona aleatoriamente una cantidad de ciudadanos desde un conjunto base
    public static Set<Ciudadano> seleccionarVacunados(Set<Ciudadano> base, int cantidad) {
        List<Ciudadano> lista = new ArrayList<>(base); // Convierto el conjunto en lista
        Collections.shuffle(lista); // Mezcla aleatoriamente los elementos
        return new HashSet<>(lista.subList(0, cantidad)); // Devuelvo los primeros 'cantidad' elementos como conjunto
    }
}