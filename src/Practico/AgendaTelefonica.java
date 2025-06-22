/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practico;

/**
 *
 * @author User
 */
public class AgendaTelefonica {
    // Atributos
    public Contacto[] contactos;
    // Declaro un arreglo público de tipo Contacto para almacenar todos mis contactos
    public int totalContactos;
    // Declaro una variable pública entera para llevar el conteo de cuántos contactos he agregado
    
    // Constructor
    public AgendaTelefonica(int capacidad) {
         // Defino el constructor público 
        contactos = new Contacto[capacidad];
        totalContactos = 0;// Inicializo el contador de contactos en cero
    }
    
    // Agregar contactos
    public boolean agregarContacto(String nombre, String telefono, String correo) {
        if (totalContactos >= contactos.length) {
            // Verifico si ya alcancé la capacidad máxima de mi agenda
            return false;  // Si la agenda está llena, retorno false
        } else {
            contactos[totalContactos] = new Contacto(nombre, telefono, correo);
            // Creo un nuevo objeto Contacto con los datos recibidos y lo coloco en la posición actual
            totalContactos = totalContactos + 1; // Incremento mi contador en 1 
            return true;
        }
    }
    
    // Mostrar contactos
    public void mostrarContactos() {
        if (totalContactos == 0) {   // Verifico si no tengo ningún contacto registrado en mi agenda
            System.out.println("No tienes registros");
        } else {
            for (int i = 0; i < totalContactos; i++) {
                 // Inicio un bucle for que recorrerá desde 0 hasta el número total de contactos
                Contacto c = contactos[i];
                  // Obtengo el contacto en la posición i y lo asigno a una variable temporal
                System.out.println("DATOS DEL CONTACTO" + i);
                System.out.println("Nombre:" + c.nombre());
                System.out.println("Teléfono:" + c.telefono());
                System.out.println("Correo:" + c.correo());
            }
        }
    }
}
