/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private String nombre;
    private String direccion;  
    private int id;  
    private int num_ejem_pres;
    private int num_ejem_tot;    
    static public int num_ejem_pres_glob;
    static public int num_ejem_tot_glob;   

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String direccion, int id, int num_ejem_pres, int num_ejem_tot) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.id = id;
        this.num_ejem_pres = num_ejem_pres;
        this.num_ejem_tot = num_ejem_tot;
        Libro.num_ejem_tot_glob+=this.num_ejem_tot;
    }
    public Biblioteca(Biblioteca a) {
        this.nombre = a.nombre;
        this.direccion = a.direccion;
        this.id = a.id;
/* quizás en el constructor copia no tiene sentido copiar un libro y que ya
        establezcamos una seria de número de ejemplares prestados, aunque no 
        lo indicaba el ejercicio, asumimos que copiamos todos los elementos
        excepto los ejemplares prestado que los dejaremos a cero
        */        
        this.num_ejem_pres = 0;
        this.num_ejem_tot = a.num_ejem_tot;
/*        Libros.num_ejem_pres_glob+=num_ejem_pres; */
        Biblioteca.num_ejem_tot_glob+=this.num_ejem_tot;        
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_ejem_pres() {
        return num_ejem_pres;
    }

    public void setNum_ejem_pres(int num_ejem_pres) {
        this.num_ejem_pres = num_ejem_pres;
    }

    public int getNum_ejem_tot() {
        return num_ejem_tot;
    }

    public void setNum_ejem_tot(int num_ejem_tot) {
        this.num_ejem_tot = num_ejem_tot;
    }

    public static int getNum_ejem_pres_glob() {
        return num_ejem_pres_glob;
    }

    public static void setNum_ejem_pres_glob(int num_ejem_pres_glob) {
        Biblioteca.num_ejem_pres_glob = num_ejem_pres_glob;
    }

    public static int getNum_ejem_tot_glob() {
        return num_ejem_tot_glob;
    }

    public static void setNum_ejem_tot_glob(int num_ejem_tot_glob) {
        Biblioteca.num_ejem_tot_glob = num_ejem_tot_glob;
    }
    public boolean prestar_Libro() {
        if (this.num_ejem_tot>this.num_ejem_pres){
            this.num_ejem_pres++;
            Biblioteca.num_ejem_pres_glob++;            
            return true;
        }
        else return false;
    }
    static public void pedir_prestar_Libro(ArrayList<Libro> p){
        Scanner lector=new Scanner(System.in);
        System.out.println("¿Qué libro deseas prestar? Introduce el ISBN");
        int a=lector.nextInt();
        boolean encontrado=false;
        int i = 0;
/*Mejora: deberíamos utilizar el metodo localizar libro en lugar de 
 * realizar este while en este método 
 */        
        while ((i < p.size()) && (encontrado==false)) {
            if (p.get(i).getIsbn()==a){
                if (p.get(i).prestar_Libro()){
                    System.out.println("El ejemplar existe. El libro ha sido prestado");
                }
                else{System.out.println("Lo sentimos, todos los ejemplares estan prestados, NO se ha podido prestar el libro");
                }
                encontrado=true; 
            }                              
            else i++;         
        }
        if (encontrado==false){
            System.out.println("El ejemplar no existe. El libro NO se ha prestado");            
        }
    }    
    public boolean devolver_Libro() {
        if (this.num_ejem_pres>0){
            this.num_ejem_pres--;
            Libro.num_ejem_pres_glob--;             
            return true;
        }
        else return false;
    } 
    static public void pedir_devolver_Libro(ArrayList<Libro> p){
        Scanner lector=new Scanner(System.in);
        System.out.println("¿Qué libro deseas devolver? Introduce el ISBN");
        int a=lector.nextInt();
        boolean encontrado=false;
        int i = 0;
/*Mejora: deberíamos utilizar el metodo localizar libro en lugar de 
 * realizar este while en este método 
 */
        while ((i < p.size()) && (encontrado==false)) {
            if (p.get(i).getIsbn()==a){
                System.out.println("El ejemplar existe. El libro ha sido devuelto");
                if (p.get(i).devolver_Libro()){
                    encontrado=true; 
                }               
                else{
                    System.out.println("No puedes devolver el libro");
                }
                
            }else i++;
            
        }
        if (encontrado==false){
            System.out.println("El ejemplar no existe. El libro NO se ha prestado");            
        }
    }    
    public void mostrar_Biblioteca(){
        System.out.println("======================");
        System.out.println("FICHA DE BIBLIOTECA   ");
        System.out.println("----------------------");
        System.out.println("Nombre: "+ this.getNombre());
        System.out.println("Direccion: "+ this.getDireccion());
        System.out.println("Ejemplares prestados: "+this.getNum_ejem_pres());
        System.out.println("Ejemplares totales: "+this.getNum_ejem_tot());
        System.out.println("======================");        
    }
    static public void pedir_mostrar_Libro(ArrayList<Biblioteca> p){
        Scanner lector=new Scanner(System.in);
        System.out.println("¿Qué libro deseas que te mostremos? Introduce el ISBN");
        int a=lector.nextInt();
        boolean encontrado=false;
        int i = 0;
        while ((i < p.size()) && (encontrado==false)) {
            if (p.get(i).getId()==a){
                System.out.println("Biblioteca encontrada. Esta es su ficha coompleta: ");
                p.get(i).mostrar_Biblioteca();
                encontrado=true;                
            }else i++;
            
        }
        if (encontrado==false){
            System.out.println("El ejemplar no existe. El libro NO puede ser mostrado");            
        }
    }    
    static public void localizar_Biblioteca(ArrayList<Biblioteca> p){
        Scanner lector=new Scanner(System.in);
        System.out.println("======================");
        System.out.println("LOCALIZADOR DE BIBLIOTECAS ");
        System.out.println("----------------------");
        System.out.println("¿Qué libro deseas localizar? Introduce el ISBN");
        int a=lector.nextInt();
        boolean encontrado=false;
        int i = 0;
        while ((i < p.size()) && (encontrado==false)) {
            if (p.get(i).getId()==a){
                System.out.println("El ejemplar existe. Esta es su información actualizada:");
                p.get(i).mostrar_Biblioteca();
                encontrado=true;                
            }else i++;            
        }
        if (encontrado==false){
            System.out.println("El ejemplar no existe. El libro NO se ha localizado");            
        }        
    }
    static public Biblioteca crear_Biblioteca(){
        Scanner lector=new Scanner(System.in);
        Biblioteca nuevabiblioteca=new Biblioteca();        
        System.out.println("=================================");
        System.out.println("Dando de alta a una biblioteca...");
        System.out.println("---------------------------------");
        System.out.println("¿Cuál es el nombre de la biblioteca?");
        nuevabiblioteca.setNombre(lector.nextLine());      
        System.out.println("¿Cuál es la dirección de la biblioteca?");
        nuevabiblioteca.setDireccion(lector.nextLine());
        System.out.println("¿Cuál es el id de la biblioteca?");
        nuevabiblioteca.setId(lector.nextInt());        
        System.out.println("Introduce el número de libros totales que tiene la biblioteca:");
        nuevabiblioteca.setNum_ejem_tot(lector.nextInt()); 
        nuevabiblioteca.setNum_ejem_pres(0);
        return nuevabiblioteca;    
    }
    
}
