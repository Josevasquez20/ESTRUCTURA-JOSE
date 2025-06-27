/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5; 

import java.util.ArrayList; // Importo la clase ArrayList para poder usar listas dinámicas.
import java.util.Collections; // Importo la clase Collections para poder invertir la lista fácilmente.

public class numero_inverso { // Declaro mi clase pública llamada numero_inverso.

    private ArrayList<Integer> numeros; // Declaro una lista privada 

    public numero_inverso() { // Este es mi constructor
        numeros = new ArrayList<>(); // Inicializo la lista vacía.
        for (int i = 1; i <= 10; i++) { // Recorro los números del 1 al 10.
            numeros.add(i); // En cada vuelta, agrego el número actual a la lista.
        }
    }

    public void mostrarInverso() { // Este es mi método para mostrar los números en orden inverso.
        Collections.reverse(numeros); // Invierto el orden de los elementos en la lista.
        for (int i = 0; i < numeros.size(); i++) { // Recorro todos los elementos ya invertidos.
            System.out.print(numeros.get(i)); // Imprimo el número actual.
            if (i < numeros.size() - 1) { 
                System.out.print(", "); 
            }
        }
        System.out.println(); 
    }

    public static void main(String[] args) { // Este es el método principal desde donde arranca el programa.
        numero_inverso obj = new numero_inverso(); // Creo un objeto de mi clase para usar sus métodos.
        obj.mostrarInverso(); // Llamo al método que muestra los números en orden inverso.
    }
}