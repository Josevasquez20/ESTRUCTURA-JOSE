/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5; 
import java.util.ArrayList; // Importo la clase ArrayList porque la usaré para guardar una lista de materias.

/**
 *
 * @author User
 */
public class Materias_de_Estudio { // Declaro una clase pública llamada Materias_de_Estudio.

    private ArrayList<String> materias; // Declaro una lista privada 

    public Materias_de_Estudio() { // Creo el constructor de la clase, que se ejecuta cuando se crea un objeto.
        materias = new ArrayList<>(); // Inicializo la lista de materias vacía.
        materias.add("Matematicas"); // Agrego la materia "Matemáticas" a la lista.
        materias.add("Fisica"); // Agrego "Física".
        materias.add("Quimica"); // Agrego "Química".
        materias.add("Historia"); // Agrego "Historia".
        materias.add("Lengua"); // Agrego "Lengua".
    }

    public void mostrarMaterias() { // Declaro un método que va a mostrar cada materia.
        for (String materia : materias) { // Recorro la lista de materias una por una.
            System.out.println("Yo estudio " + materia); // Imprimo el mensaje con el nombre de la materia.
        }
    }

    public static void main(String[] args) { // Es el punto de entrada del programa.
        Materias_de_Estudio miCurso = new Materias_de_Estudio(); // Creo un objeto de mi clase para usar sus métodos.
        miCurso.mostrarMaterias(); // Llamo al método para mostrar las materias que tengo en la lista.
    }
}
