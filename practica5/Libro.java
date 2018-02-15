package practica5;

import java.util.ArrayList;
import java.util.Scanner;

public class Libro {
    private String titulo;
    private String autor;  
    private int isbn;  
    private int num_ejem_pres;
    private int num_ejem_tot;    
    static public int num_ejem_pres_glob;
    static public int num_ejem_tot_glob;   

    public Libro() {
    }

    public Libro(String titulo, String autor, int isbn, int num_ejem_pres, int num_ejem_tot) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.num_ejem_pres = num_ejem_pres;
        this.num_ejem_tot = num_ejem_tot;
        Libro.num_ejem_tot_glob+=this.num_ejem_tot;
    }
    public Libro(Libro a) {
        this.titulo = a.titulo;
        this.autor = a.autor;
        this.isbn = a.isbn;
/* quizás en el constructor copia no tiene sentido copiar un libro y que ya
        establezcamos una seria de número de ejemplares prestados, aunque no 
        lo indicaba el ejercicio, asumimos que copiamos todos los elementos
        excepto los ejemplares prestado que los dejaremos a cero
        */        
        this.num_ejem_pres = 0;
        this.num_ejem_tot = a.num_ejem_tot;
/*        Libro.num_ejem_pres_glob+=num_ejem_pres; */
        Libro.num_ejem_tot_glob+=this.num_ejem_tot;        
    }    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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
        Libro.num_ejem_pres_glob = num_ejem_pres_glob;
    }

    public static int getNum_ejem_tot_glob() {
        return num_ejem_tot_glob;
    }

    public static void setNum_ejem_tot_glob(int num_ejem_tot_glob) {
        Libro.num_ejem_tot_glob = num_ejem_tot_glob;
    }
    public boolean prestar_Libro() {
        if (this.num_ejem_tot>this.num_ejem_pres){
            this.num_ejem_pres++;
            Libro.num_ejem_pres_glob++;            
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
    public void mostrar_Libro(){
        System.out.println("======================");
        System.out.println("FICHA DEL LIBRO       ");
        System.out.println("----------------------");
        System.out.println("Titulo: "+ this.getTitulo());
        System.out.println("Autor: "+ this.getAutor());
        System.out.println("Ejemplares prestados: "+this.getNum_ejem_pres());
        System.out.println("Ejemplares totales: "+this.getNum_ejem_tot());
        System.out.println("======================");        
    }
    static public void pedir_mostrar_Libro(ArrayList<Libro> p){
        Scanner lector=new Scanner(System.in);
        System.out.println("¿Qué libro deseas que te mostremos? Introduce el ISBN");
        int a=lector.nextInt();
        boolean encontrado=false;
        int i = 0;
        while ((i < p.size()) && (encontrado==false)) {
            if (p.get(i).getIsbn()==a){
                System.out.println("El ejemplar existe. A continuación le mostramos la ficha del libro");
                p.get(i).mostrar_Libro();
                encontrado=true;                
            }else i++;
            
        }
        if (encontrado==false){
            System.out.println("El ejemplar no existe. El libro NO puede ser mostrado");            
        }
    }    
    static public void localizar_Libro(ArrayList<Libro> p){
        Scanner lector=new Scanner(System.in);
        System.out.println("======================");
        System.out.println("LOCALIZADOR DE LIBROS ");
        System.out.println("----------------------");
        System.out.println("¿Qué libro deseas localizar? Introduce el ISBN");
        int a=lector.nextInt();
        boolean encontrado=false;
        int i = 0;
        while ((i < p.size()) && (encontrado==false)) {
            if (p.get(i).getIsbn()==a){
                System.out.println("El ejemplar existe. Esta es su información actualizada:");
                p.get(i).mostrar_Libro();
                encontrado=true;                
            }else i++;            
        }
        if (encontrado==false){
            System.out.println("El ejemplar no existe. El libro NO se ha localizado");            
        }        
    }
    static public Libro crear_Libro(){
        Scanner lector=new Scanner(System.in);
        Libro milibro=new Libro();        
        System.out.println("=========================");
        System.out.println("Creando un nuevo libro...");
        System.out.println("-------------------------");
        System.out.println("¿Cuál es el título del libro?");
        milibro.setTitulo(lector.nextLine());      
        System.out.println("¿Cuál es el autor del libro?");
        milibro.setAutor(lector.nextLine());
        System.out.println("¿Cuál es el ISBN del libro?");
        milibro.setIsbn(lector.nextInt());        
        System.out.println("Introduce el número de ejemplares totales del libro:");
        milibro.setNum_ejem_tot(lector.nextInt()); 
        milibro.setNum_ejem_pres(0);
        return milibro;    
    }
}
