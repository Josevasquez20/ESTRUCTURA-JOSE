/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author User
 */
public class Precios { // Declaro una clase pública llamada Precios

    private ArrayList<Integer> listaPrecios; // Aquí guardo todos los precios.

    public Precios() {
        listaPrecios = new ArrayList<>();
        // Agrego los precios a la lista.
        listaPrecios.add(50);
        listaPrecios.add(75);
        listaPrecios.add(46);
        listaPrecios.add(22);
        listaPrecios.add(80);
        listaPrecios.add(65);
        listaPrecios.add(8);
    }

    public void mostrarMayorYMenor() {
        // Uso Collections para encontrar el mayor y el menor valor de la lista.
        int mayor = Collections.max(listaPrecios);
        int menor = Collections.min(listaPrecios);

        System.out.println("El precio mayor es: " + mayor);
        System.out.println("El precio menor es: " + menor);
    }

    public static void main(String[] args) {
        Precios p = new Precios(); // Creo un objeto de mi clase Precios para poder usar sus métodos.
        p.mostrarMayorYMenor(); // Llamo al método que muestra los precios mayor y menor.
    }
}
