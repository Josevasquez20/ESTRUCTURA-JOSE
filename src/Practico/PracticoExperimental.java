/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practico;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class PracticoExperimental {
    // Declaro la clase principal PracticoExperimental donde ejecutaré mi programa
    public static void main(String[] args) {
        // Creo un objeto Scanner para poder leer las entradas del usuario desde el teclado
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica(100); // Capacidad para 100 contactos
        // Instancio mi objeto agenda con capacidad para almacenar 100 contactos
        int opcion;
        // Declaro una variable entera 
        do {
             // Inicio un bucle do-while que se ejecutará al menos una vez
            System.out.println("\n=== AGENDA TELEFÓNICA ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                // Evalúo la opción seleccionada usando una estructura switch
                case 1:
                     // Si el usuario eligió la opción 1, ejecuto el código para agregar contacto
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese el correo: ");
                    String correo = scanner.nextLine();
                    
                    if (agenda.agregarContacto(nombre, telefono, correo)) {
                          // Intento agregar el contacto a mi agenda y evalúo si fue exitoso
                        System.out.println("Contacto agregado exitosamente.");
                    } else {
                        System.out.println("No se pudo agregar el contacto. Agenda llena.");
                    }
                    break;
                    // Salgo del case 1
                    
                case 2:
                     // Si el usuario eligió la opción 2, muestro todos los contactos
                    System.out.println("\n=== LISTA DE CONTACTOS ===");
                    agenda.mostrarContactos();
                    break;
                    
                case 0: // Salgo del case 3
                     // Si el usuario eligió la opción 0, preparo la salida del programa
                    System.out.println("¡Gracias por usar la Agenda Telefonica!");
                    break;
                    // Salgo del case 3
                    
                default:
                    // Informo que la opción no es válida y puede intentar de nuevo
                    System.out.println("Opcion no válida. Intente nuevamente.");
            }
            
        } while (opcion != 0);
         // Continúo el bucle mientras la opción no sea 0  
        
        scanner.close();
        // Cierro el objeto Scanner 
    }
}

