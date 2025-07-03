/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_6;

/**
 *
 * @author User
 */
public class Busqueda {

    // Creo una clase interna Nodo para representar cada elemento de la lista
    class Nodo {
        int dato;           // Aquí guardo el valor del nodo
        Nodo siguiente;     // Referencia al siguiente nodo

        Nodo(int dato) {
            this.dato = dato;       // Asigno el dato al nodo
            this.siguiente = null;  // Inicializo la referencia al siguiente como nula
        }
    }

    Nodo cabeza = null; // Inicializo la cabeza de la lista

    // Método para agregar un nuevo dato a la lista
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato); // Creo un nuevo nodo con el valor ingresado
        if (cabeza == null) {
            cabeza = nuevo; // Si la lista está vacía, este nodo será la cabeza
        } else {
            Nodo actual = cabeza; // Inicio desde la cabeza
            while (actual.siguiente != null) {
                actual = actual.siguiente; // Recorro la lista hasta el último nodo
            }
            actual.siguiente = nuevo; // Conecto el nuevo nodo al final
        }
    }

    // Método para buscar cuántas veces aparece un valor en la lista
    public int buscar(int valor) {
        int veces = 0;           // Inicializo el contador de apariciones
        Nodo actual = cabeza;    // Inicio el recorrido desde la cabeza

        while (actual != null) {
            if (actual.dato == valor) {
                veces++; // Si el valor coincide, incremento el contador
            }
            actual = actual.siguiente; // Paso al siguiente nodo
        }

        if (veces == 0) {
            // Si no se encontró el valor, informo al usuario
            System.out.println("El dato " + valor + " no fue encontrado en la lista.");
        }

        return veces; // Retorno el número de veces que apareció el valor
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Busqueda lista = new Busqueda(); // Creo una instancia de la clase Busqueda

        // Agrego algunos elementos a la lista
        lista.agregar(3);
        lista.agregar(7);
        lista.agregar(3);
        lista.agregar(5);

        // Realizo una búsqueda de un valor presente
        int resultado = lista.buscar(3);
        System.out.println("El número 3 aparece " + resultado + " veces en la lista.");

        // Realizo una búsqueda de un valor que no está
        lista.buscar(9);
    }
}
