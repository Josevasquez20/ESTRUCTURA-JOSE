/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_6;

/**
 *
 * @author User
 */
public class Lista {

    // Defino la clase Nodo para representar cada elemento de la lista
    class Nodo {
        int dato;           // Aquí guardo el valor del nodo
        Nodo siguiente;     // Referencia al siguiente nodo

        public Nodo(int dato) {
            this.dato = dato;       // Inicializo el dato del nodo
            this.siguiente = null;  
        }
    }

    Nodo cabeza; // Este será el primer nodo de la lista

    // Método para agregar un nuevo nodo al final de la lista
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato); // Creo el nodo nuevo con el dato dado
        if (cabeza == null) {
            cabeza = nuevo; // Si la lista está vacía, el nuevo será la cabeza
        } else {
            Nodo temp = cabeza; // Comienzo desde la cabeza
            while (temp.siguiente != null) {
                temp = temp.siguiente; // Recorro la lista hasta el último nodo
            }
            temp.siguiente = nuevo; // Conecto el último nodo con el nuevo
        }
    }

    // Método para invertir la lista
    public void invertir() {
        Nodo anterior = null;      // El nodo anterior empieza como null
        Nodo actual = cabeza;      // Comienzo desde la cabeza
        Nodo siguiente = null;     // Nodo para guardar el siguiente temporalmente

        while (actual != null) {               // Recorro mientras haya nodos
            siguiente = actual.siguiente;      // Guardo el siguiente nodo
            actual.siguiente = anterior;       // Invierto el enlace del nodo actual
            anterior = actual;                 // Avanzo el nodo anterior
            actual = siguiente;                // Avanzo al siguiente nodo
        }

        cabeza = anterior; 
    }

    // Método para mostrar la lista
    public void mostrar() {
        Nodo temp = cabeza; // Comienzo desde la cabeza
        while (temp != null) {
            System.out.print(temp.dato + " -> "); // Muestro cada dato
            temp = temp.siguiente;               // Avanzo al siguiente nodo
        }
        System.out.println("null"); // Indico el fin de la lista
    }

    // Método main dentro de la misma clase
    public static void main(String[] args) {
        Lista miLista = new Lista(); // Creo una instancia de la lista

        // Agrego elementos
        miLista.agregar(10);
        miLista.agregar(20);
        miLista.agregar(30);
        miLista.agregar(40);

        // Muestro la lista original
        System.out.println("Lista original:");
        miLista.mostrar();

        // Invierto la lista
        miLista.invertir();

        // Muestro la lista invertida
        System.out.println("Lista invertida:");
        miLista.mostrar();
    }
}