/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Estoy creando un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Estoy inicializando el sistema de la atracción con 30 asientos
        SistemaAtraccion sistema = new SistemaAtraccion(30);
        
        // Estoy mostrando el menú principal al usuario
        int opcion;
        do {
            // Estoy imprimiendo las opciones disponibles
            System.out.println("\n=== SISTEMA DE ATRACCION ===");
            System.out.println("1. Agregar persona a la cola");
            System.out.println("2. Procesar siguiente grupo (30 personas)");
            System.out.println("3. Ver estado de la cola");
            System.out.println("4. Ver historial de grupos procesados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            
            // Estoy leyendo la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumo el salto de línea
            
            // Estoy procesando la opción seleccionada
            switch(opcion) {
                case 1:
                    // Estoy solicitando el nombre de la persona
                    System.out.print("Ingrese el nombre de la persona: ");
                    String nombre = scanner.nextLine();
                    
                 
                    sistema.agregarPersonaACola(nombre);
                    break;
                    
                case 2:
                   
                    sistema.procesarSiguienteGrupo();
                    break;
                    
                case 3:
                   
                    sistema.mostrarEstadoCola();
                    break;
                    
                case 4:
                  
                    sistema.mostrarHistorialGrupos();
                    break;
                    
                case 5:
              
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                    
                default:
                    
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 5);
        
        // Estoy cerrando el scanner
        scanner.close();
    }
}