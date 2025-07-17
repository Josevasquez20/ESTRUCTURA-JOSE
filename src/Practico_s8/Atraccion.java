/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

public class Atraccion {
    // Estoy definiendo los atributos de la atracción
    private int capacidadMaxima;
    private List<Persona> personasEnAtraccion;
    private boolean enFuncionamiento;
    
    // Estoy creando el constructor que inicializa la atracción
    public Atraccion(int capacidadMaxima) {
        // Estoy asignando la capacidad máxima de la atracción
        this.capacidadMaxima = capacidadMaxima;
        // Estoy inicializando la lista de personas en la atracción
        this.personasEnAtraccion = new ArrayList<>();
        // Estoy estableciendo que la atracción no está en funcionamiento inicialmente
        this.enFuncionamiento = false;
    }
    
    // Estoy creando el método para cargar personas en la atracción
    public boolean cargarPersonas(List<Persona> personas) {
        // Estoy verificando si la atracción no está en funcionamiento
        if (enFuncionamiento) {
            System.out.println("La atracción está en funcionamiento. No se pueden cargar más personas.");
            return false;
        }
        
        // Estoy verificando si el número de personas no excede la capacidad
        if (personas.size() > capacidadMaxima) {
            System.out.println("Error: El grupo excede la capacidad máxima de " + capacidadMaxima + " personas.");
            return false;
        }
        
        // Estoy limpiando la lista actual y agregando las nuevas personas
        this.personasEnAtraccion.clear();
        this.personasEnAtraccion.addAll(personas);
        
        // Estoy mostrando información sobre la carga
        System.out.println("Se han cargado " + personas.size() + " personas en la atracción.");
        return true;
    }
    
    // Estoy creando el método para iniciar la atracción
    public void iniciarAtraccion() {
        // Estoy verificando si hay personas en la atracción
        if (personasEnAtraccion.isEmpty()) {
            System.out.println("No hay personas en la atracción para iniciar.");
            return;
        }
        
        // Estoy marcando la atracción como en funcionamiento
        this.enFuncionamiento = true;
        
        // Estoy mostrando mensaje de inicio
        System.out.println("¡La atracción ha comenzado con " + personasEnAtraccion.size() + " personas!");
        System.out.println("Personas en la atracción:");
        
        // Estoy mostrando la lista de personas
        for (Persona persona : personasEnAtraccion) {
            System.out.println("  - " + persona.toString());
        }
    }
    
    // Estoy creando el método para finalizar la atracción
    public List<Persona> finalizarAtraccion() {
        // Estoy verificando si la atracción está en funcionamiento
        if (!enFuncionamiento) {
            System.out.println("La atracción no está en funcionamiento.");
            return new ArrayList<>();
        }
        
        // Estoy creando una copia de la lista de personas para devolver
        List<Persona> personasQueTerminaron = new ArrayList<>(personasEnAtraccion);
        
        // Estoy limpiando la atracción y marcándola como no en funcionamiento
        this.personasEnAtraccion.clear();
        this.enFuncionamiento = false;
        
        // Estoy mostrando mensaje de finalización
        System.out.println("¡La atracción ha terminado! " + personasQueTerminaron.size() + " personas han terminado su turno.");
        
        return personasQueTerminaron;
    }
    
    // Estoy creando el método getter para obtener la capacidad máxima
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    // Estoy creando el método para verificar si está en funcionamiento
    public boolean isEnFuncionamiento() {
        return enFuncionamiento;
    }
    
    // Estoy creando el método para obtener el número de personas actuales
    public int getNumeroPersonasActuales() {
        return personasEnAtraccion.size();
    }
    
    // Estoy creando el método para obtener información del estado actual
    public String getEstadoAtraccion() {
        if (enFuncionamiento) {
            return "En funcionamiento con " + personasEnAtraccion.size() + " personas";
        } else if (personasEnAtraccion.isEmpty()) {
            return "Vacia y lista para cargar";
        } else {
            return "Cargada con " + personasEnAtraccion.size() + " personas, lista para iniciar";
        }
    }
}
