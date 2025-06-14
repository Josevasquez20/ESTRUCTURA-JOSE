/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA_3;

/**
 *
 * @author User
 */
public class Estudiante {
    //Metodos
    private int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String[] telefonos;
    
    //Constructor

    public Estudiante(int id, String nombres, String apellidos, String direccion,String [] telefonos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }
    //metodos 
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefonos:");
        for(int i = 0; i < 3; i++) {
           
            System.out.println("  - " + telefonos[i]);
        }
    }

    
}