/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_5;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Palindromo {

    // Atributo privado que representa el estado del objeto.
    private String palabra;

    // Método que permite al objeto recibir una palabra del usuario.
    public void pedirPalabra() {
        Scanner scanner = new Scanner(System.in); //  leo texto del teclado.
        System.out.print("Ingresa una palabra: "); // Le pido al usuario que escriba una palabra.
        palabra = scanner.nextLine(); // Guardo esa palabra .
        scanner.close(); // Cierro el escáner .
    }

    // Método que verifica si la palabra almacenada es un palíndromo.
    public void verificarPalindromo() {
        String invertida = new StringBuilder(palabra).reverse().toString(); // Invierto la palabra usando StringBuilder.
        if (palabra.equalsIgnoreCase(invertida)) { // Comparo ignorando mayúsculas.
            System.out.println("Sí, es un palíndromo."); // Muestro si lo es.
        } else {
            System.out.println("No, no es un palíndromo."); // O si no lo es.
        }
    }

    // Método principal: donde comienza la ejecución del programa.
    public static void main(String[] args) {
        Palindromo verificador = new Palindromo(); // Creo un objeto de la clase Palindromo.
        verificador.pedirPalabra(); // Uso el objeto para llamar al método que pide la palabra.
        verificador.verificarPalindromo(); // Llamo al método que hace la verificación.
    }
}