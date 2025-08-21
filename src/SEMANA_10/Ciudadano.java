/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_10;

/**
 *
 * @author User
 */
// Declaración de la clase pública Ciudadano
public class Ciudadano {

    // Atributo privado que representa el identificador único del ciudadano
    private int id;

    // Atributo privado que representa el nombre del ciudadano
    private String nombre;

    // Constructor que inicializa los atributos id y nombre al crear un objeto Ciudadano
    public Ciudadano(int id, String nombre) {
        this.id = id;               // Asigno el valor recibido al atributo id
        this.nombre = nombre;       // Asigno el valor recibido al atributo nombre
    }

    // Método público que devuelve el valor del atributo id
    public int getId() {
        return id;
    }

    // Método público que devuelve el valor del atributo nombre
    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        // Devuelvo una cadena con el formato: Ciudadano{id=..., nombre='...'}
        return "Ciudadano{id=" + id + ", nombre='" + nombre + "'}";
    }

    // Sobrescribo el método equals para comparar objetos Ciudadano por su id
    @Override
    public boolean equals(Object obj) {
        // Verifico si ambos objetos son exactamente el mismo en memoria
        if (this == obj) return true;

        // Verifico si el objeto recibido no es una instancia de Ciudadano
        if (!(obj instanceof Ciudadano)) return false;

        // Realizo un casting seguro y compara los id
        Ciudadano other = (Ciudadano) obj;
        return this.id == other.id;
    }


    @Override
    public int hashCode() {
        // Devuelvo el código hash basado únicamente en el id
        return Integer.hashCode(id);
    }
}
