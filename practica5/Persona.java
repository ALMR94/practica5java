/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellidos;  
    private String dni;  
    private String cargo;  

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni, String cargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.cargo = cargo;
    }
    public Persona(Persona a) {
        this.nombre = a.nombre;
        this.apellidos = a.apellidos;
        this.dni = a.dni;
        this.cargo = a.cargo;    
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

   
     
    
    static public Persona alta_Persona(){
        Scanner lector=new Scanner(System.in);
        Persona nuevapersona=new Persona();        
        System.out.println("==============================");
        System.out.println("Dando de alta a una persona...");
        System.out.println("------------------------------");
        System.out.println("¿Cuál es el nombre de la persona?");
        nuevapersona.setNombre(lector.nextLine());      
        System.out.println("¿Cuáles son sus apellidos?");
        nuevapersona.setApellidos(lector.nextLine());
        System.out.println("¿Cuál es su DNI?");
        nuevapersona.setDni(lector.nextLine());        
        System.out.println("¿Cuál es su cargo en la biblioteca?");
        nuevapersona.setCargo(lector.nextLine());
        return nuevapersona;    
    }    
}
