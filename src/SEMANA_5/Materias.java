/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Materias {

    private ArrayList<String> asignaturas; // Declaro una lista para guardar los nombres de las materias.

    public Materias() {
        asignaturas = new ArrayList<>(); // Inicializo la lista.
        // Agrego las materias al ArrayList.
        asignaturas.add("Matematicas");
        asignaturas.add("Fisica");
        asignaturas.add("Quimica");
        asignaturas.add("Historia");
        asignaturas.add("Lengua");
    }

    public void mostrarAsignaturas() {
        System.out.println("Asignaturas del curso:");
        for (String materia : asignaturas) {
            System.out.println("- " + materia);
        }
    }

    public static void main(String[] args) {
        Materias curso = new Materias(); // Creo un objeto de la clase Materias.
        curso.mostrarAsignaturas(); // Llamo al método para mostrar las asignaturas.
    }
}