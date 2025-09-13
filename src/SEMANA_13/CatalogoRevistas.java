/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_13;
import java.util.Scanner; // importo la libreria 
/**
 *
 * @author User
 */
public class CatalogoRevistas {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Utilizo Scanner para leer la entrada del usuario

        // Catálogo con al menos 10 títulos
        String[] revistas = {
            "Ciencia Hoy", "Educación y Sociedad", "Neuroeducación", "Tecnología y Futuro",
            "Revista Pedagógica", "Aprendizaje Activo", "Innovación Docente", "Matemática Real",
            "Lenguaje y Cultura", "Revista Digital"
        };

        boolean salir = false; // Uso esta variable para controlar el ciclo del menú

        while (!salir) { // Inicio un ciclo while para mostrar el menú hasta que el usuario decida salir
            System.out.println("\n--- MENU ---");
            System.out.println("1. Buscar titulo");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
   // Utilizo switch para ejecutar la acción según la opción elegida
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo a buscar: "); // Leo el título que el usuario quiere buscar
                    String tituloBuscado = scanner.nextLine();
                    boolean encontrado = buscarIterativo(revistas, tituloBuscado);
                    if (encontrado) {
                        System.out.println("Resultado: Encontrado"); // Si lo encuentra, muestro mensaje
                    } else {
                        System.out.println("Resultado: No encontrado"); // Si no lo encuentra, aviso al usuario
                    }
                    break;
                case 2:
                    salir = true; // Cambio la variable para salir del ciclo
                    System.out.println("Gracias por usar el catálogo."); // Mensaje de despedida
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    // Búsqueda iterativa
    public static boolean buscarIterativo(String[] catalogo, String titulo) {
        for (String revista : catalogo) {
            // Comparo ignorando mayúsculas/minúsculas y eliminando espacios innecesarios
            if (revista.equalsIgnoreCase(titulo.trim())) {
                return true; // Si lo encuentro devuelvo true.
            } 
        }
        return false; // Si recorro todo y no lo encuentro, devuelvo false
    }
}

