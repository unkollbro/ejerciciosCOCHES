/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocoches;

import java.util.Scanner;

/**
 *
 * @author Catalin 'uNKoLL' Ciurcanu
 */
public class Circuito {
   Coche vCoches[];
   private String nombre;
   private int distancia_carrera;
   private int numCoches;

    public Circuito(String nombre, int distancia_carrera, int numCoches) {
        this.nombre = nombre;
        this.distancia_carrera = distancia_carrera;
        this.numCoches = numCoches;
        vCoches = new Coche[numCoches];
    }
    
    //CONFIGURAR CIRCUITO
    public void configurarCircuito(){
        Scanner leer = new Scanner(System.in);
        String nombre;
        int distancia, participantes;
        System.out.println("Introduce El nombre del circuito");
        nombre = leer.next();
        System.out.println("Introduce La distancia de la carrera");
        distancia = leer.nextInt();
        System.out.println("Introduce los participantes");
        participantes = leer.nextInt();
        
        Circuito circuito = new Circuito(nombre, distancia, participantes);
    }
    //AÑADIR COCHES AL CIRCUITO
    public void anadirCoche(){
        Scanner leer = new Scanner(System.in);
        int num_dorsal;
        String nombre_piloto;
        
        System.out.println("Introduce el Nombre del Piloto");
        nombre_piloto = leer.next();
        do{
            System.out.println("Introduce el Dorsal del Piloto");
            num_dorsal = leer.nextInt(); 
        }while (comprobarExistente(num_dorsal));
        
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]==null){
                vCoches[i] = new Coche(nombre_piloto, num_dorsal, distancia_carrera);
                break;
            }
        }

    }
    
    //COMPROBAR SI EL DORSAL YA EXISTE , SI DEVUELVE TRUE
    private boolean comprobarExistente(int dorsal){
        boolean existe=false;
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]!=null && dorsal==(vCoches[i].getDorsal_piloto())){
                System.out.println("El dorsal YA EXISTE");
                return true;
            }
        }
        return existe;
    }

    //CALCULAR NUMERO DE COCHES COMPTIENDO
    public int numeroCochesCompitiendo(){
        int total=0;
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]!=null){
                total++;
            }
        }
        return total;
    }
    
    //CALCULAR COCHES EN CARRERA (MARCHA)
    public int numeroCochesEnCarrera(){
        int total=0;
        for (int i = 0; i < vCoches.length; i++) {
            if(vCoches[i]!=null && vCoches[i].getEstado_coche().equals("MARCHA")){
                total++;
            }
        }
        return total;
    }
    
    //CALCULAR COCHES QUE HAN FINALIZADO
    public int numeroCochesFinalizado(){
        int total=0;
        for (Coche vCoches : vCoches) {
            if (vCoches != null && vCoches.getEstado_coche().equals("TERMINADO")) {
                total++;
            }
        }
        return total;
    }
    
    //SI LA CARRERA A TERMINADO
    public boolean estadoCarrera(){
        boolean estado=false;
        for (Coche vCoches : vCoches){
            if(vCoches !=null && ( vCoches.getEstado_coche().equals("TERMINADO") || vCoches.getEstado_coche().equals("ACCIDENTADO"))){
                return true;
            }
        }
        return estado;
    }
   
}
