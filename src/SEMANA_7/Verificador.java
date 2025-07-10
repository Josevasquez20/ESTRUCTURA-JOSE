/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Stack; // Importamos la clase Stack para usar pilas
import java.util.Scanner; // Importamos Scanner para leer entrada del usuario

public class Verificador {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos un scanner para leer del teclado
        
        System.out.println("Ingrese una expresion matemática:"); // Pedimos al usuario que ingrese la expresión
        String expresion = scanner.nextLine(); // Leemos la expresión completa del usuario
        
        if (estaBalanceada(expresion)) { // Llamamos al método que verifica si está balanceada
            System.out.println("Formula balanceada"); // Si está balanceada, mostramos este mensaje
        } else {
            System.out.println("Formula NO balanceada"); // Si no está balanceada, mostramos este mensaje
        }
        
        scanner.close(); // Cerramos el scanner
    }
    
    // Método que verifica si los paréntesis están balanceados
    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>(); // Creamos una pila vacía para guardar los símbolos de apertura
        
        // Recorremos cada carácter de la expresión uno por uno
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i); // Obtenemos el carácter en la posición i
            
            // Si encontramos un símbolo de apertura, lo agregamos a la pila
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c); // Agregamos el símbolo a la pila
            }
            // Si encontramos un símbolo de cierre, verificamos si coincide
            else if (c == ')' || c == '}' || c == ']') {
                // Si la pila está vacía, no hay símbolo de apertura para este cierre
                if (pila.isEmpty()) {
                    return false; // No está balanceada
                }
                
                char apertura = pila.pop(); // Sacamos el último símbolo de apertura de la pila
                
                // Verificamos si el símbolo de apertura coincide con el de cierre
                if ((apertura == '(' && c != ')') ||  // ( debe cerrar con )
                    (apertura == '{' && c != '}') ||  // { debe cerrar con }
                    (apertura == '[' && c != ']')) { // [ debe cerrar con ]
                    return false; // No coinciden, no está balanceada
                }
            }
            // Si es cualquier otro carácter (números, operadores, etc.), lo ignoramos
        }
        
        // Si la pila está vacía, todos los símbolos están balanceados
        return pila.isEmpty();
    }
}
