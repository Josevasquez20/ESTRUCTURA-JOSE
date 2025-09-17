/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_14;

/**
 *
 * @author User
 */
// Defino la clase Nodo
// Cada nodo tiene un valor entero y dos referencias: una al hijo izquierdo y otra al derecho.
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    // Constructor que inicializa el nodo con un valor dado.
    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null; // Inicializo los hijos como nulos.
    }
}

public class ArbolBinario {
    Nodo raiz; // La raíz del árbol desde donde se construye toda la estructura.

    // Método público para insertar un valor en el árbol.
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor); // Llamo al método recursivo para ubicar el valor.
    }

    // Inserto el valor de forma recursiva, respetando la lógica del árbol binario de búsqueda.
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) return new Nodo(valor); // Si no hay nodo, creo uno nuevo.
        if (valor < actual.valor)
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor); // Si es menor, va a la izquierda.
        else if (valor > actual.valor)
            actual.derecho = insertarRecursivo(actual.derecho, valor); // Si es mayor, va a la derecha.
        return actual; // Retorno el nodo actualizado.
    }

    // Método para recorrer el árbol en inorden.
    public void inorden() {
        System.out.print("Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    // Recorrido inorden: izquierda - raíz - derecha.
    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inordenRecursivo(nodo.derecho);
        }
    }

    // Recorrido preorden: raíz - izquierda -erecha.
    public void preorden() {
        System.out.print("Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRecursivo(nodo.izquierdo);
            preordenRecursivo(nodo.derecho);
        }
    }

    // Recorrido postorden: izquierda - derecha - raíz.
    public void postorden() {
        System.out.print("Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo);
            postordenRecursivo(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // Método para buscar un valor en el árbol.
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor); // Llamo al método recursivo.
    }

    private boolean buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) return false; // Si no hay nodo, el valor no está.
        if (valor == nodo.valor) return true; 
        return valor < nodo.valor
            ? buscarRecursivo(nodo.izquierdo, valor) // Si es menor busco a la izquierda.
            : buscarRecursivo(nodo.derecho, valor); // Si es mayor  busco a la derecha.
    }

    // Método para eliminar un valor del árbol.
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor); // Llamo al metodo recursivo.
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) return null; // Si no hay nodo no se elimina nada 

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor); // Busco a la izquierda.
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor); // Busco a la derecha.
        } else {
          
            if (nodo.izquierdo == null) return nodo.derecho;

            if (nodo.derecho == null) return nodo.izquierdo;

            
            Nodo sucesor = encontrarMinimo(nodo.derecho);
            nodo.valor = sucesor.valor; // Reemplazo el valor del nodo actual.
            nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor.valor); // Elimino el sucesor.
        }
        return nodo; // Retorno el nodo actualizado.
    }

    // Encuentro el valor mínimo en un subárbol (el más a la izquierda).
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) nodo = nodo.izquierdo;
        return nodo;
    }
}