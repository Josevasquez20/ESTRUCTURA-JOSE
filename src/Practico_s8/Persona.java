/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Persona {
    // Estoy definiendo los atributos de la persona
    private String nombre;
    private LocalDateTime horaLlegada;
    private int numeroTurno;
    private static int contadorTurnos = 1; // Contador estático para asignar turnos únicos
    
    // Estoy creando el constructor que inicializa una persona
    public Persona(String nombre) {
        // Estoy asignando el nombre recibido
        this.nombre = nombre;
        // Estoy registrando la hora actual como hora de llegada
        this.horaLlegada = LocalDateTime.now();
        // Estoy asignando un número de turno único y incrementando el contador
        this.numeroTurno = contadorTurnos++;
    }
    
    // Estoy creando el método getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }
    
    // Estoy creando el método getter para obtener la hora de llegada
    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }
    
    // Estoy creando el método getter para obtener el número de turno
    public int getNumeroTurno() {
        return numeroTurno;
    }
    
    // Estoy sobrescribiendo el método toString para mostrar la información de la persona
    @Override
    public String toString() {
        // Estoy formateando la hora de llegada para mostrarla de manera legible
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("Turno #%d: %s (Llegada: %s)", 
                           numeroTurno, nombre, horaLlegada.format(formatter));
    }
    
    // Estoy creando un método para obtener información detallada de la persona
    public String getInformacionDetallada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("Nombre: %s | Turno: #%d | Llegada: %s", 
                           nombre, numeroTurno, horaLlegada.format(formatter));
    }
}